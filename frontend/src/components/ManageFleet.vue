<template>
  <div class="ManageFleet">
    <div class="content">
      <h2>Administrar Flota por Sucursal</h2>

      <!-- Selección de Sucursal -->
      <div class="form-group">
        <select id="sucursalSelect" v-model="selectedSucursalId">
          <option value="" disabled>Seleccione una sucursal</option>
          <option v-for="sucursal in sucursales" :key="sucursal.id" :value="sucursal.id">
            {{ sucursal.nombre }}
          </option>
        </select>
      </div>

      <!-- Botón de Búsqueda -->
      <button @click="buscarSucursal" :disabled="!selectedSucursalId" class="search-button">
        Buscar
      </button>

      <!-- Resultado de la búsqueda -->
      <div v-if="searchResults" class="search-results">
        <h3>Resultados de la búsqueda:</h3>
        <p><strong>Sucursal Seleccionada:</strong> {{ searchResults.nombre }}</p>
        <p><strong>Dirección:</strong> {{ searchResults.direccion }}</p>
        <p><strong>Teléfono:</strong> {{ searchResults.telefono }}</p>
        <p><strong>Email:</strong> {{ searchResults.email }}</p>

        <!-- Botón para ingresar un vehículo -->
        <button @click="abrirFormularioIngreso" class="btn-ingresar">Ingresar Vehículo</button>

        <!-- Agrupar vehículos por categoría -->
        <div v-if="agrupadosPorCategoria && Object.keys(agrupadosPorCategoria).length > 0">
          <div v-for="(vehiculosCategoria, categoria) in agrupadosPorCategoria" :key="categoria" class="categoria-container">
            <h4 class="categoria-titulo">{{ categoria }}</h4>
            <!-- Usar el componente CardCar para cada vehículo -->
            <div class="vehiculos-grid">
              <card-car 
                v-for="vehiculo in vehiculosCategoria" 
                :key="vehiculo.id" 
                :vehiculo="vehiculo" 
                @eliminar="eliminarVehiculo(vehiculo)" />
              </div>
          </div>
        </div>
        <!-- Mensaje si no hay vehículos en esta sucursal -->
        <p v-else>No hay vehículos en esta sucursal.</p>
      </div>

      <!-- Formulario de Ingreso de Vehículo (Flotante) -->
      <div v-if="formularioVisible" class="formulario-ingreso-overlay">
        <div class="formulario-ingreso">
          <h3>Formulario</h3>
          <form @submit.prevent="ingresarVehiculo">
            <div>
              <label for="patente">Patente</label>
              <input type="text" id="patente" v-model="nuevoVehiculo.patente" required>
            </div>
            <div>
              <label for="marca">Marca</label>
              <input type="text" id="marca" v-model="nuevoVehiculo.marca" required>
            </div>
            <div>
              <label for="modelo">Modelo</label>
              <input type="text" id="modelo" v-model="nuevoVehiculo.modelo" required>
            </div>
            <div>
              <label for="categoria">Categoría</label>
              <input type="text" id="categoria" v-model="nuevoVehiculo.categoria" required>
            </div>
            <div>
              <label for="estado">Estado</label>
              <input type="text" id="estado" v-model="nuevoVehiculo.estado" required>
            </div>
            <div>
              <label for="transmision">Transmisión</label>
              <input type="text" id="transmision" v-model="nuevoVehiculo.transmision" required>
            </div>
            <div>
              <label for="combustible">Combustible</label>
              <input type="text" id="combustible" v-model="nuevoVehiculo.combustible" required>
            </div>
            <div>
              <label for="sucursal">Sucursal</label>
              <select id="sucursal" v-model="nuevoVehiculo.sucursalId" required>
                <option v-for="sucursal in sucursales" :key="sucursal.id" :value="sucursal.id">
                  {{ sucursal.nombre }}
                </option>
              </select>
            </div>

            <button type="submit">Registrar Vehículo</button>
          </form>
          <button @click="cerrarFormularioIngreso">Cancelar</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import CardCar from './AdminCardCar.vue';  // Asegúrate de importar el componente CardCar

