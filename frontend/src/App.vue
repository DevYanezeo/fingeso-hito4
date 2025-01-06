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
import GeneralNavbar from './components/Layout/GuessNavbar.vue';
import Footer from './components/Layout/GeneralFooter.vue';
import UserLoggedNavbar from './components/Layout/UserLoggedNavbar.vue';
import AdminNavbar from './components/Layout/AdminNavbar.vue';

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
      // Verifica si el rol es admin
      const userRole = localStorage.getItem('userRole');
      return userRole === '2'; // Si el rol es 2, es admin
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
