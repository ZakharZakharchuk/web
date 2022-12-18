<template>
  <header>
    <div class="inHeader">
      <div class="names">
        <a href="/">Home</a>
        <a href="/schedule">Schedule</a>
        <a href="/news">About</a>
        <a href="/faculty">Faculty</a>
        <a href="/department">Department</a>
        <a href="/group">Group</a>
        <a href="/disciplines">Disciplines</a>
        <a href="/teachers">Teachers</a>
        <a href="/students">Students</a>

      </div>
      <div class="login">
        <a href="#">Log in</a>
        <a href="#">Sign up</a>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "HeaderComponent"
}
</script>

<style scoped>

header {
  display: flex;
  width: 100%;
  color: black;
}

.inHeader {
  display: flex;
  width: 100%;
  flex-direction: row;
  justify-content: space-evenly;
}

.names {
  display: flex;
  width: 100%;
  flex-direction: row;
  align-self: center;
  justify-content: flex-start;
}
.login{
  display: flex;
  width: 20%;
  flex-direction: row;
  align-self: center;
  justify-content: space-around;
}
.names a {
  margin: 2%;
}
.login a{
  margin: 6%;
}

</style>