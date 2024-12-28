<template>
    <div class="profile-container">
      <!-- Columna Izquierda -->
      <section class="sidebar">
        <div class="button-container">
          <button @click="goToSection('home')">Home</button>
          <button @click="goToSection('personalData')">Datos Personales</button>
          <button @click="goToSection('bookingHistory')">Historial de Reservas</button>
          <button @click="goToSection('changePassword')">Cambiar Contraseña</button>
        </div>
      </section>
  
      <!-- Contenido Principal -->
      <section class="content">
        <div class="section-header">
          <h2>{{ currentSectionTitle }}</h2>
        </div>
        <div class="section-content">
          <p v-if="currentSection === 'home'">Bienvenido a tu perfil.</p>
          <p v-if="currentSection === 'personalData'">Aquí puedes actualizar tus datos personales.</p>
          <p v-if="currentSection === 'bookingHistory'">Aquí está tu historial de reservas.</p>
          <p v-if="currentSection === 'changePassword'">Aquí puedes cambiar tu contraseña.</p>
        </div>
      </section>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Profile',
    data() {
      return {
        currentSection: 'home', // Sección actual por defecto
      };
    },
    computed: {
      currentSectionTitle() {
        const titles = {
          home: 'Inicio',
          personalData: 'Datos Personales',
          bookingHistory: 'Historial de Reservas',
          changePassword: 'Cambiar Contraseña',
        };
        return titles[this.currentSection] || 'Perfil';
      },
    },
    methods: {
      goToSection(section) {
        this.currentSection = section;
      },
    },
  };
  </script>
  
  <style scoped>
  /* Contenedor principal */
  .profile-container {
    display: flex;
    min-height: 100vh;
    background-color: #f4f4f4;
    font-family: Arial, sans-serif;
  }
  
  /* Sidebar */
  .sidebar {
    flex: 1; /* Ocupa 1 parte del espacio */
    background-color: #003366;
    color: white;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }
  
  .button-container {
    display: flex;
    flex-direction: column;
    gap: 15px;
    width: 100%;
  }
  
  button {
    background-color: white;
    color: #003366;
    border: none;
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
    text-align: left;
  }
  
  button:hover {
    background-color: #00509e;
    color: white;
  }
  
  /* Contenido principal */
  .content {
    flex: 2; /* Ocupa 2 partes del espacio */
    padding: 20px;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .section-header {
    background-color: #00509e;
    color: white;
    padding: 10px;
    border-radius: 5px;
  }
  
  .section-content {
    background-color: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  }
</style>
  