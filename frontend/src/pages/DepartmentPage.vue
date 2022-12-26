<template>
  <div>
    <h1>DepartmentPage</h1>
    <hr>
    <DepartmentList
        v-bind:departments="departments"
    />
    <br><br>
    <a href="/addDepartment">Додати викладача</a>
  </div>
</template>

<script>
import axios from 'axios';
import DepartmentList from "@/components/DepartmentComponents/DepartmentList";

export default {
  name: "DepartmentPage",
  components: {DepartmentList},
  data() {
    return {
      departments: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/departments/getAll')
        .then(response => (this.departments = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>