<template>
  <el-main>
    <el-row class="login-panel">
      <el-col :span="8" :offset="8">
        <el-card class="box-card">
          <div slot="header">
            <span>员工登录</span>
          </div>
          <el-form :model="loginForm" label-width="100px" label-position="left">
            <el-form-item label="账号" prop="account">
              <el-input v-model="loginForm.staffAccount" placeholder="请输入手机号"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input placeholder="请输入密码" v-model="loginForm.password" type="password"></el-input>
            </el-form-item>
          </el-form>
          <el-row type="flex" justify="center">
            <el-col :span="5">
              <el-button class="login-button" type="primary" @click="login">立即登录</el-button>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import apiUrl from '../constant/apiUrl'
import { globalRespCode, staffRespCode } from '../constant/respCode'

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        staffAccount: '',
        password: ''
      }
    }
  },
  methods: {
    login () {
      let requestData = {
        staffAccount: this.loginForm.staffAccount,
        password: this.loginForm.password
      }
      this.axios.post(apiUrl.login, requestData).then(res => {
        let result = res.data
        console.log(result)
        switch (result.code) {
          case globalRespCode.SUCCESS:
            this.$message({
              type: 'success',
              message: '登陆成功！'
            })
            this.axios.post(apiUrl.getRolesByStaffAccount, requestData).then(res2 => {
              const result2 = res2.data
              if (result2.code === globalRespCode.SUCCESS) {
                const authList = []
                if (result2.data.roles) {
                  result2.data.roles.forEach(role => {
                    role.authList.forEach(auth => {
                      authList.push(auth.authName)
                    })
                  })
                }
                this.$store
                  .dispatch('loginAction', {
                    staffInfo: result.data.staffInfo,
                    roles: authList
                  }).then(() => {
                    this.$router.push({
                      name: 'Index'
                    })
                  })
              }
            })
            break
          case staffRespCode.STAFF_NOT_FOUND:
            this.$message({
              type: 'error',
              message: '员工不存在！'
            })
            break
          case staffRespCode.INVALID_PASSWORD:
            this.$message({
              type: 'error',
              message: '密码错误！'
            })
            break
          case staffRespCode.EXPIRED_PASSWORD:
            this.$message({
              type: 'error',
              message: '密码已过期！'
            })
            break
        }
      })
    }
  },
  created () {
    // 若已经登录，则跳转
    if (this.$store.getters.hasLogin) {
      this.$router.push({
        name: 'Index'
      })
    }
  }
}
</script>

<style scoped>
.login-button {
  margin: 25px 0;
}
.login-panel {
  margin-top: 20vh;
}
</style>
