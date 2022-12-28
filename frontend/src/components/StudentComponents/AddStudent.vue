<template>
  <div>
    <form action="/students">
      <label for="groupId">groupId:</label><br>
      <input type="text" id="groupId" name="groupId" v-model="groupId" required><br><br>

      <label for="name">name:</label><br>
      <input type="text" :class="error.name?'invalid':''" id="name" name="name" v-model="name" required><br><br>
      <small class="invalid" v-if="error.name">
        {{ error.name }}</small><br>

      <label for="email">email:</label><br>
      <input type="text" :class="error.email?'invalid':''" id="email" name="email" v-model="email" required><br><br>
      <small class="invalid" v-if="error.email">
        {{ error.email }}</small><br>

      <label for="phone">phone:</label><br>
      <input type="text"
             v-mask="'+38(0##)###-##-##'"
             :class="error.phone?'invalid':''"
             placeholder="+38(0__)___-__-__"
             id="phone" name="phone" v-model="phone" required><br><br>
      <small class="invalid" v-if="error.phone">
        {{ error.phone }}</small><br>

      <input v-on:click="submitForm()" type="submit" value="Submit">
    </form>
    <h3>groups</h3>
    <p
        v-for="(group,key) in groups" :key="key"
        v-bind:group="group">{{ group.name + ' - ' + group.id }}</p>
  </div>
</template>

<script>
import axios from 'axios';
import {mask} from 'vue-the-mask'

export default {
  name: "AddStudent",
  data: () => ({
    groupId: '',
    name: '',
    email: '',
    phone: '',
    groups: [],
    error: [],
  }),
  directives: {
    mask
  },
  async mounted() {

    axios.get('http://localhost:8080/groups/getAll')
        .then(response => (this.groups = response.data))
        .catch(error => console.log(error));
  },
  methods: {
    submitForm() {
      if (this.checkEmail(this.email) &&
          this.checkName(this.name) &&
          this.checkPhone(this.phone)) {
        axios.post('http://localhost:8080/students/save', {
          groupId: this.groupId,
          name: this.name,
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