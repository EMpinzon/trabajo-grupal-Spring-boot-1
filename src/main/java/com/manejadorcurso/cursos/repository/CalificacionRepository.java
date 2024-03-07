package com.manejadorcurso.cursos.repository;

import com.manejadorcurso.cursos.model.Calificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {
    
    @Query("select c from Calificacion c where c.calificacion > 6")
   public List<Calificacion> getCalificacionesAprobadas();
}
