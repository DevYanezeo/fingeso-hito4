package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Reporte;
import autorentaschile.backend.Repositorios.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ReporteServicio {
	@Autowired
	private ReporteRepositorio reporteRepositorio;

	// Entrada: Datos necesarios para el reporte
	// Descripcion: Toma los datos y guarda el reporte en la base
	// Salida: El reporte guardado
	public Reporte crearReporte(Long idVehiculo, Long idEmpleado, Boolean enMalEstado, Boolean entregadoTarde, Integer nivelGasolina, Integer nivelAceite, Date fecha){
		Reporte reporte = new Reporte(idVehiculo, idEmpleado, enMalEstado, entregadoTarde, nivelGasolina, nivelAceite, fecha);
		Optional<Reporte> existente = reporteRepositorio.findById(reporte.getId());
		if (existente.isPresent()){
			return null;
		}
		return reporteRepositorio.save(reporte);
	}
}
