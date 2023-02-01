<template>
    <div id="app">
        <h1>Irregular Verbs - Main Page</h1>
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
</style>