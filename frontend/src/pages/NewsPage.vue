<template>
  <div>
    <h1>news</h1>
    <hr>

    <NewsList
    v-bind:news="news"
    />
    <br><br>
    <a href="/addNews">Додати викладача</a>
  </div>
</template>

<script>
import axios from 'axios';
import NewsList from "@/components/NewsComponents/NewsList";

export default {
  name: "NewsPage",
  components: {NewsList},
  data() {
    return {
      news: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/news/getAll')
        .then(response => (this.news = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>