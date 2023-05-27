<!-- Home.vue -->
<template>
  <div class="container">
    <h1 class="title">반응속도 측정 테스트</h1>
    <p class="description">
      이 테스트는 사용자의 반응 속도를 측정하는 테스트입니다. 화면이 초록색에서 빨간색으로 변하면 가능한 빨리 클릭하여 반응 시간을 측정합니다.
      사용자는 시작을 위해 파란 화면을 클릭해야 하며, 너무 일찍 클릭하면 실패로 간주됩니다.
      성공적으로 반응 시간을 측정한 후에는 빨간색 화면이 보여지고, 반응 시간이 표시됩니다.
      빨간색 화면이나 검은색 화면을 클릭하면 테스트를 다시 시작할 수 있습니다.
    </p>
    <router-link class="start-button" to="/Reaction">테스트 시작</router-link>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Home'
}
</script>

<style scoped>
.container {
  width: 80%;
  margin: 0 auto;
  text-align: center;
}

.title {
  margin-top: 20px;
  font-size: 2.5rem;
  color: #333;
}

.description {
  margin-top: 20px;
  font-size: 1.2rem;
  color: #666;
  line-height: 1.6;
}

.start-button {
  display: inline-block;
  margin-top: 40px;
  padding: 10px 20px;
  font-size: 1.5rem;
  color: #fff;
  background-color: #333;
  border-radius: 5px;
  text-decoration: none;
}

.start-button:hover {
  background-color: #666;
}
</style>
