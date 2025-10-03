package com.vicentemilla.canciones.comVicenteMillaServicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vicentemilla.canciones.comVicenteMillaModelos.Cancion;
import com.vicentemilla.canciones.comVicentemillaRepositorios.RepositorioCanciones;
import java.util.Optional;

@Service
public class ServicioCanciones {
    @Autowired
    private RepositorioCanciones cancionRepository;

    public List<Cancion> obtenerTodasLasCanciones() {
        return cancionRepository.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> cancionOptional = cancionRepository.findById(id);
        return cancionOptional.orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Cancion actualizaCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void eliminaCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}
