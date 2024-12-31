package autorentaschile.backend.Repositorios;

import autorentaschile.backend.Entidades.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepositorio extends JpaRepository<Reporte, Long> {
}