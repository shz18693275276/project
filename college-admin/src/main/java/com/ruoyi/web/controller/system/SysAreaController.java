package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * 区域信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/area")
public class SysAreaController extends BaseController {
    @Autowired
    private ISysDeptService deptService;


    /**
     * 查询区域列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:area:list')")
    @GetMapping("/list/exclude/{deptId}")
    public AjaxResult excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext()) {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() == deptId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptId + "")) {
                it.remove();
            }
        }
        return AjaxResult.success(depts);
    }

    /**
     * 根据区域编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:area:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 获取区域下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysDept dept) {
        List<SysDept> depts = deptService.selectDeptList(dept);
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 加载对应角色区域列表树
     */
    @GetMapping(value = "/roleDeptTreeselect/{roleId}")
    public AjaxResult roleDeptTreeselect(@PathVariable("roleId") Long roleId) {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", deptService.selectDeptListByRoleId(roleId));
        ajax.put("depts", deptService.buildDeptTreeSelect(depts));
        return ajax;
    }


    /**
     * 删除区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:remove')")
    @Log(title = "区域管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptId}")
    public AjaxResult remove(@PathVariable Long deptId) {
        if (deptService.hasChildByDeptId(deptId)) {
            return AjaxResult.error("存在下级区域,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId)) {
            return AjaxResult.error("区域存在用户,不允许删除");
        }
        return toAjax(deptService.deleteDeptById(deptId));
    }


    /**
     * 获取区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area:list')")
    @GetMapping("/list")
    public AjaxResult list(SysDept dept) {
        List<SysDept> sysDepts = deptService.selectAreaList(dept);
       // List<SysDept> depts = deptService.selectAreaList(dept);
        return AjaxResult.success(sysDepts);
    }

    /**
     * 修改区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:edit')")
    @Log(title = "区域管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDept dept) {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
            return AjaxResult.error("修改区域'" + dept.getDeptName() + "'失败，区域名称已存在");
        } else if (dept.getParentId().equals(dept.getDeptId())) {
            return AjaxResult.error("修改区域'" + dept.getDeptName() + "'失败，上级区域不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0) {
            return AjaxResult.error("该区域包含未停用的子区域！");
        }
        dept.setUpdateBy(SecurityUtils.getUsername());
        int i = deptService.updateDept2(dept);
        return toAjax(i);
    }
        /**
         * 新增区域
         */
        @PreAuthorize("@ss.hasPermi('system:area:add')")
        @Log(title = "区域管理", businessType = BusinessType.INSERT)
        @PostMapping
        public AjaxResult add (@Validated @RequestBody SysDept dept){
            dept.setParentId(0L);
            if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique2(dept))) {
                dept.setCreateBy(SecurityUtils.getUsername());
                int s = deptService.insertDept2(dept);
                return toAjax(s);
            }
            return AjaxResult.error("新增区域'" + dept.getDeptName() + "'失败，区域名称已存在");

        }
    }
