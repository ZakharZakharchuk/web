<template>
  <div>
    <form action="/schedule">
      <input type="hidden" v-model="id" name="id">
      <label for="teacherId">teacherId:</label><br>
      <input type="text" v-model="teacherId" name="teacherId"><br>
      <label for="disciplineId">disciplineId:</label><br>
      <input type="text" v-model="disciplineId" name="disciplineId"><br>
      <label for="groupId">groupId:</label><br>
      <input type="text" v-model="groupId" name="groupId"><br>
      <label for="time">time:</label><br>
      <input type="text" v-model="time" name="time"><br>
      <label for="classroom">classroom:</label><br>
      <input type="text" v-model="classroom" name="classroom"><br>
      <input type="submit" v-on:click="updateSchedule()" value="Редагувати">
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
import axios from "axios";

export default {
  name: "UpdateSchedule",
  data:() => ({
    id: '',
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

    const result = await axios.post('http://localhost:8080/schedules/getById', {
      id: this.$route.params.id
    })
    this.id = result.data.id
    this.teacherId = result.data.teacherId
    this.disciplineId = result.data.disciplineId
    this.groupId = result.data.groupId
    this.time = result.data.time
    this.classroom = result.data.classroom

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
    updateSchedule() {
      axios.post('http://localhost:8080/schedules/update', {
        id: this.id,
        teacherId: this.teacherId,
        disciplineId: this.disciplineId,
        groupId: this.groupId,
        time: this.time,
        classroom: this.classroom
      }).catch(error => console.log(error));
    }
  }
}
</script>

<style scoped>

</style>