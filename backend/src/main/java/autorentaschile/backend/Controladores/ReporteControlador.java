package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Reporte;
import autorentaschile.backend.Servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reporte")
public class ReporteControlador {

	@Autowired
	private ReporteServicio reporteServicio;

	// Crear reporte
	@PostMapping("/crearReporte")
	public Reporte crearReporte(@RequestBody Reporte nuevoReporte) {
		return reporteServicio.crearReporte(
				nuevoReporte.getIdVehiculo(),
				nuevoReporte.getIdEmpleado(),
				nuevoReporte.isEnMalEstado(),
				nuevoReporte.isEntregadoTarde(),
				nuevoReporte.getNivelGasolina(),
				nuevoReporte.getNivelAceite(),
				nuevoReporte.getFecha()
		);
	}
}
