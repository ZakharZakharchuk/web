<template>
<div>
  <form action="/disciplines">
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" v-model="name" required ><br><br>
    <input v-on:click="submitForm()" type="submit" value="Submit">
  </form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "AddDiscipline",
  data: () => ({
    name: ''
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/disciplines/save', {
        name: this.name,
      } )
    }
  }
}
</script>

<style scoped>

</style>