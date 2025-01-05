<template>
    <div class="trabaja-con-nosotros">
      <!-- Título principal -->
      <h1>Trabaja con Nosotros</h1>
      <p>¡Gana ingresos extra dejando tu vehículo al servicio de nuestra empresa!</p>
  
      <!-- Información principal -->
      <section class="info-section">
        <div class="info-container">
          <h2>¿Cómo funciona?</h2>
          <p>
            Pon tu vehículo a disposición de AutorrentasChile para que lo utilicemos en nuestras operaciones.
            Según el tipo, modelo y estado del vehículo, podrás recibir ingresos mensuales garantizados.
          </p>
        </div>
      </section>
  
      <!-- Beneficios -->
      <section class="benefits-section">
        <h2>Beneficios para el Usuario Arrendador</h2>
        <ul>
          <li>Ingresos mensuales garantizados según el tipo de vehículo.</li>
          <li>Nos encargamos del mantenimiento básico y seguro del vehículo.</li>
          <li>Flexibilidad para retirar tu vehículo cuando lo necesites.</li>
        </ul>
      </section>
  
      <!-- Requisitos -->
      <section class="requirements-section">
        <h2>Requisitos</h2>
        <ul>
          <li>El vehículo debe estar en buen estado mecánico y estético.</li>
          <li>Debe tener menos de 5 años de antigüedad.</li>
          <li>Documentación al día (permiso de circulación, revisión técnica, seguro obligatorio).</li>
          <li>Contrato de arrendamiento firmado con AutorrentasChile.</li>
        </ul>
      </section>
  
      <!-- Términos y condiciones -->
      <section class="terms-section">
        <h2>Términos y Condiciones</h2>
        <p>
          Al participar en este programa, aceptas que AutorrentasChile utilice tu vehículo para fines de arriendo a terceros. 
          Se realizarán inspecciones regulares y se pagará un monto fijo mensual dependiendo de las condiciones del vehículo.
        </p>
      </section>
  
      <!-- Botón de acción -->
      <section class="cta-section">
        <h3>¿Listo para comenzar?</h3>
        <p>Haz clic en el botón para completar el formulario y un representante se pondrá en contacto contigo.</p>
        <router-link to="/formulario-arrendador" class="btn">Quiero arrendar mi vehículo</router-link>
      </section>
    </div>
  </template>

<script>
</script>

<style scoped>
.trabaja-con-nosotros {
  font-family: Arial, sans-serif;
  line-height: 1.6;
  color: #333;
  padding: 20px;
}
.trabaja-con-nosotros h1 {
  display: flex;
  justify-content: center;
}
.trabaja-con-nosotros p {
  display: flex;
  justify-content: center;
}

.info-section, .benefits-section, .requirements-section, .terms-section {
  margin: 20px 0;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.info-section h2, .benefits-section h2, .requirements-section h2, .terms-section h2 {
  font-size: 1.8rem;
  margin-bottom: 15px;
  color: #003366;
}

.info-section p, .terms-section p {
  font-size: 1rem;
  color: #555;
}

.benefits-section ul, .requirements-section ul {
  list-style: disc;
  margin: 0;
  padding-left: 20px;
}

.benefits-section li, .requirements-section li {
  margin-bottom: 10px;
}

.cta-section {
  text-align: center;
  background-color: #eaf2f8;
  padding: 30px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.cta-section h3 {
  font-size: 1.8rem;
  margin-bottom: 10px;
}

.cta-section p {
  font-size: 1rem;
  margin-bottom: 20px;
}

.btn {
  display: inline-block;
  background-color: #FF4500;
  color: white;
  padding: 10px 20px;
  border-radius: 5px;
  text-decoration: none;
  font-size: 1rem;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #d66a42;
}
</style>
