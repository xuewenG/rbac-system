<template>
  <div class="container">
    <div class="user-area">
      <span class="user-name">管理员ID：{{ staffInfo.staffName }}</span>
      <el-divider direction="vertical"></el-divider>
      <el-tooltip class="item" effect="dark" content="退出登录" placement="bottom">
        <img src="../assets/logout.png" height="22px" width="22px" class="logout-button" @click="logout"/>
      </el-tooltip>
      <el-button @click="logout" type="text" size="large">退出登录</el-button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'HeaderBar',
  methods: {
    logout () {
      this.$store.dispatch('logoutAction').then(() => {
        this.$router.push({
          name: 'Login'
        })
      })
    }
  },
  computed: {
    ...mapGetters(['staffInfo'])
  }
}
</script>

<style scoped>
  .container {
      display: flex;
  }
  .user-area {
      margin-left: auto;
      margin-right: 30px;
      display: flex;
      color: #409EFF;
      justify-content: center;
      align-items: center;
  }
  .logout-button {
      cursor: pointer;
  }
</style>
