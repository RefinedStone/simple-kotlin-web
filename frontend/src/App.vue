<template>

  <div id="app">
    <!--상단메뉴-->
    <div class="menu">
      <router-link v-for="i in 메뉴들" :key="i" :to="i.path">
        {{ i.name }}
      </router-link>
    </div>
    <!-- 라우터 뷰 -->
    <router-view/>
  </div>


</template>
<script>
export default {
  name: 'App',
  data() {
    return {
      스타일: "color:blue",
      메뉴들: [
        {name: 'Home', path: '/'},
        {name: 'Reaction Test', path: '/Reaction'},
        {name: 'Ranking', path: '/Ranking'},
        {name: 'Sign in', path: '/SignIn'}],

    }
  },
  methods: {
    closeModal() {
      this.showModal = false;
    },
  },


  components: {}
  ,
}
</script>

<style>
body {
  margin: 0;
}

div {
  box-sizing: border-box;
}


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;

}

.modal {
  /* 모달창 디자인 */
  position: fixed;
  z-index: 9999;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4);
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal h2 {
  background: white;
  padding: 20px;
  border-radius: 5px;
}
</style>
