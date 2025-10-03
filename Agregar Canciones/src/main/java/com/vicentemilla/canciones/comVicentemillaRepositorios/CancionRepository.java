package com.vicentemilla.canciones.comVicentemillaRepositorios;

import com.vicentemilla.canciones.comVicenteMillaModelos.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
    public interface CancionRepository extends CrudRepository<Cancion, Long> {
        List<Cancion> findAll();
    }
