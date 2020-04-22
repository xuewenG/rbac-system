<template>
  <div class="container">
    <div class="logo-area">
      <div class="image-area">
        <img src="../assets/logo.png" height="50px" width="50px"/>
      </div>
      <div class="word-area">
        <span class="logo-word">RBAC系统</span>
      </div>
    </div>
    <el-menu
      class="nav-bar"
      background-color="#172850"
      text-color="#fff"
      active-text-color="#55A8FD"
      :unique-opened="true"
      :router="true">
      <NavMenu :menuList="menuList"></NavMenu>
    </el-menu>
  </div>
</template>

<script>
import NavMenu from './NavMenu'
import apiUrl from '../constant/apiUrl'
import {globalRespCode} from '../constant/respCode'

export default {
  name: 'LeftNavBar',
  components: {NavMenu},
  data () {
    return {
      menuList: []
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
    }
  },
  created () {
    this.getMenu()
  }
}
</script>

<style scoped>
    .logo-area {
        text-align: center;
        display: flex;
    }
    .image-area {
        margin-left: 30px;
        padding: 25px 0;
    }
    .word-area {
        color: white;
        font-size: 30px;
        margin-left: 10px;
        padding: 30px 0;
    }
</style>
