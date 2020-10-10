<template>
  <div>
    <el-row class="app-container" :gutter="15">
      <el-form :model="form" ref="form"  size="medium" label-width="100px">
        <el-form-item label="项目名称"  label-width="200">
          <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.projectName" placeholder="请输入项目名称" clearable :style="{width: '50%'}">
          </el-input>
        </el-form-item>
        <el-col :span="12">
          <el-form-item label="项目代号"  label-width="200">
            <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.projectAlias" placeholder="请输入项目名称" clearable :style="{width: '50%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目负责人"  label-width="200">
            <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.projectLeader" placeholder="请输入项目名称" clearable :style="{width: '50%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请学校"  label-width="200">
            <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.applyingSchool" placeholder="请输入项目名称" clearable :style="{width: '50%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="紧急程度"  label-width="200">
            <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.urgentLevel" placeholder="请输入项目名称" clearable :style="{width: '50%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目状态"  label-width="200">
            <el-input style="border: 0px"  disabled  v-model="form.busProjectInfo.status" placeholder="请输入项目名称" clearable :style="{width: '20%'}">
            </el-input>
          </el-form-item>
        </el-col>

      </el-form>
    </el-row>
  </div>
</template>
<script>
  import { listDeclare, getBusProjectInfo, delBusProjectInfo, addBusProjectInfo, updateBusProjectInfo, exportBusProjectInfo,updatePorjectStatus,projectDetails } from "@/api/project/busProjectInfo";
  import { getDataLabe } from "@/api/system/dict/data";

  export default {
    data() {
      return {
        projectId:null,
        form: {
          busProjectInfo:{
            projectName:'',
            busProjectType:'',
            status:'',

          }
        },
        statusOptions: [],
      };
    },
    created() {
        this.getList(this.projectId);

    },
    methods:{
      getList(){
        projectDetails(this.$route.query.projectId).then(response =>{
          this.form = response.object;
          this.getUrgentLevelDict(response.object.busProjectInfo.urgentLevel,"project_degreeEmergency")
          this.getStatusDict(response.object.busProjectInfo.status,"project_status")
          this.getProjectUser(response.object.busProjectInfo.projectLeader)

        });
      },
      //查询紧急状态
      getUrgentLevelDict(urgentLevel,type){
        getDataLabe(urgentLevel,type).then(response =>{
          this.form.busProjectInfo.urgentLevel = response.data.dictLabel;
        });
      },
      //查询项目状态
      getStatusDict(status,type){
        getDataLabe(status,type).then(response =>{
          this.form.busProjectInfo.status = response.data.dictLabel;
        });
      },
      //查询项目负责人
      getProjectUser(projectLeader){

      }
      
    }

  };
</script>
