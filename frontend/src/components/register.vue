<template>
    <div class="register-container">
      <h2 class="register-title">Registro de Cuenta</h2>
      <form @submit.prevent="submitForm" class="register-form">
        <div class="form-group">
          <label for="first-name">Nombre *</label>
          <input 
            type="text" 
            id="first-name" 
            v-model="firstName" 
            placeholder="Ingresa tu nombre"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="last-name">Apellido *</label>
          <input 
            type="text" 
            id="last-name" 
            v-model="lastName" 
            placeholder="Ingresa tu apellido"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="rut">RUT *</label>
          <input 
            type="text" 
            id="rut" 
            v-model="rut" 
            placeholder="Ingresa tu RUT"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="birthdate">Fecha de Nacimiento *</label>
          <input 
            type="date" 
            id="birthdate" 
            v-model="birthdate" 
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="email">Correo Electrónico *</label>
          <input 
            type="email" 
            id="email" 
            v-model="email" 
            placeholder="Ingresa tu correo"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="phone">Teléfono *</label>
          <input 
            type="tel" 
            id="phone" 
            v-model="phone" 
            placeholder="Ingresa tu teléfono"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="password">Contraseña *</label>
          <input 
            type="password" 
            id="password" 
            v-model="password" 
            placeholder="Crea una contraseña"
            required 
          />
        </div>
  
        <div class="form-group">
          <label for="confirm-password">Confirmar Contraseña *</label>
          <input 
            type="password" 
            id="confirm-password" 
            v-model="confirmPassword" 
            placeholder="Confirma tu contraseña"
            required 
          />
        </div>
  
        <div class="form-actions">
          <button type="submit" class="register-button">Crear Cuenta</button>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    name: "Register",
    data() {
      return {
        firstName: "",
        lastName: "",
        rut: "",
        birthdate: "",
        email: "",
        phone: "",
        password: "",
        confirmPassword: "",
      };
    },
    methods: {
      async submitForm() {
        if (this.password !== this.confirmPassword) {
          alert("Las contraseñas no coinciden");
          return;
        }
  
        // Preparamos los datos para enviar al backend
        const userData = {
          rutUsuario: this.rut,
          nombreUsuario: `${this.firstName} ${this.lastName}`,  // Concatenamos nombre y apellido
          email: this.email,
          celularUsuario: this.phone,
          passwordUsuario: this.password,
          direccionUsuario: "",  // Aquí puedes agregar un campo de dirección si es necesario
          sucursalDeTrabajo: "",  // Aquí puedes agregar un campo para la sucursal si es necesario
          rolEmpleado: "cliente",  // Puedes cambiar este valor dependiendo del rol
          tipoUsuario: "c",  // Tipo de usuario (por ejemplo, 'c' para cliente)
          fechaNacimiento: this.birthdate,
        };
  
        try {
          // Realizamos la solicitud POST al backend
          const response = await axios.post("http://localhost:8080/api/usuarios/registrar", userData);
          
          // Verificamos la respuesta
          if (response.data) {
            alert("Usuario registrado exitosamente");
            console.log(response.data);
          }
        } catch (error) {
          console.error("Hubo un error al registrar el usuario:", error);
          alert("Hubo un error al registrar el usuario. Intenta de nuevo.");
        }
      },
    },
  };
  </script>
  
  
  <style scoped>
  .register-container {
    max-width: 450px;
    margin: 50px auto;
    padding: 30px;
    background: #F4EDE4 ;
    border-radius: 10px;
    box-shadow: 0 12px 20px rgba(0, 0, 0, 0.15);
    font-family: 'Arial', sans-serif;
}

  .register-title {
    text-align: center;
    margin-bottom: 20px;
    color: #003366;
    font-size: 28px;
    font-weight: bold;
    letter-spacing: 1px;
  }
  
  .register-form {
    display: flex;
    flex-direction: column;
    gap: 5px;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  .form-group label {
    font-weight: bold;
    color: #333;
  }
  
  .form-group input {
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
    width: 100%;
  }
  
  .form-group input:focus {
    border-color: #003366;
    outline: none;
  }
  
  .form-actions {
    display: flex;
    justify-content: center;
  }
  
  .register-button {
    background-color: #003366;
    color: white;
    padding: 12px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
  }
  
  .register-button:hover {
    background-color: #00509e;
  }
  </style>
  