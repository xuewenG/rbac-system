<template>
  <el-container class="container">
    <el-aside width="250px" class="aside">
      <LeftNavBar></LeftNavBar>
    </el-aside>
    <el-container>
      <el-header class="header">
        <HeaderBar></HeaderBar>
      </el-header>
      <router-view/>
    </el-container>
  </el-container>
</template>

<script>
import LeftNavBar from '../components/LeftNavBar'
import HeaderBar from '../components/HeaderBar'
export default {
  name: 'Manage',
  components: {HeaderBar, LeftNavBar}
}
</script>

<style scoped>
  .container {
    height: 100%;
  }

  .header {
    border-bottom: #e0e0e0 solid 1px;
  }

  .aside {
    background-color: #172850;
  }
</style>
