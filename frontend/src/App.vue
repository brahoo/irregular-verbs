<template>
    <div id="app">
        <h1 id="app-title">IRREGULAR VERBS</h1>
        <a @click="currentView = ''">Main Page</a>|
        <a @click="currentView = 'verbs'">Verbs</a>|
        <a @click="currentView = 'exercises'">Exercises</a>
        <div v-if="currentView == 'verbs'">
            <verbs-view></verbs-view>            
        </div>
        <div v-if="currentView == 'exercises'">
            <exercises-view></exercises-view>
        </div>
        <div v-else></div>
    </div>
</template>

<script>
    import VerbsView from "./components/VerbsView";
    import ExercisesView from "./components/ExercisesView";

    export default {
        components: {VerbsView, ExercisesView},
        data() {
            return {
                currentView: ""
            };
        }
    };
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