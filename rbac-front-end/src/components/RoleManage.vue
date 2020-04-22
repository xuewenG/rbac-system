<template>
  <el-main>
    <h1>角色管理</h1>
<!--    搜索-->
    <el-form :inline="true" :model="keywords">
      <el-form-item>
        <el-input v-model="keywords.searchData" placeholder="搜索关键词"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">查询</el-button>
      </el-form-item>
      <!--    添加角色-->
      <el-button type="primary" @click="addRoleDialog">新增</el-button>
    </el-form>
<!--    角色列表-->
    <el-table :data="roleList" stripe>
<!--      <el-table-column type="selection" fixed="left"></el-table-column>-->
      <el-table-column prop="roleId" label="角色编号"></el-table-column>
      <el-table-column prop="roleName" label="角色名"></el-table-column>
<!--      <el-table-column prop="roleCode" label="角色编码"></el-table-column>-->
<!--      <el-table-column prop="superCode" label="上级角色编码"></el-table-column>-->
      <el-table-column prop="description" label="描述信息"></el-table-column>
      <el-table-column prop="authList" label="权限" :formatter="authFormatter"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="clickEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteRole(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
<!--    分页-->
    <el-row type="flex" justify="center">
      <el-pagination
        @current-change="currentPageChange"
        :hide-on-single-page="true"
        :current-page="this.currentPage"
        :page-size="pageSize"
        :total="total">
      </el-pagination>
    </el-row>
<!--    新增-->
    <el-dialog
      title="新增"
      :visible="addRoleFormVisible"
      :close-on-click-modal="false">
      <el-form
        :model="addRoleForm"
        label-width="120px"
        :rules="addRoleFormRules"
        ref="addRoleForm">
        <el-form-item prop="roleName" label="角色名">
          <el-input v-model="addRoleForm.roleName" auto-complete="off"></el-input>
        </el-form-item>
<!--        <el-form-item prop="roleCode" label="角色编码">-->
<!--          <el-input v-model="addRoleForm.roleCode" auto-complete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item prop="superCode" label="上级角色编码">-->
<!--          <el-input v-model="addRoleForm.superCode" auto-complete="off"></el-input>-->
<!--        </el-form-item>-->
        <el-form-item prop="description" label="描述信息">
          <el-input v-model="addRoleForm.description" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="权限" prop="authList">
          <el-select v-model="addRoleForm.authIds" multiple filterable reserve-keyword
                     placeholder="请输入关键词"
                     remote
                     :remote-method="(authName) => {searchAuth(authName,'addRoleForm')}">
            <el-option
              v-for="auth in authList"
              :key="auth.authId"
              :label="auth.authName"
              :value="auth.authId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addRoleFormVisible=false">取消</el-button>
        <el-button type="primary" @click="addRole">提交</el-button>
      </div>
    </el-dialog>
<!--    编辑-->
    <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item prop="roleName" label="角色名">
          <el-input v-model="editForm.roleName" auto-complete="off"></el-input>
        </el-form-item>
<!--        <el-form-item prop="roleCode" label="角色编码">-->
<!--          <el-input v-model="editForm.roleCode" auto-complete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item prop="superCode" label="上级角色编码">-->
<!--          <el-input v-model="editForm.superCode" auto-complete="off"></el-input>-->
<!--        </el-form-item>-->
        <el-form-item prop="description" label="描述信息">
          <el-input v-model="editForm.description" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="权限" prop="authList">
          <el-select v-model="editForm.authIds" multiple filterable reserve-keyword
                     placeholder="请输入关键词"
                     remote
                     :remote-method="(authName) => {searchAuth(authName,'editForm')}">
            <el-option
              v-for="auth in authList"
              :key="auth.authId"
              :label="auth.authName"
              :value="auth.authId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editFormVisible = false">取消</el-button>
        <el-button type="primary" @click="editRole">提交</el-button>
      </div>
    </el-dialog>
  </el-main>
</template>

