<template>
<div>
  <div class="table">


    <form action="/group">
      <input type="hidden" :value="group.id" name="id">
      <input type="text" :value="name" name="departmentName">
      <input type="text" :value="group.name" name="name">
      <input type="text" :value="group.course" name="course">
      <router-link :to="'/updateGroup/'+group.id">Редагувати</router-link>
    </form>
    <form action="/group">
      <button type="submit" @click="deleteGroup(group.id) ">Видалити</button>
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
  data: () => ({
    name: ''
  }),
  methods: {
    deleteGroup(id) {
      axios.post('http://localhost:8080/groups/delete', {
        id: id,
      })
    }
  },
  async mounted() {
    const result = await axios.post('http://localhost:8080/departments/getById', {
      id: this.group.departmentId,
    })
    this.name = result.data.name
  }
}
</script>

<style scoped>

</style>