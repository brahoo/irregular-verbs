<template>
    <div>
        <p v-if = "isCorrectAnswer">Odpowiedź poprawna.</p>
        <p v-else>Odpowiedź niepoprawna. Odpowiedź poprawna to: 
                {{ verb.firstForm }} {{ verb.secondForm }} {{ verb.thirdForm }}</p>
        <button @click = "forward()">Dalej</button>
    </div>
</template>

<script>
    export default {
        props: {
            isCorrectAnswer: Boolean,
            verb: {}
        },
        methods: {
            forward() {
                this.$emit('forwarded');
            }
        }
    }
</script>

<style>
</style>