export default {
  name: 'ManageFleet',
  components: {
    CardCar  // Declarar el componente para su uso en este archivo
  },
  data() {
    return {
      sucursales: [], 
      selectedSucursalId: '',
      searchResults: null, 
      vehiculos: [], 
      formularioVisible: false, 
      nuevoVehiculo: {
        id: null,
        patente: '', 
        marca: '',
        modelo: '',
        categoria: '',
        estado: '',
        sucursalId: null,
        transmision: '',
        combustible: ''
      },
      agrupadosPorCategoria: {}
    };
  },
  mounted() {
    this.cargarSucursales();
  },
  methods: {
    // Carga las sucursales disponibles
    async cargarSucursales() {
      try {
        const response = await fetch('http://localhost:8080/api/sucursal');
        const data = await response.json();
        this.sucursales = data;
      } catch (error) {
        console.error('Error al cargar las sucursales:', error);
      }
    },
    // Busca detalles de la sucursal seleccionada y sus vehículos
    async buscarSucursal() {
      if (!this.selectedSucursalId) {
        return;
      }
      try {
        const sucursalResponse = await fetch(`http://localhost:8080/api/sucursal/${this.selectedSucursalId}`);
        const sucursalData = await sucursalResponse.json();
        this.searchResults = sucursalData;

        const vehiculosResponse = await fetch(`http://localhost:8080/api/vehiculo/sucursal/${this.selectedSucursalId}`);
        const vehiculosData = await vehiculosResponse.json();
        this.vehiculos = vehiculosData;
        this.agrupadosPorCategoria = this.agruparPorCategoria(this.vehiculos);
      } catch (error) {
        console.error('Error al buscar la sucursal o sus vehículos:', error);
      }
    },
    agruparPorCategoria(vehiculos) {
      return vehiculos.reduce((agrupados, vehiculo) => {
        const categoria = vehiculo.categoria || 'Sin categoría'; // Si no tiene categoría, asignamos 'Sin categoría'
        if (!agrupados[categoria]) {
          agrupados[categoria] = [];
        }
        agrupados[categoria].push(vehiculo);
        return agrupados;
      }, {});
    },
    // Abre el formulario de ingreso de vehículo
    abrirFormularioIngreso(vehiculo = null) {
      this.formularioVisible = true;
      if (vehiculo) {
        this.nuevoVehiculo = { ...vehiculo };
      } else {
        this.nuevoVehiculo = {
          id: null,
          patente: '',
          marca: '',
          modelo: '',
          categoria: '',
          estado: '',
          sucursalId: this.selectedSucursalId,
          transmision: '',
          combustible: ''
        };
      }
    },
    // Cierra el formulario de ingreso de vehículo
    cerrarFormularioIngreso() {
      this.formularioVisible = false;
    },
    // Envía los datos para registrar o modificar un vehículo
    async ingresarVehiculo() {
      try {
        let response;
        if (this.nuevoVehiculo.id) {
          response = await fetch(`http://localhost:8080/api/vehiculo/modificarVehiculo`, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              ...this.nuevoVehiculo,
              sucursal: { id: this.nuevoVehiculo.sucursalId }
            })
          });
        } else {
          response = await fetch('http://localhost:8080/api/vehiculo/registrarVehiculo', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              ...this.nuevoVehiculo,
              sucursal: { id: this.nuevoVehiculo.sucursalId }
            })
          });
        }

        if (response.ok) {
          const vehiculoGuardado = await response.json();
          if (this.nuevoVehiculo.id) {
            const index = this.vehiculos.findIndex(v => v.id === vehiculoGuardado.id);
            if (index !== -1) {
              this.vehiculos.splice(index, 1, vehiculoGuardado);
            }
          } else {
            this.vehiculos.push(vehiculoGuardado);
          }
          this.agrupadosPorCategoria = this.agruparPorCategoria(this.vehiculos);
          this.cerrarFormularioIngreso();
        } else {
          console.error('Error al guardar el vehículo');
        }
      } catch (error) {
        console.error('Error al ingresar/modificar el vehículo:', error);
      }
    },
    eliminarVehiculo(vehiculo) {
      if (confirm('¿Seguro que deseas eliminar este vehículo?')) {
        fetch(`http://localhost:8080/api/vehiculo/eliminarVehiculo/${vehiculo.id}`, {
          method: 'DELETE'
        })
          .then(response => {
            if (response.ok) {
              this.vehiculos = this.vehiculos.filter(v => v.id !== vehiculo.id);
              this.agrupadosPorCategoria = this.agruparPorCategoria(this.vehiculos);
            } else {
              console.error('Error al eliminar el vehículo');
            }
          })
          .catch(error => {
            console.error('Error al eliminar el vehículo:', error);
          });
      }
    }
  }
};
</script>


