<template>
  <div>

    <div class="table">

      <form action="/faculty">
        <input type="text" :value="faculty.id" name="id">
        <input type="text" :value="faculty.name" name="name">
        <input type="text" :value="faculty.shortName" name="shortName">
        <router-link :to="'/updateFaculty/'+faculty.id">Редагувати</router-link>
      </form>
      <form action="/faculty">
        <button type="submit" @click="deleteFaculty(faculty.id) ">Видалити</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FacultyItem",
  props: {
    faculty: {
      type: Object,
    }
  },
  methods: {
    deleteFaculty(id) {
      axios.post('http://localhost:8080/facilities/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>

</style>