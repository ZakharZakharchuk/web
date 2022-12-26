<template>
  <div>
    <div class="row">
      <div class="cell">Name</div>
    </div>
    <DisciplineItem
        v-for="(discipline,key) in disciplines" :key="key"
        v-bind:discipline="discipline"

    />
  </div>
</template>

<script>
import DisciplineItem from "@/components/DisciplinesComponents/DisciplineItem";

export default {
  name: "DisciplineList",
  components: {DisciplineItem},
  props: ['disciplines'],
}
</script>

<style scoped>

</style>