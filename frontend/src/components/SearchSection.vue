<template>
  <div class="search-form">
    <h2>Arrendar Un Vehículo</h2>
    <form>
      <!-- Sucursal de Retiro -->
      <div class="form-group">
        <label for="pickup">Sucursal de Retiro</label>
        <select id="pickup" v-model="selectedSucursalRetiro">
          <option value="" disabled>Seleccione una sucursal</option>
          <option v-for="sucursal in sucursales" :key="sucursal.id" :value="sucursal.id">
            {{ sucursal.nombre }}
          </option>
        </select>
      </div>

      <!-- Fecha de Retiro -->
      <div class="form-group">
        <label for="pickup-date">Fecha de Retiro</label>
        <input type="date" id="pickup-date" v-model="pickupDate" />
      </div>

      <!-- Fecha de Devolución -->
      <div class="form-group">
        <label for="return-date">Fecha de Devolución</label>
        <input type="date" id="return-date" v-model="returnDate" />
      </div>

      <!-- Tipo de Vehículo -->
      <div class="form-group">
        <label for="vehicle-type">Tipo de Vehículo</label>
        <select id="vehicle-type" v-model="selectedVehicleType">
          <option value="" disabled>Seleccione un tipo</option>
          <option v-for="tipo in tiposVehiculo" :key="tipo" :value="tipo">
            {{ tipo }}
          </option>
        </select>
      </div>

      <!-- Sucursal de Devolución -->
      <div class="form-group">
        <label for="return-pickup">Sucursal de Devolución</label>
        <select id="return-pickup" v-model="selectedSucursalDevolucion">
          <option value="" disabled>Seleccione una sucursal</option>
          <option v-for="sucursal in sucursales" :key="sucursal.id" :value="sucursal.id">
            {{ sucursal.nombre }}
          </option>
        </select>
      </div>

      <!-- Botón de Buscar -->
      <div class="form-button">
        <button type="submit" @click.prevent="buscarVehiculos">Buscar</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

// Variables reactivas
const sucursales = ref([]);
const selectedSucursalRetiro = ref('');
const selectedSucursalDevolucion = ref('');
const pickupDate = ref('');
const returnDate = ref('');
const selectedVehicleType = ref('');
const tiposVehiculo = ref('');

// Función para cargar las sucursales
const cargarSucursales = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/sucursal');
    const data = await response.json();
    sucursales.value = data;
  } catch (error) {
    console.error('Error al cargar las sucursales:', error);
  }
};

//Funcion para cargar las categorias de vehiculos
const cargarCategorias = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/vehiculo');
    const data = await response.json();
    selectedVehicleType.value = data;
  } catch (error) {
    console.error('Error al cargar las categorias:', error);
  }
};

// Función para buscar vehículos disponibles
const buscarVehiculos = () => {
  console.log('Sucursal de Retiro:', selectedSucursalRetiro.value);
  console.log('Sucursal de Devolución:', selectedSucursalDevolucion.value);
  console.log('Fecha de Retiro:', pickupDate.value);
  console.log('Fecha de Devolución:', returnDate.value);
  console.log('Tipo de Vehículo:', selectedVehicleType.value);
  // Aquí puedes implementar la lógica para enviar la solicitud al backend
};

// Hook del ciclo de vida para cargar datos al montar el componente
onMounted(() => {
  cargarSucursales();
  cargarCategorias();
});
</script>


<style scoped>
.search-form {
  position: relative;
  background-color: #003366;
  padding: 30px;
  border-radius: 10px;
  width: 98%;
  box-sizing: border-box;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.search-form h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #fff;
  font-size: 24px;
  font-weight: 600;
}

.search-form form {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;  /* Permite que los elementos se acomoden mejor */
  gap: 20px;
}

.search-form .form-group {
  width: 200px;
  display: flex;
  flex-direction: column;
  gap: 8px;
  padding: 10px;
  justify-content: center;

}

.search-form label {
  font-weight: bold;
  color: #fff;
  font-size: 14px;
}

.search-form input, .search-form select {
  padding: 12px;
  border-radius: 8px;
  border: 1px solid #e1e1e1;
  font-size: 14px;
  transition: border 0.3s ease;
  width: 100%;
}

.search-form input[type="date"] {
  width: 100%;
}

.search-form input:focus, .search-form select:focus {
  border-color: #00c853; /* Color verde cuando está enfocado */
  outline: none;
}

.search-form button {
  background-color: #FF4500;
  color: white;
  padding: 10px 50px;  /* Aumenta el padding horizontal para hacerlo más largo */
  border: none;
  border-radius: 8px;  /* Elimina los bordes redondeados */
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s ease, transform 0.3s ease;
} 


.search-form button:hover {
  background-color: #00796b;
  transform: scale(1.05); /* Efecto de animación */
}

.search-form button:active {
  background-color: #004d40;
}

.search-form .checkbox {
  display: flex;
  align-items: center;
  gap: 10px;
}

.search-form .form-button {
  display: flex;
  justify-content: center;
  height: 40px;
  padding-left: 80px;
  margin-top: 40px;
}
</style>
