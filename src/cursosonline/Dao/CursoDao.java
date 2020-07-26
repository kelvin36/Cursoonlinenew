/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.Dao;


import cursosonline.entidades.Curso;
import cursosonline.entidades.Estudiantes;
import java.util.List;

/**
 *
 * @author Kelvin
 */
public interface CursoDao {
    List<Curso> getCursos();
    public void ingresar(Curso cursos);

    public void actualizar(Curso cursos);

    public void eliminar(int id);
      List<Estudiantes> getEstudiantePorCurso(int cursoId);
    
}
