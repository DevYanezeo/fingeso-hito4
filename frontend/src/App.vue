<template>
  <div id="app">
    <template v-if="isAdmin">
      <AdminNavbar />
    </template>
    <template v-else-if="isLoggedIn">
      <UserLoggedNavbar />
    </template>
    <template v-else>
      <GeneralNavbar />
    </template>
    <router-view />
    <Footer />
  </div>
</template>

<script>
import GeneralNavbar from './components/GuessNavbar.vue';
import Footer from './components/GeneralFooter.vue';
import UserLoggedNavbar from './components/UserLoggedNavbar.vue';
import AdminNavbar from './components/AdminNavbar.vue';

export default {
  name: 'App',
  components: {
    UserLoggedNavbar,
    GeneralNavbar,
    Footer,
    AdminNavbar,
  },
  computed: {
    isLoggedIn() {
      // Verifica si hay un token en localStorage
      return !!localStorage.getItem('authToken');
    },
    isAdmin() {
      // Verifica si el correo es el del admin y si el token está presente
      const userEmail = localStorage.getItem('userEmail');
      return userEmail === 'admin@autorentas.cl' && this.isLoggedIn;
    }
  }
};
</script>

<style>
body {
  background-color: #D3D3D3; 
  margin: 0;
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}

.header {
  width: 100%;
  display: flex;
  align-items: center;
  position: relative;
  height: 150px;
  background-color: #003366;
}

.footer {
  text-align: center;
  background-color: #C2DFE3;
}
</style>
