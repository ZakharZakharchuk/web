<template>
  <div>
    <h1>StudentsPage</h1>
    <hr>

    <StudentList
        v-bind:students="students"
    />
    <br><br>
    <a href="/addStudent">Додати студента</a>

  </div>
</template>

<script>
import axios from "axios";
import StudentList from "@/components/StudentComponents/StudentList";

export default {
  name: "StudentsPage",
  components: {StudentList},
  data() {
    return {
      students: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/students/getAll')
        .then(response => (this.students = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>