package PDF;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Grupo;
import modelo.Materia;

/**
 *
 * @author Itzel_CG
 */
public class ControladorGrupo {
    
     public static boolean existeGrupo(String nombre) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT nombre FROM grupo WHERE nombre = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia del grupo: " + e.toString());
        }
        
        return existe;
    }
    
    
    public static boolean insertarGrupo(Grupo grupo) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO grupo (nombre) VALUES ( ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
           // ps.setString(1, grupo.getNombre());
           
          
            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar grupo: " + e.toString());
        }
        
        return insertado;
    }
    
    
    
    
    
}
