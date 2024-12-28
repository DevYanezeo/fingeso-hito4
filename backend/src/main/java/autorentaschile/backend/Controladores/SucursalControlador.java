package autorentaschile.backend.Controladores;

import autorentaschile.backend.Entidades.Sucursal;
import autorentaschile.backend.Servicios.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursal")
@CrossOrigin(origins = "*")
public class SucursalControlador {

    @Autowired
    private SucursalServicio sucursalServicio;

    // Endpoint para obtener todas las sucursales
    @GetMapping
    public List<Sucursal> obtenerSucursales() {
        return sucursalServicio.obtenerSucursales();
    }

    // Endpoint para obtener una sucursal por ID
    @GetMapping("/{id}")
    public Sucursal obtenerSucursalPorId(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalServicio.obtenerSucursalPorId(id);
        return sucursal.orElse(null);  // Retorna null si no se encuentra la sucursal (puedes mejorar esto con un manejo adecuado de excepciones)
    }
}
