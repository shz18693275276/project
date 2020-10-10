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
import com.ruoyi.project.domain.BusProjectDeclaration;
import com.ruoyi.project.service.IBusProjectDeclarationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目申报书Controller
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@RestController
@RequestMapping("/project/busProjectDeclaration")
public class BusProjectDeclarationController extends BaseController
{
    @Autowired
    private IBusProjectDeclarationService busProjectDeclarationService;

    /**
     * 查询项目申报书列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusProjectDeclaration busProjectDeclaration)
    {
        startPage();
        List<BusProjectDeclaration> list = busProjectDeclarationService.selectBusProjectDeclarationList(busProjectDeclaration);
        return getDataTable(list);
    }

    /**
     * 导出项目申报书列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:export')")
    @Log(title = "项目申报书", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProjectDeclaration busProjectDeclaration)
    {
        List<BusProjectDeclaration> list = busProjectDeclarationService.selectBusProjectDeclarationList(busProjectDeclaration);
        ExcelUtil<BusProjectDeclaration> util = new ExcelUtil<BusProjectDeclaration>(BusProjectDeclaration.class);
        return util.exportExcel(list, "busProjectDeclaration");
    }

    /**
     * 获取项目申报书详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProjectDeclarationService.selectBusProjectDeclarationById(id));
    }

    /**
     * 新增项目申报书
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:add')")
    @Log(title = "项目申报书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProjectDeclaration busProjectDeclaration)
    {
        return toAjax(busProjectDeclarationService.insertBusProjectDeclaration(busProjectDeclaration));
    }

    /**
     * 修改项目申报书
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:edit')")
    @Log(title = "项目申报书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProjectDeclaration busProjectDeclaration)
    {
        return toAjax(busProjectDeclarationService.updateBusProjectDeclaration(busProjectDeclaration));
    }

    /**
     * 删除项目申报书
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectDeclaration:remove')")
    @Log(title = "项目申报书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProjectDeclarationService.deleteBusProjectDeclarationByIds(ids));
    }
}
