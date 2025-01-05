package autorentaschile.backend.Repositorios;

import autorentaschile.backend.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
}