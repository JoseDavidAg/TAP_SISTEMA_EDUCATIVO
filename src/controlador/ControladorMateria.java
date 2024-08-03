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
import java.util.ArrayList;
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
        String sql = "SELECT COUNT(*) FROM materia WHERE IdMateria = ?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // If count > 0, materia exists
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al comprobar existencia de la materia: " + e.getMessage());
        }

        return existe;
    }

   

    public static boolean insertarMateria(Materia materia) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO materia (IdMateria, idCurso) VALUES (?, ?)";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            // Set the parameters
            ps.setString(1, materia.getIdMateria());
            ps.setInt(2, materia.getIdCurso());

            // Execute the update and check if at least one row was affected
            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar materia: " + e.getMessage());
        }

        return insertado;
    }


    
    
    public static ArrayList<String> obtenerIdCursos() {
        ArrayList<String> idCursos = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT IdCurso FROM materia";

        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                idCursos.add(rs.getString("IdCurso"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los IdCurso: " + e.toString());
        }

        return idCursos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
