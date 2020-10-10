package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目里程碑对象 bus_project_milepost
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public class BusProjectMilepost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 里程碑ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 操作内容 */
    @Excel(name = "操作内容")
    private String operateContent;

    /** 操作用户 */
    @Excel(name = "操作用户")
    private String operatePerson;

    /** 操作原因 */
    @Excel(name = "操作原因")
    private String operateReason;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setOperateContent(String operateContent) 
    {
        this.operateContent = operateContent;
    }

    public String getOperateContent() 
    {
        return operateContent;
    }
    public void setOperatePerson(String operatePerson) 
    {
        this.operatePerson = operatePerson;
    }

    public String getOperatePerson() 
    {
        return operatePerson;
    }
    public void setOperateReason(String operateReason) 
    {
        this.operateReason = operateReason;
    }

    public String getOperateReason() 
    {
        return operateReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("operateContent", getOperateContent())
            .append("operatePerson", getOperatePerson())
            .append("operateReason", getOperateReason())
            .append("createTime", getCreateTime())
            .toString();
    }
}
