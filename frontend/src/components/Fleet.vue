<template>
    <div class="flota">
      <section class="search">
        <SearchSection />
      </section>
      
      <h1>TARIFAS Y VEHÍCULOS</h1>
      <p>Aquí puedes encontrar todos los vehículos para arrendar.</p>
      <img src="@/assets/flota.png" alt="Flota de vehículos" class="flota-img" />
  
      <!-- Nueva sección de filtrado -->
      <section class="filter">
        <h2>Filtrar por:</h2>
        <div class="filter-options">
          <div class="filter-option">
            <label for="categoria">Categoría</label>
            <select id="categoria" name="categoria">
              <option value="economico">Económico</option>
              <option value="de-lujo">De lujo</option>
              <option value="suv">SUV</option>
            </select>
          </div>
          <div class="filter-option">
            <label for="transmision">Transmisión</label>
            <select id="transmision" name="transmision">
              <option value="manual">Manual</option>
              <option value="automatica">Automática</option>
            </select>
          </div>
          <div class="filter-option">
            <label for="combustible">Combustible</label>
            <select id="combustible" name="combustible">
              <option value="gasolina">Gasolina</option>
              <option value="diesel">Diésel</option>
              <option value="electrico">Eléctrico</option>
            </select>
          </div>
        </div>
      </section>
    </div>
</template>
  
  <script>
  import SearchSection from './SearchSection.vue';
  
  export default {
    name: 'Flota',
    components: {
      SearchSection,
    }
  };
  </script>
  
  <style scoped>
  .flota {
    text-align: center;
    margin-top: 50px;
    font-size: 18px;
  }
  .flota-img{
    position: relative;
    width: 30%;
    height: auto;
  }
  .search {
    margin-top: 30px;
  }
  
  .filter {
    margin-top: 40px;
  }
  
  .filter h2 {
    font-size: 24px;
    margin-bottom: 20px;
  }
  
  .filter-options {
    display: flex;
    justify-content: center;
    margin-top: 10px;
    align-items: center;
  }
  
  .filter-option {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }
  
  .filter-option label {
    margin-bottom: 3px;
    font-weight: bold;
  }
  
  .filter-option select {
    padding: 8px;
    font-size: 16px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }
  </style>
  
  