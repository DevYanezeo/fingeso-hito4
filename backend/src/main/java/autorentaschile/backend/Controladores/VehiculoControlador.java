package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Sucursal;
import autorentaschile.backend.Entidades.Vehiculo;
import autorentaschile.backend.Servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins = "*")
public class VehiculoControlador {

	@Autowired
	private VehiculoServicio vehiculoServicio;

	// Obtener todos los vehículos
	@GetMapping
	public List<Vehiculo> obtenerTodosLosVehiculos() {
		return vehiculoServicio.obtenerTodosLosVehiculos();
	}

	// Agregar un vehículo
	@PostMapping("/registrarVehiculo")
	public Vehiculo addVehiculo(@RequestBody Vehiculo nuevoVehiculo) {
		// Aquí, asumimos que el objeto nuevoVehiculo ya tiene todos los datos necesarios
		// incluyendo la patente, que se pasa al servicio
		return vehiculoServicio.registrarVehiculo(
				nuevoVehiculo.getPatente(),    // Asegúrate de incluir el atributo patente
				nuevoVehiculo.getMarca(),
				nuevoVehiculo.getModelo(),
				nuevoVehiculo.getCategoria(),
				nuevoVehiculo.getEstado(),
				nuevoVehiculo.getSucursal(),
				nuevoVehiculo.getTransmision(),
				nuevoVehiculo.getCombustible(),
				nuevoVehiculo.getKilometraje(),
				nuevoVehiculo.getImagenUrl(),
				nuevoVehiculo.getPasajeros(),
				nuevoVehiculo.getPuertas(),
				nuevoVehiculo.getTarifaDiaria()
		);
	}

	// Modificar un vehículo
	@PutMapping("/modificarVehiculo")
	public Vehiculo modificarVehiculo(@RequestBody Vehiculo vehiculo) {
		// En este punto asumimos que el vehículo tiene todos los atributos, incluyendo patente
		return vehiculoServicio.modificarVehiculo(
				vehiculo.getId(),
				vehiculo.getPatente(),          // Asegúrate de incluir el atributo patente
				vehiculo.getMarca(),
				vehiculo.getModelo(),
				vehiculo.getCategoria(),
				vehiculo.getEstado(),
				vehiculo.getSucursal(),        // Se pasa la sucursal completa
				vehiculo.getTransmision(),
				vehiculo.getCombustible(),
				vehiculo.getKilometraje()
		);
	}

	// Eliminar un vehículo
	@DeleteMapping("/eliminarVehiculo")
	public boolean eliminarVehiculo(@RequestParam("id") long id) {
		return vehiculoServicio.eliminarVehiculo(id);
	}

	// Obtener vehículos por sucursal
	@GetMapping("/sucursal/{idSucursal}")
	public List<Vehiculo> obtenerVehiculosPorSucursal(@PathVariable Long idSucursal) {
		return vehiculoServicio.obtenerVehiculosPorSucursal(idSucursal);
	}

	@GetMapping("/{patente}")
	public ResponseEntity<Vehiculo> obtenerVehiculoPorPatente(@PathVariable String patente) {
		Vehiculo vehiculo = vehiculoServicio.obtenerVehiculoPorPatente(patente);

		if (vehiculo == null) {
			return ResponseEntity.notFound().build(); // Si no se encuentra, se retorna 404
		}
		return ResponseEntity.ok(vehiculo); // Si se encuentra, se retorna el vehículo con 200 OK
	}

	// Entrada de datos para la recepción
	public static class RecepcionVehiculoRequest {
		public String estado;
		public String combustible;
		public String kilometraje;
	}

	@PutMapping("/recepcionVehiculo/{patente}")
	public ResponseEntity<Vehiculo> recepcionVehiculo(
			@PathVariable String patente,
			@RequestBody RecepcionVehiculoRequest request) {

		Vehiculo vehiculo = vehiculoServicio.recepcionVehiculo(
				patente,
				request.estado,
				request.combustible,
				request.kilometraje
		);

		if (vehiculo == null) {
			return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el vehículo
		}

		return ResponseEntity.ok(vehiculo); // Retorna 200 con el vehículo actualizado
	}

}