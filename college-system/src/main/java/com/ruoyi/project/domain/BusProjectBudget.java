package com.ruoyi.project.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目预算对象 bus_project_budget
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
public class BusProjectBudget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预算ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备型号规格 */
    @Excel(name = "设备型号规格")
    private String deviceModel;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal devicePrice;

    /** 单位 */
    @Excel(name = "单位")
    private String deviceUnit;

    /** 数量 */
    @Excel(name = "数量")
    private Long deviceNum;

    /** 金额（万元） */
    @Excel(name = "金额", readConverterExp = "万=元")
    private BigDecimal totlaPrice;

    /** 中央财政拨款 */
    @Excel(name = "中央财政拨款")
    private BigDecimal centralFinancial;

    /** 省财政拨款 */
    @Excel(name = "省财政拨款")
    private BigDecimal provincialFinancial;

    /** 自筹资金 */
    @Excel(name = "自筹资金")
    private BigDecimal selfFinancing;

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
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setDeviceModel(String deviceModel) 
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel() 
    {
        return deviceModel;
    }
    public void setDevicePrice(BigDecimal devicePrice) 
    {
        this.devicePrice = devicePrice;
    }

    public BigDecimal getDevicePrice() 
    {
        return devicePrice;
    }
    public void setDeviceUnit(String deviceUnit) 
    {
        this.deviceUnit = deviceUnit;
    }

    public String getDeviceUnit() 
    {
        return deviceUnit;
    }
    public void setDeviceNum(Long deviceNum) 
    {
        this.deviceNum = deviceNum;
    }

    public Long getDeviceNum() 
    {
        return deviceNum;
    }
    public void setTotlaPrice(BigDecimal totlaPrice) 
    {
        this.totlaPrice = totlaPrice;
    }

    public BigDecimal getTotlaPrice() 
    {
        return totlaPrice;
    }
    public void setCentralFinancial(BigDecimal centralFinancial) 
    {
        this.centralFinancial = centralFinancial;
    }

    public BigDecimal getCentralFinancial() 
    {
        return centralFinancial;
    }
    public void setProvincialFinancial(BigDecimal provincialFinancial) 
    {
        this.provincialFinancial = provincialFinancial;
    }

    public BigDecimal getProvincialFinancial() 
    {
        return provincialFinancial;
    }
    public void setSelfFinancing(BigDecimal selfFinancing) 
    {
        this.selfFinancing = selfFinancing;
    }

    public BigDecimal getSelfFinancing() 
    {
        return selfFinancing;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("deviceName", getDeviceName())
            .append("deviceModel", getDeviceModel())
            .append("devicePrice", getDevicePrice())
            .append("deviceUnit", getDeviceUnit())
            .append("deviceNum", getDeviceNum())
            .append("totlaPrice", getTotlaPrice())
            .append("centralFinancial", getCentralFinancial())
            .append("provincialFinancial", getProvincialFinancial())
            .append("selfFinancing", getSelfFinancing())
            .toString();
    }
}
