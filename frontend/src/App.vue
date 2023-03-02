<template>
    <div id="app">
        <base-header></base-header>
        <router-view></router-view>
    </div>
</template>

<script>
    import {RouterView} from "vue-router"
    import BaseHeader from "./components/BaseHeader.vue"

    export default {
        components: {
            RouterView,
            BaseHeader
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
</style>