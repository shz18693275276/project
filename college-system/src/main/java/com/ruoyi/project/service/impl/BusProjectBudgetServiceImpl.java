package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.BusProjectBudgetMapper;
import com.ruoyi.project.domain.BusProjectBudget;
import com.ruoyi.project.service.IBusProjectBudgetService;

/**
 * 项目预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
@Service
public class BusProjectBudgetServiceImpl implements IBusProjectBudgetService 
{
    @Autowired
    private BusProjectBudgetMapper busProjectBudgetMapper;

    /**
     * 查询项目预算
     * 
     * @param id 项目预算ID
     * @return 项目预算
     */
    @Override
    public BusProjectBudget selectBusProjectBudgetById(Long id)
    {
        return busProjectBudgetMapper.selectBusProjectBudgetById(id);
    }

    /**
     * 查询项目预算列表
     * 
     * @param busProjectBudget 项目预算
     * @return 项目预算
     */
    @Override
    public List<BusProjectBudget> selectBusProjectBudgetList(BusProjectBudget busProjectBudget)
    {
        return busProjectBudgetMapper.selectBusProjectBudgetList(busProjectBudget);
    }

    /**
     * 新增项目预算
     * 
     * @param busProjectBudget 项目预算
     * @return 结果
     */
    @Override
    public int insertBusProjectBudget(BusProjectBudget busProjectBudget)
    {
        return busProjectBudgetMapper.insertBusProjectBudget(busProjectBudget);
    }

    /**
     * 修改项目预算
     * 
     * @param busProjectBudget 项目预算
     * @return 结果
     */
    @Override
    public int updateBusProjectBudget(BusProjectBudget busProjectBudget)
    {
        return busProjectBudgetMapper.updateBusProjectBudget(busProjectBudget);
    }

    /**
     * 批量删除项目预算
     * 
     * @param ids 需要删除的项目预算ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectBudgetByIds(Long[] ids)
    {
        return busProjectBudgetMapper.deleteBusProjectBudgetByIds(ids);
    }

    /**
     * 删除项目预算信息
     * 
     * @param id 项目预算ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectBudgetById(Long id)
    {
        return busProjectBudgetMapper.deleteBusProjectBudgetById(id);
    }
}
