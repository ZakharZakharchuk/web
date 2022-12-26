<template>
<div>
  <div class="table">


    <form action="/department">
      <input type="text" :value="department.id" name="id">
      <input type="text" :value="department.facilityId" name="facilityId">
      <input type="text" :value="department.name" name="name">
      <input type="text" :value="department.shortName" name="shortName">
      <router-link :to="'/updateTeacher/'+department.id">Редагувати</router-link>
    </form>
    <form action="/department">
      <button type="submit" @click="deleteTeacher(department.id) ">Видалити</button>
    </form>
  </div>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "DepartmentItem",
  props: {
    department: {
      type: Object,
    }
  },
  methods: {
    deleteTeacher(id) {
      axios.post('http://localhost:8080/departments/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>

</style>