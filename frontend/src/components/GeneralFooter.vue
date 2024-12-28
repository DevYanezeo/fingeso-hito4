<template>
  <footer class="footer">
    <div class="footer-container">
      <!-- Logo -->
      <div class="logo">
        <img alt="logo" src="@/assets/logo.png" />
      </div> 

      <!-- Sección: Servicios en línea -->
      <div class="footer-column">
        <h4>SERVICIOS EN LÍNEA</h4>
        <ul>
          <li><router-link to="/">Rent a Car</router-link></li>
          <li><router-link to="/login">Anular / Modificar reserva</router-link></li>
          <li><router-link to="/reporte-siniestros">Reporte de siniestros</router-link></li>
        </ul>
      </div>

      <!-- Sección: Contáctanos -->
      <div class="footer-column">
        <h4>CONTÁCTANOS</h4>
        <ul>
          <li><router-link to="/sucursales">Sucursales</router-link></li>
          <li><router-link to="/contact">Contacto</router-link></li>
        </ul>
      </div>

      <!-- Sección: Más AutorentasChile -->
      <div class="footer-column">
        <h4>MÁS AUTORENTASCHILE</h4>
        <ul>
          <li><router-link to="/Us">Sobre nosotros</router-link></li>
          <li><router-link to="/politica-calidad">Política de calidad y seguridad</router-link></li>
          <li><router-link to="/preguntas-frecuentes">Preguntas Frecuentes</router-link></li>
        </ul>
      </div>
    </div>

    <!-- Pie de copyright -->
    <div class="footer-bottom">
      <p>© 2024 AutorentasChile - Todos los derechos reservados</p>
    </div>
  </footer>
</template>


<script>
export default {
  name: 'Footer'
};
</script>

<style scoped>
/* Estilo general del footer */
.footer {
  background-color: #003366;
  color: white;
  padding: 40px 20px;
  width: 100%;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* Contenedor principal */
.footer-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  width: 100%;
  max-width: 1200px;
  margin-bottom: 20px;
}

/* Columnas */
.footer-column {
  flex: 1 1 200px; /* Ajusta el ancho mínimo de cada columna */
  margin: 10px;
}

/* Títulos de las secciones */
.footer-column h4 {
  margin-bottom: 15px;
  font-size: 16px;
  font-weight: bold;
  text-transform: uppercase;
}

.footer-container .logo img {
  height: 140px; /* Ajusta el tamaño del logo */
}

/* Lista de enlaces */
.footer-column ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-column ul li {
  margin-bottom: 10px;
}

.footer-column ul li a {
  color: white;
  text-decoration: none;
  font-size: 14px;
  transition: color 0.3s;
}

.footer-column ul li a:hover {
  color: #00ccff; /* Efecto hover */
}

/* Pie de copyright */
.footer-bottom {
  text-align: center;
  font-size: 14px;
  border-top: 1px solid #ffffff33; /* Línea divisoria tenue */
  padding-top: 10px;
  width: 100%;
}
</style>
