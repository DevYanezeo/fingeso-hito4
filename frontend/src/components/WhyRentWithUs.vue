<template>
  <div class="why-rent">
    <!-- Encabezado -->
    <h2>¿Por qué arrendar en <span class="brand-name">AutoRentasChile</span>?</h2>
    
    <!-- Sección de íconos y textos -->
    <div class="features">
      <!-- La Mejor Tarifa -->
      <div class="circle">
        <i class="icon fa fa-money-bill-wave"></i>
        <p>LA MEJOR TARIFA</p>
      </div>

      <!-- El Mejor Servicio -->
      <div class="circle">
        <i class="icon fa fa-shield-alt"></i>
        <p>EL MEJOR SERVICIO</p>
      </div>

      <!-- La Mejor Flota -->
      <div class="circle">
        <i class="icon fa fa-car"></i>
        <p>LA MEJOR FLOTA</p>
      </div>

      <!-- Cobertura Nacional -->
      <div class="circle">
        <i class="icon fa fa-map-marker-alt"></i>
        <p>COBERTURA NACIONAL</p>
      </div>

      <!-- Tecnología e Innovación -->
      <div class="circle">
        <i class="icon fa fa-laptop"></i>
        <p>TECNOLOGÍA E INNOVACIÓN</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Estilo principal */
.why-rent {
  text-align: center;
  padding: 60px 20px;
  font-family: 'Roboto', sans-serif;
  background-color: #D3D3D3;
}

.why-rent h2 {
  font-size: 36px;
  color: #000;
  font-weight: 700;
  margin-bottom: 50px;
}

.why-rent h2 .brand-name {
  color: #003366;
  font-weight: 400;
  font-style: italic;
}

/* Contenedor de características */
.features {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 30px;
  max-width: 1200px;
  margin: 0 auto;
}

/* Estilo de los círculos */
.circle {
  background: #003366;
  border: 3px solid #32CD32;
  color: white;
  width: 150px;
  height: 150px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.circle:hover {
  transform: scale(1.1);
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.3);
}

.icon {
  font-size: 40px;
  margin-bottom: 10px;
}

.circle p {
  font-size: 14px;
  font-weight: 700;
  text-align: center;
  text-transform: uppercase;
  margin: 0;
}
</style>

<script setup>
  // Asegúrate de tener instalada FontAwesome para los íconos
</script>
