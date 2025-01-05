import { createApp } from 'vue';
import App from './App.vue';
import { createRouter, createWebHistory } from 'vue-router';

// Importar los componentes
import Fleet from './components/Fleet.vue';
import Home from './components/Home.vue';  // Página de inicio
import OurBranches from './components/OurBranches.vue'; // Componente de sucursales
import Login from './components/Login.vue'; // Componente de login
import Register from './components/register.vue'; // Componente de registro
import Contact from './components/contact.vue';
import WorkWithUs from './components/workWithUs.vue';
import UserLogged from './components/UserLogged.vue';
import Profile from './components/UserProfile.vue';
import AdminDashboard from './components/AdminDashboard.vue';
import AdminNavbar from './components/AdminNavbar.vue';
import ManageFleet from './components/ManageFleet.vue';
import Reception from './components/Reception.vue';
import ReservationUser from './components/ReservationUser.vue';


// Definir las rutas
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,  // Página de inicio ahora usa Home.vue
  },
  {
    path: '/flota',
    name: 'Flota',
    component: Fleet,  // Página para Flota
  },
  {
    path: '/sucursales',
    name: 'Sucursales',
    component: OurBranches,  // Componente para las Sucursales
  },
  {
    path: '/login',  // Nueva ruta para Login
    name: 'Login',
    component: Login,  // Componente para Login
  },
  {
    path: '/Register',  // Nueva ruta para Registro
    name: 'Register',
    component: Register,  // Componente para Registro
  },
  {
    path: '/contact',  // Nueva ruta para Registro
    name: 'Contact',
    component: Contact,  // Componente para Registro
  },
  {
    path: '/workWithUs',  // Nueva ruta para Registro
    name: 'WorkWithUs',
    component: WorkWithUs,  // Componente para Registro
  },
  {
    path: '/profile',  // Nueva ruta para Registro
    name: 'Profile',
    component: Profile,  // Componente para Registro
  },
  {
    path: '/UserLogged',  // Ruta para usuarios logueados
    name: 'UserLogged',
    component: UserLogged,  // Componente para usuarios autenticados
    meta: { requiresAuth: true, role: 'cliente'},  // Marcamos esta ruta como que requiere autenticación
  },
  {
    path: '/adminDashboard',
    name: 'AdminDashboard',
    component: AdminDashboard,  // Componente correcto
    meta: { requiresAuth: true, role: 'admin' }, // Meta correcto
  },  
  {
    path: '/adminNavbar',  // Nueva ruta para Registro
    name: 'AdminNavbar',
    component: AdminNavbar,  // Componente para Registro
  },
  {
    path: '/manageFleet',  // Nueva ruta para Registro
    name: 'ManageFleet',
    component: ManageFleet,  // Componente para Registro
  },
  {
    path: '/reception',  // Nueva ruta para Registro
    name: 'Reception',
    component: Reception,  // Componente para Registro
  },
  {
    path: '/reservationUser',  // Nueva ruta para Registro
    name: 'ReservationUser',
    component: ReservationUser,  // Componente para Registro
  },
  
];

// Crear el router con las rutas definidas
const router = createRouter({
  history: createWebHistory(),
  routes,
});

// Agregar un guard de navegación global para proteger las rutas
router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem('authToken'); // Verifica si hay un token
  const userRole = localStorage.getItem('userRole'); // Obtiene el rol desde localStorage

  // Verificar si la ruta requiere autenticación
  if (to.meta.requiresAuth) {
    if (!isAuthenticated) {
      // Si no está autenticado, redirigir al login
      return next('/login');
    }

    // Verificar si el rol de la ruta coincide con el rol del usuario
    if (to.meta.role && to.meta.role !== userRole) {
      alert('Acceso denegado: rol insuficiente');
      return next('/login'); // Redirige al login o a una página de error
    }
  }
  next(); // Permitir la navegación
});

// Crear la aplicación y usar el router
createApp(App)
  .use(router)
  .mount('#app');
