<template>
<div>
  <div class="row">
    <div class="cell">facultyID</div>
    <div class="cell">Name</div>
    <div class="cell">shortName</div>
  </div>
  <DepartmentItem
      v-for="(department,key) in departments" :key="key"
      v-bind:department="department"

  />
</div>
</template>

<script>
import DepartmentItem from "@/components/DepartmentComponents/DepartmentItem";

export default {
  name: "DepartmentList",
  components: {DepartmentItem},
  props: ['departments'],
}
</script>

<style scoped>

</style>