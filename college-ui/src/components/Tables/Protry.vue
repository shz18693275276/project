<template>
<div class="el-card is-always-shadow">
  <div>
    <el-card>
      <el-table
        :data="newList"
        stripe border style="width: 100%">
        <el-table-column  label="项目试图">
        <el-table-column
          prop="progress"
          label="进度"
          width="180">
        </el-table-column>
        <el-table-column
          prop="department"
          label="项目名称"
          width="180">
        </el-table-column>
          <el-table-column
          prop="manager"
          label="项目经理">
        </el-table-column>
          <el-table-column
          prop="state"
          label="项目状态">
        </el-table-column>
          <el-table-column
          prop="stage"
          label="项目阶段">
        </el-table-column>
         <el-table-column
          prop="planbegin"
          label="计划开始">
        </el-table-column>
         <el-table-column
          prop="planover"
          label="计划结束">
        </el-table-column>
         <el-table-column
          prop="actualend"
          label="实际结束">
        </el-table-column>
         <el-table-column
          prop="budget"
          label="费用预算">
        </el-table-column>
         <el-table-column
          prop="cost"
          label="费用成本">
        </el-table-column>
         <el-table-column
          prop="totalcost"
          label="总成本">
        </el-table-column>
        </el-table-column>

      </el-table>
      <el-pagination style="padding-top:20px"
       @current-change="handleCurrentChange"
       :current-page="num"
       :page-size="size"
       layout="total, prev, pager, next, jumper"
       :total="total"
       background
      >
      </el-pagination>
    </el-card>
    </div>
    </div>
  </template>
<script>
export default {
  data() {
      return {
        newList: []
      }
    },
    props: {
      list: [Object],
      num: [Number, String],
      size: [Number, String],
      total: [Number, String],
    },
  methods: {
    handleCurrentChange(newPage) {
      this.num = newPage;
      this.newList = [];
      for (var i=this.size*(this.num-1);i<this.size*this.num;i++){
        if(this.list[i]){
          this.newList.push(this.list[i])
        }
      }
    },
  },
  created() {
    for (var i=this.size*(this.num-1);i<this.size*this.num;i++){
      if(this.list[i]){
        this.newList.push(this.list[i])
      }
    }
  }
  

};
</script>

<style lang="less" scoped></style>
