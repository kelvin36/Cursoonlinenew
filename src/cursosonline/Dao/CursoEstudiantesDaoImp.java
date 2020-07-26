/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosonline.Dao;

import Conexiones.Conexion;
import cursosonline.entidades.CursosEstudiantes;
import cursosonline.entidades.Estudiantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelvin
 */
public class CursoEstudiantesDaoImp implements CursoEstudianteDao{

    @Override
    public List<CursosEstudiantes> getCursEstudiantes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          List<CursosEstudiantes> csestudiante=new ArrayList<>();
       Connection conn;
        try {
           conn = Conexion.conector();
           String sql="select id, cursos_id,estudiantes_id from public.cursos_estudiantes;";
           PreparedStatement stm= conn.prepareStatement(sql);
           ResultSet rs=stm.executeQuery();
           while(rs.next()){
               CursosEstudiantes crestudiantes =new CursosEstudiantes();
               crestudiantes.setId(rs.getInt(1));
               crestudiantes.setCursoId(rs.getInt(2));
               crestudiantes.setEstudianteid(rs.getInt(3));
               csestudiante.add(crestudiantes);
               

                       }
        
      }catch (SQLException ex) {
            
              ex.printStackTrace();
         }
        return csestudiante;
    }
    

    @Override
    public void ingresarCE(CursosEstudiantes cestudiantes) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            Conexion conexion = new Conexion();
            Connection conn = null;
            conn = Conexion.conector();
            String sql = "INSERT INTO  public.cursos_estudiantes(cursos_id, estudiantes_id) values (?, ?);";
            PreparedStatement psta = conn.prepareStatement(sql);
            psta.setInt(1, cestudiantes.getCursoId());
            psta.setInt(2, cestudiantes.getEstudianteid());
           
            psta.execute();
         
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    
    }
    

    @Override
    public void actualizarCE(CursosEstudiantes cestudiantes) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            Conexion conexion = new Conexion();
            Connection conn = null;
            conn =Conexion.conector();
            String sqlinsertar = "Update  public.cursos_estudiantes set cursos_id=? where id=?";
            PreparedStatement psta = conn.prepareStatement(sqlinsertar);
            psta.setInt(1, cestudiantes.getCursoId());
            psta.setInt(2, cestudiantes.getId());
            psta.execute();
            
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @Override
    public void eliminarCE(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            Conexion coneccion = new Conexion();
            Connection conn = null;
            conn = Conexion.conector();
            String sqldelete = "Delete From  public.cursos_estudiantes where id=?";
            PreparedStatement psta = conn.prepareStatement(sqldelete);
            psta.setInt(1, id);
            psta.execute();
           // conn.commit();
            psta.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    
    
    }
    
}
