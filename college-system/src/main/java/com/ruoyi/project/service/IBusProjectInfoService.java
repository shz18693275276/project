package com.ruoyi.project.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.domain.BusProjectInfo;

/**
 * 项目信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public interface IBusProjectInfoService 
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
     * 批量删除项目信息
     * 
     * @param ids 需要删除的项目信息ID
     * @return 结果
     */
    public int deleteBusProjectInfoByIds(Long[] ids);

    /**
     * 删除项目信息信息
     * 
     * @param id 项目信息ID
     * @return 结果
     */
    public int deleteBusProjectInfoById(Long id);

    public  JSONObject updateProjectStatus(Long id,Integer status);

    public  JSONObject projectDetails(Long id);

}
