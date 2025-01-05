package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Usuario;
import autorentaschile.backend.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	// Endpoint para registrar un nuevo usuario
	@PostMapping("/registrar")
	public Map<String, String> registerUser(@RequestBody Usuario usuario) {
		return usuarioServicio.register(
				usuario.getRutUsuario(),
				usuario.getNombreUsuario(),
				usuario.getEmail(),
				usuario.getCelularUsuario(),
				usuario.getPasswordUsuario(),
				usuario.getDireccionUsuario(),
				usuario.getFechaNacimiento()
		);
	}
	// Endpoint para loggear un usuario
	@PostMapping("/login")
	public boolean login(@RequestBody Usuario usuario) {
		return usuarioServicio.login(usuario.getNombreUsuario(), usuario.getPasswordUsuario());
	}

}
