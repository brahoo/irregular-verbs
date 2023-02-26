<template>
    <div>
        <form @submit.prevent="giveAnswer()">
            <label> {{ verb.firstForm }}</label>
            <input type="text" v-model="answer.secondForm">
            <input type="text" v-model="answer.thirdForm">
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
</style>