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
import com.ruoyi.project.domain.BusProjectReport;
import com.ruoyi.project.service.IBusProjectReportService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目可行性报告Controller
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
@RestController
@RequestMapping("/project/busProjectReport")
public class BusProjectReportController extends BaseController
{
    @Autowired
    private IBusProjectReportService busProjectReportService;

    /**
     * 查询项目可行性报告列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusProjectReport busProjectReport)
    {
        startPage();
        List<BusProjectReport> list = busProjectReportService.selectBusProjectReportList(busProjectReport);
        return getDataTable(list);
    }

    /**
     * 导出项目可行性报告列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:export')")
    @Log(title = "项目可行性报告", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProjectReport busProjectReport)
    {
        List<BusProjectReport> list = busProjectReportService.selectBusProjectReportList(busProjectReport);
        ExcelUtil<BusProjectReport> util = new ExcelUtil<BusProjectReport>(BusProjectReport.class);
        return util.exportExcel(list, "busProjectReport");
    }

    /**
     * 获取项目可行性报告详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProjectReportService.selectBusProjectReportById(id));
    }

    /**
     * 获取项目可行性报告详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:query')")
    @GetMapping(value = "getReportProjectId/{projectId}")
    public AjaxResult getReportProjectId(@PathVariable("projectId") Long projectId)
    {
        return AjaxResult.success(busProjectReportService.getReportProjectId(projectId));
    }

    /**
     * 新增项目可行性报告
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:add')")
    @Log(title = "项目可行性报告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProjectReport busProjectReport)
    {
        return toAjax(busProjectReportService.insertBusProjectReport(busProjectReport));
    }

    /**
     * 修改项目可行性报告
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:edit')")
    @Log(title = "项目可行性报告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProjectReport busProjectReport)
    {
        return toAjax(busProjectReportService.updateBusProjectReport(busProjectReport));
    }

    /**
     * 删除项目可行性报告
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectReport:remove')")
    @Log(title = "项目可行性报告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProjectReportService.deleteBusProjectReportByIds(ids));
    }
}
