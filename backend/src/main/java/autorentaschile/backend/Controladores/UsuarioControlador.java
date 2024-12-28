package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Usuario;
import autorentaschile.backend.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	// Endpoint para registrar un nuevo usuario
	@PostMapping("/registrar")
	public Usuario registerUser(@RequestBody Usuario usuario) {
		return usuarioServicio.register(
				usuario.getRutUsuario(),
				usuario.getNombreUsuario(),
				usuario.getEmail(),
				usuario.getCelularUsuario(),
				usuario.getPasswordUsuario(),
				usuario.getDireccionUsuario(),
				usuario.getSucursalDeTrabajo(),
				usuario.getRolEmpleado(),
				usuario.getTipoUsuario(),
				usuario.getFechaNacimiento()
		);
	}
}
