<template>
<div>
  <div class="table">


    <form action="/disciplines">
      <input type="text" :value="discipline.id" name="id">
      <input type="text" :value="discipline.name" name="name">
      <router-link :to="'/updateDiscipline/'+discipline.id">Редагувати</router-link>
    </form>
    <form action="/disciplines">
      <button type="submit" @click="deleteDiscipline(discipline.id) ">Видалити</button>
    </form>
  </div>
</div>
</template>

<script>
import axios from "axios";


export default {
  name: "DisciplineItem",
  props: {
    discipline: {
      type: Object,
    }
  },
  methods: {
    deleteDiscipline(id) {
      axios.post('http://localhost:8080/disciplines/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>

</style>