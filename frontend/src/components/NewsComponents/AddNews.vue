<template>
  <div>
    <form action="/news">
      <label for="message">message:</label><br>
      <input type="text" id="message" name="message" v-model="message" required ><br><br>
      <input v-on:click="submitForm()" type="submit" value="Submit">
    </form>

  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddNews",
  data: () => ({
    message: ''
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/news/save', {
        message: this.message,
      } )
    }
  }
}
</script>

<style scoped>

</style>