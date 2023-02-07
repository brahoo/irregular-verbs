<template>
    <div>
        <form @submit.prevent="giveAnswer()">
            <label> {{ verb.firstForm }}</label>
            <input type="text" v-model="answer.secondForm">
            <input type="text" v-model="answer.thirdForm">
            <button>Sprawdź</button>
            <span v-if="error">Podaj obie formy</span>
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
                answer: {secondForm: "", thirdForm: ""}
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
                    console.log("Oba pola odpowiedzi muszą być wypełnione!")
                }
            },
            checkAnswerDataCorrectness() {
                return ((this.answer.secondForm !== "") && (this.answer.thirdForm !== ""));
            }
        }
    }
</script>

<style>
</style>