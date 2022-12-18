<template>
  <div>
    <form @submit.prevent = "submitForm()">
      <label for="name">name:</label><br>
      <input type="text" id="name" name="name" v-model="name" required ><br><br>
      <label for="surname">surname:</label><br>
      <input type="text" id="surname" name="surname" v-model="surname" required ><br><br>
      <label for="phone">phone:</label><br>
      <input type="text" id="phone" name="phone" v-model="phone" required ><br><br>
      <label for="email">email:</label><br>
      <input type="text" id="email" name="email" v-model="email" required ><br><br>
      <input type="submit" value="Submit">
    </form>

  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddTeacher",
  data: () => ({
    email: '',
    surname: '',
    name: '',
    phone: '',
    teachers: [],
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/teachers/update', {
        name: this.name,
        surname: this.surname,
        phone: this.phone,
        email: this.email
      } )
    }
  }
}


</script>

<style scoped>

</style>