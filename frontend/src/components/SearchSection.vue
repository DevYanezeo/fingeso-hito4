<template>
  <div class="search-form">
    <h2>Reservar Un Vehículo</h2>
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
  <div v-if="vehiculos.length" class="results">
  <div class="results-container">
    <h3>Vehículos Disponibles</h3>
    <div v-if="agrupadosPorCategoria && Object.keys(agrupadosPorCategoria).length > 0">
      <div v-for="(vehiculosCategoria, categoria) in agrupadosPorCategoria" :key="categoria" class="categoria-container">
        <div class="vehiculos-grid">
          <card-car v-for="vehiculo in vehiculosCategoria" :key="vehiculo.id" :vehiculo="vehiculo" />
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import CardCar from './UserCardCar.vue'; // Asegúrate de importar el componente CardCar

export default {
  name: "BuscarVehiculos",
  components: {
    CardCar,
  },
  data() {
    return {
      sucursales: [], // Lista de sucursales
      selectedSucursalRetiro: '', // Sucursal de retiro seleccionada
      selectedSucursalDevolucion: '', // Sucursal de devolución seleccionada
      pickupDate: '', // Fecha de retiro
      returnDate: '', // Fecha de devolución
      selectedVehicleType: '', // Tipo de vehículo seleccionado
      tiposVehiculo: [], // Lista de tipos de vehículos
      vehiculos: [], // Lista de vehículos encontrados
      agrupadosPorCategoria: {}, // Vehículos agrupados por categoría
    };
  },
  methods: {
    // Función para cargar las sucursales
    async cargarSucursales() {
      try {
        const response = await fetch('http://localhost:8080/api/sucursal');
        const data = await response.json();
        this.sucursales = data;
      } catch (error) {
        console.error('Error al cargar las sucursales:', error);
      }
    },

    // Función para cargar los tipos de vehículos
    async cargarCategorias() {
      try {
        const response = await fetch('http://localhost:8080/api/vehiculo/tipos');
        const data = await response.json();
        this.tiposVehiculo = data;
      } catch (error) {
        console.error('Error al cargar las categorías:', error);
      }
    },

    // Función para buscar vehículos disponibles
    async buscarVehiculos() {
      if (!this.selectedSucursalRetiro) {
        console.error('Debe seleccionar una sucursal de retiro');
        return;
      }

      try {
        const response = await fetch(`http://localhost:8080/api/vehiculo/sucursal/${this.selectedSucursalRetiro}`);
        const data = await response.json();
        this.vehiculos = data;

        // Agrupar vehículos por categoría
        this.agrupadosPorCategoria = this.agruparPorCategoria(this.vehiculos);
      } catch (error) {
        console.error('Error al buscar los vehículos:', error);
      }
    },

    // Función para agrupar vehículos por categoría
    agruparPorCategoria(vehiculos) {
      return vehiculos.reduce((agrupados, vehiculo) => {
        const categoria = vehiculo.categoria || 'Sin categoría';
        if (!agrupados[categoria]) {
          agrupados[categoria] = [];
        }
        agrupados[categoria].push(vehiculo);
        return agrupados;
      }, {});
    },
  },
  mounted() {
    // Cargar datos al montar el componente
    this.cargarSucursales();
  },
};
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
  flex-wrap: wrap;  
  justify-content: space-around;

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
  padding: 10px 60px;  /* Aumenta el padding horizontal para hacerlo más largo */
  border: none;
  border-radius: 8px;  /* Elimina los bordes redondeados */
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s ease, transform 0.3s ease;
} 

.form-button {
  display: flex;
  height: 40px;
  margin-top: 40px; /* Ajusta el valor según lo necesario */
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
  gap: 10px;
}

.search-form .vehiculos-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 10px;
  justify-items: center;
}

.search-form .vehiculos-grid .card-car {
  margin-top: 10px; /* Añadir un poco de espacio entre el título y la tarjeta */
}

.results {
  display: flex;
  justify-content: center; /* Centra horizontalmente el contenido */
  margin-top: 30px;
}

.results-container {
  background-image: url('/fondo.png'); /* Color de fondo elegante */
  padding: 20px; /* Espaciado interno */
  border-radius: 10px; /* Bordes redondeados */
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); /* Sombra para darle profundidad */
  max-width: 100%; /* Máximo ancho para pantallas grandes */
  box-sizing: border-box;
}

.categoria-container {
  display: flex;
  flex-direction: column; /* Apilar los elementos en columna */
  align-items: center; /* Centrar horizontalmente */
  margin-bottom: 30px;
}

.vehiculos-grid {
  display: flex;
  gap: 40px;
  flex-wrap: wrap;
  justify-content: center; /* Centrar los vehículos dentro de la grid */
}

</style>
