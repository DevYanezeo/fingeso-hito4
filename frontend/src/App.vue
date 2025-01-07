<template>
  <div id="app">
    <!-- Si es Admin, mostrar AdminNavbar -->
    <template v-if="isAdmin">
      <AdminNavbar />
    </template>

    <!-- Si está logueado pero no es Admin, mostrar UserLoggedNavbar -->
    <template v-else-if="isLoggedIn">
      <UserLoggedNavbar />
    </template>

    <!-- Si no está logueado, mostrar GeneralNavbar -->
    <template v-else>
      <GeneralNavbar />
    </template>

    <!-- Mostrar el contenido de las rutas -->
    <router-view />
    <Footer />
  </div>
</template>

<script>
import GeneralNavbar from './components/Layout/GuessNavbar.vue';
import Footer from './components/Layout/GeneralFooter.vue';
import UserLoggedNavbar from './components/Layout/UserLoggedNavbar.vue';
import AdminNavbar from './components/Layout/AdminNavbar.vue';

export default {
  name: 'App',
  components: {
    GeneralNavbar,
    UserLoggedNavbar,
    Footer,
    AdminNavbar,
  },
  computed: {
    // Verifica si el usuario está logueado a través del token
    isLoggedIn() {
      return !!localStorage.getItem('authToken');
    },
    // Verifica si el rol del usuario es admin
    isAdmin() {
      const userRole = localStorage.getItem('userRole');
      return userRole === 'admin' && this.isLoggedIn;
    },
    // Verifica si el rol del usuario es cliente
    isClient() {
      const userRole = localStorage.getItem('userRole');
      return userRole === 'cliente' && this.isLoggedIn;
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
