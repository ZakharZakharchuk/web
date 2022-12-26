<template>
  <div>
    <h1>GroupPage</h1>
    <hr>

    <GroupList
        v-bind:groups="groups"
    />
    <br><br>
    <a href="/addGroup">Додати групу</a>
  </div>
</template>

<script>
import axios from "axios";
import GroupList from "@/components/GroupComponents/GroupList";

export default {
  name: "GroupPage",
  components: {GroupList},
  data() {
    return {
      groups: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/groups/getAll')
        .then(response => (this.groups = response.data))
        .catch(error => console.log(error));
  },
}
</script>

<style scoped>

</style>