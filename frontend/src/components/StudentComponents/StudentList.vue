<template>
<div>
  <div class="row">
    <div class="cell">groupID</div>
    <div class="cell">name</div>
    <div class="cell">Email</div>
    <div class="cell">Phone</div>
  </div>

  <StudentItem
      v-for="(student,key) in students" :key="key"
      v-bind:student="student"
  />

</div>
</template>

<script>
import StudentItem from "@/components/StudentComponents/StudentItem";

export default {
  name: "StudentList",
  components: {StudentItem},
  props: ['students'],
}
</script>

<style scoped>

</style>