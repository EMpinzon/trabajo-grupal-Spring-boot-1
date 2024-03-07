package com.manejadorcurso.cursos.service;

import com.manejadorcurso.cursos.model.Estudiante;
import com.manejadorcurso.cursos.model.Profesor;
import com.manejadorcurso.cursos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor saveProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public List<Profesor> getAllProfesor(){
        return  profesorRepository.findAll();
    }

    public Profesor getProfesorById(Long id){
        return  profesorRepository.findById(id).orElse(null);
    }

    public  void deleteProfesor (Long id){
        profesorRepository.deleteById(id);
    }
    public Profesor updateProfesor(Long id, Profesor newProfesor) {
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setNombre(newProfesor.getNombre());
                    profesor.setAsignatura(newProfesor.getAsignatura());
                    return profesorRepository.save(profesor);
                })
                .orElseGet(() -> {
                    newProfesor.setId(id);
                    return profesorRepository.save(newProfesor);
                });
    }

}
