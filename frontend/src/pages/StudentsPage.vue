<template>
  <div>
    <h1>StudentsPage</h1>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "StudentsPage",
  data() {
    return {
      teachers: null
    };
  },
  mounted() {
    axios.get('http://localhost:8080/teachers/getAll')
        .then(response => (this.teachers = response));
  }

}
</script>

<style scoped>

</style>