/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

//import com.sun.jdi.connect.spi.Connection;


/**
 *
 * @author Itzel_CG
 */


import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
  
    public static Connection conectar(){
        try {
       
             Class.forName("com.mysql.cj.jdbc.Driver");
              
            String url = "jdbc:mysql://localhost:3306/finaldata2";
            String usuario = "root";
            String contraseña = "Da+!R947}5N3a";

            Connection cn = DriverManager.getConnection(url, usuario, contraseña);
          
            return cn;
           
        } catch (Exception e){
           
                    
            JOptionPane.showMessageDialog (null, "Problemas en la conexión  " + e.toString());
        }
    
        return null;
        
    }
}
