/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import curso.util.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.rmi.CORBA.Util;


/**
 *
 * @author Kelvin
 */
public class Conexion {
 

    static Connection conn = null;
    public static Connection conector() {
        
         
            
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(util.url,util.user, util.password);
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
            System.out.println("La conexión hecha " + "Eduardo olvera");
          return conn;  
    }
  public static void cerrar() throws SQLException {
      if (conn != null) {
         conn.close();
      }
   }
    
}
