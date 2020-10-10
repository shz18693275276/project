<template>
	<div class="app-container">
		<el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
			<el-form-item label="设备名称" prop="deviceName" label-width="200">
				<el-input v-model="queryParams.deviceName" placeholder="请输入设备名称" clearable size="small" @keyup.enter.native="handleQuery" />
			</el-form-item>
			<el-form-item>
				<el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
				<el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
			</el-form-item>
		</el-form>

		<el-row :gutter="10" class="mb8">
			<el-col :span="1.5"><el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['project:busProjectBudget:add']">新增</el-button></el-col>
			<!-- <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['project:busProjectBudget:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['project:busProjectBudget:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['project:busProjectBudget:export']"
        >导出</el-button>
      </el-col> -->
			<right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
		</el-row>

		<el-table v-loading="loading" :data="busProjectBudgetList" @selection-change="handleSelectionChange">
			<el-table-column type="selection" width="55" align="center" />
			<el-table-column label="设备名称" align="center" prop="deviceName" />
			<el-table-column label="设备型号规格" align="center" prop="deviceModel" />
			<el-table-column label="单价" align="center" prop="devicePrice" />
			<el-table-column label="单位" align="center" prop="deviceUnit" />
			<el-table-column label="数量" align="center" prop="deviceNum" />
			<el-table-column label="金额" align="center" prop="totlaPrice" />
			<el-table-column label="中央财政拨款" align="center" prop="centralFinancial" />
			<el-table-column label="省财政拨款" align="center" prop="provincialFinancial" />
			<el-table-column label="自筹资金" align="center" prop="selfFinancing" />
			<el-table-column label="操作" align="center" class-name="small-padding fixed-width">
				<template slot-scope="scope">
					<el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['project:busProjectBudget:edit']">修改</el-button>
					<el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['project:busProjectBudget:remove']">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="getList" />

		<!-- 添加或修改项目预算对话框 -->
		<el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
			<el-row :gutter="15">
				<el-form ref="form" :model="form" :rules="rules" label-position="top">
					<el-col :span="24">
						<el-form-item label="项目名称："><el-input :value="form.projectName" disabled="disabled" placeholder="" /></el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="设备名称：" prop="deviceName"><el-input v-model="form.deviceName" placeholder="请输入设备名称" /></el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="设备型号规格：" prop="deviceModel"><el-input v-model="form.deviceModel" placeholder="请输入设备型号规格" /></el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="单价：" prop="devicePrice"><el-input v-model="form.devicePrice" placeholder="请输入单价" /></el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="单位：" prop="deviceUnit"><el-input v-model="form.deviceUnit" placeholder="请输入单位" /></el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="数量：" prop="deviceNum"><el-input v-model="form.deviceNum" placeholder="请输入数量" /></el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="金额：" prop="totlaPrice"><el-input v-model="form.totlaPrice" placeholder="请输入金额" /></el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="中央财政拨款：" prop="centralFinancial"><el-input v-model="form.centralFinancial" placeholder="请输入中央财政拨款" /></el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="省财政拨款：" prop="provincialFinancial"><el-input v-model="form.provincialFinancial" placeholder="请输入省财政拨款" /></el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="自筹资金：" prop="selfFinancing"><el-input v-model="form.selfFinancing" placeholder="请输入自筹资金" /></el-form-item>
					</el-col>
				</el-form>
			</el-row>
			<div slot="footer" class="dialog-footer">
				<el-button type="primary" @click="submitForm">确 定</el-button>
				<el-button @click="cancel">取 消</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
import {
	listBusProjectBudget,
	getBusProjectBudget,
	delBusProjectBudget,
	addBusProjectBudget,
	updateBusProjectBudget,
	exportBusProjectBudget
} from '@/api/project/busProjectBudget';

export default {
	name: 'BusProjectBudget',
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
			// 项目预算表格数据
			busProjectBudgetList: [],
			// 弹出层标题
			title: '',
			// 是否显示弹出层
			open: false,
			// 查询参数
			queryParams: {
				pageNum: 1,
				pageSize: 10,
				projectId: null,
				deviceName: null,
				deviceModel: null,
				devicePrice: null,
				deviceUnit: null,
				deviceNum: null,
				totlaPrice: null,
				centralFinancial: null,
				provincialFinancial: null,
				selfFinancing: null
			},
			// 表单参数
			form: {},
			// 表单校验
			rules: {}
		};
	},
	created() {
		this.getList();
	},
	methods: {
		/** 查询项目预算列表 */
		getList() {
			this.loading = true;
			// 查询条件带参
			this.queryParams.projectId = this.$route.query.projectId
			listBusProjectBudget(this.queryParams).then(response => {
				this.busProjectBudgetList = response.rows;
				this.total = response.total;
				this.loading = false;
			});
		},
		// 取消按钮
		cancel() {
			this.open = false;
			this.reset();
		},
		// 表单重置
		reset() {
			this.form = {
				id: null,
				projectId: this.$route.query.projectId,
				projectName: this.$route.query.projectName,
				deviceModel: null,
				devicePrice: null,
				deviceUnit: null,
				deviceNum: null,
				totlaPrice: null,
				centralFinancial: null,
				provincialFinancial: null,
				selfFinancing: null
			};
			this.resetForm('form');
		},
		/** 搜索按钮操作 */
		handleQuery() {
			this.queryParams.pageNum = 1;
			this.getList();
		},
		/** 重置按钮操作 */
		resetQuery() {
			this.resetForm('queryForm');
			this.handleQuery();
		},
		// 多选框选中数据
		handleSelectionChange(selection) {
			this.ids = selection.map(item => item.id);
			this.single = selection.length !== 1;
			this.multiple = !selection.length;
		},
		/** 新增按钮操作 */
		handleAdd() {
			// this.reset();
			this.open = true;
			this.title = '添加项目预算';
		},
		/** 修改按钮操作 */
		handleUpdate(row) {
			this.reset();
			const id = row.id || this.ids;
			getBusProjectBudget(id).then(response => {
				this.form = response.data;
				this.form.projectName = this.$route.query.projectName
				this.open = true;
				this.title = '修改项目预算';
			});
		},
		/** 提交按钮 */
		submitForm() {
			this.$refs['form'].validate(valid => {
				if (valid) {
					if (this.form.id != null) {
						updateBusProjectBudget(this.form).then(response => {
							if (response.code === 200) {
								this.msgSuccess('修改成功');
								this.open = false;
								this.getList();
							}
						});
					} else {
						addBusProjectBudget(this.form).then(response => {
							if (response.code === 200) {
								this.msgSuccess('新增成功');
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
			this.$confirm('是否确认删除项目预算编号为"' + ids + '"的数据项?', '警告', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			})
				.then(function() {
					return delBusProjectBudget(ids);
				})
				.then(() => {
					this.getList();
					this.msgSuccess('删除成功');
				})
				.catch(function() {});
		},
		/** 导出按钮操作 */
		handleExport() {
			const queryParams = this.queryParams;
			this.$confirm('是否确认导出所有项目预算数据项?', '警告', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			})
				.then(function() {
					return exportBusProjectBudget(queryParams);
				})
				.then(response => {
					this.download(response.msg);
				})
				.catch(function() {});
		}
	}
};
</script>
