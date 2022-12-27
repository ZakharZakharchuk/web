<template>
  <div>
    <div class="table">


      <form action="/students">
        <input type="hidden" :value="student.id" name="id">
        <input type="text" :value="name" name="group">
        <input type="text" :value="student.name" name="name">
        <input type="text" :value="student.email" name="email">
        <input type="text" :value="student.phone" name="phone">
        <router-link :to="'/updateStudent/'+student.id">Редагувати</router-link>
      </form>
      <form action="/students">
        <button type="submit" @click="deleteStudent(student.id) ">Видалити</button>
      </form>
    </div>


  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "StudentItem",
  props: {
    student: {
      type: Object,
    }
  },
  data: () => ({
    name: ''
  }),
  methods: {
    deleteStudent(id) {
      axios.post('http://localhost:8080/students/delete', {
        id: id,
      })
    }
  },
  async mounted() {
    const result = await axios.post('http://localhost:8080/groups/getById', {
      id: this.student.groupId,
    })
    this.name = result.data.name
  }
}
</script>

<style scoped>

</style>