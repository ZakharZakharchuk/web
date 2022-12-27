<template>
<div>
  <form action="/group">
    <input type="hidden" v-model="id" name="id">
    <input type="text" v-model="departmentId" name="departmentId">
    <input type="text" v-model="name" name="name">
    <input type="text" v-model="course" name="course">
    <input type="submit" v-on:click="updateGroup()" value="Редагувати">
  </form>
  <h3>departments</h3>
  <p
      v-for="(department,key) in departments" :key="key"
      v-bind:department="department">{{department.name + ' - ' + department.id}}</p>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateGroup",
  data:() => ({
    id: '',
    name: '',
    departmentId: '',
    course: '',
    departments:[]
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/groups/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.departmentId = result.data.departmentId
    this.course = result.data.course

    axios.get('http://localhost:8080/departments/getAll')
        .then(response => (this.departments = response.data))
        .catch(error => console.log(error));

  },
  methods: {
    updateGroup() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/groups/update', {
        id: this.id,
        name: this.name,
        departmentId: this.departmentId,
        course: this.course
      })
    }
  }
}
</script>

<style scoped>

</style>