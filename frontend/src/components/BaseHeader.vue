<template>
    <div>
        <router-link to = "/" id="app-title">IRREGULAR VERBS</router-link><br/>
        <div class="line"></div>
        <router-link to = "/">Home</router-link> |
        <router-link to = "/verbs">Verbs</router-link> |
        <router-link to = "/exercises">Exercises</router-link>
    </div>
</template>

<script>
    import {RouterLink} from "vue-router"

    export default {
        components: {
            RouterLink
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