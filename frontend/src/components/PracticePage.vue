<template>
    <div>
        <practice-form :verb = "this.practice.subject"></practice-form>
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
        }
    }
</script>

<style>
</style>