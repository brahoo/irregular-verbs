<template>
    <div>
        <practice-form :verb = "this.practice.subject" @answered = "giveAnswer($event)"></practice-form>
    </div>
</template>

<script>
    import PracticeForm from "./PracticeForm.vue"
    
    export default {
        components: {
            PracticeForm
        },
        props: {
            practice: {}
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