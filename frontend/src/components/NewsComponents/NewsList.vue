<template>
  <div>
    <div class="row">
      <div class="cell">Message</div>
    </div>
    <NewsItem
        v-for="(information,key) in news" :key="key"
        v-bind:information="information"
    />
  </div>
</template>

<script>
import NewsItem from "@/components/NewsComponents/NewsItem";

export default {
  name: "NewsList",
  components: {NewsItem},
  props: ['news'],
}
</script>

<style scoped>

</style>