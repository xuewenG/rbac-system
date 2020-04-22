<template>
  <el-main style="padding-bottom: 0">
    <el-row>
      <el-col :span="6" class="toolbar" style="padding-left: 20px;font-size: 30px">
        <div>用户管理</div>
      </el-col>
      <!--搜索-->
      <el-col :span="18" class="toolbar" style="padding-left: 20px;">
        <el-form :inline="true" :model="search">
          <el-form-item>
            <el-input v-model="search.searchWord" placeholder="请输入关键词" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getStaffs">查询</el-button>
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
    <!--用户列表-->
    <el-table
      ref="multipleTable"
      :data="staffs"
      stripe
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" fixed="left"></el-table-column>
      <el-table-column fixed="left" prop="staffId" label="id"></el-table-column>
      <el-table-column fixed="left" prop="staffName" label="姓名"></el-table-column>
      <el-table-column prop="staffState" label="人员状态" :formatter="staffStateFormatter"></el-table-column>
      <el-table-column prop="staffIdStatus" label="账号状态" :formatter="staffIdStatusFormatter"></el-table-column>
      <el-table-column prop="groupList" label="工作组" :formatter="groupFormatter"></el-table-column>
      <el-table-column prop="organizationId" label="机构" :formatter="organizationFormatter"></el-table-column>
      <el-table-column prop="roleList" label="角色" :formatter="roleNameFormatter"></el-table-column>
      <el-table-column prop="petName" label="昵称"></el-table-column>
      <el-table-column fixed="right" label="操作" width="149px">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <div class="block">
      <el-pagination
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="total"
        :hide-on-single-page="true"></el-pagination>
    </div>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="id" prop="staffId">
          <el-input v-model="editForm.staffId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="staffName">
          <el-input v-model="editForm.staffName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="petName">
          <el-input v-model="editForm.petName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="人员状态" prop="staffState">
          <el-radio v-model="editForm.staffState" label="0">离职</el-radio>
          <el-radio v-model="editForm.staffState" label="1">在职</el-radio>
        </el-form-item>
        <el-form-item label="账号状态" prop="staffIdStatus">
          <el-radio v-model="editForm.staffIdStatus" label="01">正常</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="02">停用</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="03">作废</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="04">锁定</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="05">解锁</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="06">失效</el-radio>
          <el-radio v-model="editForm.staffIdStatus" label="07">未启用</el-radio>
        </el-form-item>
        <el-form-item label="工作组" prop="groupIds">
          <el-select v-model="editForm.groupIds" multiple clearable remote filterable reserve-keyword
                     placeholder="请输入关键词"
                     :remote-method = "(groupName) => {searchGroup(groupName, 'editForm')}">
            <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="机构" prop="organizationId">
          <el-select v-model="editForm.organizationId" clearable remote filterable
                     placeholder="请输入关键词"
                     :remote-method="getOrganization">
            <el-option
              v-for="organization in organizations"
              :key="organization.orgaId"
              :label="organization.orgaName"
              :value="organization.orgaId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="角色" prop="roleIds">
          <el-select v-model="editForm.roleIds" multiple filterable reserve-keyword
                     placeholder="请输入关键词"
                     remote
                     :remote-method="(roleName) => {searchRole(roleName,'editForm')}">
            <el-option
              v-for="role in roles"
              :key="role.roleId"
              :label="role.roleName"
              :value="role.roleId">
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
        <el-form-item label="id" prop="staffId">
          <el-input v-model="addForm.staffId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="staffName">
          <el-input v-model="addForm.staffName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="petName">
          <el-input v-model="addForm.petName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="人员状态" prop="staffState">
          <el-radio v-model="addForm.staffState" label="0">离职</el-radio>
          <el-radio v-model="addForm.staffState" label="1">在职</el-radio>
        </el-form-item>
        <el-form-item label="账号状态" prop="staffIdStatus">
          <el-radio v-model="addForm.staffIdStatus" label="01">正常</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="02">停用</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="03">作废</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="04">锁定</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="05">解锁</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="06">失效</el-radio>
          <el-radio v-model="addForm.staffIdStatus" label="07">未启用</el-radio>
        </el-form-item>
        <el-form-item label="工作组" prop="groupIds">
          <el-select v-model="addForm.groupIds" multiple clearable remote filterable reserve-keyword
                     placeholder="请输入关键词"
                     :remote-method = "(groupName) => {searchGroup(groupName, 'addForm')}">
            <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="机构" prop="organizationId">
          <el-select v-model="addForm.organizationId" clearable remote filterable
                     placeholder="请输入关键词"
                     :remote-method="getOrganization">
            <el-option
              v-for="organization in organizations"
              :key="organization.orgaId"
              :label="organization.orgaName"
              :value="organization.orgaId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="角色" prop="roleIds">
          <el-select v-model="addForm.roleIds" multiple filterable reserve-keyword
                     placeholder="请输入关键词"
                     remote
                     :remote-method="(roleName) => {searchRole(roleName,'addForm')}">
            <el-option
              v-for="role in roles"
              :key="role.roleId"
              :label="role.roleName"
              :value="role.roleId">
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
  name: 'StaffManage',
  data () {
    return {
      roles: [],
      groups: [],
      organizations: [],
      staffs: [],
      multipleSelections: [],
      search: {
        searchWord: ''
      },
      total: 0,
      page: 1,
      pageSize: 10,
      editFormVisible: false, // 编辑界面是否显示
      editFormRules: {
        staffName: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        staffState: [{ required: true, message: '请输入人员状态', trigger: 'blur' }],
        staffIdStatus: [{ required: true, message: '请输入账户状态', trigger: 'blur' }],
        groupIds: [{ required: true, message: '请输入工作组', trigger: 'blur' }],
        organizationId: [{ required: true, message: '请输入机构', trigger: 'blur' }],
        roleIds: [{ required: true, message: '请输入角色', trigger: 'blur' }],
        petName: [{ required: true, message: '请输入昵称', trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        staffId: '',
        staffName: '',
        staffState: '',
        staffIdStatus: '',
        groupIds: [],
        organizationId: '',
        roleIds: [],
        petName: ''
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        staffName: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        staffState: [{ required: true, message: '请输入人员状态', trigger: 'blur' }],
        staffIdStatus: [{ required: true, message: '请输入账户状态', trigger: 'blur' }],
        groupIds: [{ required: true, message: '请输入工作组', trigger: 'blur' }],
        organizationId: [{ required: true, message: '请输入机构', trigger: 'blur' }],
        roleIds: [{ required: true, message: '请输入角色', trigger: 'blur' }],
        petName: [{ required: true, message: '请输入昵称', trigger: 'blur' }]
      },
      // 新增界面数据
      addForm: {
        staffId: '',
        staffName: '',
        staffState: '',
        staffIdStatus: '',
        groupIds: [],
        organizationId: '',
        roleIds: [],
        petName: ''
      }
    }
  },
  methods: {
    // 更改当前页数 用于展示用户
    handleCurrentChange (val) {
      this.page = val
      this.getStaffs()
    },
    // 获取用户并根据筛选条件进行展示
    getStaffs () {
      this.axios({
        method: 'post',
        url: apiUrl.getStaffs,
        data: {
          searchWord: this.search.searchWord,
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(res => {
        const result = res.data
        if (result.code === globalRespCode.SUCCESS) {
          this.staffs = result.data.staffs
          this.total = result.data.total
        } else {
          this.$message({type: 'error', message: '获取员工列表失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网路错误！'})
      })
    },
    // 新增用户
    handleAdd: function () {
      this.addFormVisible = true
    },
    addSubmit: function () {
      this.$confirm('确认提交吗？', '提示', {}).then(() => {
        const form = this.addForm
        this.axios.post(apiUrl.addStaff, {
          staffId: form.staffId,
          staffName: form.staffName,
          staffState: form.staffState,
          staffIdStatus: form.staffIdStatus,
          organizationId: form.organizationId,
          petName: form.petName,
          groupIdList: form.groupIds,
          roleIdList: form.roleIds
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '新增用户成功！'
            })
            this.addFormVisible = false
            this.$refs['addForm'].resetFields()
            this.groups = []
            this.roles = []
            this.organizations = []
            this.getStaffs()
          } else {
            this.$message({type: 'error', message: '新增失败！'})
          }
        }).catch(e => {
          this.$message({type: 'error', message: '网络错误！'})
        })
      })
    },
    // 单个删除用户
    handleDelete: function (row) {
      this.$confirm('确认删除该用户信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        ids.push(row.staffId)
        this.axios({
          method: 'post',
          url: apiUrl.deleteStaff,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除用户成功！'
            })
            this.getStaffs()
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
      this.$confirm('确认删除该用户信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        this.multipleSelections.forEach(multipleSelection => {
          ids.push(multipleSelection.staffId)
        })
        this.axios({
          method: 'post',
          url: apiUrl.deleteStaff,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除用户成功！'
            })
            this.getStaffs()
          }
        })
      })
    },
    // 编辑用户
    handleEdit: function (row) {
      this.editForm = {
        staffId: row.staffId,
        staffName: row.staffName,
        staffState: row.staffState,
        staffIdStatus: row.staffIdStatus,
        groupIds: row.groupList.map(item => item.groupId),
        organizationId: row.organizationId,
        roleIds: row.roleList.map(item => item.roleId),
        petName: row.petName
      }
      this.editFormVisible = true
      this.groups = row.groupList
      this.roles = row.roleList
      this.searchGroup('')
      this.searchRole('')
      this.getOrganization(row.organization.orgaName)
    },
    searchGroup (groupName, formFlag) {
      if (groupName === '') {
        return
      }
      let oldGroup = this.groups
      console.log('oldGroup', oldGroup)
      this.getGroup(groupName).then(() => {
        oldGroup = oldGroup.filter(item => {
          let has = true
          this.groups.forEach(group => {
            if (group.groupId === item.groupId) {
              has = false
            }
          })
          return has
        })
        oldGroup = oldGroup.filter(item => {
          let has = false
          let form = (formFlag === 'addForm' ? this.addForm : this.editForm)
          form.groupIds.forEach(groupId => {
            if (groupId === item.groupId) {
              has = true
            }
          })
          return has
        })
        this.groups = [...this.groups, ...oldGroup]
      })
    },
    searchRole (roleName, formFlag) {
      if (roleName === '') {
        return
      }
      let oldRole = this.roles
      this.getRole(roleName).then(() => {
        oldRole = oldRole.filter(item => {
          let has = true
          this.roles.forEach(role => {
            if (role.roleId === item.roleId) {
              has = false
            }
          })
          return has
        })
        oldRole = oldRole.filter(item => {
          let has = false
          let form = (formFlag === 'addForm' ? this.addForm : this.editForm)
          form.roleIds.forEach(roleId => {
            if (roleId === item.roleId) {
              has = true
            }
          })
          return has
        })
        this.roles = [...this.roles, ...oldRole]
      })
    },
    editSubmit: function () {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            const form = this.editForm
            this.axios.post(apiUrl.editStaff, {
              staffId: form.staffId,
              staffName: form.staffName,
              staffState: form.staffState,
              staffIdStatus: form.staffIdStatus,
              organizationId: form.organizationId,
              petName: form.petName,
              groupIdList: form.groupIds,
              roleIdList: form.roleIds
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '修改用户成功！'
                })
                this.editFormVisible = false
                this.groups = []
                this.roles = []
                this.organizations = []
                this.getStaffs()
              } else {
                this.$message({type: 'error', message: '修改失败！'})
              }
            }).catch(e => {
              this.$message({type: 'error', message: '网络错误！'})
            })
          })
        }
      })
    },
    async getGroup (groupName) {
      await this.axios.post(apiUrl.getGroups, {
        page: 1,
        pageSize: 3,
        searchWord: groupName
      }).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.groups = result.data.groupInfoList
            break
          default:
            this.$message({type: 'error', message: '获取工作组失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    getOrganization (organizationName) {
      this.axios.post(apiUrl.getOrganizations, {
        searchWord: organizationName,
        page: 1,
        pageSize: 10
      }).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.organizations = result.data.organizationList
            break
          default:
            this.$message({type: 'error', message: '获取组织机构失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    async getRole (roleName) {
      await this.axios.post(apiUrl.getRoles, {
        page: 1,
        pageSize: 10,
        searchWord: roleName
      }).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.roles = result.data.roles
            break
          default:
            this.$message({type: 'error', message: '获取角色失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    // 展示数据时用于id和name的映射
    roleNameFormatter (row) {
      let roleNames = []
      row.roleList.forEach(rowRole => {
        roleNames.push(rowRole.roleName)
      })
      return roleNames.join(' | ')
    },
    staffStateFormatter (row) {
      switch (row.staffState) {
        case '0': return '离职'
        case '1': return '在职'
      }
    },
    staffIdStatusFormatter (row) {
      switch (row.staffIdStatus) {
        case '01': return '正常'
        case '02': return '停用'
        case '03': return '作废'
        case '04': return '锁定'
        case '05': return '解锁'
        case '06': return '失效'
        case '07': return '未启用'
      }
    },
    groupFormatter (row) {
      let name = []
      row.groupList.forEach(group => {
        name.push(group.groupName)
      })
      return name.join(' | ')
    },
    organizationFormatter (row) {
      return row.organization ? row.organization.orgaName : '---'
    }
  },
  created () {
    // this.getAll()
    this.getStaffs()
  }
}
</script>

<style scoped>
</style>
