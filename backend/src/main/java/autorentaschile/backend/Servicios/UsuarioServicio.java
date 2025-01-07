package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Usuario;
import autorentaschile.backend.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;

@Service
public class UsuarioServicio {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	// Entrada: Datos del usuario
	// Descripcion: Toma los datos del usuario, crea un objeto con estos y lo guarda en la base
	// Salida: El usuario registrado
	public Map<String, String> register(String rut, String nombre, String email, String celular, String password,
										String direccion, String fechaNacimiento, Long idRol) {
		Map<String, String> response = new HashMap<>();

		// Verificar si el correo ya está registrado
		Usuario existente = usuarioRepositorio.findByEmail(email);
		if (existente != null) {
			// Si ya existe, enviar un mensaje de error
			response.put("status", "error");
			response.put("message", "El correo electrónico ya está registrado.");
			return response;
		}

		// Crear y guardar el nuevo usuario con el rol recibido
		Usuario usuario = new Usuario(rut, nombre, email, celular, password, direccion, idRol, fechaNacimiento);
		usuarioRepositorio.save(usuario);

		// Si el registro fue exitoso
		response.put("status", "success");
		response.put("message", "Usuario registrado exitosamente.");
		return response;
	}

	// Metodo Inicio de Sesion
	public boolean login(String email, String passwordUsuario){
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		if(usuario != null) {
			if(usuario.getPasswordUsuario().equals(passwordUsuario)) {
				return true;
			}
		}
		return false;
	}
	public Usuario findByEmail(String email) {
		return usuarioRepositorio.findByEmail(email); // Devuelve el usuario o null si no existe
	}


}
