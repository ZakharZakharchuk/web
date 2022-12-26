<template>
<div>
  <div class="row">
    <div class="cell">Name</div>
    <div class="cell">Short_name</div>
    <FacultyItem
        v-for="(faculty,key) in faculties" :key="key"
        v-bind:faculty="faculty"
    />

  </div>
</div>
</template>

<script>
import FacultyItem from "@/components/FacultyComponents/FacultyItem";

export default {
  name: "FacutlyList",
  components: {FacultyItem},
  props: ['faculties']
}
</script>

<style scoped>

</style>