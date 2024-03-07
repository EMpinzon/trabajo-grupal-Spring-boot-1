package com.manejadorcurso.cursos.repository;

import com.manejadorcurso.cursos.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {
    
    @Override
    Optional<Inscripcion> findById(Long id);
}
