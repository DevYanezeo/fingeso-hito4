package autorentaschile.backend.Repositorios;

import autorentaschile.backend.Entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

	// Método para obtener vehículos por el ID de la sucursal
	List<Vehiculo> findBySucursalId(Long sucursalId);
	Optional<Vehiculo> findByPatente(String patente);
}
