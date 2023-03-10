<template>
    <div :class="`alert ` + (isError ? `alert-error` : ``)">
        {{ message }}
    </div>
</template>

<script>
    export default {
        props: {
            message: String,
            isError: Boolean
        }
    }
</script>

<style>
    .alert {
        padding: 1px;
        padding-left: 2px;
        border: 1px solid #EEA400; 
    }

    .alert-error {
        color: red;
        border-color: red;
    }
</style>