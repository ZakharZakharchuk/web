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
    classroom: ''
  }),
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