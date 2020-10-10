package com.ruoyi.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.domain.*;
import com.ruoyi.project.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.service.IBusProjectInfoService;

/**
 * 项目信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
@Service
public class BusProjectInfoServiceImpl implements IBusProjectInfoService 
{
    @Autowired
    private BusProjectInfoMapper busProjectInfoMapper;

    @Autowired
    private BusProjectBudgetMapper busProjectBudgetMapper;

    @Autowired
    private BusProjectDeclarationMapper busProjectDeclarationMapper;

    @Autowired
    private BusProjectMilepostMapper busProjectMilepostMapper;

    @Autowired
    private BusProjectReportMapper busProjectReportMapper;


    /**
     * 查询项目信息
     * 
     * @param id 项目信息ID
     * @return 项目信息
     */
    @Override
    public BusProjectInfo selectBusProjectInfoById(Long id)
    {
        return busProjectInfoMapper.selectBusProjectInfoById(id);
    }

    /**
     * 查询项目信息列表
     * 
     * @param busProjectInfo 项目信息
     * @return 项目信息
     */
    @Override
    public List<BusProjectInfo> selectBusProjectInfoList(BusProjectInfo busProjectInfo)
    {
        return busProjectInfoMapper.selectBusProjectInfoList(busProjectInfo);
    }

    /**
     * 新增项目信息
     * 
     * @param busProjectInfo 项目信息
     * @return 结果
     */
    @Override
    public int insertBusProjectInfo(BusProjectInfo busProjectInfo)
    {
        busProjectInfo.setCreateTime(DateUtils.getNowDate());
        return busProjectInfoMapper.insertBusProjectInfo(busProjectInfo);
    }

    /**
     * 修改项目信息
     * 
     * @param busProjectInfo 项目信息
     * @return 结果
     */
    @Override
    public int updateBusProjectInfo(BusProjectInfo busProjectInfo)
    {
        return busProjectInfoMapper.updateBusProjectInfo(busProjectInfo);
    }

    /**
     * 批量删除项目信息
     * 
     * @param ids 需要删除的项目信息ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectInfoByIds(Long[] ids)
    {
        return busProjectInfoMapper.deleteBusProjectInfoByIds(ids);
    }

    /**
     * 删除项目信息信息
     * 
     * @param id 项目信息ID
     * @return 结果
     */
    @Override
    public int deleteBusProjectInfoById(Long id)
    {
        return busProjectInfoMapper.deleteBusProjectInfoById(id);
    }

    @Override
    public JSONObject updateProjectStatus(Long id, Integer status) {
        JSONObject jsonObject = new JSONObject();
        if (status.equals(0) || status.equals(12)) {
            status = 10;
        } else if (status.equals(11)) {
            status = 20;
        } else if (status.equals(22) || status.equals(32) || status.equals(42)) {
            status = 20;
        } else if (status.equals(21)) {
            status = 30;
        } else if (status.equals(31)) {
            status = 40;
        }
        int i = busProjectInfoMapper.updateProjectStatus(id, status);
        if (i > 0) {
            jsonObject.put("Code", "success");
            jsonObject.put("msg", "提交成功");
        } else {
            jsonObject.put("Code", "fail");
            jsonObject.put("msg", "提交失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject projectDetails(Long id) {
        JSONObject jsonObject = new JSONObject();
        Map<String,Object> detailMap = new HashMap<>();
        BusProjectInfo busProjectInfo = busProjectInfoMapper.selectBusProjectInfoById(id);
        if (busProjectInfo != null){
            detailMap.put("busProjectInfo",busProjectInfo);
            //根据项目于Id查询项目预算
            BusProjectBudget busProjectBudget = busProjectBudgetMapper.selectProjectBudgetByProjectId(busProjectInfo.getId());
            if (busProjectBudget != null){
                detailMap.put("busProjectBudget",busProjectBudget);

            }
            //根据项目Id查询项目申报书
            BusProjectDeclaration busProjectDeclaration = busProjectDeclarationMapper.selectProjectDeclarationByProjectId(busProjectInfo.getId());
            if (busProjectDeclaration != null){
                detailMap.put("busProjectDeclaration",busProjectDeclaration);
            }
            //根据项目Id查询项目里程碑
            BusProjectMilepost busProjectMilepost = busProjectMilepostMapper.selectBusProjectMilepostByProjectId(busProjectInfo.getId());
            if (busProjectMilepost != null){
                detailMap.put("busProjectMilepost",busProjectMilepost);
            }
            //根据项目Id查询项目可行性报告
            BusProjectReport busProjectReport = busProjectReportMapper.selectProjectReportByProjectId(busProjectInfo.getId());
            if (busProjectReport != null){
                detailMap.put("busProjectReport",busProjectReport);
            }
            jsonObject.put("Code","success");
            jsonObject.put("object" ,detailMap);
        }else {
            jsonObject.put("Code","fail");
        }
        return jsonObject;
    }

}
