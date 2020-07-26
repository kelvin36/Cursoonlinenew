/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.entidades;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelvin
 */
public class Curso {
  private int id;
    private String nombre;
    private List<Estudiantes> estudiante = new ArrayList<>();
    
    
    public List<Estudiantes> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<Estudiantes> estudiante) {
        this.estudiante = estudiante;
    }
   
    public Curso(){}
    public Curso(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}