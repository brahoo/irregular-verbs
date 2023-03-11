<template>
    <div class="practice-bar">
        <div v-if = "isCorrectAnswer">Odpowiedź poprawna.</div>
        <div v-else>
            Odpowiedź niepoprawna.
            <br/>
            Odpowiedź poprawna to:
            <br/>
            <div class="correct-answer">
                {{ verb.firstForm }} {{ verb.secondForm }} {{ verb.thirdForm }}
            </div> 
            
        </div>
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

    .practice-bar {
        text-align: center;
        font-size: 20px;
    }

    .correct-answer {
        font-size: 30px;
        font-weight: 600;
        margin-top: 15px;
    }

    .practice-bar > button {
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

    .practice-bar > button:hover {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }

    .practice-bar > button:focus {
        outline: none;
        background-color: #FFC622;
        color: #222242;
    }

</style>