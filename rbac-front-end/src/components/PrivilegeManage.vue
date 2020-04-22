<template>
  <el-main style="padding-bottom: 0">
    <el-row>
      <el-col :span="6" class="toolbar" style="padding-left: 20px;font-size: 30px">
        <div>权限管理</div>
      </el-col>
      <!--搜索-->
      <el-col :span="18" class="toolbar" style="padding-left: 20px;">
        <el-form :inline="true" :model="search">
          <el-form-item>
            <el-input v-model="search.searchWord" placeholder="请输入关键词" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getAuth">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleAdd">新增</el-button>
          </el-form-item>
<!--          <el-form-item>-->
<!--            <el-button type="danger" @click="handleBatchDelete">批量删除</el-button>-->
<!--          </el-form-item>-->
        </el-form>
      </el-col>
    </el-row>
    <!--权限列表-->
    <el-table
      ref="multipleTable"
      :data="authList"
      stripe
      style="width: 100%"
      height="470"
      @selection-change="handleSelectionChange"
    >
<!--      <el-table-column type="selection" fixed="left"></el-table-column>-->
      <el-table-column fixed="left" prop="authId" label="编号" width="100px"></el-table-column>
      <el-table-column fixed="left" prop="authName" label="名称" width="100px"></el-table-column>
      <el-table-column prop="moduleId" label="所属模块编号" width="150px"></el-table-column>
      <el-table-column prop="authCode" label="编码" width="150px"></el-table-column>
      <el-table-column prop="superCode" label="上级编码" width="150px"></el-table-column>
      <el-table-column prop="menuFlag" label="菜单项标记" width="150px" :formatter="menuFlagFormatter"></el-table-column>
      <el-table-column prop="description" label="描述信息" width="150px"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150px">
        <template slot-scope="scope">
<!--          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>-->
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
        <el-form-item label="权限编号" prop="authId" >
          <el-input v-model="editForm.authId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="权限名称" prop="authName">
          <el-input v-model="editForm.authName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属模块编号" prop="moduleId">
          <el-input v-model="editForm.moduleId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="节点编码" prop="authCode">
          <el-input v-model="editForm.authCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superCode">
          <el-input v-model="editForm.superCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="菜单项标记" prop="menuFlag">
          <el-radio v-model="editForm.menuFlag" label="0">功能</el-radio>
          <el-radio v-model="editForm.menuFlag" label="1">菜单</el-radio>
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="editForm.description" auto-complete="off"></el-input>
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
        <el-form-item label="权限编号" prop="authId" >
          <el-input v-model="addForm.authId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="权限名称" prop="authName">
          <el-input v-model="addForm.authName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属模块编号" prop="moduleId">
          <el-input v-model="addForm.moduleId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="节点编码" prop="authCode">
          <el-input v-model="addForm.authCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superCode">
          <el-input v-model="addForm.superCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="菜单项标记" prop="menuFlag">
          <el-radio v-model="addForm.menuFlag" label="0">功能</el-radio>
          <el-radio v-model="addForm.menuFlag" label="1">菜单</el-radio>
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="addForm.description" auto-complete="off"></el-input>
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
  name: 'PrivilegeManage',
  data () {
    return {
      authList: [],
      multipleSelections: [],
      search: {
        searchWord: ''
      },
      total: 0,
      page: 1,
      pageSize: 20,
      editFormVisible: false, // 编辑界面是否显示
      editFormRules: {
        authName: [{ required: true, message: '请输入权限名称', trigger: 'blur' }],
        moduleId: [{ required: true, message: '所属模块编号', trigger: 'blur' }],
        authCode: [{ required: true, message: '请输入编码', trigger: 'blur' }],
        superCode: [{ required: true, message: '请输入父权限编码', trigger: 'blur' }],
        menuFlag: [{ required: true, message: '请输入菜单项标记', trigger: 'blur' }],
        description: [{ required: false, trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        authName: '',
        moduleId: '',
        authCode: '',
        superCode: '',
        menuFlag: '',
        description: ''
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        authName: [{ required: true, message: '请输入权限名称', trigger: 'blur' }],
        moduleId: [{ required: true, message: '所属模块编号', trigger: 'blur' }],
        authCode: [{ required: true, message: '请输入编码', trigger: 'blur' }],
        superCode: [{ required: true, message: '请输入父权限编码', trigger: 'blur' }],
        menuFlag: [{ required: true, message: '请输入菜单项标记', trigger: 'blur' }],
        description: [{ required: false, trigger: 'blur' }]
      },
      // 新增界面数据
      addForm: {
        authName: '',
        moduleId: '',
        authCode: '',
        superCode: '',
        menuFlag: '',
        description: ''
      }
    }
  },
  methods: {
    menuFlagFormatter: function (row) {
      switch (row.menuFlag) {
        case '0': return '功能'
        case '1': return '菜单'
      }
    },
    // 更改当前页数 用于展示工作组
    handleCurrentChange (val) {
      this.page = val
      this.getAuth()
    },
    // 获取工作组并根据筛选条件进行展示
    getAuth: function () {
      this.axios({
        method: 'post',
        url: apiUrl.getAuth,
        data: {
          searchWord: this.search.searchWord,
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.authList = res.data.data.authList
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
              url: apiUrl.addAuth,
              data: this.addForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '添加权限成功！'
                })
                this.$refs['addForm'].resetFields()
                this.addFormVisible = false
                this.getAuth()
              }
            })
          })
        }
      })
    },
    handleDelete: function (row) {
      this.$confirm('确认删除该权限吗?', '提示', {
        type: 'warning'
      }).then(() => {
        this.axios({
          method: 'post',
          url: apiUrl.deleteAuth,
          data: {
            authId: row.authId
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除权限成功！'
            })
            this.getAuth()
          } else {
            this.$message({
              type: 'error',
              message: '删除权限失败！该权限可能在使用中！'
            })
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
      this.$confirm('确认删除该权限吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        this.multipleSelections.forEach(multipleSelection => {
          ids.push(multipleSelection.authId)
        })
        this.axios({
          method: 'post',
          url: apiUrl.deleteAuth,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除权限成功！'
            })
            this.getAuth()
          }
        })
      })
    },
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
              url: apiUrl.editAuth,
              data: this.editForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '修改权限成功！'
                })
                this.$refs['editForm'].resetFields()
                this.editFormVisible = false
                this.getAuth()
              }
            })
          })
        }
      })
    }
  },
  created () {
    this.getAuth()
  }
}
</script>

<style scoped>
</style>
