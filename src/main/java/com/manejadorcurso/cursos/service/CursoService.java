package com.manejadorcurso.cursos.service;

import com.manejadorcurso.cursos.model.Curso;
import com.manejadorcurso.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso updateCurso(Long id, Curso cursoDetails) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setNombre(cursoDetails.getNombre());
                    curso.setDescripcion(cursoDetails.getDescripcion());
                    curso.setProfesor(cursoDetails.getProfesor());
                    return cursoRepository.save(curso);
                })
                .orElseGet(() -> {
                    cursoDetails.setId(id);
                    return cursoRepository.save(cursoDetails);
                });
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
    
    public  List<Curso> getCursosConMuchasInscripciones(){
        return cursoRepository.getCursosConMuchasInscripciones();
    }
}