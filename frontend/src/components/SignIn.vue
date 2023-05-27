<template>
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
import axios from "axios";

export default {
  name: "SignIn",
  data() {
    return {
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
  }
}
</script>

<style scoped>

</style>