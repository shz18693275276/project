package com.ruoyi.web.controller.project;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
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
import com.ruoyi.project.domain.BusProjectInfo;
import com.ruoyi.project.service.IBusProjectInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@RestController
@RequestMapping("/project")
public class BusProjectInfoController extends BaseController
{
    @Autowired
    private IBusProjectInfoService busProjectInfoService;

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:declare:list')")
    @GetMapping("/declare/list")
    public TableDataInfo declareList(BusProjectInfo busProjectInfo)
    {
        startPage();
        busProjectInfo.setStatusTeam(0);
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        return getDataTable(list);
    }

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:prepare:list')")
    @GetMapping("/prepare/list")
    public TableDataInfo listPrepare(BusProjectInfo busProjectInfo)
    {
        startPage();
        busProjectInfo.setStatusTeam(1);
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        return getDataTable(list);
    }

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:simulate:list')")
    @GetMapping("/simulate/list")
    public TableDataInfo listSimulate(BusProjectInfo busProjectInfo)
    {
        startPage();
        busProjectInfo.setStatusTeam(2);
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        return getDataTable(list);
    }

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:establish:list')")
    @GetMapping("/establish/list")
    public TableDataInfo listEstablish(BusProjectInfo busProjectInfo)
    {
        startPage();
        busProjectInfo.setStatusTeam(3);
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        return getDataTable(list);
    }

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:urgent:list')")
    @GetMapping("/urgent/list")
    public TableDataInfo listUrgent(BusProjectInfo busProjectInfo)
    {
        startPage();
        busProjectInfo.setStatusTeam(4);
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectInfo:export')")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProjectInfo busProjectInfo)
    {
        List<BusProjectInfo> list = busProjectInfoService.selectBusProjectInfoList(busProjectInfo);
        ExcelUtil<BusProjectInfo> util = new ExcelUtil<BusProjectInfo>(BusProjectInfo.class);
        return util.exportExcel(list, "busProjectInfo");
    }

    /**
     * 获取项目信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProjectInfoService.selectBusProjectInfoById(id));
    }

    /**
     * 新增项目信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectInfo:add')")
    @Log(title = "项目信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProjectInfo busProjectInfo)
    {
        return toAjax(busProjectInfoService.insertBusProjectInfo(busProjectInfo));
    }

    /**
     * 修改项目信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectInfo:edit')")
    @Log(title = "项目信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProjectInfo busProjectInfo)
    {
        return toAjax(busProjectInfoService.updateBusProjectInfo(busProjectInfo));
    }

    /**
     * 删除项目信息
     */
    @PreAuthorize("@ss.hasPermi('project:busProjectInfo:remove')")
    @Log(title = "项目信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProjectInfoService.deleteBusProjectInfoByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('project:prepare:submit')")
    @Log(title = "项目信息", businessType = BusinessType.DELETE)
    @GetMapping("/busProjectInfo/updatePorjectStatus/{id}/{status}")
    public JSONObject updatePorjectStatus(@PathVariable Long id, @PathVariable Integer status){
        JSONObject jsonObject = new JSONObject();
        jsonObject = busProjectInfoService.updateProjectStatus(id, status);

        return jsonObject;
    }

    @PreAuthorize("@ss.hasPermi('project:prepare:submit')")
    @GetMapping("/busProjectInfo/projectDetails/{id}")
    public JSONObject projectDetails(@PathVariable Long id){
        if (id != null){
            return busProjectInfoService.projectDetails(id);
        }else {
         return  null;
        }
    }

}
