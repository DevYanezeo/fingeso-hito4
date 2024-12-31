package autorentaschile.backend.Entidades;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Entity
@Table(name = "boleta")
@Data

public class Boleta {

    // Atributos
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idBoleta;           // ID único de la boleta
    private int idReserva;          // ID de la reserva asociada a la boleta
    private Date fechaEmision;      // Fecha de emisión de la boleta
    private double montoTotal;      // Monto total de la boleta
    private String estadoPago;      // Estado del pago (pendiente, pagado, cancelado)
    private String rutUsuario;      // RUT del usuario que realizó el pago

    // Constructor
    public Boleta(int idBoleta, int idReserva, Date fechaEmision, double montoTotal,
                  String estadoPago, String rutUsuario) {
        this.idBoleta = idBoleta;
        this.idReserva = idReserva;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.estadoPago = estadoPago;
        this.rutUsuario = rutUsuario;
    }

    public Boleta() {

    }
    // Getters y Setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public long getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(long idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
}
