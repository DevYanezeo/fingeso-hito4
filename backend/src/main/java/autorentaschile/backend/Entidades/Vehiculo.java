package autorentaschile.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor

public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(nullable = false) // No permitir que la patente sea nula
	private String patente;

	private String marca;
	private String modelo;
	private String categoria; // Auto, moto, etc.
	private String estado; // Disponible o no

	@ManyToOne
	@JoinColumn(name = "sucursal_id")
	private Sucursal sucursal;

	private String transmision;
	private String combustible;
	private String kilometraje;
	private String imagenUrl;

	// Constructor vacío
	public Vehiculo() {
	}

	// Constructor con todos los atributos
	public Vehiculo(String patente, String marca, String modelo, String categoria, String estado, Sucursal sucursal, String transmision, String combustible, String kilometraje, String imagenUrl) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.categoria = categoria;
		this.estado = estado;
		this.sucursal = sucursal;
		this.transmision = transmision;
		this.combustible = combustible;
		this.kilometraje = kilometraje;
		this.imagenUrl = imagenUrl;
	}

	// Getter y Setter para patente
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	// Otros getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
}