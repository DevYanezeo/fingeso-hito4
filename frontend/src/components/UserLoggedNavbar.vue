<template>
    <nav class="navBar">
      <div class="logo">
        <!-- Envolvemos tanto la imagen como el título en un router-link -->
        <router-link to="/">
          <img alt="logo" src="@/assets/logo.png" />
        </router-link>
      </div>
      
      <!-- Título dentro de un router-link para hacerlo clickeable -->
      <router-link to="/">
        <h1 class="navbar-title">AutoRentasChile</h1>
      </router-link>
  
      <div class="navLinks">
        <div class="nav-link-container">
          <router-link to="/profile" class="nav-link">Mi Perfil</router-link>
        </div>
        <div class="nav-link-container">
          <router-link to="/flota" class="nav-link">Mis reservas</router-link>
        </div>
        <div class="nav-link-container">
          <router-link to="/sucursales" class="nav-link">Sucursales</router-link>
        </div>
        <div class="nav-link-container">
          <router-link to="/workWithUs" class="nav-link">Trabaja Con Nosotros</router-link>
        </div>
        <div class="nav-link-container">
          <router-link to="/" class="nav-link" @click.prevent="logout">Cerrar Sesión</router-link>
        </div>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'NavbarLogged',
    methods: {
      logout() {
        localStorage.removeItem('authToken');  // Elimina el token de localStorage
        this.$router.push('/');  // Redirige al usuario a la página de inicio
      }
    }
  };
  </script>
  
  <style scoped>
  /* Estilos generales del navbar */
  .navBar {
    display: flex;
    justify-content: space-around; /* Distribuye los elementos entre el inicio y el final */
    align-items: center;            /* Alinea los elementos verticalmente al centro */
    background-color: #003366;
    color: white;
    padding: 3px 3px; /* Espacio en el navbar */
  }
  
  /* Logo y título */
  .navBar .logo {
    margin-right: 10px; /* Espacio entre el logo y el título */
  }
  
  .navBar .logo img {
    height: 140px; /* Ajusta el tamaño del logo */
  }
  
  .navbar-title {
    font-size: 32px;
    font-weight: 600;
    color: white;
    text-transform: uppercase; /* Pone el título en mayúsculas */
    letter-spacing: 1px; 
    margin-right: 150px; 
    padding-right: 40px;
  }
  
  .navbar-title, .logo img {
    cursor: pointer;  
  }
  
  /* Enlaces de navegación */
  .navLinks {
    display: flex; /* Usamos flexbox para distribuir los enlaces */
    justify-content: space-evenly; /* Distribuye los elementos uniformemente */
    gap: 25px; /* Espacio uniforme entre los enlaces */
    text-transform: uppercase; /* Pone el título en mayúsculas */
  }
  
  .nav-link-container {
    display: flex;
    justify-content: center;
  }
  
  .nav-link {
    color: #fff;
    text-decoration: none;
    font-size: 16px;
    padding-bottom: 5px; 
  }
  
  .nav-link::after {
    left: 0;
    bottom: 0;
    width: 0%;
    height: 2px;
    background-color: #FF4500;
    transition: width 0.3s ease;
  }
  
  .nav-link:hover::after {
    width: 100%;
  }
  
  .nav-link:hover {
    color: #FF6347; /* Cambia el color del texto al pasar el cursor */
  }
  </style>
  