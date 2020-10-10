package com.ruoyi.project.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.project.domain.BusProjectInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 项目信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public interface BusProjectInfoMapper 
{
    /**
     * 查询项目信息
     * 
     * @param id 项目信息ID
     * @return 项目信息
     */
    public BusProjectInfo selectBusProjectInfoById(Long id);

    /**
     * 查询项目信息列表
     * 
     * @param busProjectInfo 项目信息
     * @return 项目信息集合
     */
    public List<BusProjectInfo> selectBusProjectInfoList(BusProjectInfo busProjectInfo);

    /**
     * 新增项目信息
     * 
     * @param busProjectInfo 项目信息
     * @return 结果
     */
    public int insertBusProjectInfo(BusProjectInfo busProjectInfo);

    /**
     * 修改项目信息
     * 
     * @param busProjectInfo 项目信息
     * @return 结果
     */
    public int updateBusProjectInfo(BusProjectInfo busProjectInfo);

    /**
     * 删除项目信息
     * 
     * @param id 项目信息ID
     * @return 结果
     */
    public int deleteBusProjectInfoById(Long id);

    /**
     * 批量删除项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusProjectInfoByIds(Long[] ids);

    int updateProjectStatus(@Param("id") Long id,@Param("status") Integer status);

    public SysDictData selectDictLabel(Integer parma);
}
