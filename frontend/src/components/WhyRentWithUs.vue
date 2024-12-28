<template>
  <div class="why-rent">
    <h2>¿Por qué arrendar en <span>AutoRentasChile</span>?</h2>
    <div class="features">
      <div class="feature feature-top">
        <div class="circle">
          <div class="icon">💰</div>
          <p>La Mejor Tarifa</p>
        </div>
      </div>
      <div class="feature feature-bottom">
        <div class="circle">
          <div class="icon">🛡️</div>
          <p>El Mejor Servicio</p>
        </div>
      </div>
      <div class="feature feature-top">
        <div class="circle">
          <div class="icon">🚗</div>
          <p>La Mejor Flota</p>
        </div>
      </div>
      <div class="feature feature-bottom">
        <div class="circle">
          <div class="icon">📍</div>
          <p>Cobertura Nacional</p>
        </div>
      </div>
      <div class="feature feature-top">
        <div class="circle">
          <div class="icon">💻</div>
          <p>Tecnología e Innovación</p>
        </div>
      </div>
    </div>
  </div>
</template>

  
<script setup>
</script>

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
  color: #003366;
  margin-bottom: 50px;
  font-weight: 700;
}

.why-rent h2 span {
  color: #FF4500;
}

/* Contenedor de características */
.features {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  position: relative;
  max-width: 1200px;
  margin: 0 auto;
  gap: 50px;
}



.feature-top {
  align-items: flex-start;
}

.feature-bottom {
  align-items: flex-end;
}

/* Estilo de los círculos */
.circle {
  background: linear-gradient(145deg, #003366, #003366);
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
  font-weight: 600;
  text-align: center;
  margin: 0;
}

  </style>
  