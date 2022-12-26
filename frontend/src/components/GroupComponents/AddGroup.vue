<template>
<div>
  <form action="/group">
    <label for="departmentId">departmentId:</label><br>
    <input type="text" id="departmentId" name="departmentId" v-model="departmentId" required ><br><br>
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" v-model="name" required ><br><br>
    <label for="course">course:</label><br>
    <input type="text" id="course" name="course" v-model="course" required ><br><br>
    <input v-on:click="submitForm()" type="submit" value="Submit">
  </form>
</div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddGroup",
  data: () => ({
    departmentId: '',
    name: '',
    course: '',
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/groups/save', {
        departmentId: this.departmentId,
        name: this.name,
        course: this.course,
      } )
    }
  }
}
</script>

<style scoped>

</style>