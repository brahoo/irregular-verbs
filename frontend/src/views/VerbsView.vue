<template>
    <div id="verbs-view">
        <h1>Irregular Verbs List</h1>
        <base-notification
            v-if="message"
            :message="message"
            :isError="isError"
        >
        </base-notification>
        <verbs-list :verbs = "verbs"></verbs-list>
    </div>
</template>

<script>
    import axios from 'axios'
    import VerbsList from '../components/VerbsList.vue'
    import BaseNotification from '@/components/BaseNotification.vue'

    export default {
        components: {
            VerbsList,
            BaseNotification
        },
        data() {
            return {
                verbs: [],
                isError: false,
                message: ""
            };
        },
        methods: {
            getVerbs() {
                axios.get('/api/verbs')
                    .then(response => {
                        this.verbs = response.data;
                    })
                    .catch(error => {
                        this.failure(error.response.status + " Nie udało się pobrać czasowników!");
                    });
            },
            failure(message) {
                this.message = message;
                this.isError = true;
            }
        },
        mounted() {
            this.getVerbs();
        }
    }
</script>

<style>
</style>