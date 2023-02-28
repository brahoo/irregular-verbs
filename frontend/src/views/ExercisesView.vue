<template>
    <div id="exercises-view">
        <h1>Exercises</h1>
        <h4>Points: {{ exercise.points }}</h4>
        <div v-if = "!exercise.finished">
            <practice-page 
                    v-if = "!isAnswered" 
                    :verb = "verb"
                    @answered = "checkAnswer($event)"></practice-page>
            <practice-bar
                    v-else
                    :isCorrectAnswer = "isCorrectAnswer"
                    :verb = "verb"
                    @forwarded = "forward()"></practice-bar>
        </div>
        <div v-else>
            <p>Ćwiczenie zakończone.</p>
            <button @click = "createExercise()">Nowe ćwiczenie</button>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import PracticeBar from '../components/PracticeBar.vue'
    import PracticePage from '../components/PracticePage.vue'
    
    export default {
        components: {
            PracticeBar,
            PracticePage
        },
        data() {
            return {
                exercise: {},
                practice: {},
                verb: {},
                isAnswered: false,
                isCorrectAnswer: Boolean
            }
        },
        methods: {
            createExercise() {
                axios.get('/api/exercises/new')
                    .then(response => {
                        this.exercise = response.data;
                        this.practice = this.exercise.currentPractice;
                        this.verb = this.practice.subject;
                    })
                    .catch(error => {
                        console.log(error.response.status + " Nie udało się pobrać ćwiczenia!");
                    });
            },
            checkAnswer(answer) {
                axios.put('/api/exercises', answer)
                    .then(response => {
                        this.isCorrectAnswer = response.data;
                        this.isAnswered = true;
                    })
                    .catch(error => {
                        console.log(error.response.status + " Nie udało się przesłać odpowiedzi!");
                    });
            },
            forward() {
                axios.get('/api/exercises')
                    .then(response => {
                        this.exercise = response.data;
                        this.practice = this.exercise.currentPractice;
                        this.verb = this.practice.subject;
                        this.isAnswered = false;
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