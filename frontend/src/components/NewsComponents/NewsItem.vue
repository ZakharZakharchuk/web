<template>
  <div>
    <div class="table">


      <form action="/news">
        <input type="hidden" :value="information.id" name="id">
        <input type="text" :value="information.message" name="message">
        <router-link :to="'/updateNews/'+information.id">Редагувати</router-link>
      </form>
      <form action="/news">
        <button type="submit" @click="deleteNews(information.id) ">Видалити</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "NewsItem",
  props: {
    information: {
      type: Object,
    }
  },
  methods: {
    deleteNews(id) {
      axios.post('http://localhost:8080/news/delete', {
        id: id,
      })
    }
  }
}
</script>

<style scoped>

</style>