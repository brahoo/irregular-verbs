<template>
    <div class="nav">
        <li
            v-for="navItem in navItems"
            :key=navItem.title
            class="nav-item"
            @click="router.push(`${navItem.route}`)"
        >
            {{ navItem.title }}
        </li>
    </div>
</template>

<script>
    import {useRouter} from "vue-router"

    export default {
        data() {
            return{
                router: useRouter(),
                navItems: [
                    {
                        title: "Home",
                        route:  "/"
                    },
                    {
                        title: "Verbs",
                        route:  "/verbs"
                    },
                    {
                        title: "Exercises",
                        route:  "/exercises"
                    }
                ]
            }
        }
    }
</script>

<style>
    .nav {
        list-style-type: none;
    }
    
    .nav-item {
        display: inline-block;
        padding-left: 5px;
        padding-right: 5px;
        border-left: 1px solid #EEA400;
    }

    .nav-item:first-child {
        padding-left: 0;
        border-left: none;
    }
</style>