<template>
  <el-main style="padding-bottom: 0">
    <el-row>
      <el-col :span="6" class="toolbar" style="padding-left: 20px;font-size: 30px">
        <div>工作组管理</div>
      </el-col>
      <!--搜索-->
      <el-col :span="18" class="toolbar" style="padding-left: 20px;">
        <el-form :inline="true" :model="search">
          <el-form-item>
            <el-input v-model="search.searchWord" placeholder="请输入关键词" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getGroups">查询</el-button>
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
    <!--工作组列表-->
    <el-table
      ref="multipleTable"
      :data="groups"
      stripe
      style="width: 100%"
      height="470"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" fixed="left"></el-table-column>
      <el-table-column fixed="left" prop="groupId" label="编号" width="100px"></el-table-column>
      <el-table-column fixed="left" prop="groupName" label="名称" width="100px"></el-table-column>
      <el-table-column prop="groupTypeId" label="类型编号" width="150px"></el-table-column>
      <el-table-column prop="groupCode" label="节点编码" width="150px"></el-table-column>
      <el-table-column prop="superGroupCode" label="父节点编码" width="150px"></el-table-column>
      <el-table-column prop="validStart" label="有效期开始时间" width="150px"></el-table-column>
      <el-table-column prop="validEnd" label="有效期结束时间" width="150px"></el-table-column>
      <el-table-column prop="groupDesc" label="工作组描述" width="150px"></el-table-column>
      <el-table-column prop="cityId" label="所属地市编号" width="150px"></el-table-column>
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
        <el-form-item label="工作组编号" prop="groupId" >
          <el-input v-model="editForm.groupId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="工作组名称" prop="groupName">
          <el-input v-model="editForm.groupName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="类型编号" prop="groupTypeId">
          <el-input v-model="editForm.groupTypeId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="节点编码" prop="groupCode">
          <el-input v-model="editForm.groupCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superGroupCode">
          <el-input v-model="editForm.superGroupCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效期开始时间" prop="validStart">
          <el-input v-model="editForm.validStart" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效期结束时间" prop="validEnd">
          <el-input v-model="editForm.validEnd" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="groupDesc">
          <el-input v-model="editForm.groupDesc" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属地市编号" prop="cityId">
          <el-input v-model="editForm.cityId" auto-complete="off"></el-input>
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
        <el-form-item label="工作组编号" prop="groupId">
          <el-input v-model="addForm.groupId" auto-complete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="工作组名称" prop="groupName">
          <el-input v-model="addForm.groupName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="类型编号" prop="groupTypeId">
          <el-input v-model="addForm.groupTypeId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="节点编码" prop="groupCode">
          <el-input v-model="addForm.groupCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="父节点编码" prop="superGroupCode">
          <el-input v-model="addForm.superGroupCode" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效期开始时间" prop="validStart">
          <el-input v-model="addForm.validStart" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效期结束时间" prop="validEnd">
          <el-input v-model="addForm.validEnd" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="groupDesc">
          <el-input v-model="addForm.groupDesc" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="所属地市编号" prop="cityId">
          <el-input v-model="addForm.cityId" auto-complete="off"></el-input>
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
  name: 'GroupManage',
  data () {
    return {
      groups: [],
      multipleSelections: [],
      search: {
        searchWord: ''
      },
      total: 0,
      page: 1,
      pageSize: 20,
      editFormVisible: false, // 编辑界面是否显示
      editFormRules: {
        groupName: [{ required: true, message: '请输入工作组名称', trigger: 'blur' }],
        groupTypeId: [{ required: true, message: '请输入工作组类型编号', trigger: 'blur' }],
        groupCode: [{ required: true, message: '请输入节点编号', trigger: 'blur' }],
        superGroupCode: [{ required: false, trigger: 'blur' }],
        validStart: [{ required: false, trigger: 'blur' }],
        validEnd: [{ required: false, trigger: 'blur' }],
        groupDesc: [{ required: false, trigger: 'blur' }],
        cityId: [{ required: false, trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        groupId: '',
        groupName: '',
        groupTypeId: '',
        groupCode: '',
        superGroupCode: '',
        validStart: '',
        validEnd: '',
        groupDesc: '',
        cityId: ''
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        groupName: [{ required: true, message: '请输入工作组名称', trigger: 'blur' }],
        groupTypeId: [{ required: true, message: '请输入工作组类型编号', trigger: 'blur' }],
        groupCode: [{ required: true, message: '请输入节点编号', trigger: 'blur' }],
        superGroupCode: [{ required: false, trigger: 'blur' }],
        validStart: [{ required: false, trigger: 'blur' }],
        validEnd: [{ required: false, trigger: 'blur' }],
        groupDesc: [{ required: false, trigger: 'blur' }],
        cityId: [{ required: false, trigger: 'blur' }]
      },
      // 新增界面数据
      addForm: {
        groupId: '',
        groupName: '',
        groupTypeId: '',
        groupCode: '',
        superGroupCode: '',
        validStart: '',
        validEnd: '',
        groupDesc: '',
        cityId: ''
      }
    }
  },
  methods: {
    // 更改当前页数 用于展示工作组
    handleCurrentChange (val) {
      this.page = val
      this.getGroups()
    },
    // 获取工作组并根据筛选条件进行展示
    getGroups: function () {
      this.axios({
        method: 'post',
        url: apiUrl.getGroups,
        data: {
          searchWord: this.search.searchWord,
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(res => {
        this.groups = res.data.data.groupInfoList
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
              url: apiUrl.addGroup,
              data: this.addForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '添加用户成功！'
                })
                this.$refs['addForm'].resetFields()
                this.addFormVisible = false
                this.getGroups()
              }
            })
          })
        }
      })
    },
    // 单个删除工作组
    handleDelete: function (row) {
      this.$confirm('确认删除该工作组信息吗?', '提示', {
        type: 'warning'
      }).then(() => {
        let ids = []
        ids.push(row.groupId)
        this.axios({
          method: 'post',
          url: apiUrl.deleteGroup,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除工作组成功！'
            })
            this.getGroups()
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
          ids.push(multipleSelection.groupId)
        })
        this.axios({
          method: 'post',
          url: apiUrl.deleteGroup,
          data: {
            ids: ids
          }
        }).then(res => {
          let result = res.data
          if (result.code === globalRespCode.SUCCESS) {
            this.$message({
              type: 'success',
              message: '删除工作组成功！'
            })
            this.getGroups()
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
              url: apiUrl.editGroup,
              data: this.editForm
            }).then(res => {
              let result = res.data
              if (result.code === globalRespCode.SUCCESS) {
                this.$message({
                  type: 'success',
                  message: '修改工作组成功！'
                })
                this.$refs['editForm'].resetFields()
                this.editFormVisible = false
                this.getGroups()
              }
            })
          })
        }
      })
    }
  },
  created () {
    this.getGroups()
  }
}
</script>

  <style scoped>
  </style>
