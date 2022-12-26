<template>
<div>
  <div class="row">
    <div class="cell">DepartmentID</div>
    <div class="cell">Name</div>
    <div class="cell">Course</div>

  </div>
  <GroupItem
      v-for="(group,key) in groups" :key="key"
      v-bind:group="group"
  />

</div>
</template>

<script>
import GroupItem from "@/components/GroupComponents/GroupItem";

export default {
  name: "GroupList",
  components: {GroupItem},
  props: ['groups'],
}
</script>

<style scoped>

</style>