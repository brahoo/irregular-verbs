<template>
    <div>
        <table>
            <thead>
            <tr>
                <th>Base Form</th>
                <th>Past Simple</th>
                <th>Past Participle</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="verb in verbs" :key="verb.firstForm">
                <td>{{verb.firstForm}}</td>
                <td>{{verb.secondForm}}</td>
                <td>{{verb.thirdForm}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
       props: {
            verbs: [],
        }
    }
</script>

<style>
</style>