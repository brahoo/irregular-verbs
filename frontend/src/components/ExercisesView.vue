<template>
    <div id="exercises-view">
        <h1>Exercises</h1>
        <h4>Points: {{ exercise.points }}</h4>
        <practice-page 
                v-if = "!isAnswered" 
                :practice = "exercise.currentPractice" 
                @answered = "checkAnswer($event)"></practice-page>
        <practice-bar
                v-else 
                :isCorectAnswer = "isCorectAnswer"
                :verb = "exercise.currentPractice.subject"></practice-bar>
    </div>
</template>

<script>
    import axios from 'axios'
    import PracticeBar from './PracticeBar.vue'
    import PracticePage from './PracticePage.vue'
    
    export default {
        components: {
            PracticeBar,
            PracticePage
        },
        data() {
            return {
                exercise: {},
                isAnswered: false,
                isCorectAnswer: Boolean
            }
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
            },
            checkAnswer(answer) {
                axios.put('/api/exercises', answer)
                    .then(response => {
                        this.isCorectAnswer = response.data;
                        this.isAnswered = true;
                    })
                    .catch(error => {
                        console.log(error.response.status + " Nie udało się przesłać odpowiedzi!");
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