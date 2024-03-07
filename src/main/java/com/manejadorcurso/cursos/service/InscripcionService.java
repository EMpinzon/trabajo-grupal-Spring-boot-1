package com.manejadorcurso.cursos.service;

import com.manejadorcurso.cursos.model.Inscripcion;
import com.manejadorcurso.cursos.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion saveInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion getInscripcionById(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    public Inscripcion updateInscripcion(Long id, Inscripcion inscripcionDetails) {
        return inscripcionRepository.findById(id).map(inscripcion -> {
            inscripcion.setEstudiante(inscripcionDetails.getEstudiante());
            inscripcion.setCurso(inscripcionDetails.getCurso());
            return inscripcionRepository.save(inscripcion);
        }).orElseGet(() -> {
            inscripcionDetails.setId(id);
            return inscripcionRepository.save(inscripcionDetails);
        });
    }
}