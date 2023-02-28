<template>
    <div id="app">
        <h1 id="app-title">IRREGULAR VERBS</h1>

        <router-link to = "/">Home</router-link> |
        <router-link to = "/verbs">Verbs</router-link> |
        <router-link to = "/exercises">Exercises</router-link>

        <router-view></router-view>
    </div>
</template>

<script>
    import {RouterView, RouterLink} from "vue-router"

    export default {
        components: {
            RouterView,
            RouterLink
        }
    }

</script>

<style>
    body {
        background-color: #000020;
        color: #EEA400;
        font-family: 'Lato', sans-serif;
    }

    #app {
        margin-left: auto;
        margin-right: auto;
        width: 1000px;
    }   

    #app-title {
        margin-bottom: 5px;
        font-size: 44px;
        font-weight: 900;
        letter-spacing: 4px;
        text-align: justify;
    }
</style>