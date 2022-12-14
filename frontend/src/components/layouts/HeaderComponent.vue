<template>
  <header>
    <div class="inHeader">
      <div class="names">
        <a href="lab1.html">Home</a>
        <a href="FAQ.html">About</a>
        <a href="lab1.html">Services</a>
        <a href="tables.html">Portfolio</a>
      </div>
      <div class="login">
        <a href="login.html">Log in</a>
        <a href="signUp.html">Sign up</a>
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