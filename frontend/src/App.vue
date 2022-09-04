<template>
    <div id="app">
        <h1>Irregular Verbs</h1>
        <verbs-list :verbs = "verbs"></verbs-list>
    </div>
</template>

<script>
    import VerbsList from './components/VerbsList.vue'

    export default {
        components: {
            VerbsList
        },
        data() {
            return {
                verbs: []
            };
        }
    }
</script>

<style>
</style>