<template>
  <el-main style="padding-bottom: 0">
    <el-row>
      <el-col :span="6" class="toolbar" style="padding-left: 20px;font-size: 30px">
        <div>组织机构管理</div>
      </el-col>
      <!--搜索-->
      <el-col :span="18" class="toolbar" style="padding-left: 20px;">
        <el-form :inline="true" :model="search">
          <el-form-item>
            <el-input v-model="search.searchWord" placeholder="请输入关键词" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getOrganizations">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleAdd">新增</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="danger" @click="handleBatchDelete">批量删除</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <!--组织机构列表-->
    <el-table
      ref="multipleTable"
      :data="organizations"
      stripe
      style="width: 100%"
      height="76vh"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" fixed="left"></el-table-column>
      <el-table-column fixed="left" prop="orgaId" label="编号" width="100px"></el-table-column>
      <el-table-column fixed="left" prop="orgaName" label="名称" width="100px"></el-table-column>
      <el-table-column prop="orgaTypeId" label="类型编号" width="150px"></el-table-column>
      <el-table-column prop="orgaState" label="状态" width="150px" :formatter="orgaStateFormatter"></el-table-column>
      <el-table-column prop="cityFlag" label="地市或班组标记" width="150px" :formatter="cityFlagFormatter"></el-table-column>
      <el-table-column prop="orgaCode" label="节点编码" width="150px"></el-table-column>
      <el-table-column prop="superOrgaCode" label="父节点编码" width="150px"></el-table-column>
      <el-table-column prop="orgaDesc" label="组织机构描述" width="150px"></el-table-column>
      <el-table-column prop="areaCode" label="地市区号" width="150px"></el-table-column>
      <el-table-column prop="orderNum" label="排序字段" width="150px"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间" width="150px"></el-table-column>
      <el-table-column prop="enterpriseName" label="所属企业" width="150px"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150px">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <div class="block">
      <el-pagination @current-change="handleCurrentChange"
                     :page-size="pageSize"
                     :total="total"
                     :hide-on-single-page="true"></el-pagination>
    </div>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="组织机构编号" prop="orgaId" >
          <el-input v-model="editForm.orgaId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="组织机构名称" prop="orgaName">
          <el-input v-model="editForm.orgaName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="类型编号" prop="orgaTypeId">
          <el-input v-model="editForm.orgaTypeId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="组织机构状态" prop="orgaState">
          <el-radio v-model="editForm.orgaState" label="0">在用</el-radio>
          <el-radio v-model="editForm.orgaState" label="1">废弃</el-radio>
          <el-radio v-model="editForm.orgaState" label="2">暂停</el-radio>
        </el-form-item>
        <el-form-item label="地市或班组标记" prop="cityFlag">
          <el-radio v-model="editForm.cityFlag" label="0">地市</el-radio>
          <el-radio v-model="editForm.cityFlag" label="1">班组</el-radio>
        </el-form-item>
        <el-form-item label="节点编码" prop="orgaCode">
          <el-input v-model="editForm.orgaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superOrgaCode">
          <el-input v-model="editForm.superOrgaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="orgaDesc">
          <el-input v-model="editForm.orgaDesc" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="地市区号" prop="areaCode">
          <el-input v-model="editForm.areaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="排序字段" prop="orderNum">
          <el-input v-model="editForm.orderNum" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="修改时间" prop="updateTime">
          <el-input v-model="editForm.updateTime" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属企业" prop="organizationId">
          <el-select v-model="editForm.enterpriseId" clearable remote filterable
                     placeholder="请输入关键词"
                     :remote-method="getEnterprise">
            <el-option
              v-for="enterprise in enterpriseList"
              :key="enterprise.enterpriseId"
              :label="enterprise.enterpriseName"
              :value="enterprise.enterpriseId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="editSubmit">提交</el-button>
      </div>
    </el-dialog>
    <!--新增-->
    <el-dialog title="新增" :visible.sync="addFormVisible" :close-on-click-modal="false">
      <el-form :model="addForm" label-width="80px" :rules="addFormRules" ref="addForm">
        <el-form-item label="组织机构编号" prop="orgaId" >
          <el-input v-model="addForm.orgaId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="组织机构名称" prop="orgaName">
          <el-input v-model="addForm.orgaName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="类型编号" prop="orgaTypeId">
          <el-input v-model="addForm.orgaTypeId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="组织机构状态" prop="orgaState">
          <el-radio v-model="addForm.orgaState" label="0">在用</el-radio>
          <el-radio v-model="addForm.orgaState" label="1">废弃</el-radio>
          <el-radio v-model="addForm.orgaState" label="2">暂停</el-radio>
        </el-form-item>
        <el-form-item label="地市或班组标记" prop="cityFlag">
          <el-radio v-model="addForm.cityFlag" label="0">地市</el-radio>
          <el-radio v-model="addForm.cityFlag" label="1">班组</el-radio>
        </el-form-item>
        <el-form-item label="节点编码" prop="orgaCode">
          <el-input v-model="addForm.orgaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superOrgaCode">
          <el-input v-model="addForm.superOrgaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="orgaDesc">
          <el-input v-model="addForm.orgaDesc" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="地市区号" prop="areaCode">
          <el-input v-model="addForm.areaCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="排序字段" prop="orderNum">
          <el-input v-model="addForm.orderNum" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="修改时间" prop="updateTime">
          <el-input v-model="addForm.updateTime" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属企业" prop="organizationId">
          <el-select v-model="addForm.enterpriseId" clearable remote filterable
                     placeholder="请输入关键词"
                     :remote-method="getEnterprise">
            <el-option
              v-for="enterprise in enterpriseList"
              :key="enterprise.enterpriseId"
              :label="enterprise.enterpriseName"
              :value="enterprise.enterpriseId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit">提交</el-button>
      </div>
    </el-dialog>
  </el-main>
