package autorentaschile.backend.Entidades;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Entity
@Table(name = "reserva")
@Data
public class Reserva {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idReserva;
    private String rutUsuario;                  // RUT del usuario que realiza la reserva
    private int idSucursalRetiro;                // ID de la sucursal donde se retira el vehículo
    private String fechaRetiro;                    // Fecha de retiro del vehículo
    private String fechaDevolucion;                // Fecha de devolución del vehículo
    private int idSucursalDevolucion;            // ID de la sucursal donde se devuelve el vehículo
    private String patenteVehiculo;      // Patente del vehículo asignado
    private String estadoReserva;                       // Estado de la reserva (pendiente, entregado, finalizado)


    // Constructor

    public Reserva() {

    }

    public Reserva(String rutUsuario, int idSucursalRetiro, String fechaRetiro, String fechaDevolucion, int idSucursalDevolucion, String patenteVehiculo, String estadoReserva) {
        this.rutUsuario = rutUsuario;
        this.idSucursalRetiro = idSucursalRetiro;
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.idSucursalDevolucion = idSucursalDevolucion;
        this.patenteVehiculo = patenteVehiculo;
        this.estadoReserva = estadoReserva;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
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

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdSucursalDevolucion() {
        return idSucursalDevolucion;
    }

    public void setIdSucursalDevolucion(int idSucursalDevolucion) {
        this.idSucursalDevolucion = idSucursalDevolucion;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
