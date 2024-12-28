<template>
  <div class="adminDashboard">
    <main class="dashboard-content">
      <!-- Sección de Notificaciones Importantes -->
      <section class="notificaciones">
        <h2>Notificaciones Importantes</h2>
        <div class="notification-container">
          <div 
            class="notification-item" 
            v-for="(vehicle, index) in urgentVehicles" 
            :key="index">
            <div>
              <p><strong>Vehículo: </strong>{{ vehicle.name }}</p>
              <p><strong>Razón: </strong>{{ vehicle.maintenanceReason }}</p>
              <button @click="sendToWorkshop(vehicle.id)">Enviar a Mantenimiento</button>
            </div>
          </div>
        </div>
      </section>

      <!-- Sección de Flota -->
      <section class="flota">
        <h2>Flota de Vehículos por Sucursal</h2>
        <div class="flota-container">
          <div class="flota-item" v-for="(sucursal, index) in sucursales" :key="index">
            <h3>{{ sucursal.name }}</h3>
            <p><strong>Total vehículos: </strong>{{ sucursal.totalVehicles }}</p>
            <p><strong>Vehículos disponibles: </strong>{{ sucursal.availableVehicles }}</p>
            <p><strong>Vehículos en mantenimiento: </strong>{{ sucursal.vehiclesInMaintenance }}</p>
            <button @click="manageFleet(manageFleet)">Gestionar Flota</button>
          </div>
        </div>
      </section>

      <!-- Sección de Estadísticas de Rent a Car -->
      <section class="estadisticas">
        <h2>Estadísticas de Rent a Car</h2>
        <p>Demanda por día: {{ demandByDay }}</p>
        <p>Demanda mensual: {{ demandByMonth }}</p>
        <p>Demanda anual: {{ demandByYear }}</p>
        <button @click="viewRentStatistics">Ver Estadísticas de Alquiler</button>
      </section>

      <!-- Sección de Mantenimiento -->
      <section class="mantenimiento">
        <h2>Mantenimiento de Vehículos</h2>
        <p>Vehículos en taller: {{ vehiclesInWorkshop }}</p>
        <p>Mantenimiento programado: {{ scheduledMaintenance }}</p>
        <button @click="manageMaintenance">Gestionar Mantenimiento</button>
      </section>
    </main>
  </div>
</template>
 
<script>
import AdminNavbar from './AdminNavbar.vue';

export default {
  name: 'AdminDashboard',
  components: {
    AdminNavbar,
  },
  data() {
    return {
      // Vehículos que necesitan mantenimiento urgente
      urgentVehicles: [ 
        { id: 1, name: 'Vehículo A', maintenanceReason: 'Cambio de aceite por kilometraje alto' },
        { id: 2, name: 'Vehículo B', maintenanceReason: 'Permiso de circulación vencido' },
        { id: 3, name: 'Vehículo C', maintenanceReason: 'Accidente reportado por el cliente' },
      ],
      // Información sobre las sucursales y sus flotas
      sucursales: [
        {
          name: 'Santiago',
          totalVehicles: 50,
          availableVehicles: 40,
          vehiclesInMaintenance: 5,
        },
        {
          name: 'Valparaíso',
          totalVehicles: 30,
          availableVehicles: 25,
          vehiclesInMaintenance: 3,
        },
        {
          name: 'Viña del Mar',
          totalVehicles: 20,
          availableVehicles: 18,
          vehiclesInMaintenance: 1,
        },
      ],
      demandByDay: 20, // Demanda de alquiler por día
      demandByMonth: 500, // Demanda de alquiler mensual
      demandByYear: 6000, // Demanda de alquiler anual
      vehiclesInWorkshop: 5, // Vehículos en taller
      scheduledMaintenance: 2, // Vehículos con mantenimiento programado
    };
  },
  methods: {
    manageFleet(sucursalName) {
      // Lógica para gestionar la flota de una sucursal específica
      console.log(`Gestionando flota de la sucursal: ${sucursalName}`);
      this.$router.push(`/manage-fleet/${sucursalName}`);
    },
    viewRentStatistics() {
      // Lógica para ver estadísticas de alquiler
      this.$router.push('/rent-statistics');
    },
    manageMaintenance() {
      // Lógica para gestionar el mantenimiento
      this.$router.push('/manage-maintenance');
    },
    sendToWorkshop(vehicleId) {
      // Lógica para enviar el vehículo al taller
      console.log(`Enviando vehículo con ID ${vehicleId} al taller.`);
      // Aquí puedes llamar a la API del backend para registrar el mantenimiento
    },
  },
};
</script>

<style scoped>
.adminDashboard {
  display: flex;
  flex-direction: column;
}

.dashboard-content {
  flex-grow: 1;
  padding: 20px;
}

section {
  margin-bottom: 30px;
}

h2 {
  color: #003366;
}

button {
  padding: 10px 20px;
  background-color: #003366;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #00509e;
}

/* Estilo para Notificaciones */
.notificaciones {
  margin-bottom: 20px;
}

.notification-container {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.notification-item {
  flex: 1 1 calc(33% - 20px); /* Calculamos el ancho para que se ajusten en filas */
  background-color: #f9f9f9;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.notification-item p {
  margin: 0;
  padding: 5px 0;
}

.notification-item button {
  margin-top: 10px;
  background-color: #e74c3c;
}

.notification-item button:hover {
  background-color: #c0392b;
}

/* Estilo para Flota de Vehículos */
.flota {
  margin-bottom: 20px;
}

.flota-container {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.flota-item {
  flex: 1 1 calc(33% - 20px); /* Aseguramos que se ajusten a una fila */
  background-color: #f9f9f9;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.flota-item h3 {
  color: #003366;
}

.flota-item p {
  margin: 5px 0;
}

/* Estilo para Estadísticas y Mantenimiento */
.estadisticas, .mantenimiento {
  margin-bottom: 20px;
}

.estadisticas button, .mantenimiento button {
  background-color: #f39c12;
  padding: 10px 20px;
}

.estadisticas button:hover, .mantenimiento button:hover {
  background-color: #e67e22;
}
</style>
