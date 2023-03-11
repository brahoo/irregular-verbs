import {createRouter, createWebHistory} from "vue-router"
import HomeView from "../views/HomeView.vue"
import VerbsView from "../views/VerbsView.vue"
import ExercisesView from "../views/ExercisesView.vue"

const router = createRouter({
    // history: createWebHistory(import.meta.env.BASE_URL),
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            name: "home",
            component: HomeView
        },
        {
            path: "/verbs",
            name: "verbs",
            component: VerbsView
        },
        {
            path: "/exercises",
            name: "exercises",
            component: ExercisesView
        }
    ]
})

export default router