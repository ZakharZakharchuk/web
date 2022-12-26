<template>
  <div>
    <h1>FacultyPage</h1>
    <hr>

    <FacutlyList
    v-bind:faculties="faculties"
    />
    <br><br>
    <a href="/addFaculty">Додати факультет</a>

  </div>
</template>

<script>
import axios from 'axios';
import FacutlyList from "@/components/FacultyComponents/FacutlyList";

export default {
  name: "FacultyPage",
  components: {FacutlyList},
  data() {
    return {
      faculties: []
    };
  },
  mounted() {
     axios.get('http://localhost:8080/facilities/getAll')
        .then(response => (this.faculties = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>