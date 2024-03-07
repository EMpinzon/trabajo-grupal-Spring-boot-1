package com.manejadorcurso.cursos.controller;


import com.manejadorcurso.cursos.model.Estudiante;
import com.manejadorcurso.cursos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.saveEstudiante(estudiante);
    }

    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable Long id){
        return estudianteService.getEstudianteById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEstudianteById(@PathVariable Long id){
        estudianteService.deleteEstudiante(id);
        return "Estudiante eliminado";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante updatedEstudiante = estudianteService.updateEstudiante(id, estudiante);
        if (updatedEstudiante != null) {
            return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}