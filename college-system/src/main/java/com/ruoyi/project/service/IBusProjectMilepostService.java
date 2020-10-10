package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.BusProjectMilepost;

/**
 * 项目里程碑Service接口
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public interface IBusProjectMilepostService 
{
    /**
     * 查询项目里程碑
     * 
     * @param id 项目里程碑ID
     * @return 项目里程碑
     */
    public BusProjectMilepost selectBusProjectMilepostById(Long id);

    /**
     * 查询项目里程碑列表
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 项目里程碑集合
     */
    public List<BusProjectMilepost> selectBusProjectMilepostList(BusProjectMilepost busProjectMilepost);

    /**
     * 新增项目里程碑
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 结果
     */
    public int insertBusProjectMilepost(BusProjectMilepost busProjectMilepost);

    /**
     * 修改项目里程碑
     * 
     * @param busProjectMilepost 项目里程碑
     * @return 结果
     */
    public int updateBusProjectMilepost(BusProjectMilepost busProjectMilepost);

    /**
     * 批量删除项目里程碑
     * 
     * @param ids 需要删除的项目里程碑ID
     * @return 结果
     */
    public int deleteBusProjectMilepostByIds(Long[] ids);

    /**
     * 删除项目里程碑信息
     * 
     * @param id 项目里程碑ID
     * @return 结果
     */
    public int deleteBusProjectMilepostById(Long id);
}
