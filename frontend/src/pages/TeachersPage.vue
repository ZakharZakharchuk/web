<template>
  <div>
    <h1>teachers-page</h1>
    <hr>

      <TeacherList
        v-bind:teachers="teachers"
      />

    <br><br>
    <a href="/add">Додати викладача</a>
  </div>
</template>

<script>
import axios from 'axios';
import TeacherList from "@/components/TeacherComponents/TeacherList";

export default {
  name: "TeachersPage",
  components: {TeacherList},
  data() {
    return {
      teachers: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/teachers/getAll')
        .then(response => (this.teachers = response.data))
        .catch(error => console.log(error));
  },
}


</script>

<style scoped>


</style>