<template>
  <div id="app">
    <router-view id="main-router"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    height: 100vh;
  }
  * {
    margin: 0;
    padding: 0;
  }
  #main-router {
    height: 100vh;
  }
</style>
