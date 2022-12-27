<template>
<div>
  <div class="table">


    <form action="/department">
      <input type="hidden" :value="department.id" name="id">
      <input type="text" :value="name" name="facilityName">
      <input type="text" :value="department.name" name="name">
      <input type="text" :value="department.shortName" name="shortName">
      <router-link :to="'/updateDepartment/'+department.id">Редагувати</router-link>
    </form>
    <form action="/department">
      <button type="submit" @click="deleteDepartment(department.id) ">Видалити</button>
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
  data: () => ({
    name: ''
  }),
  methods: {
    deleteDepartment(id) {
      axios.post('http://localhost:8080/departments/delete', {
        id: id,
      })
    }
  },
  async mounted() {
    const result = await axios.post('http://localhost:8080/facilities/getById', {
      id: this.department.facilityId,
    })
    this.name = result.data.name
  }
}
</script>

<style scoped>

</style>