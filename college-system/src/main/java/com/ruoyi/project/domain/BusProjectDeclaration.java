package com.ruoyi.project.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目申报书对象 bus_project_declaration
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public class BusProjectDeclaration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 学校类别 */
    @Excel(name = "学校类别")
    private Integer schoolType;

    /** 学校地址 */
    @Excel(name = "学校地址")
    private String schoolAddress;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 学生人数 */
    @Excel(name = "学生人数")
    private Long schoolStudent;

    /** 本专科生 */
    @Excel(name = "本专科生")
    private Long schoolStudentSpecialty;

    /** 硕士生 */
    @Excel(name = "硕士生")
    private Long schoolStudentMaster;

    /** 博士生 */
    @Excel(name = "博士生")
    private Long schoolStudentDoctor;

    /** 教师人数 */
    @Excel(name = "教师人数")
    private Long schoolTeacher;

    /** 专任教师 */
    @Excel(name = "专任教师")
    private Long schoolTeacherRegular;

    /** 教授 */
    @Excel(name = "教授")
    private Long schoolTeacherProfessor;

    /** 副教授 */
    @Excel(name = "副教授")
    private Long schoolTeacherReProfessor;

    /** 国家重点学科数（个） */
    @Excel(name = "国家重点学科数", readConverterExp = "个=")
    private Long countryStudyCourse;

    /** 省级重点学科数（个） */
    @Excel(name = "省级重点学科数", readConverterExp = "个=")
    private Long provincialStudyCourse;

    /** 国家重点研究基地（个） */
    @Excel(name = "国家重点研究基地", readConverterExp = "个=")
    private Long countryResearchBase;

    /** 省级重点研究基地（个） */
    @Excel(name = "省级重点研究基地", readConverterExp = "个=")
    private Long provincialResearchBase;

    /** 现有固定资产总值（万元） */
    @Excel(name = "现有固定资产总值", readConverterExp = "万=元")
    private Long existingFixedAssets;

    /** 房屋建筑物总值（万元） */
    @Excel(name = "房屋建筑物总值", readConverterExp = "万=元")
    private Long buildingValue;

    /** 房屋建筑面积（㎡） */
    @Excel(name = "房屋建筑面积", readConverterExp = "㎡=")
    private BigDecimal buildingArea;

    /** 40万以上大型仪器设备（台） */
    @Excel(name = "40万以上大型仪器设备", readConverterExp = "台=")
    private Long equipment40wOver;

    /** 大型专用仪器设备总值(万元) */
    @Excel(name = "大型专用仪器设备总值(万元)")
    private BigDecimal equipmentSpecializedValue;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private Integer projectType;

    /** 申请资金总额（万元） */
    @Excel(name = "申请资金总额", readConverterExp = "万=元")
    private BigDecimal applicationAmount;

    /** 中央财政 */
    @Excel(name = "中央财政")
    private BigDecimal centralFinanceAmount;

    /** 地方自筹 */
    @Excel(name = "地方自筹")
    private BigDecimal localFundingAmount;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String projectLeader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 项目简介 */
    @Excel(name = "项目简介")
    private String projectIntroduction;

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
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setSchoolType(Integer schoolType) 
    {
        this.schoolType = schoolType;
    }

    public Integer getSchoolType() 
    {
        return schoolType;
    }
    public void setSchoolAddress(String schoolAddress) 
    {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolAddress() 
    {
        return schoolAddress;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setSchoolStudent(Long schoolStudent) 
    {
        this.schoolStudent = schoolStudent;
    }

    public Long getSchoolStudent() 
    {
        return schoolStudent;
    }
    public void setSchoolStudentSpecialty(Long schoolStudentSpecialty) 
    {
        this.schoolStudentSpecialty = schoolStudentSpecialty;
    }

    public Long getSchoolStudentSpecialty() 
    {
        return schoolStudentSpecialty;
    }
    public void setSchoolStudentMaster(Long schoolStudentMaster) 
    {
        this.schoolStudentMaster = schoolStudentMaster;
    }

    public Long getSchoolStudentMaster() 
    {
        return schoolStudentMaster;
    }
    public void setSchoolStudentDoctor(Long schoolStudentDoctor) 
    {
        this.schoolStudentDoctor = schoolStudentDoctor;
    }

    public Long getSchoolStudentDoctor() 
    {
        return schoolStudentDoctor;
    }
    public void setSchoolTeacher(Long schoolTeacher) 
    {
        this.schoolTeacher = schoolTeacher;
    }

    public Long getSchoolTeacher() 
    {
        return schoolTeacher;
    }
    public void setSchoolTeacherRegular(Long schoolTeacherRegular) 
    {
        this.schoolTeacherRegular = schoolTeacherRegular;
    }

    public Long getSchoolTeacherRegular() 
    {
        return schoolTeacherRegular;
    }
    public void setSchoolTeacherProfessor(Long schoolTeacherProfessor) 
    {
        this.schoolTeacherProfessor = schoolTeacherProfessor;
    }

    public Long getSchoolTeacherProfessor() 
    {
        return schoolTeacherProfessor;
    }
    public void setSchoolTeacherReProfessor(Long schoolTeacherReProfessor) 
    {
        this.schoolTeacherReProfessor = schoolTeacherReProfessor;
    }

    public Long getSchoolTeacherReProfessor() 
    {
        return schoolTeacherReProfessor;
    }
    public void setCountryStudyCourse(Long countryStudyCourse) 
    {
        this.countryStudyCourse = countryStudyCourse;
    }

    public Long getCountryStudyCourse() 
    {
        return countryStudyCourse;
    }
    public void setProvincialStudyCourse(Long provincialStudyCourse) 
    {
        this.provincialStudyCourse = provincialStudyCourse;
    }

    public Long getProvincialStudyCourse() 
    {
        return provincialStudyCourse;
    }
    public void setCountryResearchBase(Long countryResearchBase) 
    {
        this.countryResearchBase = countryResearchBase;
    }

    public Long getCountryResearchBase() 
    {
        return countryResearchBase;
    }
    public void setProvincialResearchBase(Long provincialResearchBase) 
    {
        this.provincialResearchBase = provincialResearchBase;
    }

    public Long getProvincialResearchBase() 
    {
        return provincialResearchBase;
    }
    public void setExistingFixedAssets(Long existingFixedAssets) 
    {
        this.existingFixedAssets = existingFixedAssets;
    }

    public Long getExistingFixedAssets() 
    {
        return existingFixedAssets;
    }
    public void setBuildingValue(Long buildingValue) 
    {
        this.buildingValue = buildingValue;
    }

    public Long getBuildingValue() 
    {
        return buildingValue;
    }
    public void setBuildingArea(BigDecimal buildingArea) 
    {
        this.buildingArea = buildingArea;
    }

    public BigDecimal getBuildingArea() 
    {
        return buildingArea;
    }
    public void setEquipment40wOver(Long equipment40wOver) 
    {
        this.equipment40wOver = equipment40wOver;
    }

    public Long getEquipment40wOver() 
    {
        return equipment40wOver;
    }
    public void setEquipmentSpecializedValue(BigDecimal equipmentSpecializedValue) 
    {
        this.equipmentSpecializedValue = equipmentSpecializedValue;
    }

    public BigDecimal getEquipmentSpecializedValue() 
    {
        return equipmentSpecializedValue;
    }
    public void setProjectType(Integer projectType) 
    {
        this.projectType = projectType;
    }

    public Integer getProjectType() 
    {
        return projectType;
    }
    public void setApplicationAmount(BigDecimal applicationAmount) 
    {
        this.applicationAmount = applicationAmount;
    }

    public BigDecimal getApplicationAmount() 
    {
        return applicationAmount;
    }
    public void setCentralFinanceAmount(BigDecimal centralFinanceAmount) 
    {
        this.centralFinanceAmount = centralFinanceAmount;
    }

    public BigDecimal getCentralFinanceAmount() 
    {
        return centralFinanceAmount;
    }
    public void setLocalFundingAmount(BigDecimal localFundingAmount) 
    {
        this.localFundingAmount = localFundingAmount;
    }

    public BigDecimal getLocalFundingAmount() 
    {
        return localFundingAmount;
    }
    public void setProjectLeader(String projectLeader) 
    {
        this.projectLeader = projectLeader;
    }

    public String getProjectLeader() 
    {
        return projectLeader;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setProjectIntroduction(String projectIntroduction) 
    {
        this.projectIntroduction = projectIntroduction;
    }

    public String getProjectIntroduction() 
    {
        return projectIntroduction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("schoolName", getSchoolName())
            .append("schoolType", getSchoolType())
            .append("schoolAddress", getSchoolAddress())
            .append("postalCode", getPostalCode())
            .append("schoolStudent", getSchoolStudent())
            .append("schoolStudentSpecialty", getSchoolStudentSpecialty())
            .append("schoolStudentMaster", getSchoolStudentMaster())
            .append("schoolStudentDoctor", getSchoolStudentDoctor())
            .append("schoolTeacher", getSchoolTeacher())
            .append("schoolTeacherRegular", getSchoolTeacherRegular())
            .append("schoolTeacherProfessor", getSchoolTeacherProfessor())
            .append("schoolTeacherReProfessor", getSchoolTeacherReProfessor())
            .append("countryStudyCourse", getCountryStudyCourse())
            .append("provincialStudyCourse", getProvincialStudyCourse())
            .append("countryResearchBase", getCountryResearchBase())
            .append("provincialResearchBase", getProvincialResearchBase())
            .append("existingFixedAssets", getExistingFixedAssets())
            .append("buildingValue", getBuildingValue())
            .append("buildingArea", getBuildingArea())
            .append("equipment40wOver", getEquipment40wOver())
            .append("equipmentSpecializedValue", getEquipmentSpecializedValue())
            .append("projectType", getProjectType())
            .append("applicationAmount", getApplicationAmount())
            .append("centralFinanceAmount", getCentralFinanceAmount())
            .append("localFundingAmount", getLocalFundingAmount())
            .append("projectLeader", getProjectLeader())
            .append("contactNumber", getContactNumber())
            .append("projectIntroduction", getProjectIntroduction())
            .toString();
    }
}
