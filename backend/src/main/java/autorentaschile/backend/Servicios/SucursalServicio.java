package autorentaschile.backend.Servicios;

import autorentaschile.backend.Entidades.Sucursal;
import autorentaschile.backend.Repositorios.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServicio {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    // Método que obtiene todas las sucursales
    public List<Sucursal> obtenerSucursales() {
        return sucursalRepositorio.findAll();
    }

    // Método para obtener una sucursal por su ID
    public Optional<Sucursal> obtenerSucursalPorId(Long id) {
        return sucursalRepositorio.findById(id);
    }
}
