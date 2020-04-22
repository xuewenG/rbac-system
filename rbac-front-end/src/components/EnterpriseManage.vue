<template>
  <el-main style="padding-bottom: 0">
    <el-row>
      <el-col :span="6" class="toolbar" style="padding-left: 20px;font-size: 30px">
        <div>企业信息管理</div>
      </el-col>
      <!--搜索-->
      <el-col :span="18" class="toolbar" style="padding-left: 20px;">
        <el-form :inline="true" :model="search">
          <el-form-item>
            <el-input v-model="search.searchWord" placeholder="请输入关键词" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getEnterpriseList">查询</el-button>
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
    <!--企业信息列表-->
    <el-table
      ref="multipleTable"
      :data="enterpriseList"
      stripe
      style="width: 100%"
      height=85%
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" fixed="left"></el-table-column>
      <el-table-column fixed="left" prop="enterpriseId" label="编号" width="100px"></el-table-column>
      <el-table-column fixed="left" prop="enterpriseName" label="名称" width="100px"></el-table-column>
      <el-table-column prop="enterpriseAddress" label="企业所在地" width="150px"></el-table-column>
      <el-table-column prop="legalRepresentative" label="法人代表" width="150px"></el-table-column>
      <el-table-column prop="registeredCapital" label="注册资本" width="150px"></el-table-column>
      <el-table-column prop="businessScope" label="经营范围" width="150px"></el-table-column>
      <el-table-column prop="businessQualification" label="经营资质" width="150px"></el-table-column>
      <el-table-column prop="numberOfEmployees" label="员工人数" width="150px"></el-table-column>
      <el-table-column prop="corporateWebsite" label="企业网站" width="150px"></el-table-column>
      <el-table-column prop="telephone" label="联系方式" width="150px"></el-table-column>
      <el-table-column prop="licenseInformation" label="企业执照信息" width="150px"></el-table-column>
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
        <el-form-item label="企业编号" prop="enterpriseId">
          <el-input v-model="editForm.enterpriseId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="企业名称" prop="enterpriseName">
          <el-input v-model="editForm.enterpriseName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业所在地" prop="enterpriseAddress">
          <el-input v-model="editForm.enterpriseAddress" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="法人代表" prop="legalRepresentative">
          <el-input v-model="editForm.legalRepresentative" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="注册资本" prop="registeredCapital">
          <el-input v-model="editForm.registeredCapital" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="经营范围" prop="businessScope">
          <el-input v-model="editForm.businessScope" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="经营资质" prop="businessQualification">
          <el-input v-model="editForm.businessQualification" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="员工人数" prop="numberOfEmployees">
          <el-input v-model="editForm.numberOfEmployees" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业网站" prop="corporateWebsite">
          <el-input v-model="editForm.corporateWebsite" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="联系方式" prop="telephone">
          <el-input v-model="editForm.telephone" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业执照信息" prop="licenseInformation">
          <el-input v-model="editForm.licenseInformation" auto-complete="off"></el-input>
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
        <el-form-item label="企业编号" prop="enterpriseId">
          <el-input v-model="addForm.enterpriseId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="企业名称" prop="enterpriseName">
          <el-input v-model="addForm.enterpriseName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业所在地" prop="enterpriseAddress">
          <el-input v-model="addForm.enterpriseAddress" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="法人代表" prop="legalRepresentative">
          <el-input v-model="addForm.legalRepresentative" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="注册资本" prop="registeredCapital">
          <el-input v-model="addForm.registeredCapital" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="经营范围" prop="businessScope">
          <el-input v-model="addForm.businessScope" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="经营资质" prop="businessQualification">
          <el-input v-model="addForm.businessQualification" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="员工人数" prop="numberOfEmployees">
          <el-input v-model="addForm.numberOfEmployees" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业网站" prop="corporateWebsite">
          <el-input v-model="addForm.corporateWebsite" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="联系方式" prop="telephone">
          <el-input v-model="addForm.telephone" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="企业执照信息" prop="licenseInformation">
          <el-input v-model="addForm.licenseInformation" auto-complete="off"></el-input>
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
import {globalRespCode} from '../constant/respCode'

export default {
  name: 'EnterpriseManage',
  data () {
    return {
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
        enterpriseName: [{required: true, message: '请输入企业名称', trigger: 'blur'}]
      },
      // 编辑界面数据
      editForm: {
        enterpriseId: '',
        enterpriseName: '',
        enterpriseAddress: '',
        legalRepresentative: '',
        registeredCapital: '',
        businessScope: '',
        businessQualification: '',
        numberOfEmployees: '',
        corporateWebsite: '',
        telephone: '',
        licenseInformation: ''
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        enterpriseName: [{required: true, message: '请输入企业名称', trigger: 'blur'}]
      },
      // 新增界面数据
      addForm: {
        enterpriseId: '',
        enterpriseName: '',
        enterpriseAddress: '',
        legalRepresentative: '',
        registeredCapital: '',
        businessScope: '',
        businessQualification: '',
        numberOfEmployees: '',
        corporateWebsite: '',
        telephone: '',
        licenseInformation: ''
      }
    }
  },
  methods: {
    // 更改当前页数 用于展示工作组
    handleCurrentChange (val) {
      this.page = val
      this.getEnterpriseList()
    },
    getEnterpriseList: function () {
      this.axios({
        method: 'post',
        url: apiUrl.getEnterpriseList,
        data: {
          searchWord: this.search.searchWord,
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.enterpriseList = res.data.data.enterpriseBeanList
        this.total = res.data.data.total
      })
    },
    handleAdd: function () {
      this.addFormVisible = true
    },
    addSubmit: function () {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            this.axios({
              method: 'post',
              url: apiUrl.addEnterprise,
              data: this.addForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '添加企业信息成功！'
                })
                this.$refs['addForm'].resetFields()
                this.addFormVisible = false
                this.getEnterpriseList()
              }
            })
          })
        }
      })
    },
    handleDelete: function (row) {
      this.$confirm('确认删除该企业信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let enterpriseIdList = []
        enterpriseIdList.push(row.enterpriseId)
        this.axios({
          method: 'post',
          url: apiUrl.deleteEnterpriseList,
          data: {
            enterpriseIdList: enterpriseIdList
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除企业信息成功！'
            })
            this.getEnterpriseList()
          }
        })
      })
    },
    handleSelectionChange (val) {
      this.multipleSelections = val
    },
    handleBatchDelete: function () {
      this.$confirm('确认删除该企业信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let enterpriseIDList = []
        this.multipleSelections.forEach(multipleSelection => {
          enterpriseIDList.push(multipleSelection.enterpriseId)
        })
        this.axios({
          method: 'post',
          url: apiUrl.deleteEnterpriseList,
          data: {
            enterpriseIDList: enterpriseIDList
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除企业信息成功！'
            })
            this.getEnterpriseList()
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
              url: apiUrl.editEnterprise,
              data: this.editForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '修改企业信息成功！'
                })
                this.$refs['editForm'].resetFields()
                this.editFormVisible = false
                this.getEnterpriseList()
              }
            })
          })
        }
      })
    }
  },
  created () {
    this.getEnterpriseList()
  }
}
</script>

<style scoped>
</style>
