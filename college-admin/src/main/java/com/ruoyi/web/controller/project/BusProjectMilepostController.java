package com.ruoyi.web.controller.project;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.BusProjectMilepost;
import com.ruoyi.project.service.IBusProjectMilepostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目里程碑Controller
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@RestController
@RequestMapping("/project/busProjectMilepost")
public class BusProjectMilepostController extends BaseController
{
    @Autowired
    private IBusProjectMilepostService busProjectMilepostService;

    /**
     * 查询项目里程碑列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusProjectMilepost busProjectMilepost)
    {
        startPage();
        List<BusProjectMilepost> list = busProjectMilepostService.selectBusProjectMilepostList(busProjectMilepost);
        return getDataTable(list);
    }

    /**
     * 导出项目里程碑列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:export')")
    @Log(title = "项目里程碑", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProjectMilepost busProjectMilepost)
    {
        List<BusProjectMilepost> list = busProjectMilepostService.selectBusProjectMilepostList(busProjectMilepost);
        ExcelUtil<BusProjectMilepost> util = new ExcelUtil<BusProjectMilepost>(BusProjectMilepost.class);
        return util.exportExcel(list, "busProjectMilepost");
    }

    /**
     * 获取项目里程碑详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProjectMilepostService.selectBusProjectMilepostById(id));
    }

    /**
     * 新增项目里程碑
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:add')")
    @Log(title = "项目里程碑", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProjectMilepost busProjectMilepost)
    {
        return toAjax(busProjectMilepostService.insertBusProjectMilepost(busProjectMilepost));
    }

    /**
     * 修改项目里程碑
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:edit')")
    @Log(title = "项目里程碑", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProjectMilepost busProjectMilepost)
    {
        return toAjax(busProjectMilepostService.updateBusProjectMilepost(busProjectMilepost));
    }

    /**
     * 删除项目里程碑
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectMilepost:remove')")
    @Log(title = "项目里程碑", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProjectMilepostService.deleteBusProjectMilepostByIds(ids));
    }
}