<style scoped>
/* Estilo para la clase principal del contenedor */
.ManageFleet {
  display: flex;
  justify-content: center;
  min-height: 100vh;
  background: #F4EDE4; /* Color de fondo suave */
  padding: 20px;
  box-sizing: border-box;
}

/* Contenido central */
.content {
  background: white;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 80%;  /* Usa un mayor porcentaje de ancho para dar espacio */
  max-width: 1200px; /* Limita el tamaño máximo */
  margin-top: 20px;
  height: 100%; /* Asegura que ocupe toda la altura de la ventana */

}

/* Título */
h2 {
  font-size: 2rem;
  color: #333;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center;
  letter-spacing: 1px;
  justify-self: center;
}

/* Estilo de los grupos de formulario */
.form-group {
  margin-bottom: 25px;
  width: 100%;
}

select,
input {
  width: 100%;
  padding: 12px;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 6px;
  background-color: #f9f9f9;
  color: #333;
}

select:focus,
input:focus {
  border-color: #003366;
  outline: none;
}

/* Estilo del botón de búsqueda */
.search-button {
  padding: 12px 24px;
  font-size: 1rem;
  color: white;
  background-color: #003366;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.search-button:hover {
  background-color: #0056b3;
}

.search-button:disabled {
  background-color: #d3d3d3;
  cursor: not-allowed;
}

/* Estilo de los resultados de la búsqueda */
.search-results {
  margin-top: 30px;
  background-color: #f2f2f2;
  padding: 15px;
  border-radius: 8px;
  width: 100%;
}

.categoria-container {
  margin-bottom: 30px; /* Espacio entre categorías */
}

.categoria-titulo {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 15px; /* Separación entre el título y las tarjetas */
}

.vehiculos-grid {
  display: flex;
  flex-wrap: wrap; /* Permite que las tarjetas se ajusten cuando no hay suficiente espacio en una fila */
  gap: 20px; /* Espacio entre las tarjetas */
}

.btn-modificar {
  background-color: #003366;
  color: white;
  border: none;
}

.btn-modificar:hover {
  background-color: #0056b3;
}

.btn-eliminar {
  background-color: #FF4500;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn-eliminar:hover {
  background-color: #FF6347;
}


.btn-ingresar {
  background-color: #FF4500;
  color: white;
  border: none;
  padding: 12px 24px;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 20px;
}

.btn-ingresar:hover {
  background-color: #FF6347;
}

.formulario-ingreso-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.formulario-ingreso {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
  width: 500px;
}

.formulario-ingreso input,
.formulario-ingreso select {
  width: 100%;
  padding: 8px;
  margin: 10px 0;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.formulario-ingreso button {
  width: 100%;
  background-color: #007bff;
  color: white;
}

.formulario-ingreso button[type="submit"] {
  width: 100%;
  background-color: #FF4500;
  color: white;
  padding: 13px 0; /* Aumenta la altura del botón */
  font-size: 14px; /* Aumenta el tamaño de la fuente */
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.formulario-ingreso button[type="submit"]:hover {
  background-color: #FF6347; /* Cambio de color al pasar el ratón */
}

.formulario-ingreso button {
  width: 100%;
  background-color: #FF4500; /* Color rojo para destacar el botón de cancelar */
  color: white;
  padding: 13px 0; /* Aumenta la altura del botón */
  font-size: 14px; /* Aumenta el tamaño de la fuente */
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 20px; /* Espacio entre el botón de cancelar y el formulario */
}

.formulario-ingreso button:hover {
  background-color: #FF6347; /* Cambio de color al pasar el ratón */
}

.btn-ingresar {
  background-color: #FF4500;
  margin-top: 20px;
}

</style>
