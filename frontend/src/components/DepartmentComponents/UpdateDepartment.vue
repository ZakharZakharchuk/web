<template>
<div>
  <form action="/department">
    <input type="hidden" v-model="id" name="id">
    <label for="facilityId">facilityId:</label><br>
    <input type="text" v-model="facilityId" name="facilityId"><br>
    <label for="name">name:</label><br>
    <input type="text" v-model="name" name="name"><br>
    <label for="shortName">shortName:</label><br>
    <input type="text" v-model="shortName" name="shortName"><br>
    <input type="submit" v-on:click="updateTeacher()" value="Редагувати">
  </form>
  <h3>faculties</h3>
  <p
      v-for="(faculty,key) in faculties" :key="key"
      v-bind:faculty="faculty">{{faculty.name + ' - ' + faculty.id}}</p>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateDepartment",
  data:() => ({
    id: '',
    name: '',
    facilityId: '',
    shortName: '',
    faculties:[]
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/departments/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.facilityId = result.data.facilityId
    this.shortName = result.data.shortName

    axios.get('http://localhost:8080/facilities/getAll')
        .then(response => (this.faculties = response.data))
        .catch(error => console.log(error));

  },
  methods: {
    updateTeacher() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/departments/update', {
        id: this.id,
        name: this.name,
        facilityId: this.facilityId,
        shortName: this.shortName
      })
    }
  }
}
</script>

<style scoped>

</style>