</template>

<script>
import apiUrl from '../constant/apiUrl'
import { globalRespCode } from '../constant/respCode'

export default {
  name: 'OrganizationManage',
  data () {
    return {
      organizations: [],
      enterpriseList: [],
      multipleSelections: [],
      search: {
        searchWord: ''
      },
      total: 0,
      page: 1,
      pageSize: 20,
      editFormVisible: false, // 编辑界面是否显示
      editFormRules: {
        orgaName: [{ required: true, message: '请输入工作组名称', trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        orgaId: '',
        orgaName: '',
        orgaTypeId: '',
        orgaState: '',
        cityFlag: '',
        orgaCode: '',
        superOrgaCode: '',
        orgaDesc: '',
        areaCode: '',
        orderNum: '',
        updateTime: '',
        enterpriseId: '',
        enterpriseName: ''
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        orgaName: [{ required: true, message: '请输入工作组名称', trigger: 'blur' }]
      },
      // 新增界面数据
      addForm: {
        orgaId: '',
        orgaName: '',
        orgaTypeId: '',
        orgaState: '',
        cityFlag: '',
        orgaCode: '',
        superOrgaCode: '',
        orgaDesc: '',
        areaCode: '',
        orderNum: '',
        updateTime: '',
        enterpriseId: '',
        enterpriseName: ''
      }
    }
  },
  methods: {
    orgaStateFormatter: function (row) {
      switch (row.orgaState) {
        case '0': return '在用'
        case '1': return '废弃'
        case '2': return '暂停'
      }
    },
    cityFlagFormatter: function (row) {
      switch (row.cityFlag) {
        case '0': return '地市'
        case '1': return '班组'
      }
    },
    // 更改当前页数 用于展示工作组
    handleCurrentChange (val) {
      this.page = val
      this.getOrganizations()
    },
    getEnterprise: function (enterpriseName) {
      this.axios.post(apiUrl.getEnterpriseList, {
        searchWord: enterpriseName,
        page: 1,
        pageSize: 10
      }).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.enterpriseList = result.data.enterpriseBeanList
            break
          default:
            this.$message({type: 'error', message: '获取企业信息失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    // 获取工作组并根据筛选条件进行展示
    getOrganizations: function () {
      this.axios({
        method: 'post',
        url: apiUrl.getOrganizations,
        data: {
          searchWord: this.search.searchWord,
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.organizations = res.data.data.organizationList
        this.total = res.data.data.total
      })
    },
    // 新增工作组
    handleAdd: function () {
      this.addFormVisible = true
    },
    addSubmit: function () {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            this.axios({
              method: 'post',
              url: apiUrl.addOrganization,
              data: this.addForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '添加组织机构成功！'
                })
                this.$refs['addForm'].resetFields()
                this.addFormVisible = false
                this.getOrganizations()
              }
            })
          })
        }
      })
    },
    // 单个删除工作组
    handleDelete: function (row) {
      this.$confirm('确认删除该组织机构信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        ids.push(row.orgaId)
        this.axios({
          method: 'post',
          url: apiUrl.deleteOrganization,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除组织机构成功！'
            })
            this.getOrganizations()
          }
        })
      })
    },
    // 多选用户 用于批量删除
    handleSelectionChange (val) {
      this.multipleSelections = val
    },
    // 批量删除用户
    handleBatchDelete: function () {
      this.$confirm('确认删除该组织机构吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        this.multipleSelections.forEach(multipleSelection => {
          ids.push(multipleSelection.orgaId)
        })
        this.axios({
          method: 'post',
          url: apiUrl.deleteOrganization,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除组织机构成功！'
            })
            this.getOrganizations()
          }
        })
      })
    },
    // 编辑工作组
    handleEdit: function (row) {
      this.editForm = Object.assign({}, row)
      this.editFormVisible = true
    },
    editSubmit: function () {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            this.axios({
              method: 'post',
              url: apiUrl.editOrganization,
              data: this.editForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '修改组织机构成功！'
                })
                this.$refs['editForm'].resetFields()
                this.editFormVisible = false
                this.getOrganizations()
              }
            })
          })
        }
      })
    }
  },
  created () {
    this.getOrganizations()
  }
}
</script>

<style scoped>
</style>
