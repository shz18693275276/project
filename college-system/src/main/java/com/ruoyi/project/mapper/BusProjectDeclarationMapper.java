package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.BusProjectDeclaration;

/**
 * 项目申报书Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-29
 */
public interface BusProjectDeclarationMapper 
{
    /**
     * 查询项目申报书
     * 
     * @param id 项目申报书ID
     * @return 项目申报书
     */
    public BusProjectDeclaration selectBusProjectDeclarationById(Long id);

    /**
     * 查询项目申报书列表
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 项目申报书集合
     */
    public List<BusProjectDeclaration> selectBusProjectDeclarationList(BusProjectDeclaration busProjectDeclaration);

    /**
     * 新增项目申报书
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 结果
     */
    public int insertBusProjectDeclaration(BusProjectDeclaration busProjectDeclaration);

    /**
     * 修改项目申报书
     * 
     * @param busProjectDeclaration 项目申报书
     * @return 结果
     */
    public int updateBusProjectDeclaration(BusProjectDeclaration busProjectDeclaration);

    /**
     * 删除项目申报书
     * 
     * @param id 项目申报书ID
     * @return 结果
     */
    public int deleteBusProjectDeclarationById(Long id);

    /**
     * 批量删除项目申报书
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusProjectDeclarationByIds(Long[] ids);

    public BusProjectDeclaration selectProjectDeclarationByProjectId(Long projectId);
}
