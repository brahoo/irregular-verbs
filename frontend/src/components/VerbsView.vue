<template>
    <div id="verbs-view">
        <h1>Irregular Verbs List</h1>
        <verbs-list :verbs = "verbs"></verbs-list>
    </div>
</template>

<script>
    import VerbsList from './VerbsList.vue'

    export default {
        components: {
            VerbsList
        },
        data() {
            return {
                verbs: []
            };
        },
        methods: {
            getVerbs() {
                this.$http.get('verbs')
                    .then(response => {
                        this.verbs = response.body;
                    })
                    .catch(response => {
                        console.log("Nie udało się pobrać czasowników!" + response.status);
                    });
            }
        },
        mounted() {
            this.getVerbs();
        }
    }
</script>

<style>
</style>