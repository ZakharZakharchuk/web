<template>
  <div>
    <div class="table">


      <form action="/schedule">
        <input type="hidden" :value="schedule.id" name="id">
        <input type="text" :value="teacherName" name="teacherName">
        <input type="text" :value="disciplineName" name="disciplineName">
        <input type="text" :value="groupName" name="groupName">
        <input type="text" :value="schedule.time" name="time">
        <input type="text" :value="schedule.classroom" name="classroom">
        <router-link :to="'/updateSchedule/'+schedule.id">Редагувати</router-link>
      </form>
      <form action="/schedule">
        <button type="submit" @click="deleteSchedule(schedule.id) ">Видалити</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ScheduleItem",
  props: {
    schedule: {
      type: Object,
    }
  },
  data: () => ({
    teacherName: '',
    disciplineName:'',
    groupName:''
  }),
  methods: {
    deleteSchedule(id) {
      axios.post('http://localhost:8080/schedules/delete', {
        id: id,
      })
    }
  },
  async mounted() {
    const teacherNameResult = await axios.post('http://localhost:8080/teachers/getById', {
      id: this.schedule.teacherId,
    })
    this.teacherName = teacherNameResult.data.name
    const disciplineNameResult = await axios.post('http://localhost:8080/disciplines/getById', {
      id: this.schedule.disciplineId,
    })
    this.disciplineName = disciplineNameResult.data.name
    const groupNameResult = await axios.post('http://localhost:8080/groups/getById', {
      id: this.schedule.groupId,
    })
    this.groupName = groupNameResult.data.name
  }
}
</script>

<style scoped>

</style>