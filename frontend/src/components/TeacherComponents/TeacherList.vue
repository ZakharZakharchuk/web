<template>
  <div>
    <div class="row">
      <div class="cell">Name</div>
      <div class="cell">Surname</div>
      <div class="cell">Email</div>
      <div class="cell">Phone</div>
      <div class="cell">Дії</div>
    </div>
      <TeacherItem
        v-for="(teacher,key) in teachers" :key="key"
        v-bind:teacher="teacher"

      />
  </div>
</template>

<script>
import TeacherItem from "@/components/TeacherComponents/TeacherItem";

export default {
  name: "TeacherList",
  components: {TeacherItem},
  props: ['teachers'],
}
</script>

<style scoped>

</style>