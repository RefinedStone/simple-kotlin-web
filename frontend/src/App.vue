<template>


  <!--  상단메뉴 -->
  <div class="menu">
    <a v-for="i in 메뉴들" :key="i">
      {{ i }}
    </a>
  </div>
  <!--회원 등록 이후 성공 모달창-->
  <div v-if="showModal" class="modal">
    <h2>{{ modalMessage }}</h2>
    <button @click="closeModal">Close</button>
  </div>
  <!--  -->
  <!-- 회원등록 form -->
  <div>
    <h2>회원 등록</h2>
    <form @submit.prevent="register">
      <label>Email: </label>
      <input type="email" v-model="newUser.email" required/>

      <label>Nickname: </label>
      <input type="text" v-model="newUser.nickname" required/>

      <label>Team: </label>
      <select v-model="newUser.team">
        <option value="">팀 선택</option>
        <option value="CS">Counter Strike</option>
        <option value="SA">Sudden Attack</option>
      </select>

      <button type="submit">회원 등록</button>
    </form>
  </div>
  <!-- ... -->


</template>
<script>
//axios 통신 import
import axios from 'axios';


export default {
  name: 'App',
  data() {
    return {
      모달창열렸니: false,
      price1: 60,
      price2: 80,
      price3: 100,
      스타일: "color:blue",
      메뉴들: ["Home", "Reaction Test", "Ranking"],

      //회원등록
      newUser: {
        email: '',
        nickname: '',
        team: ''
      },
      //회원등록모달창
      showModal: false,
      modalMessage: '',
    }
  },
  methods: {
    increase() {
      this.신고수 += 1;
    },
    //회원등록
    async register() {
      try {
        const response = await axios.post('http://localhost:8080/accounts', this.newUser);
        console.log(response.data);
        if (response.data === true) {
          this.modalMessage = '등록에 성공하였습니다.';
        } else {
          this.modalMessage = '등록에 실패하였습니다.';
        }
        this.showModal = true;
      } catch (error) {
        console.error(error);
        this.modalMessage = '등록에 실패하였습니다.';
        this.showModal = true;
      }
    },
    closeModal() {
      this.showModal = false;
    },
  },


components: {
}
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
