<template>
  <div>
    <form action="/faculty">
      <label for="name">name:</label><br>
      <input type="text" id="name" name="name" v-model="name" required ><br><br>
      <label for="surname">short_name:</label><br>
      <input type="text" id="surname" name="surname" v-model="shortName" required ><br><br>
      <input v-on:click="submitForm()" type="submit" value="Submit">
    </form>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "AddFaculty",
  data: () => ({
    name: '',
    shortName: '',
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/facilities/save', {
        name: this.name,
        shortName: this.shortName
      } )
    }
  }
}
</script>

<style scoped>

</style>