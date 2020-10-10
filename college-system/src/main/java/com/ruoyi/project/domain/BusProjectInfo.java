package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目信息对象 bus_project_info
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public class BusProjectInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long id;

    /** 项目省份 */
    @Excel(name = "项目省份")
    private String projectProvince;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目代号 */
    @Excel(name = "项目代号")
    private String projectAlias;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private Long projectLeader;

    /** 申请学校 */
    @Excel(name = "申请学校")
    private String applyingSchool;

    /** 紧急程度（0次要 1重要 2紧急 3特急） */
    @Excel(name = "紧急程度", readConverterExp = "0=次要,1=重要,2=紧急,3=特急")
    private Integer urgentLevel;

    /** 项目状态（0待提交 10审批中 11审批通过·预备项目 12审批不通过·审批项目 20遴选中 21遴选通过·拟建项目 22遴选不通过·预备项目 30审议中 31审议通过·立项项目 32审议不通过·预备项目 40资产报备审批中 41资产报备审批通过·实施准备 42资产报备审批不通过·预备项目 ） */
    @Excel(name = "项目状态", readConverterExp = "0=待提交,1=0审批中,1=1审批通过·预备项目,1=2审批不通过·审批项目,2=0遴选中,2=1遴选通过·拟建项目,2=2遴选不通过·预备项目,3=0审议中,3=1审议通过·立项项目,3=2审议不通过·预备项目,4=0资产报备审批中,4=1资产报备审批通过·实施准备,4=2资产报备审批不通过·预备项目")
    private Integer status;

    private Integer statusTeam;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectProvince(String projectProvince) 
    {
        this.projectProvince = projectProvince;
    }

    public String getProjectProvince() 
    {
        return projectProvince;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectAlias(String projectAlias) 
    {
        this.projectAlias = projectAlias;
    }

    public String getProjectAlias() 
    {
        return projectAlias;
    }
    public void setProjectLeader(Long projectLeader) 
    {
        this.projectLeader = projectLeader;
    }

    public Long getProjectLeader()
    {
        return projectLeader;
    }
    public void setApplyingSchool(String applyingSchool)
    {
        this.applyingSchool = applyingSchool;
    }

    public String getApplyingSchool()
    {
        return applyingSchool;
    }
    public void setUrgentLevel(Integer urgentLevel) 
    {
        this.urgentLevel = urgentLevel;
    }

    public Integer getUrgentLevel() 
    {
        return urgentLevel;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public Integer getStatusTeam() {
        return statusTeam;
    }

    public void setStatusTeam(Integer statusTeam) {
        this.statusTeam = statusTeam;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectProvince", getProjectProvince())
            .append("projectName", getProjectName())
            .append("projectAlias", getProjectAlias())
            .append("projectLeader", getProjectLeader())
            .append("applyingSchool", getApplyingSchool())
            .append("createTime", getCreateTime())
            .append("urgentLevel", getUrgentLevel())
            .append("status", getStatus())
            .toString();
    }
}
