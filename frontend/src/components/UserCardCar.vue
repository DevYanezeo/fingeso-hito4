<template>
  <div class="tarjeta">
    <!-- Contenedor con los datos importantes del vehículo -->
    <div class="info-vehiculo">
      <div class="imagenes">
        <img 
          v-if="vehiculo.imagenUrl" 
          :src="`/Vehiculos/${vehiculo.imagenUrl}`" 
          alt="Imagen del vehículo" 
          class="vehiculo-imagen" 
        />
      </div>
      <div class="nombres">
        <p class="marca-modelo">{{ vehiculo.marca }} {{ vehiculo.modelo }}</p>
        <p v-if="vehiculo.descripcion" class="descripcion">{{ vehiculo.descripcion }}</p>
      </div>

    </div>

    <!-- Detalles adicionales del vehículo -->
    <div class="detalles">
      <div class="tarifa">
        <div class="iconos">
          <div><span>👥</span> {{ vehiculo.pasajeros }} Pasajeros</div>
          <div><span>🚪</span> {{ vehiculo.puertas }} Puertas</div>
          <div><span>⛽</span> {{ vehiculo.combustible }}</div>
          <div><span>⚙️</span> {{ vehiculo.transmision }}</div>
        </div>
        <p class="tarifa-titulo">TARIFA DIARIA</p>
        <p class="tarifa-precio">${{ vehiculo.tarifaDiaria }}</p>
        <button class="btn-seleccionar" @click="seleccionarVehiculo">RESERVAR</button>
        <p class="terminos">Términos y condiciones</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardCar",
  props: {
    vehiculo: {
      type: Object,
      required: true,
    },
  },
  methods: {
    seleccionarVehiculo() {
      // Método para manejar el clic en "Seleccionar"
      this.$emit("seleccionar", this.vehiculo);
    },
  },
};
</script>

<style scoped>
.tarjeta {
  display: flex;
  justify-content: space-between;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 10px;
  background-color: white;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  gap: 40px;
  width: 80%;
}

.info-vehiculo {
  flex: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.imagenes {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 20px;
  font-weight: bold;
  background-color: #e7e7e793;
  padding: 20px;
  max-width: 100px;
  max-height: 100px;
  border: 0.5px solid #00000019;
  border-radius: 6px;


}
.imagenes img {
  width: 100%;
  height: 100%;
  border-radius: 8px;
  margin-bottom: 16px;
  padding: 10px;
  margin: 30px;
}

.nombres {
  text-align: center;
}

.nombres .marca-modelo {
  font-weight: bold;
  font-size: 16px;
  color: #333;
}

.detalles {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.iconos {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  margin-top: 16px;
}

.iconos div {
  font-size: 16px;
  color: #000;
  margin-right: 16px;
}

.tarifa {
  background-color: #e7e7e7;
  padding: 16px;
  border-radius: 8px;
  width: 100%;
  text-align: center;
  border: 0.5px solid #00000065;
  border-radius: 6px;
}

.tarifa-titulo {
  font-weight: bold;
  margin: 8px 0;
  font-size: 18px;
}

.tarifa-precio {
  color: #e60000;
  font-size: 18px;
  font-weight: bold;
}

.tarifa-sin-iva {
  font-size: 12px;
  color: #777;
}

.btn-seleccionar {
  background-color: #e60000;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  margin-top: 16px;
}

.btn-seleccionar:hover {
  background-color: #cc0000;
}

.terminos {
  font-size: 12px;
  color: #777;
  margin-top: 8px;
}
</style>
