<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="projectName" label-width="200">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目负责人" prop="projectLeader" label-width="200">
        <el-input
          v-model="queryParams.projectLeader"
          placeholder="请输入项目负责人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['project:declare:add']"
        >新增申报</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="busProjectInfoList" @selection-change="handleSelectionChange">
        <el-table-column label="项目名称" align="center" prop="projectName" />
		<el-table-column label="项目代号" align="center" prop="projectAlias" />
		<el-table-column label="项目负责人" align="center" prop="projectLeader" />
		<el-table-column label="申请学校" align="center" prop="applyingSchool" />
		<el-table-column label="紧急程度" align="center" prop="urgentLevel" >
			<template slot-scope="scope">
			  <div style="display: flex;justify-content: center;align-items: center;" v-if="scope.row.urgentLevel==0">
				  <el-button type="success" size="mini" circle></el-button>
				  <el-link type="success" style="padding-left: 5px;">次要</el-link>
			  </div>
			  <div style="display: flex;justify-content: center;align-items: center;" v-if="scope.row.urgentLevel==1">
				  <el-button type="warning" size="mini" circle></el-button>
				  <el-link type="warning" style="padding-left: 5px;">重要</el-link>
			  </div>
			  <div style="display: flex;justify-content: center;align-items: center;" v-if="scope.row.urgentLevel==2">
				  <el-button type="danger" size="mini" circle plain></el-button>
				  <el-link type="danger" disabled style="padding-left: 5px;">紧急</el-link>
			  </div>
			  <div style="display: flex;justify-content: center;align-items: center;" v-if="scope.row.urgentLevel==3">
				  <el-button type="danger" size="mini" circle></el-button>
				  <el-link type="danger" style="padding-left: 5px;">特急</el-link>
			  </div>
			</template>
		</el-table-column>
	    <el-table-column label="项目状态" align="center" class-name="small-padding fixed-width" width="200">
			<template slot-scope="scope">
			  <el-link v-if="scope.row.status==0">未提交</el-link>
			  <el-link type="warning" v-if="scope.row.status==10">审批中</el-link>
			  <el-link type="success" v-if="scope.row.status==11">审批通过</el-link>
			  <el-link type="danger" v-if="scope.row.status==12">审批未通过</el-link>
			  <el-link type="warning" v-if="scope.row.status==20">遴选中</el-link>
			  <el-link type="success" v-if="scope.row.status==21">遴选通过</el-link>
			  <el-link type="danger" v-if="scope.row.status==22">遴选未通过</el-link>
			  <el-link type="warning" v-if="scope.row.status==30">审议中</el-link>
			  <el-link type="success" v-if="scope.row.status==31">审议通过</el-link>
			  <el-link type="danger" v-if="scope.row.status==32">审议未通过</el-link>
			  <el-link type="warning" v-if="scope.row.status==40">资产报备审批中</el-link>
			  <el-link type="success" v-if="scope.row.status==41">资产报备审批通过</el-link>
			  <el-link type="danger" v-if="scope.row.status==42">资产报备审批未通过</el-link>
			</template>
	    </el-table-column>
	  <!-- <el-table-column label="可行性报告" align="center" class-name="small-padding fixed-width">
	    <template slot-scope="scope">
	      <el-button
	        size="mini"
	        type="text"
	        icon="el-icon-edit"
	        @click="reportList(scope.row)"
	      >可行性报告{{scope.row.reportCount>0?'（已填写）':'（未填写）'}}</el-button>
	    </template>
	  </el-table-column>
	  <el-table-column label="项目预算" align="center" class-name="small-padding fixed-width">
	    <template slot-scope="scope">
	      <el-button
	        size="mini"
	        type="text"
	        icon="el-icon-edit"
	        @click="budgetList(scope.row)"
	      >项目预算表{{scope.row.budgetCount>0?'（'+scope.row.budgetCount+'项）':'（未填写）'}}</el-button>
	    </template>
	  </el-table-column>
	  <el-table-column label="附件" align="center" class-name="small-padding fixed-width">
	    <template slot-scope="scope">
	      <el-button
	        size="mini"
	        type="text"
	        icon="el-icon-edit"
	        @click="handleUpdate(scope.row)"
	        v-hasPermi="['project:busProjectInfo:edit']"
	      >填写附表</el-button>
	    </template>
	  </el-table-column> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="220">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-tickets"
            @click="handleDetail(scope.row)"
            v-hasPermi="['project:declare:detail']"
          >详情</el-button>
          <el-button
			v-if="scope.row.status==0 || scope.row.status==12"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['project:declare:edit']"
          >更新</el-button>
          <el-button
			v-if="scope.row.status==0 || scope.row.status==12"
            size="mini"
            type="text"
            icon="el-icon-check"
            @click="updateStatus(scope.row)"
            v-hasPermi="['project:declare:submit']"
          >提交</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['project:declare:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改项目信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" 
	  style="width: 900px;margin-left: 50px;padding: 50px;box-shadow: 0px 2px 10px #BBBBBB;border-radius: 8px;">
		<div class="add">
			<div style="text-align: center;font-size: 32px;font-weight: 700;padding-bottom: 20px;">项目申报书</div>
			  <!-- <el-form-item label="用户ID" prop="userId">
			    <el-input v-model="form.userId" placeholder="请输入用户ID" />
			  </el-form-item> -->
			 <table class="table">
				 <tr>
					 <td style="width: 10%;padding: 0 30px;" rowspan="13">
						 <div style="padding: 10px 0;">学</div>
						 <div style="padding: 10px 0;">校</div>
						 <div style="padding: 10px 0;">基</div>
						 <div style="padding: 10px 0;">本</div>
						 <div style="padding: 10px 0;">情</div>
						 <div style="padding: 10px 0;">况</div>
					 </td>
					 <td style="width: 25%;">学校名称</td>
					 <td style="width: 20%;">
						 <el-form-item label="" prop="schoolName">
						   <el-input v-model="form.schoolName" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td style="width: 20%;">学校类别</td>
					 <td style="width: 25%;">
						 <el-select v-model="form.schoolType" placeholder="请选择">
							 <el-option
							   label="类别1"
							   value="1">
							 </el-option>
							 <el-option
							   label="类别2"
							   value="2">
							 </el-option>
						 </el-select>
						 <!-- <el-form-item label="" prop="schoolType">
						   <el-input v-model="form.schoolType" placeholder="请输入" />
						 </el-form-item> -->
					 </td>
				 </tr>
				 <tr>
					 <td>详细地址</td>
					 <td>
						 <el-form-item label="" prop="schoolAddress">
						   <el-input v-model="form.schoolAddress" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td>邮政编码</td>
					 <td>
						 <el-form-item label="" prop="postalCode">
						   <el-input v-model="form.postalCode" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>在校人数（人）</td>
					 <td>
						 <el-form-item label="" prop="schoolStudent">
						   <el-input v-model="form.schoolStudent" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td>教职工总数（人）</td>
					 <td>
						 <el-form-item label="" prop="schoolTeacher">
						   <el-input v-model="form.schoolTeacher" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：本专科生</td>
					 <td>
						 <el-form-item label="" prop="schoolStudentSpecialty">
						   <el-input v-model="form.schoolStudentSpecialty" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td>其中：专任教师</td>
					 <td>
						 <el-form-item label="" prop="schoolTeacherRegular">
						   <el-input v-model="form.schoolTeacherRegular" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：硕士生</td>
					 <td>
						 <el-form-item label="" prop="schoolStudentMaster">
						   <el-input v-model="form.schoolStudentMaster" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td>其中：教授</td>
					 <td>
						 <el-form-item label="" prop="schoolTeacherProfessor">
						   <el-input v-model="form.schoolTeacherProfessor" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：博士生</td>
					 <td>
						 <el-form-item label="" prop="schoolStudentDoctor">
						   <el-input v-model="form.schoolStudentDoctor" placeholder="请输入" />
						 </el-form-item>
					 </td>
					 <td>其中：副教授</td>
					 <td>
						 <el-form-item label="" prop="schoolTeacherReProfessor">
						   <el-input v-model="form.schoolTeacherReProfessor" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">国家/省级重点学科数（个）</td>
					 <td colspan="2">
						<div style="display: flex;justify-content: center;align-items: center;">
							<el-form-item label="" prop="countryStudyCourse">
							  <el-input v-model="form.countryStudyCourse" placeholder="请输入" />
							</el-form-item>
							/
							<el-form-item label="" prop="provincialStudyCourse">
							  <el-input v-model="form.provincialStudyCourse" placeholder="请输入" />
							</el-form-item>
						 </div>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">国家/省级重点研究基地（个）</td>
					 <td colspan="2">
						 <div style="display: flex;justify-content: center;align-items: center;">
							 <el-form-item label="" prop="countryResearchBase">
							   <el-input v-model="form.countryResearchBase" placeholder="请输入" />
							 </el-form-item>
							 /
							 <el-form-item label="" prop="provincialResearchBase">
							   <el-input v-model="form.provincialResearchBase" placeholder="请输入" />
							 </el-form-item>
						 </div>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">现有固定资产总值（万元）</td>
					 <td colspan="2">
						 <el-form-item label="" prop="existingFixedAssets">
						   <el-input v-model="form.existingFixedAssets" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">其中：房屋建筑物总值（万元）</td>
					 <td colspan="2">
						 <el-form-item label="" prop="buildingValue">
						   <el-input v-model="form.buildingValue" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">其中：房屋建筑物面积(M2)</td>
					 <td colspan="2">
						 <el-form-item label="" prop="buildingArea">
						   <el-input v-model="form.buildingArea" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">其中：40万元以上大型仪器设备（台）</td>
					 <td colspan="2">
						 <el-form-item label="" prop="equipment40wOver">
						   <el-input v-model="form.equipment40wOver" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="2">其中：大型专用仪器设备总值(万元)</td>
					 <td colspan="2">
						 <el-form-item label="" prop="equipmentSpecializedValue">
						   <el-input v-model="form.equipmentSpecializedValue" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td style="width: 10%;padding: 0 30px;" rowspan="13">
						 <div style="padding: 10px 0;">申</div>
						 <div style="padding: 10px 0;">请</div>
						 <div style="padding: 10px 0;">项</div>
						 <div style="padding: 10px 0;">目</div>
						 <div style="padding: 10px 0;">基</div>
						 <div style="padding: 10px 0;">本</div>
						 <div style="padding: 10px 0;">情</div>
						 <div style="padding: 10px 0;">况</div>
					 </td>
					 <td rowspan="10">项目类型</td>
					 <td style="width: 25%;" rowspan="5">
						 <el-form-item label="">
						   <el-radio-group v-model="form.projectType">
						     <el-radio label="0" style="padding: 15px 0;">省级重点学科建设项目</el-radio>
						     <el-radio label="1" style="padding: 15px 0;">教学实验平台项目</el-radio>
						     <el-radio label="2" style="padding: 15px 0;">科研平台和专业能力实践基地建设项目</el-radio>
						     <el-radio label="3" style="padding: 15px 0;">公共服务体系建设项目</el-radio>
						     <el-radio label="4" style="padding: 15px 0;">人才培养和创新团队建设项目</el-radio>
						   </el-radio-group>
						 </el-form-item>
					 </td>
					 <td style="width: 25%;">申请资金总额（万元）</td>
					 <td style="width: 30%;">
						 <el-form-item label="" prop="applicationAmount">
						   <el-input v-model="form.applicationAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：中央财政</td>
					 <td>
						 <el-form-item label="" prop="centralFinanceAmount">
						   <el-input v-model="form.centralFinanceAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：地方自筹</td>
					 <td>
						 <el-form-item label="" prop="localFundingAmount">
						   <el-input v-model="form.localFundingAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>项目负责人</td>
					 <td>
						 <el-form-item label="" prop="projectLeader">
						   <el-input v-model="form.projectLeader" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>联系电话</td>
					 <td>
						 <el-form-item label="" prop="contactNumber">
						   <el-input v-model="form.contactNumber" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td rowspan="5">
						 <div style="padding: 15px 0;">特色重点学科建设项目</div>
						 <el-form-item label="">
						   <el-radio-group v-model="form.projectType">
							 <div style="padding: 15px 0;padding-left: 80px;"><el-radio label="5">一级学科</el-radio></div>
							 <div style="padding: 15px 0;padding-left: 80px;"><el-radio label="6">一级学科</el-radio></div>
						   </el-radio-group>
						 </el-form-item>
					 </td>
					 <td>申请资金总额（万元）</td>
					 <td>
						 <el-form-item label="" prop="applicationAmount">
						   <el-input v-model="form.applicationAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：中央财政</td>
					 <td>
						 <el-form-item label="" prop="centralFinanceAmount">
						   <el-input v-model="form.centralFinanceAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>其中：地方自筹</td>
					 <td>
						 <el-form-item label="" prop="localFundingAmount">
						   <el-input v-model="form.localFundingAmount" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>项目负责人</td>
					 <td>
						 <el-form-item label="" prop="projectLeader">
						   <el-input v-model="form.projectLeader" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td>联系电话</td>
					 <td>
						 <el-form-item label="" prop="contactNumber">
						   <el-input v-model="form.contactNumber" placeholder="请输入" />
						 </el-form-item>
					 </td>
				 </tr>
				 <tr>
					 <td colspan="4">
						 <el-form-item label="" prop="projectIntroduction">
						   <el-input v-model="form.projectIntroduction" type="textarea" placeholder="项目简介（概述项目内容、资金安排及预期效益等，字数控制在500字内）" />
						 </el-form-item>
					 </td>
				 </tr>
			 </table>
			 <div style="padding-top: 10px;">高校类别指综合类、理工类、师范类、农林类、政法类、医药类、财政类、民族类、语言类、艺术类、体育类及其他等。</div>
		</div>
        <!-- 
        <el-form-item label="项目类型">
          <el-select v-model="form.projectType" placeholder="请选择项目类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="项目状态">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="!disDetail">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
	
	<!-- 添加或修改项目信息对话框 -->
	<el-dialog :title="reportTitle" :visible.sync="reportOpen" width="900px" append-to-body>
	  <el-form ref="reportForm" :model="reportForm" :rules="reportRules" label-position="top"
		style="width: 750px;margin-left: 50px;padding: 50px;box-shadow: 0px 2px 10px #BBBBBB;border-radius: 8px;">
		<!-- <el-form-item label="项目ID" prop="projectId">
		  <el-input v-model="form.projectId" placeholder="请输入项目ID" />
		</el-form-item> -->
		<div style="text-align: center;font-size: 32px;font-weight: 700;padding-bottom: 20px;">项目可行性报告</div>
		<el-form-item label="基本情况" prop="basicInformation">
		  <el-input v-model="reportForm.basicInformation" :rows="4" type="textarea" placeholder="简要叙述本单位基本情况、支持项目建设的基础条件、待解决的主要问题。" />
		</el-form-item>
		<el-form-item label="可行性与必要性" prop="feasibilityAndNecessity">
		  <el-input v-model="reportForm.feasibilityAndNecessity" :rows="5" type="textarea" placeholder="论证要充分、详尽。" />
		</el-form-item>
		<el-form-item label="目标与内容" prop="objectiveAndContents">
		  <el-input v-model="reportForm.objectiveAndContents" :rows="5" type="textarea" placeholder="建设目标要有具体的可考核指标，建设任务围绕建设目标展开，规划期内各建设项目及内容，具体建设计划具有可操作性。" />
		</el-form-item>
		<el-form-item label="预算与用途" prop="budgetAndUsage">
		  <el-input v-model="reportForm.budgetAndUsage" :rows="5" type="textarea" placeholder="规划总资金预算及年度预算（理工科类单个申请项目总规划资金建议不高于400万，人文社科管理类单个申请项目总规划资金建议不高于200万，规划项目总资金不低于50万，可将多个相关小项目并合申报）" />
		</el-form-item>
		<el-form-item label="项目实施组织及进度安排" prop="organizeAndSchedule">
		  <el-input v-model="reportForm.organizeAndSchedule" :rows="4" type="textarea" placeholder="包括实施周期和步骤，确需分年建设的项目，其阶段性工作内容和总体目标要明确具体。" />
		</el-form-item>
		<el-form-item label="预期效益分析" prop="benefitAnalyze">
		  <el-input v-model="reportForm.benefitAnalyze" :rows="4" type="textarea" placeholder="建设项目要有明确可量化的绩效目标，以便于项目的绩效考评。要分析本项目完成后发挥的主要作用。" />
		</el-form-item>
		<el-form-item label="保障措施" prop="safeguardMeasures">
		  <el-input v-model="reportForm.safeguardMeasures" :rows="4" type="textarea" placeholder="包括管理机制、管理队伍、环境条件、资金筹措、政府采购、集中支付等。" />
		</el-form-item>
		<el-form-item label="其他" prop="other">
		  <el-input v-model="reportForm.other" :rows="4" type="textarea" placeholder="请输入其他说明" />
		</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer">
		<el-button type="primary" @click="submitReportForm">确 定</el-button>
		<el-button @click="cancel">取 消</el-button>
	  </div>
	</el-dialog>
  </div>
</template>

<script>
import { listDeclare, getBusProjectInfo, delBusProjectInfo, addBusProjectInfo, updateBusProjectInfo, exportBusProjectInfo,updatePorjectStatus } from "@/api/project/busProjectInfo";
import { listBusProjectReport, getBusProjectReport, getReportProjectId, delBusProjectReport, addBusProjectReport, updateBusProjectReport, exportBusProjectReport } from "@/api/project/busProjectReport";
export default {
  name: "BusProjectInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 项目信息表格数据
      busProjectInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        projectProvince: null,
        projectName: null,
        schoolName: null,
        schoolType: null,
        schoolAddress: null,
        postalCode: null,
        schoolStudent: null,
        schoolStudentSpecialty: null,
        schoolStudentMaster: null,
        schoolStudentDoctor: null,
        schoolTeacher: null,
        schoolTeacherRegular: null,
        schoolTeacherProfessor: null,
        schoolTeacherReProfessor: null,
        countryStudyCourse: null,
        provincialStudyCourse: null,
        countryResearchBase: null,
        provincialResearchBase: null,
        existingFixedAssets: null,
        buildingValue: null,
        buildingArea: null,
        equipment40wOver: null,
        equipmentSpecializedValue: null,
        projectType: null,
        applicationAmount: null,
        centralFinanceAmount: null,
        localFundingAmount: null,
        projectLeader: null,
        contactNumber: null,
        projectIntroduction: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
	  disDetail: false,
	  
	  reportOpen: false,
	  reportTitle: '',
	  reportForm: {},
	  reportRules: {},
	  
	  busProjectType: '',
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项目信息列表 */
    getList() {
      this.loading = true;
      listDeclare(this.queryParams).then(response => {
        this.busProjectInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
	  
	  this.getDicts("bus_project_type").then(response => {
	    this.busProjectType = response.data;
		console.log(response.data)
	  });
    },
    // 取消按钮
    cancel() {
      this.open = false;
	  this.reportOpen = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        projectProvince: '甘肃省',
        projectName: null,
        createTime: null,
        schoolName: null,
        schoolType: null,
        schoolAddress: null,
        postalCode: null,
        schoolStudent: null,
        schoolStudentSpecialty: null,
        schoolStudentMaster: null,
        schoolStudentDoctor: null,
        schoolTeacher: null,
        schoolTeacherRegular: null,
        schoolTeacherProfessor: null,
        schoolTeacherReProfessor: null,
        countryStudyCourse: null,
        provincialStudyCourse: null,
        countryResearchBase: null,
        provincialResearchBase: null,
        existingFixedAssets: null,
        buildingValue: null,
        buildingArea: null,
        equipment40wOver: null,
        equipmentSpecializedValue: null,
        projectType: null,
        applicationAmount: null,
        centralFinanceAmount: null,
        localFundingAmount: null,
        projectLeader: null,
        contactNumber: null,
        projectIntroduction: null,
        status: 0
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
   //    this.reset();
	  // this.disDetail = false;
   //    this.open = true;
   //    this.title = "添加项目信息";
	  this.$router.push({
	      path:"/project/projectAdd"
	  })
    },
    /** 详情 */
	handleDetail(row){
		this.reset();
		this.disDetail = true;
		const id = row.id || this.ids
		getBusProjectInfo(id).then(response => {
		  this.form = response.data;
		  this.open = true;
		  this.title = "修改项目信息";
		});
	},
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
	  this.disDetail = false;
      const id = row.id || this.ids
      getBusProjectInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBusProjectInfo(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addBusProjectInfo(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    updateStatus(row){
      var that = this;
      that.$confirm('是否提交', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        updatePorjectStatus(row.id,row.status).then(response => {
          that.getList();
          that.$message({
            type:response.Code,
            message:response.msg
          });

        })
      }).catch(() => {
        that.$message({
          type: 'info',
          message: '取消提交'
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除项目信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delBusProjectInfo(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有项目信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportBusProjectInfo(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    },
	budgetList(row){
		console.log(row)
		this.$router.push({
		    path:"/project/busProjectBudget",
			query:{
			  projectId: row.id,
			  projectName: row.projectName,
			  projectStatus: row.status
			}
		})
	},
	reportList(row){
		// this.reset();
		const projectId = row.id || this.ids
		this.reportForm.projectId = projectId
		getReportProjectId(projectId).then(response => {
		  if(response.data){
			  this.reportForm = response.data;
			  this.reportTitle = "编辑可行性报告"
		  }else{
			  this.reportTitle = "添加可行性报告"
		  }
		  this.reportOpen = true;
		});
	},
	/** 提交按钮 */
	submitReportForm() {
	  this.$refs["reportForm"].validate(valid => {
	    if (valid) {
	      if (this.reportForm.id != null) {
	        updateBusProjectReport(this.reportForm).then(response => {
	          if (response.code === 200) {
	            this.msgSuccess("修改成功");
	            this.reportOpen = false;
	            // this.getList();
	          }
	        });
	      } else {
	        addBusProjectReport(this.reportForm).then(response => {
	          if (response.code === 200) {
	            this.msgSuccess("新增成功");
	            this.reportOpen = false;
	            // this.getList();
	          }
	        });
	      }
	    }
	  });
	},
  }
};
</script>
<style lang="scss">
	.add .el-form-item{
		margin-bottom: 0px!important;
	}
	.add .el-form-item__content{
		margin-left: 0px!important;
	}
	.add .table{
		border-collapse:collapse;
	}
	.add td{
		border:1px #333333 solid;
		padding: 10px;
	}
	.add .el-input__inner,.add .el-textarea__inner{
		border: none!important;
	}
	.add .el-dialog__body{
		font-size: 16px!important;
	}
	.add .bottomBorder{
		border-bottom: 1px solid #999999;
		border-radius: 0px;
	}
</style>
