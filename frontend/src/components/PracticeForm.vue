<template>
    <div>
        <form>
            <label> {{ this.verb.firstForm }}</label>
            <input>
            <input>
        </form>
    </div>
</template>

<script>
    export default {
        props: {
            verb: {}
        }
    }
</script>

<style>
</style>