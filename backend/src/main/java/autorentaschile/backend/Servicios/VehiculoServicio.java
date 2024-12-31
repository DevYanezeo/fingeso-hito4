package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Sucursal;
import autorentaschile.backend.Entidades.Vehiculo;
import autorentaschile.backend.Repositorios.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class VehiculoServicio {

	@Autowired
	private VehiculoRepositorio vehiculoRepositorio;

	// Obtener todos los vehículos
	public List<Vehiculo> obtenerTodosLosVehiculos() {
		return vehiculoRepositorio.findAll();
	}

	// Entrada: Datos de un vehículo
	// Descripción: Toma los datos del vehículo a agregar y lo agrega
	// Salida: El vehículo registrado
	public Vehiculo registrarVehiculo(String patente, String marca, String modelo, String categoria, String estado, Sucursal sucursal, String transmision, String combustible, String kilometraje, String imagenUrl, int pasajeros, int puertas, int tarifaDiaria) {
		// Crear nuevo vehículo con todos los atributos, incluyendo patente
		Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, categoria, estado, sucursal, transmision, combustible, kilometraje, imagenUrl, pasajeros, puertas, tarifaDiaria);

		// Verificar si existe un vehículo con la misma patente (puedes cambiar esta lógica según tus necesidades)
		Optional<Vehiculo> existenteOptional = vehiculoRepositorio.findById(vehiculo.getId());

		// Si el vehículo ya existe, retornar null
		if (existenteOptional.isPresent()) {
			return null; // Retorna null si ya existe
		}

		// Guardar y retornar el nuevo vehículo
		return vehiculoRepositorio.save(vehiculo);
	}

	// Entrada: Datos de un vehículo, incluyen la ID
	// Descripción: Modifica los datos del vehículo con la ID introducida
	// Salida: Un vehículo modificado
	public Vehiculo modificarVehiculo(long id, String patente, String marca, String modelo, String categoria, String estado, Sucursal sucursal, String transmision, String combustible, String kilometraje) {
		// Buscar vehículo existente
		Optional<Vehiculo> existenteOptional = vehiculoRepositorio.findById(id);

		// Caso no existe
		if (!existenteOptional.isPresent()) {
			return null; // Si el vehículo no existe, retorna null
		}

		// Obtener el vehículo existente
		Vehiculo existente = existenteOptional.get();

		// Actualizar los datos del vehículo, incluyendo patente
		existente.setPatente(patente);
		existente.setMarca(marca);
		existente.setModelo(modelo);
		existente.setCategoria(categoria);
		existente.setEstado(estado);
		existente.setSucursal(sucursal);
		existente.setTransmision(transmision);
		existente.setCombustible(combustible);
		existente.setKilometraje(kilometraje);

		// Guardar y retornar el vehículo actualizado
		return vehiculoRepositorio.save(existente);
	}

	// Eliminar vehículo
	public boolean eliminarVehiculo(long id) {
		// Encontrar el vehículo
		Optional<Vehiculo> existenteOptional = vehiculoRepositorio.findById(id);

		// Caso no existe
		if (!existenteOptional.isPresent()) {
			return false; // Si no existe, retorna false
		}
		// Obtener el vehículo existente
		Vehiculo existente = existenteOptional.get();

		// Eliminar el vehículo
		vehiculoRepositorio.delete(existente);
		return true; // Retorna true cuando se elimina correctamente
	}

	// Obtener vehículos por sucursal
	public List<Vehiculo> obtenerVehiculosPorSucursal(Long idSucursal) {
		// Llama al método del repositorio para obtener los vehículos
		return vehiculoRepositorio.findBySucursalId(idSucursal);
	}

	// Obtener vehículo por patente
	public Vehiculo obtenerVehiculoPorPatente(String patente) {
		// Aquí se busca el vehículo por patente
		Optional<Vehiculo> vehiculoOptional = vehiculoRepositorio.findByPatente(patente);
		return vehiculoOptional.orElse(null);  // Devuelve null si no se encuentra el vehículo
	}

	public Vehiculo recepcionVehiculo(String patente, String estado, String combustible, String kilometraje) {
		// Buscar el vehículo por patente
		Optional<Vehiculo> vehiculoOptional = vehiculoRepositorio.findByPatente(patente);

		if (!vehiculoOptional.isPresent()) {
			return null; // Si no se encuentra, retorna null
		}

		// Obtener el vehículo y actualizar los campos necesarios
		Vehiculo vehiculo = vehiculoOptional.get();
		vehiculo.setEstado(estado);
		vehiculo.setCombustible(combustible);
		vehiculo.setKilometraje(kilometraje);

		// Guardar los cambios en el repositorio
		return vehiculoRepositorio.save(vehiculo);
	}
}