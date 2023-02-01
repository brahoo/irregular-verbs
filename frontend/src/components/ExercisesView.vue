<template>
    <div id="exercises-view">
        <h1>Exercises</h1>
        <h4>Points: {{ exercise.points }}</h4>
        <practice-page :practice = "this.exercise.currentPractice"></practice-page>
    </div>
</template>

<script>
    import axios from 'axios'
    import PracticePage from './PracticePage.vue'
    
    export default {
        components: {
            PracticePage
        },
        data() {
            return {
                exercise: {}
            };
        },
        methods: {
            createExercise() {
                axios.get('/api/exercises/new')
                    .then(response => {
                       this.exercise = response.data;
                    })
                    .catch(error => {
                        console.log(error.response.status + " Nie udało się pobrać ćwiczenia!");
                    });
            }
        },
        mounted() {
            this.createExercise();
        }
    }
</script>

<style>
</style>