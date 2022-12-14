<template>
  <footer>
    <div>
      <h3>СТРУКТУРА</h3>
      <p>Ректорат</p>
      <p>Вчена рада</p>
      <p>Департаменти</p>
    </div>
    <div>
      <h3>МОЖЛИВОСТІ ОСВІТИ</h3>
      <p>Дистанційна освіта</p>
      <p>Академічна мобільність</p>
      <p>Перепідготовка (друга вища освіта)</p>
    </div>
    <div>
      <h3>ДЛЯ КОРИСТУВАЧІВ</h3>
      <p>Школяру</p>
      <p>Вступнику</p>
      <p>Першокурснику</p>
      <a href="tel:+555555555555"><i class="fa-solid fa-phone"></i></a>
      <a href="mailto:mail@example.com"><i class="fa-solid fa-envelope"></i></a>
      <a href="https://telegram.me/kondrasiuk"><i class="fa-brands fa-telegram"></i></a>
      <a href="https://wa.me/555555555"> <i class="fa-brands fa-whatsapp"></i></a>
    </div>
  </footer>
</template>

<script>
export default {
  name: "FooterComponent"
}
</script>

<style scoped>
footer p {
  color: lightgray;
}
footer {
  display: flex;
  justify-content: space-around;
  padding: 3px;
  background-color: royalblue;
  color: white;
  margin-top: 10%;
}
</style>