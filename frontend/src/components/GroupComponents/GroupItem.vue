<template>
<div>
  <div class="table">


    <form action="/group">
      <input type="text" :value="group.id" name="id">
      <input type="text" :value="group.departmentId" name="departmentId">
      <input type="text" :value="group.name" name="name">
      <input type="text" :value="group.course" name="course">
      <router-link :to="'/updateTeacher/'+group.id">Редагувати</router-link>
    </form>
    <form action="/group">
      <button type="submit" @click="deleteTeacher(group.id) ">Видалити</button>
    </form>
  </div>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "GroupItem",
  props: {
    group: {
      type: Object,
    }
  },
  methods: {
    deleteTeacher(id) {
      axios.post('http://localhost:8080/groups/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>

</style>