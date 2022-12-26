<template>
<div>
  <form action="/department">
    <label for="facilityId">facilityId:</label><br>
    <input type="text" id="facilityId" name="facilityId" v-model="facilityId" required ><br><br>
    <label for="name">name:</label><br>
    <input type="text" id="name" name="name" v-model="name" required ><br><br>
    <label for="shortName">shortName:</label><br>
    <input type="text" id="shortName" name="shortName" v-model="shortName" required ><br><br>
    <input v-on:click="submitForm()" type="submit" value="Submit">
  </form>

</div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddDepartment",
  data: () => ({
    facilityId: '',
    name: '',
    shortName: '',
  }),
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/departments/save', {
        facilityId: this.facilityId,
        name: this.name,
        shortName: this.shortName,
      } )
    }
  }
}
</script>

<style scoped>

</style>