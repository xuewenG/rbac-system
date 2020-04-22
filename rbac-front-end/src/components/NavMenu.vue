<template>
  <div>
    <el-submenu  v-for="item in menuList"
                 v-if="item.children && item.children.length !== 0"
                 :key="item.nodeData.menuUrl"
                 :index="item.nodeData.menuUrl"
                 v-has-any-role="[item.nodeData.auth.authName]">
      <template slot="title">
        <i  class="el-icon-location"></i>
        <span>{{ item.nodeData.menuName }}</span>
      </template>
      <NavMenu :menuList="item.children"></NavMenu>
    </el-submenu>

    <el-menu-item  v-for="item in menuList"
                   :key="item.nodeData.menuUrl"
                   v-if="!item.children || item.children.length === 0"
                   :index="item.nodeData.menuUrl"
                   v-has-any-role="[item.nodeData.auth.authName]">
      <i  class="el-icon-location"></i>
      <span>{{ item.nodeData.menuName }}</span></el-menu-item>
  </div>
</template>

<script>
export default {
  name: 'NavMenu',
  props: ['menuList']
}
</script>
<style>
.el-menu--collapse .el-menu-item span {
  height: 0;
  width: 0;
  overflow: hidden;
  visibility: hidden;
  display: inline-block;
}
.el-menu--collapse .el-submenu .el-submenu__title span {
  height: 0;
  width: 0;
  overflow: hidden;
  visibility: hidden;
  display: inline-block;
}
</style>
