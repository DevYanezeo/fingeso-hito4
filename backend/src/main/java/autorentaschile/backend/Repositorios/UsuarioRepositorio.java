package autorentaschile.backend.Repositorios;

import autorentaschile.backend.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio  extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String emailUsuario);
	Usuario findByIdUsuario(long idUsuario);
}
