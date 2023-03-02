<template>
    <div>
        <router-link to="/" id="app-title">IRREGULAR VERBS</router-link><br/>
        <div class="line"></div>
        <base-nav></base-nav>
    </div>
</template>

<script>
    import {RouterLink} from "vue-router"
    import BaseNav from "./BaseNav.vue"

    export default {
        components: {
            RouterLink,
            BaseNav
        }
    }
</script>

<style>
    #app-title {
        margin-bottom: 5px;
        font-size: 44px;
        font-weight: 900;
        letter-spacing: 4px;
        text-align: justify;
    }

    a:link {
        color: #EEA400;
        text-decoration: none;
    }

    a:visited{
        color: #EEA400;
    }

    .line {
        margin-top: 5px;
        margin-bottom: 10px;
        height: 3px;
        border-bottom: 2px solid #EEA400; 
    }
</style>