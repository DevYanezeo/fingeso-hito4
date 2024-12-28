<template>
  <div class="login-container">
    <h2 class="login-title">Iniciar Sesión</h2>

    <form @submit.prevent="submitForm" class="login-form">
      <div class="form-group">
        <label for="email">Correo Electrónico</label>
        <div class="input-wrapper">
          <span class="input-icon">📧</span>
          <input 
            type="email" 
            id="email" 
            v-model="email" 
            placeholder="Ingresa tu correo"
            required 
          />
        </div>
      </div>

      <div class="form-group">
        <label for="password">Contraseña</label>
        <div class="input-wrapper">
          <span class="input-icon">🔒</span>
          <input 
            type="password" 
            id="password" 
            v-model="password" 
            placeholder="Ingresa tu contraseña"
            required 
          />
        </div>
      </div>

      <div class="form-actions">
        <button type="submit" class="login-button">Iniciar Sesión</button>
      </div>

      <div class="register-link">
        <p>¿No tienes una cuenta? <router-link to="/Register">Regístrate aquí</router-link></p>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    submitForm() {
      // Definir las credenciales válidas
      const validEmailAdmin = 'admin@autorentas.cl';
      const validPasswordAdmin = 'admin';

      const validEmailCliente = 'usuario@dominio.com'; // Ejemplo de cliente
      const validPasswordCliente = '12345'; // Ejemplo de cliente

      // Simular autenticación
      if (this.email === validEmailAdmin && this.password === validPasswordAdmin) {
        // Si las credenciales son correctas, guardamos el token y el correo
        localStorage.setItem('authToken', 'token-de-autenticacion');
        localStorage.setItem('userEmail', this.email); // Guardar el correo en localStorage
        localStorage.setItem('userRole', 'admin'); // Guardar el rol de administrador

        // Redirigir al usuario al Admin Dashboard
        this.$router.push('/AdminDashboard');
      } else if (this.email === validEmailCliente && this.password === validPasswordCliente) {
        // Si las credenciales son correctas para un cliente, guardamos el token y el correo
        localStorage.setItem('authToken', 'token-de-autenticacion');
        localStorage.setItem('userEmail', this.email); // Guardar el correo en localStorage
        localStorage.setItem('userRole', 'cliente'); // Guardar el rol de cliente

        // Redirigir al usuario a la página UserLogged
        this.$router.push('/UserLogged');
      } else {
        alert('Correo o contraseña incorrectos.');
      }
    }
  }
};
</script>


<style scoped>
/* Contenedor principal */
.login-container {
  max-width: 450px;
  margin: 50px auto;
  padding: 30px;
  background: #F4EDE4 ;
  border-radius: 10px;
  box-shadow: 0 12px 20px rgba(0, 0, 0, 0.15);
  font-family: 'Arial', sans-serif;
}

/* Título */
.login-title {
  text-align: center;
  margin-bottom: 20px;
  color: #003366;
  font-size: 28px;
  font-weight: bold;
  letter-spacing: 1px;
}

/* Estilo general del formulario */
.login-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

/* Grupo de formularios */
.form-group label {
  font-weight: bold;
  margin-bottom: 8px;
  color: #003366;
}

.form-actions {
  display: flex; /* Usamos flexbox */
  justify-content: center; /* Centra horizontalmente */
  align-items: center; /* Centra verticalmente */
}

/* Wrapper de input con íconos */
.input-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.input-icon {
  position: absolute;
  left: 10px;
  font-size: 18px;
  color: #aaa;
}

.input-wrapper input {
  padding: 10px 10px 10px 35px; /* Espaciado para el ícono */
  font-size: 16px;
  border-radius: 5px;
  border: 1px solid #ccc;
  width: 100%;
}

.input-wrapper input:focus {
  border-color: #003366;
  outline: none;
}

/* Botón de inicio de sesión */
.login-button {
  background-color: #003366;
  color: white;
  padding: 12px;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
}

.login-button:hover {
  background-color: #00509e;
}

/* Registro */
.register-link {
  text-align: center;
  font-size: 14px;
}

.register-link a {
  color: #003366;
  text-decoration: none;
}

.register-link a:hover {
  text-decoration: underline;
}
</style>
