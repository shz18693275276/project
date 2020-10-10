package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.BusProjectReportMapper;
import com.ruoyi.project.domain.BusProjectReport;
import com.ruoyi.project.service.IBusProjectReportService;

/**
 * 项目可行性报告Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
@Service
public class BusProjectReportServiceImpl implements IBusProjectReportService 
{
    @Autowired
    private BusProjectReportMapper busProjectReportMapper;

    /**
     * 查询项目可行性报告
     * 
     * @param id 项目可行性报告ID
     * @return 项目可行性报告
     */
    @Override
    public BusProjectReport selectBusProjectReportById(Long id)
    {
        return busProjectReportMapper.selectBusProjectReportById(id);
    }

    /**
     * 根据项目id查询项目可行性报告
     *
     * @param projectId 项目可行性报告ID
     * @return 项目可行性报告
     */
    public BusProjectReport getReportProjectId(Long projectId)
    {
        return busProjectReportMapper.getReportProjectId(projectId);
    }

    /**
     * 查询项目可行性报告列表
     * 
     * @param busProjectReport 项目可行性报告
     * @return 项目可行性报告
     */
    @Override
    public List<BusProjectReport> selectBusProjectReportList(BusProjectReport busProjectReport)
    {
        return busProjectReportMapper.selectBusProjectReportList(busProjectReport);
    }

    /**
     * 新增项目可行性报告
     * 
     * @param busProjectReport 项目可行性报告
     * @return 结果
     */
    @Override
    public int insertBusProjectReport(BusProjectReport busProjectReport)
    {
        return busProjectReportMapper.insertBusProjectReport(busProjectReport);
    }

    /**
     * 修改项目可行性报告
     * 
     * @param busProjectReport 项目可行性报告
     * @return 结果
     */
    @Override
    public int updateBusProjectReport(BusProjectReport busProjectReport)
    {
        return busProjectReportMapper.updateBusProjectReport(busProjectReport);
    }

    /**
     * 批量删除项目可行性报告
     * 
     * @param ids 需要删除的项目可行性报告ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectReportByIds(Long[] ids)
    {
        return busProjectReportMapper.deleteBusProjectReportByIds(ids);
    }

    /**
     * 删除项目可行性报告信息
     * 
     * @param id 项目可行性报告ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectReportById(Long id)
    {
        return busProjectReportMapper.deleteBusProjectReportById(id);
    }
}
