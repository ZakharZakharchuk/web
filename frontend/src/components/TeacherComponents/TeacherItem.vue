<template>
  <div>

    <div class="table">
      <div>{{teacher.name}}</div>
      <div>{{teacher.surname}}</div>
      <div>{{teacher.email}}</div>
      <div>{{teacher.phone}}</div>
        <router-link :to="'/updateTeacher/'+teacher.id">Редагувати</router-link>
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