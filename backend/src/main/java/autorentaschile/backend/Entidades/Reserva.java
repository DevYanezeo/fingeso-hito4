package autorentaschile.backend.Entidades;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Entity
@Table(name = "reserva")
@Data
public class Reserva {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idReserva;
    private String rutUsuario;                  // RUT del usuario que realiza la reserva
    private int idSucursalRetiro;                // ID de la sucursal donde se retira el vehículo
    private Date fechaRetiro;                    // Fecha de retiro del vehículo
    private Date fechaDevolucion;                // Fecha de devolución del vehículo
    private int idSucursalDevolucion;            // ID de la sucursal donde se devuelve el vehículo
    private String categoriaVehiculo;            // Categoría del vehículo (ej. SUV, sedán, etc.)
    private String patenteVehiculoAsignado;      // Patente del vehículo asignado
    private String estadoReserva;                       // Estado de la reserva (pendiente, entregado, finalizado)
    private Date fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "idBoleta")
    private Boleta idBoleta;                        // ID de la boleta asociada a la reserva


    // Constructor
    public Reserva(String rutUsuario, int idSucursalRetiro, Date fechaRetiro, Date fechaDevolucion,
                   int idSucursalDevolucion, String categoriaVehiculo, String patenteVehiculoAsignado,
                   String estadoReserva, Date fechaCreacion, Boleta idBoleta) {
        this.rutUsuario = rutUsuario;
        this.idSucursalRetiro = idSucursalRetiro;
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.idSucursalDevolucion = idSucursalDevolucion;
        this.categoriaVehiculo = categoriaVehiculo;
        this.patenteVehiculoAsignado = patenteVehiculoAsignado;
        this.estadoReserva = estadoReserva;
        this.fechaCreacion = fechaCreacion;
        this.idBoleta = idBoleta;
    }

    public Reserva() {

    }

    // Getters y Setters

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public int getIdSucursalRetiro() {
        return idSucursalRetiro;
    }

    public void setIdSucursalRetiro(int idSucursalRetiro) {
        this.idSucursalRetiro = idSucursalRetiro;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdSucursalDevolucion() {
        return idSucursalDevolucion;
    }

    public void setIdSucursalDevolucion(int idSucursalDevolucion) {
        this.idSucursalDevolucion = idSucursalDevolucion;
    }

    public String getCategoriaVehiculo() {
        return categoriaVehiculo;
    }

    public void setCategoriaVehiculo(String categoriaVehiculo) {
        this.categoriaVehiculo = categoriaVehiculo;
    }

    public String getPatenteVehiculoAsignado() {
        return patenteVehiculoAsignado;
    }

    public void setPatenteVehiculoAsignado(String patenteVehiculoAsignado) {
        this.patenteVehiculoAsignado = patenteVehiculoAsignado;
    }

    public String getEstado() {
        return estadoReserva;
    }

    public void setEstado(String estado) {
        this.estadoReserva = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boleta getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Boleta idBoleta) {
        this.idBoleta = idBoleta;
    }
}
