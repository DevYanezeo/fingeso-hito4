package autorentaschile.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	private long idVehiculo;
	private long idEmpleado;
	private boolean enMalEstado;
	private boolean entregadoTarde;
	private int nivelGasolina;
	private int nivelAceite;
	private Date fecha;


	// Constructor

	public Reporte(long idEmpleado, long idVehiculo, boolean enMalEstado, boolean entregadoTarde, int nivelAceite, int nivelGasolina, Date fecha) {
		this.nivelAceite = nivelAceite;
		this.nivelGasolina = nivelGasolina;
		this.entregadoTarde = entregadoTarde;
		this.enMalEstado = enMalEstado;
		this.idEmpleado = idEmpleado;
		this.idVehiculo = idVehiculo;
	}


	// Getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public boolean isEnMalEstado() {
		return enMalEstado;
	}

	public void setEnMalEstado(boolean enMalEstado) {
		this.enMalEstado = enMalEstado;
	}

	public boolean isEntregadoTarde() {
		return entregadoTarde;
	}

	public void setEntregadoTarde(boolean entregadoTarde) {
		this.entregadoTarde = entregadoTarde;
	}

	public int getNivelGasolina() {
		return nivelGasolina;
	}

	public void setNivelGasolina(int nivelGasolina) {
		this.nivelGasolina = nivelGasolina;
	}

	public int getNivelAceite() {
		return nivelAceite;
	}

	public void setNivelAceite(int nivelAceite) {
		this.nivelAceite = nivelAceite;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
