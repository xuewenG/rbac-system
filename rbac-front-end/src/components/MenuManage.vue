<template>
  <el-main>
<!--    添加菜单-->
    <el-button type="primary" @click="addMenuDialog(0)">添加菜单</el-button>
    <el-table
      :data="menuList"
      :tree-props="{children: 'children'}"
      row-key="nodeId">
      <el-table-column prop="nodeData.menuId" label="菜单编号"></el-table-column>
      <el-table-column prop="nodeData.menuName" label="菜单名称"></el-table-column>
      <el-table-column prop="nodeData.menuDescription" label="菜单描述"></el-table-column>
      <el-table-column prop="nodeData.menuUrl" label="菜单地址"></el-table-column>
      <el-table-column prop="nodeData.authId" label="菜单权限"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button size="mini" @click="addMenuDialog(scope.row.nodeData.menuId)">添加子菜单</el-button>
          <el-button size="mini" type="danger" @click="deleteMenu(scope.row.nodeData.menuId)">删除菜单</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--    新增-->
    <el-dialog
      title="新增"
      :visible.sync="addMenuDialogVisible"
      :close-on-click-modal="false">
      <el-form
        :model="addMenuForm"
        label-width="120px"
        :rules="addMenuFormRules"
        ref="addMenuFormRef">
        <el-form-item prop="menuName" label="菜单名">
          <el-input v-model="addMenuForm.menuName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="menuDescription" label="描述信息">
          <el-input v-model="addMenuForm.menuDescription" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="menuUrl" label="菜单地址">
          <el-input v-model="addMenuForm.menuUrl" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="moduleId" label="组件">
          <el-input v-model="addMenuForm.moduleId" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="authList" label="权限">
          <el-select v-model="addMenuForm.authId" filterable
                     placeholder="请输入关键词"
                     remote
                     :remote-method="getAuth">
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
        <el-button @click="addMenuDialogVisible=false">取消</el-button>
        <el-button type="primary" @click="addMenu">提交</el-button>
      </div>
    </el-dialog>
  </el-main>
</template>

<script>
import apiUrl from '../constant/apiUrl'
import {globalRespCode} from '../constant/respCode'

export default {
  name: 'MenuManage',
  data () {
    return {
      menuList: [],
      authList: [],
      addMenuDialogVisible: false,
      addMenuForm: {},
      addMenuFormRules: {
        menuName: { required: true, message: '请输入菜单名称', trigger: 'blur' },
        menuUrl: { required: true, message: '请输入菜单地址', trigger: 'blur' },
        moduleId: { required: true, message: '请输入组件名称', trigger: 'blur' },
        authId: { required: true, message: '请选择权限', trigger: 'blur' }
      }
    }
  },
  methods: {
    getMenu () {
      this.axios.post(apiUrl.getMenu).then(res => {
        const result = res.data
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.menuList = result.data.menuList.children
            break
          default:
            this.$message({type: 'error', message: '获取菜单失败！'})
        }
      }).catch(e => {
        this.$message({type: 'error', message: '网络错误！'})
      })
    },
    addMenuDialog (parentId) {
      this.getAuth('')
      this.addMenuDialogVisible = true
      this.addMenuForm = {
        menuName: '',
        menuDescription: '',
        menuUrl: '',
        moduleId: '',
        parentId: parentId,
        authId: ''
      }
    },
    addMenu () {
      this.$refs.addMenuFormRef.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            this.axios.post(apiUrl.addMenu, {
              menuName: this.addMenuForm.menuName,
              menuDescription: this.addMenuForm.menuDescription,
              menuUrl: this.addMenuForm.menuUrl,
              moduleId: this.addMenuForm.moduleId,
              parentId: this.addMenuForm.parentId,
              authId: this.addMenuForm.authId
            }).then(res => {
              const result = res.data
              switch (result.code) {
                case globalRespCode.SUCCESS:
                  this.$message({type: 'success', message: '添加成功！'})
                  this.getMenu()
                  this.addMenuDialogVisible = false
                  break
                default:
                  this.$message({type: 'error', message: '添加失败！'})
              }
            }).catch(e => {
              this.$message({type: 'error', message: '网络错误！'})
            })
          })
        }
      })
    },
    deleteMenu (menuId) {
      this.$confirm('确认删除此菜单及其子菜单？', '确定').then(() => {
        this.axios.post(apiUrl.deleteMenu, {
          menuId: menuId
        }).then(res => {
          const result = res.data
          switch (result.code) {
            case globalRespCode.SUCCESS:
              this.$message({type: 'success', message: '删除成功！'})
              this.getMenu()
              break
            default:
              this.$message({type: 'error', message: '删除失败！'})
          }
        }).catch(e => {
          this.$message({type: 'error', message: '网络错误！'})
        })
      })
    },
    getAuth (authName) {
      this.axios.post(apiUrl.getAuth, {
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
    }
  },
  created () {
    this.getMenu()
  }
}
</script>

<style scoped>

</style>
