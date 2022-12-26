<template>
  <div>
    <h1>DisciplinesPage</h1>
    <hr>

    <DisciplineList
      v-bind:disciplines="disciplines"
    />
    <a href="/addDiscipline">Додати предмет</a>

  </div>
</template>

<script>
import axios from 'axios';
import DisciplineList from "@/components/DisciplinesComponents/DisciplineList";

export default {
  name: "DisciplinesPage",
  components: {DisciplineList},
  data() {
    return {
      disciplines: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/disciplines/getAll')
        .then(response => (this.disciplines = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>