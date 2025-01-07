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
        <button @click="cambiarImagen(-1)" class="btn-navegacion">←</button>
        <button @click="cambiarImagen(1)" class="btn-navegacion">→</button>
      </div>
    </div>

    <!-- Información textual -->
    <div class="informacion">
      <p class="categoria">{{ vehiculo.categoria }}</p>
      <h2 class="titulo">{{ vehiculo.marca }} {{ vehiculo.modelo }}</h2>
      <div class="detalles">
        <div class="iconos">
          <div><span>🧑‍🤝‍🧑</span> {{ vehiculo.pasajeros }} Pasajeros</div>
          <div><span>🚘</span> {{ vehiculo.puertas }} Puertas</div>
          <div><span>🛢️</span> {{ vehiculo.combustible }}</div>
          <div><span>🔄</span> {{ vehiculo.transmision }}</div>
        </div>
        <div class="tarifa">
          <p class="tarifa-titulo">TARIFA DIARIA</p>
          <p class="tarifa-precio">💲{{ vehiculo.tarifaDiaria }}</p>
        </div>
        <!-- Aquí hemos reemplazado el botón por el router-link -->
        <router-link to="/login" class="btn-seleccionar">
          CONTINUAR CON MI RESERVA →
        </router-link>
        <div class="disponibilidad">
          ⚠️ Auto con disponibilidad limitada
        </div>
        <p class="nota-impuestos">Valores incluyen IVA (impuesto)</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CartaVehiculo",
  props: {
    vehiculo: {
      type: Object,
      required: true,
    },
  },
  methods: {
    seleccionarVehiculo() {
      this.$emit("seleccionar", this.vehiculo);
    },
    cambiarImagen(direccion) {
      console.log(`Cambiar imagen en dirección: ${direccion}`);
    },
  },
};
</script>

<style scoped>
.carta-vehiculo {
  display: flex;
  justify-content: space-between;
  border-radius: 12px;
  background: linear-gradient(135deg, #003366, #000000);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  overflow: hidden;
  padding: 20px;
  color: #ffffff;

}

.car-image {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40%;
}

.vehiculo-imagen {
  max-width: 100%;
  border-radius: 12px;
}

.navegacion-imagen {
  position: absolute;
  top: 50%;
  width: 100%;
  display: flex;
  justify-content: space-between;
  transform: translateY(-50%);
}

.btn-navegacion {
  background-color: rgba(0, 39, 77, 0.8);
  color: #fff;
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  cursor: pointer;
  transition: transform 0.2s ease;
}

.btn-navegacion:hover {
  transform: scale(1.1);
}

.informacion {
  width: 55%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.categoria {
  font-size: 1rem;
  text-transform: uppercase;
  letter-spacing: 2px;
  color: #ffcc00;
}

.titulo {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 16px;
}

.iconos {
  display: flex;
  justify-content: space-between;
  margin: 16px 0;
}

.iconos div {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 1.2rem;
}

.tarifa {
  text-align: center;
}

.tarifa-titulo {
  font-weight: bold;
}

.tarifa-precio {
  font-size: 1.5rem;
  color: #ffcc00;
  margin: 15px;
}

.btn-seleccionar {
  background-color: #FF4500;
  color: #000000;
  border: none;
  border-radius: 8px;
  padding: 12px;
  font-size: 1rem;
  cursor: pointer;
  margin-top: 10px;
  transition: background-color 0.3s ease;
}

.btn-seleccionar:hover {
  background-color: #cca300;
}

.disponibilidad {
  color: #d21009;
  padding: 8px;
  border-radius: 8px;
  font-size: 1rem;
  text-align: center;
  margin-top: 12px;
}

.nota-impuestos {
  font-size: 0.75rem;
  color: #cccccc;
  text-align: center;
}
</style>
