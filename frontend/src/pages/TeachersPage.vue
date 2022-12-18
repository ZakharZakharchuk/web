<template>
  <div>
    <h1>teachers-page</h1>
    <hr>
    {{ teachers }}
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "TeachersPage",
  data() {
    return {
      teachers: null
    };
  },
  mounted() {
    axios.get('http://localhost:8080/teachers/getAll')
        .then(response => (this.teachers = response))
        .catch(error => console.log(error));
  }
}
//const URL = 'http://localhost:8080/';

</script>

<style scoped>

</style>