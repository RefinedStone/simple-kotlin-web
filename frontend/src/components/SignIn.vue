<template>
  <!--회원 등록 이후 성공 모달창-->
  <div v-if="showModal" class="modal">
    <div class="modal-content">
      <h2>{{ modalMessage }}</h2>
      <button @click="closeModal">닫기</button>
    </div>
  </div>

  <!-- 회원등록 form -->
  <div class="form-container">
    <h2 class="title">회원 등록</h2>
    <form @submit.prevent="register" class="register-form">
      <div class="input-group">
        <label>Email: </label>
        <input type="email" v-model="newUser.email" required/>
      </div>

      <div class="input-group">
        <label>Nickname: </label>
        <input type="text" v-model="newUser.nickname" required/>
      </div>

      <div class="input-group">
        <label>Team: </label>
        <select v-model="newUser.team">
          <option value="">팀 선택</option>
          <option value="CS">Counter Strike</option>
          <option value="SA">Sudden Attack</option>
        </select>
      </div>

      <button type="submit">회원 등록</button>
    </form>
  </div>
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
.form-container {
  width: 80%;
  margin: 0 auto;
  text-align: center;
}

.title {
  margin-top: 20px;
  font-size: 2.5rem;
  color: #333;
}

.register-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}

.input-group {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

label {
  font-size: 1.2rem;
  color: #666;
}

input, select {
  margin-top: 10px;
  padding: 10px;
  font-size: 1rem;
  width: 100%;
  max-width: 300px;
}

button {
  display: inline-block;
  margin-top: 40px;
  padding: 10px 20px;
  font-size: 1.5rem;
  color: #fff;
  background-color: #333;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #666;
}

.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  background-color: rgba(0,0,0,0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  width: 80%;
  max-width: 500px;
  text-align: center;
}

.modal-content h2 {
  margin-bottom: 20px;
}

.modal-content button {
  background-color: #333;
  color: #fff;
  border: none;
  cursor: pointer;
  padding: 10px;
}

.modal-content button:hover {
  background-color: #666;
}
</style>