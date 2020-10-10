package com.ruoyi.project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目可行性报告对象 bus_project_report
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
public class BusProjectReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报告ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 基本情况 */
    @Excel(name = "基本情况")
    private String basicInformation;

    /** 可行性与必要性 */
    @Excel(name = "可行性与必要性")
    private String feasibilityAndNecessity;

    /** 目标与内容 */
    @Excel(name = "目标与内容")
    private String objectiveAndContents;

    /** 预算与用途 */
    @Excel(name = "预算与用途")
    private String budgetAndUsage;

    /** 项目实施组织及进度安排 */
    @Excel(name = "项目实施组织及进度安排")
    private String organizeAndSchedule;

    /** 预期效益分析 */
    @Excel(name = "预期效益分析")
    private String benefitAnalyze;

    /** 保障措施 */
    @Excel(name = "保障措施")
    private String safeguardMeasures;

    /** 其他 */
    @Excel(name = "其他")
    private String other;

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
    public void setBasicInformation(String basicInformation) 
    {
        this.basicInformation = basicInformation;
    }

    public String getBasicInformation() 
    {
        return basicInformation;
    }
    public void setFeasibilityAndNecessity(String feasibilityAndNecessity) 
    {
        this.feasibilityAndNecessity = feasibilityAndNecessity;
    }

    public String getFeasibilityAndNecessity() 
    {
        return feasibilityAndNecessity;
    }
    public void setObjectiveAndContents(String objectiveAndContents) 
    {
        this.objectiveAndContents = objectiveAndContents;
    }

    public String getObjectiveAndContents() 
    {
        return objectiveAndContents;
    }
    public void setBudgetAndUsage(String budgetAndUsage) 
    {
        this.budgetAndUsage = budgetAndUsage;
    }

    public String getBudgetAndUsage() 
    {
        return budgetAndUsage;
    }
    public void setOrganizeAndSchedule(String organizeAndSchedule) 
    {
        this.organizeAndSchedule = organizeAndSchedule;
    }

    public String getOrganizeAndSchedule() 
    {
        return organizeAndSchedule;
    }
    public void setBenefitAnalyze(String benefitAnalyze) 
    {
        this.benefitAnalyze = benefitAnalyze;
    }

    public String getBenefitAnalyze() 
    {
        return benefitAnalyze;
    }
    public void setSafeguardMeasures(String safeguardMeasures) 
    {
        this.safeguardMeasures = safeguardMeasures;
    }

    public String getSafeguardMeasures() 
    {
        return safeguardMeasures;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("basicInformation", getBasicInformation())
            .append("feasibilityAndNecessity", getFeasibilityAndNecessity())
            .append("objectiveAndContents", getObjectiveAndContents())
            .append("budgetAndUsage", getBudgetAndUsage())
            .append("organizeAndSchedule", getOrganizeAndSchedule())
            .append("benefitAnalyze", getBenefitAnalyze())
            .append("safeguardMeasures", getSafeguardMeasures())
            .append("other", getOther())
            .toString();
    }
}
