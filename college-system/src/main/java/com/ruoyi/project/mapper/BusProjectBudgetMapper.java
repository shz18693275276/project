package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.BusProjectBudget;

/**
 * 项目预算Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-24
 */
public interface BusProjectBudgetMapper 
{
    /**
     * 查询项目预算
     * 
     * @param id 项目预算ID
     * @return 项目预算
     */
    public BusProjectBudget selectBusProjectBudgetById(Long id);

    /**
     * 查询项目预算列表
     * 
     * @param busProjectBudget 项目预算
     * @return 项目预算集合
     */
    public List<BusProjectBudget> selectBusProjectBudgetList(BusProjectBudget busProjectBudget);

    /**
     * 新增项目预算
     * 
     * @param busProjectBudget 项目预算
     * @return 结果
     */
    public int insertBusProjectBudget(BusProjectBudget busProjectBudget);

    /**
     * 修改项目预算
     * 
     * @param busProjectBudget 项目预算
     * @return 结果
     */
    public int updateBusProjectBudget(BusProjectBudget busProjectBudget);

    /**
     * 删除项目预算
     * 
     * @param id 项目预算ID
     * @return 结果
     */
    public int deleteBusProjectBudgetById(Long id);

    /**
     * 批量删除项目预算
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusProjectBudgetByIds(Long[] ids);

    public BusProjectBudget selectProjectBudgetByProjectId(Long projectId);
}
