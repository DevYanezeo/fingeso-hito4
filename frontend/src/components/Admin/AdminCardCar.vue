<template>
  <div class="carta-vehiculo">
    <!-- Imagen del vehículo -->
    <div class="car-image">
      <img 
        v-if="vehiculo.imagenUrl" 
        :src="`/Vehiculos/${vehiculo.imagenUrl}`" 
        alt="Imagen del vehículo" 
        class="vehiculo-imagen" 
      />
      <div class="navegacion-imagen">
        <button @click="cambiarImagen(-1)" class="btn-navegacion">&lt;</button>
        <button @click="cambiarImagen(1)" class="btn-navegacion">&gt;</button>
      </div>
    </div>
    <!-- Botones para modificar y eliminar -->
    <div class="btn-container">
      <button @click="modificarVehiculo" class="btn-modificar">Modificar</button>
      <button @click="eliminarVehiculo" class="btn-eliminar">Eliminar</button>
    </div>
    <!-- Información textual -->
    <div class="informacion">
      <h2 class="categoria">Patente:{{ vehiculo.patente }}</h2>
      <h3 class="categoria">{{ vehiculo.categoria }}</h3>
      <h3 class="titulo">{{ vehiculo.marca }} {{ vehiculo.modelo }}</h3>
      <h4 class="categoria">Kilometraje: {{ vehiculo.kilometraje }}</h4>
      <div class="detalles">
        <div class="tarifa">
          <div class="iconos">
            <div><span>👥</span> {{ vehiculo.pasajeros }} Pasajeros</div>
            <div><span>🚪</span> {{ vehiculo.puertas }} Puertas</div>
            <div><span>⛽</span> {{ vehiculo.combustible }}</div>
            <div><span>⚙️</span> {{ vehiculo.transmision }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    vehiculo: {
      type: Object,
      required: true
    }
  },
  methods: {
    modificarVehiculo() {
      // Emite el evento para modificar el vehículo
      this.$emit('modificar', this.vehiculo);
    },
    eliminarVehiculo() {
      // Emite el evento para eliminar el vehículo
      this.$emit('eliminar', this.vehiculo);
    }
  }
};
</script>

<style scoped>
.carta-vehiculo {
  display: flex;
  justify-content: space-between;
  border: 1px solid #ccc;
  border-radius: 8px;
  overflow: hidden;
  background-color: #003366f4;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  height: 300px; /* Altura fija para todas las tarjetas */
  padding: 15px;
}

.car-image {
  position: relative;
  display: flex;
}

.vehiculo-imagen {
  max-width: 100%;
  height: auto;
  border-radius: 4px;
}

.navegacion-imagen {
  position: absolute;
  display: flex;
  justify-content: space-between;
  width: 100%;
  top: 50%;
  transform: translateY(-50%);
  padding: 0 10px;
}

.btn-navegacion {
  background-color: rgba(0, 0, 0, 0.5);
  color: #fff;
  border: none;
  border-radius: 50%;
  width: 32px;
  height: 32px;
  cursor: pointer;
}

.informacion {
  flex: 1;
  padding: 16px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color:#ffffffe0;
}

.titulo {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 16px;
  color:#ffffffe0;
}

.iconos {
  display: flex;
  flex-direction: row;
  margin-bottom: 16px;
}

.iconos div {
  display: flex;
  align-items: center;
  gap: 10px;
}

.tarifa-titulo {
  font-weight: bold;
  margin: 8px 0;
}

.tarifa-precio {
  font-size: 1.25rem;
  color: #003366;
  margin: 8px 0;
}

.botones { 
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.btn-modificar {
  background-color: #000000d8;
  color: #fff;
  border: none;
  padding: 12px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
}

.btn-eliminar {
  background-color: #e21616d8;
  color: #fff;
  border: none;
  padding: 12px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
}


.texto-disponibilidad {
  color: #d9534f;
  font-size: 0.875rem;
  margin-top: 16px;
}

.nota-impuestos {
  color: #6c757d;
  font-size: 0.75rem;
  margin-top: 8px;
}
</style>
