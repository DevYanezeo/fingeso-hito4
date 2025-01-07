<template>
  <div class="flota">
    <section class="search">
      <SearchSection />
    </section>

    <h1>TARIFAS Y VEHÍCULOS</h1>
    <p>Aquí puedes encontrar todos los vehículos para arrendar.</p>
    <!-- Contenedor dinámico para los vehículos -->
    <div class="vehiculos-container">
      <CardCar 
        v-for="(vehiculo, index) in vehiculos" 
        :key="index" 
        :vehiculo="vehiculo" 
        @seleccionar="manejarSeleccion" 
      />
    </div>
  </div>
</template>

<script>
import SearchSection from '../User/SearchSection.vue';
import CardCar from '../User/UserCardCar.vue'; // Asegúrate de importar el componente CardCar

export default {
  name: 'Flota',
  components: {
    SearchSection,
    CardCar, // Incluye el componente CardCar
  },
  data() {
    return {
      vehiculos: [], // Lista de vehículos
    };
  },
  methods: {
    // Método para cargar los vehículos
    async cargarVehiculos() {
      try {
        const response = await fetch("http://localhost:8080/api/vehiculo");
        if (!response.ok) {
          throw new Error("Error al cargar la flota");
        }
        const data = await response.json();
        this.vehiculos = data; // Asigna los vehículos obtenidos a la propiedad vehiculos
      } catch (error) {
        console.error("Error al cargar la flota:", error);
      }
    },
    manejarSeleccion(vehiculo) {
      // Maneja la selección del vehículo
      console.log("Vehículo seleccionado:", vehiculo);
    },
  },
  mounted() {
    // Cargar datos al montar el componente
    this.cargarVehiculos();
  },
};
</script>

<style scoped>
.flota {
  background-image: url('/fondo.png'); 
  text-align: center;
  margin-top: 50px;
  font-size: 18px;
}
.flota-img {
  position: relative;
  width: 30%;
  height: auto;
}
.vehiculos-container {
  display: flex;
  flex-wrap: wrap;
  gap: 16px;
  justify-content: center;
  margin-top: 20px;
}
</style>
