<template>
  <div>
    <h1>SchedulePage</h1>
    <hr>
    <ScheduleList
        v-bind:schedules="schedules"
    />
    <br><br>
    <a href="/addSchedule">Додати розклад</a>
  </div>
</template>

<script>
import axios from 'axios';
import ScheduleList from "@/components/ScheduleComponents/ScheduleList";

export default {
  name: "SchedulePage",
  components: {ScheduleList},
  data() {
    return {
      schedules: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/schedules/getAll')
        .then(response => (this.schedules = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>