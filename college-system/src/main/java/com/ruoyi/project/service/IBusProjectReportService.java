package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.BusProjectReport;

/**
 * 项目可行性报告Service接口
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
public interface IBusProjectReportService 
{
    /**
     * 查询项目可行性报告
     * 
     * @param id 项目可行性报告ID
     * @return 项目可行性报告
     */
    public BusProjectReport selectBusProjectReportById(Long id);

    /**
     * 根据项目id查询项目可行性报告
     *
     * @param projectId 项目可行性报告ID
     * @return 项目可行性报告
     */
    public BusProjectReport getReportProjectId(Long projectId);

    /**
     * 查询项目可行性报告列表
     * 
     * @param busProjectReport 项目可行性报告
     * @return 项目可行性报告集合
     */
    public List<BusProjectReport> selectBusProjectReportList(BusProjectReport busProjectReport);

    /**
     * 新增项目可行性报告
     * 
     * @param busProjectReport 项目可行性报告
     * @return 结果
     */
    public int insertBusProjectReport(BusProjectReport busProjectReport);

    /**
     * 修改项目可行性报告
     * 
     * @param busProjectReport 项目可行性报告
     * @return 结果
     */
    public int updateBusProjectReport(BusProjectReport busProjectReport);

    /**
     * 批量删除项目可行性报告
     * 
     * @param ids 需要删除的项目可行性报告ID
     * @return 结果
     */
    public int deleteBusProjectReportByIds(Long[] ids);

    /**
     * 删除项目可行性报告信息
     * 
     * @param id 项目可行性报告ID
     * @return 结果
     */
    public int deleteBusProjectReportById(Long id);
}
