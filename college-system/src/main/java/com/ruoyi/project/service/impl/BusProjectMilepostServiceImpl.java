package com.ruoyi.project.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.BusProjectMilepostMapper;
import com.ruoyi.project.domain.BusProjectMilepost;
import com.ruoyi.project.service.IBusProjectMilepostService;

/**
 * 项目里程碑Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@Service
public class BusProjectMilepostServiceImpl implements IBusProjectMilepostService 
{
    @Autowired
    private BusProjectMilepostMapper busProjectMilepostMapper;

    /**
     * 查询项目里程碑
     * 
     * @param id 项目里程碑ID
     * @return 项目里程碑
     */
    @Override
    public BusProjectMilepost selectBusProjectMilepostById(Long id)
    {
        return busProjectMilepostMapper.selectBusProjectMilepostById(id);
    }

    /**
     * 查询项目里程碑列表
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 项目里程碑
     */
    @Override
    public List<BusProjectMilepost> selectBusProjectMilepostList(BusProjectMilepost busProjectMilepost)
    {
        return busProjectMilepostMapper.selectBusProjectMilepostList(busProjectMilepost);
    }

    /**
     * 新增项目里程碑
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 结果
     */
    @Override
    public int insertBusProjectMilepost(BusProjectMilepost busProjectMilepost)
    {
        busProjectMilepost.setCreateTime(DateUtils.getNowDate());
        return busProjectMilepostMapper.insertBusProjectMilepost(busProjectMilepost);
    }

    /**
     * 修改项目里程碑
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 结果
     */
    @Override
    public int updateBusProjectMilepost(BusProjectMilepost busProjectMilepost)
    {
        return busProjectMilepostMapper.updateBusProjectMilepost(busProjectMilepost);
    }

    /**
     * 批量删除项目里程碑
     * 
     * @param ids 需要删除的项目里程碑ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectMilepostByIds(Long[] ids)
    {
        return busProjectMilepostMapper.deleteBusProjectMilepostByIds(ids);
    }

    /**
     * 删除项目里程碑信息
     * 
     * @param id 项目里程碑ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectMilepostById(Long id)
    {
        return busProjectMilepostMapper.deleteBusProjectMilepostById(id);
    }
}
