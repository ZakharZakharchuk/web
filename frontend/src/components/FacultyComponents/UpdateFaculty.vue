<template>
<div>
  <form action="/faculty">
    <input type="hidden" v-model="id" name="id">
    <input type="text" v-model="name" name="name">
    <input type="text" v-model="shortName" name="surname">
    <input type="submit" v-on:click="updateTeacher()" value="Редагувати">
  </form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateFaculty",
  data:() => ({
    id: '',
    name: '',
    shortName: '',
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/facilities/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.shortName = result.data.shortName
  },
  methods: {
    updateTeacher() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/facilities/update', {
        id: this.id,
        name: this.name,
        shortName: this.shortName,
      })
    }
  }
}
</script>

<style scoped>

</style>