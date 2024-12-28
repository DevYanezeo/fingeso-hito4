<template>
  <div class="Reception">
    <div class="container">
      <h2>Recepción de Vehiculos</h2>
      <!-- Formulario para consultar el vehículo por patente -->
      <div class="search-form">
        <label for="patente">Patente del vehículo:</label>
        <input
          type="text"
          id="patente"
          v-model="vehiculo.patente"
          placeholder="Ingrese la patente"
        />
        <button class="btn-primary" @click="consultarVehiculo">
          Consultar Vehículo
        </button>
      </div>

      <!-- Mostrar el formulario si el vehículo es encontrado -->
      <div v-if="vehiculoEncontrado" class="vehicle-form">
        <h3>Detalles del Vehículo</h3>
        <form>
          <div class="form-group">
            <label for="estado">Estado (Disponible - Fuera de Servicio):</label>
            <input
              type="text"
              id="estado"
              v-model="vehiculo.estado"
              placeholder="Ingrese el estado"
            />
          </div>

          <div class="form-group">
            <label for="combustible">Combustible (1/8):</label>
            <input
              type="number"
              id="combustible"
              v-model="vehiculo.combustible"
              placeholder="Ingrese el nivel de combustible"
            />
          </div>

          <div class="form-group">
            <label for="kilometraje">Kilometraje:</label>
            <input
              type="number"
              id="kilometraje"
              v-model="vehiculo.kilometraje"
              placeholder="Ingrese el kilometraje"
            />
          </div>

          <!-- Botón para procesar la recepción del vehículo -->
          <button class="btn-secondary" @click.prevent="recepcionarVehiculo">
            Procesar Recepción
          </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      vehiculo: {
        patente: "",
        estado: "",
        combustible: "",
        kilometraje: "",
      },
      vehiculoEncontrado: false, // Controlar si se muestra el formulario
    };
  },
  methods: {
    // Método para consultar el vehículo por patente
    async consultarVehiculo() {
      if (!this.vehiculo.patente) {
        alert("Por favor, ingrese una patente.");
        return;
      }

      try {
        const response = await axios.get(
          `http://localhost:8080/api/vehiculo/${this.vehiculo.patente}`
        );

        // Si la respuesta es exitosa, mostrar los datos en consola y habilitar el formulario
        console.log("Vehículo encontrado:", response.data);
        this.vehiculo = {
          patente: response.data.patente,
          estado: response.data.estado,
          combustible: response.data.combustible,
          kilometraje: response.data.kilometraje,
        };
        this.vehiculoEncontrado = true; // Mostrar el formulario
      } catch (error) {
        // Manejo de errores
        if (error.response && error.response.status === 404) {
          alert("Vehículo no encontrado.");
        } else {
          console.error("Error al consultar el vehículo:", error);
          alert("Hubo un error al consultar el vehículo.");
        }
        this.vehiculoEncontrado = false;
      }
    },

    // Método para actualizar la recepción del vehículo
    async recepcionarVehiculo() {
      if (!this.vehiculoEncontrado) {
        alert("Primero debe buscar un vehículo válido.");
        return;
      }

      try {
        const response = await axios.put(
          `http://localhost:8080/api/vehiculo/recepcionVehiculo/${this.vehiculo.patente}`,
          {
            estado: this.vehiculo.estado,
            combustible: this.vehiculo.combustible,
            kilometraje: this.vehiculo.kilometraje,
          }
        );

        // Si la respuesta es exitosa, mostrar mensaje y actualizar consola
        console.log("Vehículo actualizado exitosamente:", response.data);
        alert("Recepción del vehículo procesada correctamente.");
      } catch (error) {
        // Manejo de errores
        if (error.response && error.response.status === 404) {
          alert("No se pudo procesar la recepción, vehículo no encontrado.");
        } else {
          console.error("Error al recepcionar el vehículo:", error);
          alert("Hubo un error al procesar la recepción del vehículo.");
        }
      }
    },
  },
};
</script>

<style scoped>

/* General Container */

.Reception {
  display: flex;
  justify-content: center;
  min-height: 100vh; /* Asegura que ocupe toda la altura de la ventana */
  background: #F4EDE4; /* Color de fondo suave */
  padding: 20px;
  box-sizing: border-box;
}
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  padding: 2rem;
  background-color: #f9f9f9;
  height: 80%;
  font-family: Arial, sans-serif;
}

/* Formulario de búsqueda */
.search-form {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 2rem;
}

.search-form label {
  font-weight: bold;
  color: #333;
}

.search-form input {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1rem;
}

.search-form .btn-primary {
  background-color: #003366;
  color: white;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.search-form .btn-primary:hover {
  background-color: #002244;
}

/* Formulario de vehículo */
.vehicle-form {
  background-color: white;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 500px;
}

.vehicle-form h3 {
  text-align: center;
  color: #003366;
  margin-bottom: 1rem;
}

.vehicle-form .form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}

.vehicle-form .form-group label {
  font-weight: bold;
  margin-bottom: 0.5rem;
  color: #333;
}

.vehicle-form .form-group input {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1rem;
}

/* Botones */
.vehicle-form .btn-secondary {
  background-color: #ff4500;
  color: white;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.vehicle-form .btn-secondary:hover {
  background-color: #cc3700;
}
</style>