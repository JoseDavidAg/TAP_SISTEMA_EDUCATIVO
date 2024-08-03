/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Materia;

/**
 *
 * @author Itzel_CG
 */
public class ControladorMateria {
    
    
    
    
    public static boolean existeMateria(String nombre) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT IdMateria FROM materia WHERE IdMateria = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia de la materia: " + e.toString());
        }
        
        return existe;
    }
    
    
    public static boolean insertarMateria(Materia materia) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO materia (IdMateria, IdCurso) VALUES (?, ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, materia.getIdMateria());
            ps.setInt(2, materia.getIdCurso());
          
            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar materia: " + e.toString());
        }
        
        return insertado;
    }
    
    
    
    
}
