// index.js
import { createRouter, createWebHistory } from 'vue-router'
import SignIn from '@/components/SignIn.vue'

// import App from "@/App";
import Home from "@/components/Home";
import Ranking from "@/components/Ranking";
import Reaction from "@/components/Reaction";

const routes = [
    {
        path: '/SignIn',
        name: 'SignIn',
        component: SignIn,
    },
    {
        path:'/Home',
        name: 'Home',
        component: Home,
    },
    {
        path:'/Ranking',
        name: 'Ranking',
        component: Ranking,
    },
    {
        path:'/Reaction',
        name: 'Reaction',
        component: Reaction,
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
