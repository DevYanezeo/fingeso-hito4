package autorentaschile.backend.Repositorios;

import autorentaschile.backend.Entidades.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepositorio extends JpaRepository<Sucursal, Long> {
    // No necesitamos más métodos en este caso, findAll() sirve.
}
