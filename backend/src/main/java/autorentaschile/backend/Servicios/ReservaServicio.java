package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Boleta;
import autorentaschile.backend.Entidades.Reserva;
import autorentaschile.backend.Entidades.Vehiculo;
import autorentaschile.backend.Repositorios.ReservaRepositorio;
import autorentaschile.backend.Repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ReservaServicio {

	@Autowired
	private ReservaRepositorio reservaRepositorio;
	@Autowired
	private VehiculoRepositorio vehiculoRepositorio;

	// Entrada: Datos de una reserva
	// Descripcion: Crea una reserva, verificando el estado del vehiculo involucrado que sea Disponible y que la reserva tenga una ID unica
	// Salida: Una reserva en la base
	public Reserva crearReserva(String rutUsuario,
								int idSucursalRetiro,
								String fechaRetiro,
								String fechaDevolucion,
								int idSucursalDevolucion,
								String patenteVehiculo,
								String estadoReserva) {
		// Ocupar el constructor de la entidad con todos los datos introducidos
		Reserva reserva = new Reserva(rutUsuario, idSucursalRetiro, fechaRetiro, fechaDevolucion, idSucursalDevolucion, patenteVehiculo, estadoReserva);


		// Verificar que la reserva sea unica en ID
		Optional<Reserva> existenteReservaOptional = reservaRepositorio.findById(reserva.getIdReserva());
		if (existenteReservaOptional.isPresent()) {
			return null;
		}

		// Guardar la reserva en la base y retornar la reserva
		return reservaRepositorio.save(reserva);
	}

	// Entrada: Datos de una reserva, incluyendo la ID
	// Descripcion: Modifica los datos de una reserva con la ID correspondiente, ESTO NO ES RECEPCION DE VEHICULOS ☺
	// Salida: La reserva modificada en la base de datos
	public Reserva modificarReserva(Long id,
									String rutUsuario,
									int idSucursalRetiro,
									String fechaRetiro,
									String fechaDevolucion,
									int idSucursalDevolucion,
									String patenteVehiculo,
									String estadoReserva) {
		//Buscar reserva existente
		Optional<Reserva> existenteOptional = reservaRepositorio.findById(id);
		// Caso no existe
		if (existenteOptional.isEmpty()) {
			return null;
		}
		// Obtener la reserva existente
		Reserva existente = existenteOptional.get();

		// Actualizar todos los datos de la reserva con la ID correspondiente
		existente.setRutUsuario(rutUsuario);
		existente.setIdSucursalRetiro(idSucursalRetiro);
		existente.setFechaRetiro(fechaRetiro);
		existente.setFechaDevolucion(fechaDevolucion);
		existente.setIdSucursalDevolucion(idSucursalDevolucion);
		existente.setPatenteVehiculo(patenteVehiculo);
		existente.setEstadoReserva(estadoReserva);

		return reservaRepositorio.save(existente);
	}
}
