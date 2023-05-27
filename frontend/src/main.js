import { createApp } from 'vue'
import App from './App.vue'
//router(페이지이동)을 추가합니다
import router from './router'

createApp(App).use(router).mount('#app')


