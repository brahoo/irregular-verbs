<template>
    <div id="exercises-view">
        <h1>Exercises</h1>
        <base-notification
            v-if="message"
            :message="message"
            :isError="isError"
        >
        </base-notification>
        <div class="points-bar">Points: {{ exercise.points }}</div>
        <div v-if = "!exercise.finished">
            <practice-form 
                v-if = "!isAnswered" 
                :verb = "verb"
                @answered = "checkAnswer($event)"
            >
            </practice-form>
            <practice-bar
                v-else
                :isCorrectAnswer = "isCorrectAnswer"
                :verb = "verb"
                @forwarded = "forward()"
            >
            </practice-bar>
        </div>
        <div class="ending-bar" v-else>
            <p>Ćwiczenie zakończone.</p>
            <button @click = "createExercise()">Nowe ćwiczenie</button>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import PracticeBar from '../components/PracticeBar.vue'
    import PracticeForm from '../components/PracticeForm.vue'
    import BaseNotification from '@/components/BaseNotification.vue'
    
    export default {
        components: {
            PracticeBar,
            PracticeForm,
            BaseNotification: BaseNotification
        },
        data() {
            return {
                exercise: {},
                practice: {},
                verb: {},
                isAnswered: false,
                isCorrectAnswer: Boolean,
                isError: false,
                message: ""
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
                        this.failure(error.response.status + " Nie udało się pobrać ćwiczenia!");
                    });
            },
            checkAnswer(answer) {
                axios.put('/api/exercises', answer)
                    .then(response => {
                        this.isCorrectAnswer = response.data;
                        this.isAnswered = true;
                    })
                    .catch(error => {
                        this.failure(error.response.status + " Nie udało się przesłać odpowiedzi!");
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
                        this.failure(error.response.status + " Nie udało się pobrać ćwiczenia!");
                    });
            },
            failure(message) {
                this.message = message;
                this.isError = true;
            }
        },
        mounted() {
            this.createExercise();
        }
    }
</script>

<style>
    .points-bar {
        text-align: right;
        font-size: 30px;
    }
    
    .ending-bar {
        text-align: center;
        font-size: 20px;
    }

    .ending-bar > button {
        margin-left: auto;
        margin-right: auto;
        margin-top: 15px;
        margin-bottom: 5px;
        width: auto;
        padding: 3px;
        background-color: #EEA400;
        color: #000020;
        text-align: center;
        font-size: 20px;
        font-weight: 500;
        letter-spacing: 1px;
        border: none;
    }

    .ending-bar > button:hover {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }

    .ending-bar > button:focus {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }
</style>