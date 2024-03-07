package com.manejadorcurso.cursos.service;

import com.manejadorcurso.cursos.model.Calificacion;
import com.manejadorcurso.cursos.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public Calificacion saveCalificacion(Calificacion calificacion){
        return calificacionRepository.save(calificacion);
    }

    public List<Calificacion> getAllCalificaciones(){
        return calificacionRepository.findAll();
    }

    public Calificacion getCalificacionById(Long id){
        return calificacionRepository.findById(id).orElse(null);
    }

    public void deleteCalificacion(Long id){
        calificacionRepository.deleteById(id);
    }
    public Calificacion updateCalificacion(Long id, Calificacion newCalificacion) {
        return calificacionRepository.findById(id)
                .map(calificacion -> {
                    calificacion.setCalificacion(newCalificacion.getCalificacion());
                    calificacion.setEstudiante(newCalificacion.getEstudiante());
                    calificacion.setCurso(newCalificacion.getCurso());
                    return calificacionRepository.save(calificacion);
                })
                .orElse(null);
    }
    
    public List<Calificacion>  getCalificacionesAprobadas(){
        
        return calificacionRepository.getCalificacionesAprobadas();
        
    }
}