<template>
  <div>
    <template v-if="!isStarted">
      <div class="blue-screen" @click="startTest">
        <h2 class="centered-text">Click to Start</h2>
      </div>
    </template>
    <template v-else-if="loseClicked">
      <div class="black-screen" @click="resetTest">
        <h2 class="centered-text">You Lose</h2>
        <p class="centered-text smaller-text">너무 일찍 클릭했습니다</p>
        <p class="centered-text smaller-text">다시 시작하려면 클릭하세요</p>
      </div>
    </template>
    <template v-else-if="isGreen">
      <div class="green-screen" @click="handleClick">
        <h2 class="centered-text">Ready</h2>
      </div>
    </template>
    <template v-else>
      <div class="red-screen" @click="handleClick">
        <h2 class="centered-text" v-if="!showResult">Click Click !!</h2>
        <p class="centered-text larger-text" v-if="showResult && reactionTime !== 'You lose'">Your reaction time: {{ reactionTime.toFixed(2) }} ms</p>
        <p class="centered-text smaller-text" v-if="showResult">다시 시작하려면 클릭하세요</p>
      </div>
    </template>
  </div>
</template>

<script>
export default {
  name: "ReactionTest",
  data() {
    return {
      isStarted: false,
      isGreen: false,
      showResult: false,
      startTime: null,
      reactionTime: null,
      loseClicked: false
    };
  },
  methods: {
    startTest() {
      this.isStarted = true;
      this.isGreen = true;

      setTimeout(() => {
        if (!this.loseClicked) {
          this.isGreen = false;

          // 빨간색으로 변경 및 랜더링이 다 이루어지고 나서 시간을 측정합니다.
          requestAnimationFrame(() => {
            requestAnimationFrame(() => {
              this.startTime = performance.now();
            });
          });
        }
      }, Math.floor(Math.random() * 15000));
    },

    resetTest() {
      this.isStarted = false;
      this.isGreen = false;
      this.showResult = false;
      this.startTime = null;
      this.reactionTime = null;
      this.loseClicked = false;
    },

    handleClick() {
      if (this.isGreen && !this.showResult) {
        this.loseClicked = true;
        this.showResult = true;
        this.reactionTime = "You lose";
      } else if (!this.isGreen && !this.showResult) {
        const currentTime = performance.now();
        this.reactionTime = currentTime - this.startTime;
        this.showResult = true;
      } else if(this.showResult) {
        this.resetTest();
      }
    }
  }
};
</script>

<style scoped>
.blue-screen {
  background-color: blue;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  flex-direction: column;
}

.green-screen {
  background-color: green;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  flex-direction: column;
}

.red-screen {
  background-color: red;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  flex-direction: column;
}

.black-screen {
  background-color: black;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
  flex-direction: column;
}

.centered-text {
  font-size: 100pt;
  color: white;
  text-align: center;
}

.larger-text {
  font-size: 50pt;
  color: white;
  text-align: center;
}

.smaller-text {
  font-size: 30pt;
  color: white;
  text-align: center;
}
</style>
