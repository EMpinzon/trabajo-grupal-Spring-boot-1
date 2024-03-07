package com.manejadorcurso.cursos.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity

public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nombre;
    private  String asignatura;

    @OneToMany(mappedBy = "profesor")
    private Set<Curso> cursos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Profesor :" +
                "id=" + id +
                "nombre='" + nombre + '\'' +
                "asignatura='" + asignatura + '\'' +
                "cursos=" + cursos ;
    }
}
