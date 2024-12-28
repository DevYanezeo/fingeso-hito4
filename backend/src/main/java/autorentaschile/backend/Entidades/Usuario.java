package autorentaschile.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	// Correspondientes a los campos del formulario frontend
	private String rutUsuario;             // RUT del usuario
	private String nombreUsuario;          // Nombre completo del usuario
	private String email;                  // Correo electrónico
	private String celularUsuario;         // Teléfono celular
	private String passwordUsuario;        // Contraseña
	private String direccionUsuario;       // Dirección del usuario
	private String sucursalDeTrabajo;      // Sucursal de trabajo (si aplica)
	private String rolEmpleado;            // Rol del empleado (puede ser cliente, admin, etc.)
	private String tipoUsuario;            // Tipo de usuario (admin, cliente, arrendador, etc.)
	private String fechaNacimiento;        // Fecha de nacimiento del usuario

	// Constructor
	public Usuario(String rutUsuario, String nombreUsuario, String email, String celularUsuario,
				   String passwordUsuario, String direccionUsuario, String sucursalDeTrabajo,
				   String rolEmpleado, String tipoUsuario, String fechaNacimiento) {
		this.rutUsuario = rutUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.celularUsuario = celularUsuario;
		this.passwordUsuario = passwordUsuario;
		this.direccionUsuario = direccionUsuario;
		this.sucursalDeTrabajo = sucursalDeTrabajo;
		this.rolEmpleado = rolEmpleado;
		this.tipoUsuario = tipoUsuario;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRutUsuario() {
		return rutUsuario;
	}

	public void setRutUsuario(String rutUsuario) {
		this.rutUsuario = rutUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelularUsuario() {
		return celularUsuario;
	}

	public void setCelularUsuario(String celularUsuario) {
		this.celularUsuario = celularUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getSucursalDeTrabajo() {
		return sucursalDeTrabajo;
	}

	public void setSucursalDeTrabajo(String sucursalDeTrabajo) {
		this.sucursalDeTrabajo = sucursalDeTrabajo;
	}

	public String getRolEmpleado() {
		return rolEmpleado;
	}

	public void setRolEmpleado(String rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}


