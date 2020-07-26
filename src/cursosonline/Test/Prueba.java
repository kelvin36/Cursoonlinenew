/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.Test;

import cursosonline.Dao.CursoDao;
import cursosonline.Dao.CursoEstudianteDao;
import cursosonline.Dao.CursoEstudiantesDaoImp;
import cursosonline.Dao.EstudiantesDao;
import cursosonline.Dao.cursoDaoImp;
import cursosonline.Dao.estudiantesDaoImp;
import cursosonline.entidades.Curso;
import cursosonline.entidades.CursosEstudiantes;
import cursosonline.entidades.Estudiantes;

/**
 *
 * @author Antum
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Ingresar
        CursoDao  cursoD = new cursoDaoImp();
       Curso cursos=new Curso(0,"Matematicas");
        cursoD.ingresar(cursos);
        //Actualizar
         /*Curso cursos1=new Curso(3,"Sociales");
        cursoD.actualizar(cursos1);*/
        // Eliminar 
        //Curso cursos2=new Curso(6,"Lenguaje");
        //cursoD.eliminar(6);
      EstudiantesDao  estuD = new estudiantesDaoImp();
       // Estudiantes estudiantes=new Estudiantes(0,"juan","Cedeño","juanc@gmail.com");
        //estuD.ingresarE(estudiantes);
        //Actualizar
         /*Estudiantes estu1=new Estudiantes(1,"andrade17@hotmail.com");
        estuD.actualizarE(estu1);*/
        // Eliminar 
        //Estudiantes estudiantes=new Estudiantes(1,"Luis","Lopez","lulo@gmail.com");
          //estuD.eliminarE(1);
          
           CursoEstudianteDao  cestuD = new CursoEstudiantesDaoImp();
       // CursosEstudiantes crsestudiantes=new CursosEstudiantes(0,3,2);
        //cestuD.ingresarCE(crsestudiantes);
        //Actualizar
        //CursosEstudiantes cestu1=new CursosEstudiantes(1,1,1);
        //cestuD.actualizarCE(cestu1);
        // Eliminar 
      // CursosEstudiantes crestudiantes=new CursosEstudiantes(3,1,1);
        //cestuD.eliminarCE(3);
        for (Curso e : cursoD.getCursos()){
            System.out.println(e.getId() + "-" + e.getNombre());
          
        
                
            
    }
         /*for (Estudiantes r : estuD.getEstudiantes()){
            System.out.println(r.getId() + "-" + r.getNombre()+ "-"+ r.getApellido()+ "-" + r.getEmail());
            
    }*/
        //for (CursosEstudiantes ce : cestuD.getCursEstudiantes()){
           // System.out.println(ce.getId() + "-" + ce.getCursoId() + "-" + ce.getEstudianteid());
    }
}
