package com.vicentemilla.canciones.comVicenteMillaControladores;

import com.vicentemilla.canciones.comVicenteMillaModelos.Cancion;
import com.vicentemilla.canciones.comVicenteMillaServicios.ServicioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping
    public String listarCanciones(Model model) {
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "Canciones";
    }

    @GetMapping("/detalle/{id}")
    public String detalleCancion(@PathVariable Long id, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "detalleCanciones";
    }

    @GetMapping("/formulario/agregar")
    public String formularioAgregar(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion";
    }

    @PostMapping("/agregar")
    public String agregarCancion(@ModelAttribute Cancion cancion) {
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/formulario/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    @PostMapping("/editar")
    public String editarCancion(@ModelAttribute Cancion cancion) {
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCancion(@PathVariable Long id) {
        servicioCanciones.eliminaCancion(id);
        return "redirect:/canciones";
    }

}
