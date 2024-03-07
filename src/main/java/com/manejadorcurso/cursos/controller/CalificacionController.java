package com.manejadorcurso.cursos.controller;

import com.manejadorcurso.cursos.model.Calificacion;
import com.manejadorcurso.cursos.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> createCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.saveCalificacion(calificacion));
    }

    @GetMapping("/listar")
    public List<Calificacion> getAllCalificaciones(){
        return calificacionService.getAllCalificaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> getCalificacionById(@PathVariable Long id){
        Calificacion calificacion = calificacionService.getCalificacionById(id);
        return calificacion != null ? ResponseEntity.ok(calificacion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        calificacionService.deleteCalificacion(id);
        return ResponseEntity.ok("Calificación eliminada");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> updateCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        Calificacion updatedCalificacion = calificacionService.updateCalificacion(id, calificacion);
        if (updatedCalificacion != null) {
            return new ResponseEntity<>(updatedCalificacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/aprobadas")
    public List<Calificacion>  getCalificacionesAprobadas(){
        return calificacionService.getCalificacionesAprobadas();
    } 
}