<template>
  <div>
    <form action="/schedule">
      <label for="teacherId">teacherId:</label><br>
      <input type="text" id="teacherId" name="teacherId" v-model="teacherId" required ><br><br>
      <label for="disciplineId">disciplineId:</label><br>
      <input type="text" id="disciplineId" name="disciplineId" v-model="disciplineId" required ><br><br>
      <label for="groupId">groupId:</label><br>
      <input type="text" id="groupId" name="groupId" v-model="groupId" required ><br><br>
      <label for="time">time:</label><br>
      <input type="text" id="time" name="time" v-model="time" required ><br><br>
      <label for="classroom">classroom:</label><br>
      <input type="text" id="classroom" name="classroom" v-model="classroom" required ><br><br>
      <input v-on:click="submitForm()" type="submit" value="Submit">
    </form>

    <h3>teachers</h3>
    <p
        v-for="(teacher,key) in teachers" :key="key"
        v-bind:teacher="teacher">{{teacher.name + ' - ' + teacher.id}}</p>
    <h3>disciplines</h3>

    <p
        v-for="(discipline,key) in disciplines" :key="key"
        v-bind:discipline="discipline">{{discipline.name + ' - ' + discipline.id}}</p>
    <h3>groups</h3>

    <p
        v-for="(group,key) in groups" :key="key"
        v-bind:group="group">{{group.name + ' - ' + group.id}}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "AddSchedule",
  data: () => ({
    teacherId: '',
    disciplineId: '',
    groupId: '',
    time: '',
    classroom: '',
    teachers:[],
    disciplines:[],
    groups:[]
  }),
  async mounted() {


    axios.get('http://localhost:8080/teachers/getAll')
        .then(response => (this.teachers = response.data))
        .catch(error => console.log(error));

    axios.get('http://localhost:8080/disciplines/getAll')
        .then(response => (this.disciplines = response.data))
        .catch(error => console.log(error));

    axios.get('http://localhost:8080/groups/getAll')
        .then(response => (this.groups = response.data))
        .catch(error => console.log(error));
  },
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/schedules/save', {
        teacherId: this.teacherId,
        disciplineId: this.disciplineId,
        groupId: this.groupId,
        time: this.time,
        classroom: this.classroom
      } )
    }
  }
}
</script>

<style scoped>

</style>