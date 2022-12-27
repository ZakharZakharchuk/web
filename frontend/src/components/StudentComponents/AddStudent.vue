<template>
<div>
  <form action="/students">
    <label for="groupId">groupId:</label><br>
    <input type="text" id="groupId" name="groupId" v-model="groupId" required ><br><br>
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" v-model="name" required ><br><br>
    <label for="email">email:</label><br>
    <input type="text" id="email" name="email" v-model="email" required ><br><br>
    <label for="phone">phone:</label><br>
    <input type="text" id="phone" name="phone" v-model="phone" required ><br><br>
    <input v-on:click="submitForm()" type="submit" value="Submit">
  </form>

</div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddStudent",
  data: () => ({
    groupId: '',
    name: '',
    email: '',
    phone: '',
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/students/save', {
        groupId: this.groupId,
        name: this.name,
        email: this.email,
        phone: this.phone
      } )
    }
  }
}
</script>

<style scoped>

</style>