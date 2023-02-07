<template>
    <div>
        <p v-if = "isCorectAnswer">Odpowiedź poprawna.</p>
        <p v-else>Odpowiedź niepoprawna. Odpowiedź poprawna to: 
                {{ verb.firstForm }} {{ verb.secondForm }} {{ verb.thirdForm }}</p>
    </div>
</template>

<script>
    export default {
        props: {
            isCorectAnswer: Boolean,
            verb: {}
        }
    }
</script>

<style>
</style>