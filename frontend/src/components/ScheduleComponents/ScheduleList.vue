<template>
  <div>

    <div class="row">
      <div class="cell">teacherId</div>
      <div class="cell">disciplineId</div>
      <div class="cell">groupId</div>
      <div class="cell">time</div>
      <div class="cell">classroom</div>
    </div>
    <ScheduleItem
        v-for="(schedule,key) in schedules" :key="key"
        v-bind:schedule="schedule"
    />
  </div>
</template>

<script>
import ScheduleItem from "@/components/ScheduleComponents/ScheduleItem";

export default {
  name: "ScheduleList",
  components: {ScheduleItem},
  props: ['schedules'],
}
</script>

<style scoped>

</style>