package com.manejadorcurso.cursos.service;

import com.manejadorcurso.cursos.model.Estudiante;
import com.manejadorcurso.cursos.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante saveEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> getAllEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudianteById(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }

    public void deleteEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }

    public Estudiante updateEstudiante(Long id, Estudiante newEstudiante) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(newEstudiante.getNombre());
                    estudiante.setFechaNacimiento(newEstudiante.getFechaNacimiento());
                    estudiante.setGrado(newEstudiante.getGrado());
                    return estudianteRepository.save(estudiante);
                })
                .orElseGet(() -> {
                    newEstudiante.setId(id);
                    return estudianteRepository.save(newEstudiante);
                });
    }
}