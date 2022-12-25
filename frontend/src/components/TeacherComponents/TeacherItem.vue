<template>
  <div>

    <div class="table">


      <form action="/teachers">
        <input type="text" :value="teacher.id" name="id">
        <input type="text" :value="teacher.name" name="name">
        <input type="text" :value="teacher.surname" name="surname">
        <input type="text" :value="teacher.email" name="email">
        <input type="text" :value="teacher.phone" name="phone">
        <router-link :to="'/update/'+teacher.id">Редагувати</router-link>
      </form>
      <form action="/teachers">
        <button type="submit" @click="deleteTeacher(teacher.id) ">Видалити</button>
      </form>
    </div>


  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TeacherItem",
  props: {
    teacher: {
      type: Object,
    }
  },
  methods: {
    deleteTeacher(id) {
      axios.post('http://localhost:8080/teachers/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>


</style>