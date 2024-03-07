package com.manejadorcurso.cursos.repository;

import com.manejadorcurso.cursos.model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    
    @Query("SELECT c FROM Curso c WHERE SIZE(c.inscripciones) > 3")
    public List<Curso> getCursosConMuchasInscripciones();
}
