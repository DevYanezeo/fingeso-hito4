<template>
  <div class="sucursales">
    <h1>Sucursales AutoRentasChile</h1>
    <p>
      Disponemos de sucursales en todas las regiones de Chile continental,
      ubicadas en lugares clave para garantizar comodidad y facilidad de acceso
      a nuestros clientes.
    </p>

    <!-- Filtro de búsqueda -->
    <div class="filter">
      <label for="pickup">Selecciona una ciudad:</label>
      <select id="pickup" v-model="selectedCity">
        <option value="" disabled>Selecciona una ciudad</option>
        <option v-for="sucursal in sucursales" :key="sucursal.idSucursal" :value="sucursal.nombre">
          {{ sucursal.nombre }}
        </option>
      </select>
      <button @click="buscarSucursal">Buscar</button>
    </div>

    <!-- Contenedores de sucursales -->
    <main class="locations">
      <div 
        class="card" 
        v-for="(sucursal, index) in filteredSucursales" 
        :key="index"
      >
        <div class="card-left">
          <h3>{{ sucursal.nombre }}</h3>
          <p><strong>Dirección:</strong> {{ sucursal.direccion }}</p>
          <p><strong>Teléfono:</strong> {{ sucursal.telefono }}</p>
          <p><strong>Email:</strong> {{ sucursal.email }}</p>
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
      selectedCity: "", // Ciudad seleccionada
      sucursales: [], // Lista completa de sucursales cargadas
      filteredSucursales: [], // Lista de sucursales filtradas
    };
  },
  methods: {
    // Función para cargar las sucursales desde el backend
    async cargarSucursales() {
      try {
        const response = await fetch("http://localhost:8080/api/sucursal");
        if (!response.ok) {
          throw new Error("Error al cargar las sucursales");
        }
        const data = await response.json();
        this.sucursales = data; // Guardar los datos en la lista de sucursales
        this.filteredSucursales = data; // Mostrar todas por defecto
      } catch (error) {
        console.error("Error al cargar las sucursales:", error);
      }
    },
    // Función para buscar sucursales según la ciudad seleccionada
    buscarSucursal() {
      if (this.selectedCity) {
        this.filteredSucursales = this.sucursales.filter(
          (sucursal) => sucursal.nombre === this.selectedCity
        );
      } else {
        this.filteredSucursales = this.sucursales; // Mostrar todas si no hay filtro
      }
    },
  },
  mounted() {
    // Cargar datos al montar el componente
    this.cargarSucursales();
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
    background-color: #00336639;
    color: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    width: 100%;
  }
    
  .card-left {
    padding: 20px;
    background-color: #003366;
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
    background-color: #002346;
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
  