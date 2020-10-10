<template>
  <div>
    <!-- <el-form v-if="isShow" id="codeForm" method="post" ref="ruleForm" :rules="publishData.rules" class="code-form" label-width="11rem" :model="publishData.jsonData">
		<input type="hidden" id="hiddenCode" name="collectionData.jsonData" />
		<Codeadmin></Codeadmin>
	</el-form> -->

    <el-card>
      <!-- <List></List> -->
     
      <el-table :data="newList" stripe border>
        <el-table-column label="管理或参与的项目">
        <el-table-column type="index"> </el-table-column>
        <el-table-column prop="name" label="项目名称"></el-table-column>
        <el-table-column prop="speed" label="进度" width="300px">
          <el-progress :percentage="20"></el-progress>
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
</template>

<script>
export default {
  data() {
    return {
      newList: []
    };
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
