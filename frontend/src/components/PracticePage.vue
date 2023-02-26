<template>
    <div>
        <practice-form :verb = "verb" @answered = "giveAnswer($event)"></practice-form>
    </div>
</template>

<script>
    import PracticeForm from "./PracticeForm.vue"
    
    export default {
        components: {
            PracticeForm
        },
        props: {
            verb: {}
        },
        methods: {
            giveAnswer(answer) {
                this.$emit('answered', answer);
            }
        }
    }
</script>

<style>
</style>