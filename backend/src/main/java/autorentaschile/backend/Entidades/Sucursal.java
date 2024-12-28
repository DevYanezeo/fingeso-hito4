package autorentaschile.backend.Entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sucursal")
@Data
@JsonIgnoreProperties({"sucursalVehiculo"})
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> sucursalVehiculo;

    public Sucursal() {
    }

    public Sucursal(String nombre, String direccion, String telefono, String email, ArrayList<Vehiculo> vehiculosSucursal) {
		this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sucursalVehiculo = vehiculosSucursal;
    }

    public long getId() {
        return idSucursal;
    }

    public void setId(long id) {
        this.idSucursal = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vehiculo> getSucursalVehiculo() {
        return sucursalVehiculo;
    }

    public void setSucursalVehiculo(List<Vehiculo> sucursalVehiculo) {
        this.sucursalVehiculo = sucursalVehiculo;
    }
}