<script>
import apiUrl from '../constant/apiUrl'
import {globalRespCode} from '../constant/respCode'
export default {
  name: 'RoleManage',
  data () {
    return {
      keywords: {
        searchData: ''
      },
      total: 0,
      currentPage: 1,
      pageSize: 20,
      roleList: [],
      authList: [],
      addRoleFormVisible: false,
      addRoleForm: {
        roleName: '',
        // roleCode: '',
        // superCode: '',
        description: '',
        authIds: []
      },
      addRoleFormRules: {
        roleName: [
          { required: true, message: '请输入角色名', trigger: 'blur' }
        ]
        // roleCode: [
        //   { required: true, message: '请输入角色编码', trigger: 'blur' }
        // ],
        // superCode: [
        //   { required: true, message: '请输入上级编码', trigger: 'blur' }
        // ]
      },
      editFormVisible: false,
      editForm: {
        roleId: '',
        roleName: '',
        // roleCode: '',
        // superCode: '',
        description: '',
        authIds: []
      },
      editFormRules: {
        roleName: [
          { required: true, message: '请输入角色名', trigger: 'blur' }
        ],
        // roleCode: [
        //   { required: true, message: '请输入角色编码', trigger: 'blur' }
        // ],
        // superCode: [
        //   { required: true, message: '请输入上级编码', trigger: 'blur' }
        // ],
        description: [{ message: '请输入描述信息', trigger: 'blur' }]
      }
    }
  },
  methods: {
    authFormatter (row) {
      let name = []
      console.log('auth.authName')
      row.authList.forEach(auth => {
        console.log(auth.authName)
        name.push(auth.authName)
      })
      return name.join(' | ')
    },
    search () {
      this.currentPage = 1
      this.getRoleList()
    },
    searchAuth (authName, formFlag) {
      if (authName === '') {
        return
      }
      let oldAuth = this.authList
      this.getAuth(authName).then(() => {
        oldAuth = oldAuth.filter(item => {
          let has = true
          this.authList.forEach(auth => {
            if (auth.authId === item.authId) {
              has = false
            }
          })
          return has
        })
        oldAuth = oldAuth.filter(item => {
          let has = false
          let form = (formFlag === 'addForm' ? this.addForm : this.editForm)
          form.authIds.forEach(authId => {
            if (authId === item.authId) {
              has = true
            }
          })
          return has
        })
        this.authList = [...this.authList, ...oldAuth]
      })
    },
    async getAuth (authName) {
      await this.axios.post(apiUrl.getAuth, {
        page: 1,
        pageSize: 10,
        searchWord: authName
      }).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.authList = result.data.authList
            break
          default:
            this.$message({type: 'error', message: '获取权限失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    getRoleList () {
      this.axios.post(apiUrl.getRoles, {
        searchWord: this.keywords.searchData,
        page: this.currentPage,
        pageSize: this.pageSize
      }).then(res => {
        let result = res.data
        if (result.code === globalRespCode.SUCCESS) {
          this.roleList = result.data.roles
          this.total = result.data.total
        } else {
          this.$message({
            type: 'error',
            message: '获取角色列表失败！'
          })
        }
      }).catch(e => {
        this.$message({
          type: 'error',
          message: '网络错误！'
        })
      })
    },
    currentPageChange (current) {
      this.currentPage = current
      this.getRoleList()
    },
    addRoleDialog () {
      this.addRoleFormVisible = true
    },
    addRole () {
      this.$refs.addRoleForm.validate(valid => {
        if (valid) {
          console.log('submit')
          this.$confirm('确认提交吗？', '确认', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.axios.post(apiUrl.addRole, this.addRoleForm).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '添加角色成功！'
                })
                this.$refs['addRoleForm'].resetFields()
                this.addRoleFormVisible = false
                this.getRoleList()
              } else {
                this.$message({
                  type: 'error',
                  message: '添加角色失败！'
                })
              }
            }).catch(e => {
              this.$message({type: 'error', message: '网络错误!'})
            })
          }).catch(e => {
            this.$message({
              type: 'info',
              message: '已取消'
            })
          })
        }
      })
    },
    deleteRole: function (row) {
      this.$confirm('确认删除该记录吗?', '确认', {
        type: 'warning'
      }).then(() => {
        this.axios.post(apiUrl.deleteRole, {
          roleId: row.roleId
        }).then(res => {
          const result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除角色成功！'
            })
            this.getRoleList()
          }
        }).catch(e => {
          this.$message({type: 'error', message: '网络错误！'})
        })
        this.getRoleList()
      }).catch(e => {
        this.$message({
          type: 'info',
          message: '取消删除！'
        })
      })
    },
    clickEdit: function (row) {
      this.authList = row.authList
      this.searchAuth('')
      this.editForm = {
        roleId: row.roleId,
        roleName: row.roleName,
        description: row.description,
        authIds: row.authList.map(item => item.authId)
      }
      this.editFormVisible = true
    },
    editRole: function () {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示').then(() => {
            this.axios.post(apiUrl.editRole, this.editForm).then(res => {
              const result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '编辑成功！'
                })
                this.$refs['editForm'].resetFields()
                this.editFormVisible = false
                this.getRoleList()
              }
            }).catch(e => {
              this.$message({type: 'error', message: '网络错误！'})
            })
          }).catch(e => {
            this.$message({type: 'info', message: '编辑取消！'})
          })
        }
      })
    }
  },
  created () {
    this.getRoleList()
  }
}
</script>

<style scoped>
</style>
