package com.manejadorcurso.cursos.controller;

import com.manejadorcurso.cursos.model.Profesor;
import com.manejadorcurso.cursos.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {


    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor){
        return  profesorService.saveProfesor(profesor);
    }

    @GetMapping("/profesores")
    @ResponseBody
    public List<Profesor> getAllProfesores(){
        return profesorService.getAllProfesor();
    }
    @GetMapping("/{id}")
    public  Profesor getProfesorById(@PathVariable Long id){
        return  profesorService.getProfesorById(id);
    }

    @DeleteMapping("/{id}")
    public  String deleteByID(@PathVariable Long id){
        profesorService.deleteProfesor(id);
        return  "Profesor eliminado";
    }
}
