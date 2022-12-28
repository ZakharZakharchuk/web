<template>
  <div>
    <form action="/teachers">
      <input type="hidden" v-model="id" name="id">
      <label for="name">name:</label><br>
      <input type="text" :class="error.name?'invalid':''" id="name" name="name" v-model="name" required><br><br>
      <small class="invalid" v-if="error.name">
        {{ error.name }}</small><br>

      <label for="surname">surname:</label><br>
      <input type="text" :class="error.surname?'invalid':''" id="surname" name="surname" v-model="surname" required><br><br>
      <small class="invalid" v-if="error.surname">
        {{ error.surname }}</small><br>

      <label for="phone">phone:</label><br>
      <input type="text"
             v-mask="'+38(0##)###-##-##'"
             :class="error.phone?'invalid':''"
             placeholder="+38(0__)___-__-__"
             id="phone" name="phone" v-model="phone" required><br><br>
      <small class="invalid" v-if="error.phone">
        {{ error.phone }}</small><br>

      <label for="email">email:</label><br>
      <input type="text" :class="error.email?'invalid':''" id="email" name="email" v-model="email" required><br><br>
      <small class="invalid" v-if="error.email">
        {{ error.email }}</small><br>
        <input type="submit" v-on:click="updateTeacher()" value="Редагувати">
    </form>
  </div>
</template>

<script>
import axios from "axios";
import {mask} from 'vue-the-mask'

export default {
  name: "UpdateTeacher",
  data: () => ({
    id: '',
    name: '',
    surname: '',
    email: '',
    phone: '',
    error: [],
  }),
  directives: {
    mask
  },
  async mounted() {

    const result = await axios.post('http://localhost:8080/teachers/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.name = result.data.name
    this.surname = result.data.surname
    this.email = result.data.email
    this.phone = result.data.phone
  },
  methods: {
    updateTeacher() {
      console.warn(this.teacher)
      if (this.checkEmail(this.email) &&
          this.checkSurname(this.surname) &&
          this.checkName(this.name) &&
          this.checkPhone(this.phone)) {
        axios.post('http://localhost:8080/teachers/update', {
          id: this.id,
          name: this.name,
          surname: this.surname,
          email: this.email,
          phone: this.phone
        })
      }
    },
    checkEmail(value) {
      if (/^(?=.{1,64}@)[A-Za-z0-9_-]+(.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$/
          .test(value)) {
        this.error['email'] = '';
        return true;
      } else {
        this.error['email'] = 'Invalid Email Address';
        return false;
      }
    },
    checkSurname(value) {
      if (/([A-Za-z]){2,}/
          .test(value)) {
        this.error['surname'] = '';
        return true;
      } else {
        this.error['surname'] = 'Invalid Surname';
        return false;
      }
    },
    checkName(value) {
      if (/([A-Za-z]){2,}/
          .test(value)) {
        this.error['name'] = '';
        return true;
      } else {
        this.error['name'] = 'Invalid Name';
        return false;
      }
    },
    checkPhone(value) {
      if (/(\+380|8)[- _]*\(?[- _]*(\d{3}[- _]*\)?([- _]*\d){7}|\d\d[- _]*\d\d[- _]*\)?([- _]*\d){6})/
          .test(value)) {
        this.error['phone'] = '';
        return true;
      } else {
        this.error['phone'] = 'Invalid Phone';
        return false;
      }
    },
  }, watch: {
    email: function (value) {
      this.checkEmail(value);
    },
    surname: function (value) {
      this.checkSurname(value);
    },
    name: function (value) {
      this.checkName(value);
    },
    phone: function (value) {
      this.checkPhone(value);
    },
  }
}

</script>

<style scoped>

</style>