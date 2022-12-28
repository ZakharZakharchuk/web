<template>
  <div>
    <form action="/teachers">
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
      <input v-on:click="submitForm()" type="submit" value="Submit">
    </form>

  </div>
</template>

<script>
import axios from 'axios';
import {mask} from 'vue-the-mask'

export default {
  name: "AddTeacher",
  data: () => ({
    email: '',
    surname: '',
    name: '',
    phone: '',
    error: [],
  }),
  directives: {
    mask
  },
  methods: {
    submitForm() {
      if (this.checkEmail(this.email) &&
          this.checkSurname(this.surname) &&
          this.checkName(this.name) &&
          this.checkPhone(this.phone)) {
        axios.post('http://localhost:8080/teachers/save', {
          name: this.name,
          surname: this.surname,
          phone: this.phone,
          email: this.email
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