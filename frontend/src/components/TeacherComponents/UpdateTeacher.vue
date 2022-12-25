<template>
  <div>
    <form action="/teachers">
      <input type="hidden" v-model="id" name="id">
      <input type="text" id="name" v-model="name" name="name">
      <input type="text" v-model="surname" name="surname">
      <input type="text" v-model="email" name="email">
      <input type="text" v-model="phone" name="phone">
      <input type="submit" v-on:click="updateTeacher()" value="Редагувати">
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateTeacher",
  data:() => ({
        id: '',
        name: '',
        surname: '',
        email: '',
        phone: ''
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/teachers/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.surname = result.data.surname
    this.email = result.data.email
    this.phone = result.data.phone
  },
  methods: {
    updateTeacher() {
      console.warn(this.teacher)
       axios.post('http://localhost:8080/teachers/update', {
        id: this.id,
        name: this.name,
        surname: this.surname,
        email: this.email,
        phone: this.phone
      })
    }
  }
}
</script>

<style scoped>

</style>