package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Reporte;
import autorentaschile.backend.Entidades.Reserva;
import autorentaschile.backend.Servicios.BoletaServicio;
import autorentaschile.backend.Servicios.ReporteServicio;
import autorentaschile.backend.Servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva")
public class ReservaControlador {

	@Autowired
	private ReservaServicio reservaServicio;

	// Crear una reserva
	@PostMapping("/crearReserva")
	public Reserva crearReserva(@RequestBody Reserva nuevaReserva){
		return reservaServicio.crearReserva(
				nuevaReserva.getRutUsuario(),
				nuevaReserva.getIdSucursalRetiro(),
				nuevaReserva.getFechaRetiro(),
				nuevaReserva.getFechaDevolucion(),
				nuevaReserva.getIdSucursalDevolucion(),
				nuevaReserva.getCategoriaVehiculo(),
				nuevaReserva.getPatenteVehiculoAsignado(),
				nuevaReserva.getEstadoReserva(),
				nuevaReserva.getFechaCreacion(),
				nuevaReserva.getIdBoleta()
		);
	}

	// Modificar una reserva (NO ES RECIVIR EL VEHICULO) ☻
	@PutMapping("/modificarReserva")
	public Reserva modificarReserva(@RequestBody Reserva reserva) {
		return reservaServicio.modificarReserva(
				reserva.getIdReserva(),
				reserva.getRutUsuario(),
				reserva.getIdSucursalRetiro(),
				reserva.getFechaRetiro(),
				reserva.getFechaDevolucion(),
				reserva.getIdSucursalDevolucion(),
				reserva.getCategoriaVehiculo(),
				reserva.getPatenteVehiculoAsignado(),
				reserva.getEstadoReserva(),
				reserva.getFechaCreacion(),
				reserva.getIdBoleta()
		);
	}
}