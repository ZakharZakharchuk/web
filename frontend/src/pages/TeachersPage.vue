<template>
  <div>
    <h1>teachers-page</h1>
    <hr>
    <table>
    <td>
      <tr>Ім'я</tr>
      <tr v-for="(teacher, index) in teachers" :key="index"> {{ teacher.name }} </tr>
    </td>
      <td>
        <tr>Прізвище</tr>
        <tr v-for="(teacher, index) in teachers" :key="index"> {{ teacher.surname }} </tr>
      </td>
      <td>
        <tr>Мобільний</tr>
        <tr v-for="(teacher, index) in teachers" :key="index"> {{ teacher.phone }} </tr>
      </td>
      <td>
        <tr>Email</tr>
        <tr v-for="(teacher, index) in teachers" :key="index"> {{ teacher.email }} </tr>
      </td>
      <td>
        <tr>Дії</tr>
        <tr v-for="(teacher, index) in teachers" :key="index">
          <a href = "/update" >Редагувати</a>
          <a href = "/update" >Видалити</a>
        </tr>
      </td>
    </table>
    <a href="/add">Додати викладача</a>
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
        .then(response => (this.teachers = response.data))
        .catch(error => console.log(error));
  }
}


</script>

<style scoped>


</style>