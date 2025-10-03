package com.vicentemilla.canciones.comVicenteMillaControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.vicentemilla.canciones.comVicenteMillaModelos.*;
import com.vicentemilla.canciones.comVicenteMillaServicios.*;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired
	private ServicioCanciones servicioCanciones;
	
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }
    
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            modelo.addAttribute("cancion", cancion);
            return "detallecanciones";
        } else {
            modelo.addAttribute("mensajeError", "Canción no encontrada");
            return "detallecanciones";
        }
    }
    
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute Cancion cancion) {
        return "agregarcancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion,
    		BindingResult validaciones, Model modelo) {
        if (validaciones.hasErrors()) {
            return "agregarcancion";
        }
        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String muestraFormularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancionActual);
        return "editarcancion";
    }

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable Long idCancion,
                                        @Valid @ModelAttribute Cancion cancion,
                                        BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "editarcancion";
        }
        cancion.setId(idCancion);
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }
    
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion) {
        this.servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}