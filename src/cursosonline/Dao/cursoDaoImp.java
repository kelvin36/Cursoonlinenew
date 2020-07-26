/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.Dao;

import Conexiones.Conexion;
import curso.util.util;

import cursosonline.entidades.Curso;
import cursosonline.entidades.Estudiantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelvin
 */
public class cursoDaoImp implements CursoDao{
    


    @Override
    public List<Curso> getCursos() {
       List<Curso> cursos=new ArrayList<>();
       Connection conn;
        try {
           conn = Conexion.conector();
           String sql="select id, nombre from public.cursos;";
           PreparedStatement stm= conn.prepareStatement(sql);
           ResultSet rs=stm.executeQuery();
           while(rs.next()){
               Curso curso =new Curso(rs.getInt(1), rs.getString(2));
               cursos.add(curso);
               

                       }
        
      }catch (SQLException ex) {
            
              ex.printStackTrace();
         }
        return cursos;
    }

    @Override
    public void ingresar(Curso cursos) {
     try {
            Conexion conexion = new Conexion();
            Connection conn = null;
            conn = Conexion.conector();
            String sql = "INSERT INTO  public.cursos(nombre) values (?);";
            PreparedStatement psta = conn.prepareStatement(sql);
            psta.setString(1, cursos.getNombre());
            psta.execute();
         
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    

    @Override
    public void actualizar(Curso cursos) {
      try {
            Conexion conexion = new Conexion();
            Connection conn = null;
            conn =Conexion.conector();
            String sqlinsertar = "Update  public.cursos set nombre=? where id=?";
            PreparedStatement psta = conn.prepareStatement(sqlinsertar);
            psta.setString(1, cursos.getNombre());
            psta.setInt(2, cursos.getId());
            psta.execute();
            
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @Override
    public void eliminar(int id) {
    try {
            Conexion coneccion = new Conexion();
            Connection conn = null;
            conn = Conexion.conector();
            String sqldelete = "Delete From  public.cursos where id=?";
            PreparedStatement psta = conn.prepareStatement(sqldelete);
            psta.setInt(1, id);
            psta.execute();
           // conn.commit();
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @Override
    public List<Estudiantes> getEstudiantePorCurso(int cursoId) {
                String query = "SELECT estudiantes.id, nombres, apellidos, email\n" +
"	FROM public.estudiantes\n" +
"	INNER JOIN cursos_estudiantes on estudiantes.id = cursos_estudiantes.estudiante_id\n" +
"	where cursos_estudiantes.curso_id=?;";
        List<Estudiantes> estudiante = new ArrayList<Estudiantes>();
        Connection con;
        try {
            con = DriverManager.getConnection(util.url, util.user, util.password);
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, cursoId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Estudiantes estudiantes = new Estudiantes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                estudiante.add(estudiantes);
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return estudiante;
    }
    
    
}
