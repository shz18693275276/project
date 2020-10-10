package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.BusProjectDeclarationMapper;
import com.ruoyi.project.domain.BusProjectDeclaration;
import com.ruoyi.project.service.IBusProjectDeclarationService;

/**
 * 项目申报书Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@Service
public class BusProjectDeclarationServiceImpl implements IBusProjectDeclarationService 
{
    @Autowired
    private BusProjectDeclarationMapper busProjectDeclarationMapper;

    /**
     * 查询项目申报书
     * 
     * @param id 项目申报书ID
     * @return 项目申报书
     */
    @Override
    public BusProjectDeclaration selectBusProjectDeclarationById(Long id)
    {
        return busProjectDeclarationMapper.selectBusProjectDeclarationById(id);
    }

    /**
     * 查询项目申报书列表
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 项目申报书
     */
    @Override
    public List<BusProjectDeclaration> selectBusProjectDeclarationList(BusProjectDeclaration busProjectDeclaration)
    {
        return busProjectDeclarationMapper.selectBusProjectDeclarationList(busProjectDeclaration);
    }

    /**
     * 新增项目申报书
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 结果
     */
    @Override
    public int insertBusProjectDeclaration(BusProjectDeclaration busProjectDeclaration)
    {
        return busProjectDeclarationMapper.insertBusProjectDeclaration(busProjectDeclaration);
    }

    /**
     * 修改项目申报书
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 结果
     */
    @Override
    public int updateBusProjectDeclaration(BusProjectDeclaration busProjectDeclaration)
    {
        return busProjectDeclarationMapper.updateBusProjectDeclaration(busProjectDeclaration);
    }

    /**
     * 批量删除项目申报书
     * 
     * @param ids 需要删除的项目申报书ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectDeclarationByIds(Long[] ids)
    {
        return busProjectDeclarationMapper.deleteBusProjectDeclarationByIds(ids);
    }

    /**
     * 删除项目申报书信息
     * 
     * @param id 项目申报书ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectDeclarationById(Long id)
    {
        return busProjectDeclarationMapper.deleteBusProjectDeclarationById(id);
    }
}
