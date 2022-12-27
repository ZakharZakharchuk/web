<template>
  <div>
    <form action="/students">
      <input type="hidden" v-model="id" name="id">
      <input type="text" v-model="groupId" name="groupId">
      <input type="text" v-model="name" name="name">
      <input type="text" v-model="email" name="email">
      <input type="text" v-model="phone" name="phone">
      <input type="submit" v-on:click="updateStudent()" value="Редагувати">
    </form>
    <h3>groups</h3>
    <p
        v-for="(group,key) in groups" :key="key"
        v-bind:group="group">{{ group.name + ' - ' + group.id }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateStudent",
  data: () => ({
    id: '',
    name: '',
    groupId: '',
    email: '',
    phone: '',
    groups: ''
  }),
  async mounted() {

    const result = await axios.post('http://localhost:8080/students/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.groupId = result.data.groupId
    this.email = result.data.email
    this.phone = result.data.phone


    axios.get('http://localhost:8080/groups/getAll')
        .then(response => (this.groups = response.data))
        .catch(error => console.log(error));
  },
  methods: {
    updateStudent() {
      console.warn(this.teacher)
      axios.post('http://localhost:8080/students/update', {
        id: this.id,
        name: this.name,
        groupId: this.groupId,
        email: this.email,
        phone: this.phone
      })
    }


  }
}
</script>

<style scoped>

</style>