<template>
    <div id="verbs-view">
        <h1>Irregular Verbs List</h1>
        <verbs-list :verbs = "verbs"></verbs-list>
    </div>
</template>

<script>
    import axios from 'axios'
    import VerbsList from '../components/VerbsList.vue'

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
                axios.get('/api/verbs')
                    .then(response => {
                        this.verbs = response.data;
                    })
                    .catch(error => {
                        console.log(error.response.status + " Nie udało się pobrać czasowników!");
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