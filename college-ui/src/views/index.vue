<template>
  <div class="dashboard-editor-container">
    <el-row :gutter="20">
      <el-col :span="12"><Parpro :list="list1" :num="1" :size="5" :total="11"/></el-col>
      <el-col :span="12"><Todo :list="list2" :num="1" :size="5" :total="6" /></el-col>
    </el-row> 

    <el-row :gutter="20" style="padding-top: 20px;">
      <el-col  :span="24">
        <Protry :list="list3" :num="1" :size="5" :total="4"></Protry>
      </el-col>
    </el-row>

    <el-row :gutter="32" style="padding-top: 20px;">
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <line-chart :chart-data="lineChartData" />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <pie-chart />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <bar-chart />
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import PanelGroup from './dashboard/PanelGroup'
import LineChart from './dashboard/LineChart'
// import RaddarChart from './dashboard/RaddarChart'
import PieChart from './dashboard/PieChart'
import BarChart from './dashboard/BarChart'
// import CodeAdmin from '../components/Tables/index' 
import Parpro from '../components/Tables/Parpro' 
import Todo from '../components/Tables/Todo'
import Protry from '../components/Tables/Protry' 

const lineChartData = {
  newVisitis: {
    expectedData: [100, 120, 161, 134, 105, 160, 165],
    actualData: [120, 82, 91, 154, 162, 140, 145]
  },
  messages: {
    expectedData: [200, 192, 120, 144, 160, 130, 140],
    actualData: [180, 160, 151, 106, 145, 150, 130]
  },
  purchases: {
    expectedData: [80, 100, 121, 104, 105, 90, 100],
    actualData: [120, 90, 100, 138, 142, 130, 130]
  },
  shoppings: {
    expectedData: [130, 140, 141, 142, 145, 150, 160],
    actualData: [120, 82, 91, 154, 162, 140, 130]
  }
}

export default {
  name: 'Index',
  components: {
    PanelGroup,
    LineChart,
    // RaddarChart,
    PieChart,
    BarChart,
    Parpro,
    Todo,
    Protry,
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis,
      list1: [
        {name: '项目1',speed: 28},
        {name: '项目2',speed: 59},
        {name: '项目3',speed: 59},
        {name: '项目4',speed: 59},
        {name: '项目5',speed: 59},
        {name: '项目6',speed: 59},
        {name: '项目7',speed: 59},
        {name: '项目8',speed: 59},
        {name: '项目9',speed: 59},
        {name: '项目10',speed: 59},
        {name: '项目11',speed: 59}
      ],
      list2: [
        {name: '项目1',status: '待提交'},
        {name: '项目2',status: '已完成'},
        {name: '项目3',status: '已完成'},
        {name: '项目4',status: '已完成'},
        {name: '项目5',status: '已完成'},
        {name: '项目6',status: '已完成'}
      ],
      list3: [{
        progress: '红',
        projectname: 'XXXXXXXXXXXXX',
        department:'科技部',
        manager:'阿三',
        state:'红',
        stage:'开发',
        planbegin:'2020-2',
        planover:'2030',
        actualend:'2030',
        budget:'30万',
        cost:'40万',
        totalcost:'80万'
      }, {
        progress: '红',
        projectname: 'XXXXXXXXXXXXX',
        department:'科技部',
        manager:'阿三',
        state:'红',
        stage:'开发',
        planbegin:'2020-2',
        planover:'2030',
        actualend:'2030',
        budget:'30万',
        cost:'40万',
        totalcost:'80万'
      }, {
        progress: '红',
        projectname: 'XXXXXXXXXXXXX',
        department:'科技部',
        manager:'阿三',
        state:'红',
        stage:'开发',
        planbegin:'2020-2',
        planover:'2030',
        actualend:'2030',
        budget:'30万',
        cost:'40万',
        totalcost:'80万'
      }, {
        progress: '红',
        projectname: 'XXXXXXXXXXXXX',
        department:'科技部',
        manager:'阿三',
        state:'红',
        stage:'开发',
        planbegin:'2020-2',
        planover:'2030',
        actualend:'2030',
        budget:'30万',
        cost:'40万',
        totalcost:'80万'
      }]
    }
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
