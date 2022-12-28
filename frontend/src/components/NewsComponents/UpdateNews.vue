<template>
  <div>
    <form action="/news">
      <input type="hidden" v-model="id" name="id">
      <label for="message">message:</label><br>
      <input type="text" v-model="message" name="message"><br>
      <input type="submit" v-on:click="updateNews()" value="Редагувати">
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateNews",
  data:() => ({
    id: '',
    message: ''
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/news/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.message = result.data.message
  },
  methods: {
    updateNews() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/news/update', {
        id: this.id,
        message: this.message
      })
    }
  }
}
</script>

<style scoped>

</style>