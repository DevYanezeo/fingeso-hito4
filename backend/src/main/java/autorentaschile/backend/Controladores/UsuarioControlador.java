package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Usuario;
import autorentaschile.backend.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;


@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
@RestController
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	// Endpoint para registrar un nuevo usuario (cliente)
	@PostMapping("/registrar")
	public Map<String, String> registerUser(@RequestBody Usuario usuario) {
		// Asignar el rol 1 para cliente
		return usuarioServicio.register(
				usuario.getRutUsuario(),
				usuario.getNombreUsuario(),
				usuario.getEmail(),
				usuario.getCelularUsuario(),
				usuario.getPasswordUsuario(),
				usuario.getDireccionUsuario(),
				usuario.getFechaNacimiento(),
				1L // Rol 1 para cliente
		);
	}

	// Endpoint para registrar un administrador (manual)
	@PostMapping("/registrarAdmin")
	public Map<String, String> registerAdmin(@RequestBody Usuario usuario) {
		// Asignar el rol 2 para administrador
		return usuarioServicio.register(
				usuario.getRutUsuario(),
				usuario.getNombreUsuario(),
				usuario.getEmail(),
				usuario.getCelularUsuario(),
				usuario.getPasswordUsuario(),
				usuario.getDireccionUsuario(),
				usuario.getFechaNacimiento(),
				2L // Rol 2 para administrador
		);
	}

	// Endpoint para loggear un usuario y verificar su rol
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Usuario usuario) {
		Map<String, String> response = new HashMap<>();

		// Verificar si el usuario existe
		Usuario usuarioExistente = usuarioServicio.findByEmail(usuario.getEmail());
		if (usuarioExistente == null) {
			response.put("status", "error");
			response.put("message", "El usuario no existe.");
			return response;
		}

		// Verificar si la contraseña es correcta
		if (!usuarioExistente.getPasswordUsuario().equals(usuario.getPasswordUsuario())) {
			response.put("status", "error");
			response.put("message", "Contraseña incorrecta.");
			return response;
		}

		// Si la autenticación es exitosa, agregar el rol del usuario
		response.put("status", "success");
		if (usuarioExistente.getIdRol() == 1L) {
			response.put("rol", "cliente");
		} else if (usuarioExistente.getIdRol() == 2L) {
			response.put("rol", "admin");
		} else {
			response.put("rol", "desconocido");
		}

		return response;
	}

}
