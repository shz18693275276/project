<template>
  <div class="app-container">
	<el-tabs v-model="activeName" @tab-click="handleClick">
	  <el-tab-pane label="基本信息" name="0">
		  <el-row class="app-container" :gutter="15">
		    <el-form ref="form" :model="form" :rules="rules" size="medium" label-width="100px">
		      <el-col :span="24">
		        <el-form-item label="项目名称" prop="projectName">
		          <el-input v-model="form.projectName" placeholder="请输入项目名称" clearable :style="{width: '60%'}">
		          </el-input>
		        </el-form-item>
		      </el-col>
		      <el-col :span="12">
		        <el-form-item label="项目代号" prop="projectAlias">
		          <el-input v-model="form.projectAlias" placeholder="请输入项目代号" clearable :style="{width: '60%'}">
		          </el-input>
		        </el-form-item>
		      </el-col>
		      <el-col :span="12">
		        <el-form-item label="项目省份" prop="projectProvince">
		          <el-input v-model="form.projectProvince" placeholder="请输入项目省份" clearable :style="{width: '60%'}">
				  </el-input>
		        </el-form-item>
		      </el-col>
		      <el-col :span="12">
		        <el-form-item label="申请学校" prop="applyingSchool">
		          <el-input v-model="form.applyingSchool" placeholder="请输入申请学校" clearable :style="{width: '60%'}">
		          </el-input>
		        </el-form-item>
		      </el-col>
		      <el-col :span="12">
		        <el-form-item label="项目负责人" prop="projectLeader">
		          <el-input v-model="form.projectLeader" placeholder="请输入项目负责人项目负责人" clearable
		            :style="{width: '60%'}"></el-input>
		        </el-form-item>
		      </el-col>
		      <el-col :span="23">
		        <el-form-item label="紧急程度" prop="urgentLevel">
		          <el-radio-group v-model="form.urgentLevel" size="medium">
		            <el-radio v-for="(item, index) in urgentLevelOptions" :key="index" :label="item.value">{{item.label}}</el-radio>
		          </el-radio-group>
		        </el-form-item>
		      </el-col>
		      <el-col :span="24">
		        <el-form-item size="large">
		          <el-button type="primary" @click="submitForm(1)">下一步</el-button>
		          <!-- <el-button @click="resetForm">重置</el-button> -->
		        </el-form-item>
		      </el-col>
		    </el-form>
		  </el-row>
	  </el-tab-pane>
	  <el-tab-pane label="申报书" name="1">
		  <el-form ref="form" :model="form" :rules="rules" label-width="80px">
		  		<div class="add" style="width: 80%;margin-left: 10%;">
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
			
			<el-col :span="24" style="margin-top: 20px;margin-left: 50px;">
			  <el-form-item size="large">
				<el-button type="primary" @click="submitForm(-1)">上一步</el-button>
				<el-button type="primary" @click="submitForm(1)">下一步</el-button>
				<!-- <el-button @click="resetForm">重置</el-button> -->
			  </el-form-item>
			</el-col>
		  </el-form>
	  </el-tab-pane>
	  <el-tab-pane label="可行性报告" name="2">
		  <el-form ref="reportForm" :model="reportForm" :rules="reportRules" label-position="top" style="width: 80%;margin-left: 10%;">
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
				<el-col :span="24">
				  <el-form-item size="large">
				    <el-button type="primary" @click="submitForm(-1)">上一步</el-button>
				    <el-button type="primary" @click="submitForm(1)">下一步</el-button>
				    <!-- <el-button @click="resetForm">重置</el-button> -->
				  </el-form-item>
				</el-col>
		  </el-form>
	  </el-tab-pane>
	  <el-tab-pane label="其他附件" name="3">
		  
	  </el-tab-pane>
	</el-tabs>
  </div>
</template>

<script>
import { listBusProjectInfo, getBusProjectInfo, delBusProjectInfo, addBusProjectInfo, updateBusProjectInfo, exportBusProjectInfo } from "@/api/project/busProjectInfo";

export default {
  name: "BusProjectInfo",
  data() {
    return {
	  activeName: 0,
	  urgentLevelOptions: [{
		"label": "次要",
		"value": 0
	  }, {
		"label": "重要",
		"value": 1
	  }, {
		"label": "紧急",
		"value": 2
	  }, {
		"label": "特急",
		"value": 3
	  }],
      // 基本信息表单
      form: {},
      // 表单校验
      rules: {},
	  // 申报书
	  declarationForm: {},
	  // 可行性报告
	  reportForm: {},
    };
  },
  created() {
    
  },
  methods: {
    /** 提交按钮 */
    submitForm(num) {
      // this.$refs["form"].validate(valid => {
      //   if (valid) {
      //     if (this.form.id != null) {
      //       updateBusProjectInfo(this.form).then(response => {
      //         if (response.code === 200) {
      //           this.msgSuccess("修改成功");
      //           this.open = false;
      //           this.getList();
      //         }
      //       });
      //     } else {
      //       addBusProjectInfo(this.form).then(response => {
      //         if (response.code === 200) {
      //           this.msgSuccess("新增成功");
      //           this.open = false;
      //           this.getList();
      //         }
      //       });
      //     }
      //   }
      // });
	  if(num==1) this.activeName = parseInt(this.activeName)+1+''
	  else this.activeName = parseInt(this.activeName)-1+''
    },
	handleClick(e){
		console.log(e)
		return false
	}
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
	.add .bottomBorder{
		border-bottom: 1px solid #999999;
		border-radius: 0px;
	}
</style>
