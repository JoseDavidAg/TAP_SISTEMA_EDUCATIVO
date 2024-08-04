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
import java.sql.Statement;
import java.util.ArrayList;
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
        String sql = "SELECT IdGrupo FROM grupo WHERE IdGrupo = ?";
        
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
    String sql = "INSERT INTO grupo (IdGrupo, idCurso) VALUES (?, ?)";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        // Set the parameters
        ps.setString(1, grupo.getIdGrupo());
        ps.setInt(2, grupo.getIdCurso());

        // Execute the update and check if at least one row was affected
        insertado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar grupo: " + e.getMessage());
    }

    return insertado;
}

    
    
     
    public static ArrayList<String> obtenerIdCursos() {
        ArrayList<String> idCursos = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT IdCurso FROM curso";

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
