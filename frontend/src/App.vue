<template>
    <div id="app">
        <h1>Irregular Verbs - Main Page</h1>
        <a @click="currentView = ''">Main Page</a>
        | 
        <a @click="currentView = 'verbs'">Verbs</a>
        <div v-if="currentView == 'verbs'">
            <verbs-view></verbs-view>            
        </div>
        <div v-else></div>
    </div>
</template>

<script>
    import VerbsView from "./components/VerbsView";

    export default {
        components: {VerbsView},
        data() {
            return {
                currentView: ""
            };
        }
    };
</script>

<style>
</style>