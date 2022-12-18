<template>
  <div>
    <h1>Редагувати викладача</h1>
    <hr>
    <td>
      <tr>Ім'я</tr>
      <tr><input type="text" id="name" ></tr>
    </td>
    <td>
      <tr>Прізвище</tr>
      <tr><input type="text" id="surname"></tr>
    </td>
    <td>
      <tr>Мобільний</tr>
      <tr><input type="text" id="phone"></tr>
    </td>
    <td>
      <tr>Почта</tr>
      <tr><input type="text" id="email"></tr>
    </td>
    <button onclick="updateTeacher(id, name, surname, phone, email)">Підтвердити</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "UpdateTeacher"
}

export class TeachersService {
  async updateTeacher(name, surname, phone, email ) {
    axios.post('http://localhost:8080/teachers/update', {
      name: name,
      surname: surname,
      phone: phone,
      email: email
    } )
  }
}



</script>

<style scoped>

</style>