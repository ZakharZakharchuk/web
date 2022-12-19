<template>
  <div>
    <h1>teachers-page</h1>
    <hr>

    <div class="table">
      <div class="row">
        <div class="cell">Id</div>
        <div class="cell">Name</div>
        <div class="cell">Surname</div>
        <div class="cell">Email</div>
        <div class="cell">Phone</div>
        <div class="cell">Дії</div>
      </div>
      <div v-for="(teacher, key) in teachers" :key="key" class="row">
        <div class="cell">{{key}}</div>
        <div class="cell">{{ teacher.name }}</div>
        <div class="cell">{{ teacher.surname }}</div>
        <div class="cell">{{ teacher.email }}</div>
        <div class="cell">{{ teacher.phone }}</div>
        <div class="cell">
          <form action="/update">
            <input value="Редагувати" type="submit">
          </form></div>

      </div>
    </div>
    <br><br>
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
  },
}


</script>

<style scoped>


input:-webkit-autofill {
  background-color: aquamarine;
}

.form-container > label {
  width: 100px;
}

button {
  background-color: antiquewhite;
  border: darkcyan 2px solid;
  cursor: pointer;
}

input {
  width: 150px;
  border-left: 0;
  border-right: 0;
  border-bottom: 2px solid;
  border-top: 0;
}

.table {
  font-size: 24px;
  margin-top: 40px;
  width: 90%;
  margin-left: 5%;
}

.row {
  display: table-row;
}

.cell {
  display: table-cell;
  border: #717171 1px solid;
}

</style>