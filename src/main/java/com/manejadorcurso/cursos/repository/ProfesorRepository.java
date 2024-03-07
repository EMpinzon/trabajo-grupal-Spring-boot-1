package com.manejadorcurso.cursos.repository;

import com.manejadorcurso.cursos.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
