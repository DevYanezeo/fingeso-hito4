package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Usuario;
import autorentaschile.backend.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	// Entrada: Datos del usuario
	// Descripcion: Toma los datos del usuario, crea un objeto con estos y lo guarda en la base
	// Salida: El usuario registrado
	public Usuario register(String rut, String nombre, String email, String celular, String password,
							String direccion, String sucursal_de_trabajo, String rol_empleado,
							String tipo_usuario, String fecha_nacimiento) {
		Usuario usuario = new Usuario(rut, nombre, email, celular, password, direccion,
				sucursal_de_trabajo, rol_empleado, tipo_usuario, fecha_nacimiento);
		Usuario existente = usuarioRepositorio.findByEmail(usuario.getEmail());
		if (existente != null) {
			return null;
		}
		return usuarioRepositorio.save(usuario);
	}

	// Métodos adicionales (login, etc.) permanecen iguales
}
