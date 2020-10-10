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
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="220">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-tickets"
            @click="handleDetail(scope.row)"
            v-hasPermi="['project:urgent:detail']"
          >详情</el-button>
          <el-button
			v-if="scope.row.status==31"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['project:urgent:edit']"
          >更新</el-button>
          <el-button
			v-if="scope.row.status==31"
            size="mini"
            type="text"
            icon="el-icon-check"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['project:urgent:submit']"
          >提交</el-button>
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
  </div>
</template>

<script>
import { listUrgent, getBusProjectInfo, delBusProjectInfo, addBusProjectInfo, updateBusProjectInfo, exportBusProjectInfo,updatePorjectStatus } from "@/api/project/busProjectInfo";
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
	  
	  reportOpen: false,
	  reportTitle: '',
	  reportForm: {},
	  reportRules: {},
	  
	  busProjectType: ''
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项目信息列表 */
    getList() {
      this.loading = true;
      listUrgent(this.queryParams).then(response => {
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
      this.reset();
      this.open = true;
      this.title = "添加项目信息";
    },
    /** 详情 */
	handleDetail(row){
		this.reset();
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
      const id = row.id || this.ids
      getBusProjectInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目信息";
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
