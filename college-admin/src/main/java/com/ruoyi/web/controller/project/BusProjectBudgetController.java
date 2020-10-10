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
import com.ruoyi.project.domain.BusProjectBudget;
import com.ruoyi.project.service.IBusProjectBudgetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目预算Controller
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
@RestController
@RequestMapping("/project/busProjectBudget")
public class BusProjectBudgetController extends BaseController
{
    @Autowired
    private IBusProjectBudgetService busProjectBudgetService;

    /**
     * 查询项目预算列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusProjectBudget busProjectBudget)
    {
        startPage();
        List<BusProjectBudget> list = busProjectBudgetService.selectBusProjectBudgetList(busProjectBudget);
        return getDataTable(list);
    }

    /**
     * 导出项目预算列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:export')")
    @Log(title = "项目预算", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProjectBudget busProjectBudget)
    {
        List<BusProjectBudget> list = busProjectBudgetService.selectBusProjectBudgetList(busProjectBudget);
        ExcelUtil<BusProjectBudget> util = new ExcelUtil<BusProjectBudget>(BusProjectBudget.class);
        return util.exportExcel(list, "busProjectBudget");
    }

    /**
     * 获取项目预算详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProjectBudgetService.selectBusProjectBudgetById(id));
    }

    /**
     * 新增项目预算
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:add')")
    @Log(title = "项目预算", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProjectBudget busProjectBudget)
    {
        return toAjax(busProjectBudgetService.insertBusProjectBudget(busProjectBudget));
    }

    /**
     * 修改项目预算
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:edit')")
    @Log(title = "项目预算", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProjectBudget busProjectBudget)
    {
        return toAjax(busProjectBudgetService.updateBusProjectBudget(busProjectBudget));
    }

    /**
     * 删除项目预算
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectBudget:remove')")
    @Log(title = "项目预算", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProjectBudgetService.deleteBusProjectBudgetByIds(ids));
    }
}
