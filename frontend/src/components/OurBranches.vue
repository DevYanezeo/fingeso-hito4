<template>
    <div class="sucursales">
      <h1>Sucursales de Alquiler de Autos</h1>
      <p>
        Disponemos de sucursales de alquiler de autos en todas las regiones de
        Chile continental, ubicadas en lugares clave para garantizar comodidad y
        facilidad de acceso a nuestros clientes.
      </p>
  
      <!-- Filtro de búsqueda -->
      <div class="filter">
        <label for="city-selector">Selecciona una ciudad:</label>
        <select id="city-selector" v-model="selectedCity" @change="filterLocations">
          <option value="" disabled selected>Selecciona una ciudad</option>
          <option value="arica">Arica</option>
          <option value="santiago">Santiago</option>
          <option value="valparaiso">Valparaíso</option>
        </select>
      </div>
  
      <!-- Contenedores de sucursales -->
      <main class="locations">
        <div 
          class="card" 
          v-for="(location, index) in filteredLocations" 
          :key="index"
        >
          <div class="card-left">
            <h3>{{ location.city }} - {{ location.name }}</h3>
            <p><i class="icon-calendar"></i> {{ location.schedule }}</p>
            <p><i class="icon-phone"></i> Teléfono: {{ location.phone }}</p>
          </div>
          <div class="card-right">
            <div class="map">Mapa de ubicación</div>
          </div>
        </div>
      </main>
    </div>
  </template>
  
  <script>
  export default {
    name: "Sucursales",
    data() {
      return {
        selectedCity: "",
        locations: [
          {
            city: "Arica",
            name: "Aeropuerto Chacalluta",
            schedule: "Horario de Atención Según Llegada de Vuelos Comerciales",
            phone: "+569 3200 1126",
          },
          {
            city: "Arica",
            name: "Avenida Chile",
            schedule: "Lunes a Viernes 08:30 - 17:45, Sábados y Domingos Cerrado",
            phone: "+569 6192 6924",
          },
          {
            city: "Santiago",
            name: "Aeropuerto Internacional",
            schedule: "24/7",
            phone: "+569 1122 3344",
          },
          {
            city: "Valparaíso",
            name: "Terminal de Buses",
            schedule: "Lunes a Domingo 09:00 - 18:00",
            phone: "+569 5566 7788",
          },
        ],
      };
    },
    computed: {
      filteredLocations() {
        if (this.selectedCity === "") {
          return this.locations;
        }
        return this.locations.filter(
          (location) => location.city.toLowerCase() === this.selectedCity
        );
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilo general */
  .sucursales {
    font-family: 'Arial', sans-serif;
    text-align: center;
    padding: 20px;
  }
  
  .sucursales h1 {
    font-size: 28px;
    margin-bottom: 10px;
  }
  
  .sucursales p {
    font-size: 16px;
    margin-bottom: 20px;
  }
  
  /* Estilo del filtro */
  .filter {
    margin: 20px 0;
  }
  
  .filter label {
    margin-right: 10px;
    font-size: 16px;
  }
  
  .filter select {
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }
  
  /* Estilo de las tarjetas */
  .locations {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
  }
  
  .card {
    display: flex;
    flex-direction: row;
    background-color: #2d572c;
    color: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    width: 100%;
  }
  
  .card-left {
    padding: 20px;
    background-color: #4caf50;
    flex: 1;
  }
  
  .card-left h3 {
    margin-bottom: 10px;
    font-size: 20px;
  }
  
  .card-left p {
    font-size: 14px;
    margin: 5px 0;
  }
  
  .card-left i {
    margin-right: 8px;
  }
  
  .card-right {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #2d572c;
  }
  
  .map {
    width: 100%;
    height: 150px;
    background-color: #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #000;
    font-size: 14px;
  }
  
  /* Responsivo */
  @media (max-width: 768px) {
    .card {
      flex-direction: column;
    }
  
    .map {
      height: 100px;
    }
  }
  </style>
  