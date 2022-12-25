<template>
  <div>
    <form action="/teachers">
      <input type="text" v-model="teacher.id" name="id">
      <input type="text" v-model="teacher.name" name="name">
      <input type="text" v-model="teacher.surname" name="surname">
      <input type="text" v-model="teacher.email" name="email">
      <input type="text" v-model="teacher.phone" name="phone">
      <button
          type="submit"
          @click="updateTeacher(teacher.id, teacher.name, teacher.surname, teacher.email, teacher.phone) ">Редагувати
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateTeacher",
  data(){
    return{
      teacher: {
        id:'',
        name:'',
        surname:'',
        email:'',
        phone:''
      }
    }
  },
  async mounted() {
    console.warn(this.$route.params.id)

    const result = await axios.get('http://localhost:8080/teachers/getTeacher/'+this.$route.params.id)
    this.teacher = result.data
  }
}
</script>

<style scoped>

</style>