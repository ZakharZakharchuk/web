<template>
<div>
  <form action="/disciplines">
    <input type="hidden" v-model="id" name="id">
    <label for="name">name:</label><br>
    <input type="text" v-model="name" name="name"><br>
    <input type="submit" v-on:click="updateDiscipline()" value="Редагувати">
  </form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateDiscipline",
  data:() => ({
    id: '',
    name: '',
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/disciplines/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
  },
  methods: {
    updateDiscipline() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/disciplines/update', {
        id: this.id,
        name: this.name,
      })
    }
  }
}
</script>

<style scoped>

</style>