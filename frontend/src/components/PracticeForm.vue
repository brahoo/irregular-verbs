<template>
    <div>
        <form class="practice-form" @submit.prevent="giveAnswer()">
            <label> {{ verb.firstForm }}</label>
            <input class="practice-input" type="text" v-model="answer.secondForm">
            <input class="practice-input" type="text" v-model="answer.thirdForm">
            <br/>
            <button>Sprawdź</button>
            <p v-if="error">Podaj obie formy</p>
        </form>
    </div>
</template>

<script>
    export default {
        props: {
            verb: {}
        },
        data() {
            return {
                answer: {secondForm: "", thirdForm: ""},
                error : false
            }
        },
        methods: {
            giveAnswer() {
                this.error = false;
                if (this.checkAnswerDataCorrectness()) {
                    this.$emit('answered', this.answer);
                    this.answer = {};
                }
                else{
                    this.error = true;
                }
            },
            checkAnswerDataCorrectness() {
                return ((this.answer.secondForm !== "") && (this.answer.thirdForm !== ""));
            }
        }
    }
</script>

<style>
    .practice-form {
        text-align: center;
        font-size: 30px;
    }

    .practice-input {
        color: #EEA400;
        background-color: #000020;
        font-size: 30px;
        width: 200px;
        padding: 1px;
        padding-left: 3px;
        border: 1px solid #EEA400;
        margin-left: 10px;
    } 

    .practice-input:focus {
        outline: none;
        border-color: #FFC622;
    }

    .practice-form > button {
        margin-left: auto;
        margin-right: auto;
        margin-top: 15px;
        margin-bottom: 5px;
        width: 110px;
        padding: 3px;
        background-color: #EEA400;
        color: #000020;
        text-align: center;
        font-size: 20px;
        font-weight: 500;
        letter-spacing: 1px;
        border: none;
    }

    .practice-form > button:hover {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }

    .practice-form > button:focus {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }
</style>