package com.manejadorcurso.cursos.repository;

import com.manejadorcurso.cursos.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
