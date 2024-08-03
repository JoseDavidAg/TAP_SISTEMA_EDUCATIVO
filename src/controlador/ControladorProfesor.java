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
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Profesor;

/**
 *
 * @author Itzel_CG
 */
public class ControladorProfesor {
    
    
    
     public static boolean insertarProfesor(Profesor profesor) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO tb_profesor (nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellidoP());
            ps.setString(3, profesor.getApellidoM());            
            ps.setString(4, profesor.getDireccion());   
            ps.setString(5, profesor.getTelefono());
            ps.setString(6, profesor.getEspecialidad());
            ps.setString(7, profesor.getCedula());
          
          
            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar profesor: " + e.toString());
        }
        
        return insertado;
    }
    
    
    
    
    
     public static boolean existeProfesor(String cedula) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT cedula FROM tb_profesor WHERE cedula = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia del profesor: " + e.toString());
        }
        
        return existe;
    }
    
    
     
     
     public static boolean eliminarProfesor(String cedula) {
        boolean eliminado = false;
        Connection cn = Conexion.conectar();
        String sql = "DELETE FROM tb_profesor WHERE cedula = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cedula);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar profesor: " + e.toString());
        }
        
        return eliminado;
    } 
    
     
     
     
     public static List<Profesor> obtenerProfesor() {
        List<Profesor> listaProfesor = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula FROM tb_profesor";

        try (PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Profesor profesor = new Profesor();
                
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellidoP(rs.getString("apellidoP"));
                profesor.setApellidoM(rs.getString("apellidoM"));
                profesor.setDireccion(rs.getString("direccion"));
                profesor.setTelefono(rs.getString("telefono"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setCedula(rs.getString("cedula"));
            
          
                
                
                listaProfesor.add(profesor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los profesores: " + e.toString());
        }

        return listaProfesor;
    }
     
     
     
     public static boolean modificarProfesor(Profesor profesor) {
         
        boolean modificado = false;
        Connection cn = Conexion.conectar();
      
        String sql = "UPDATE tb_profesor SET nombre = ?, apellidoP = ?, apellidoM = ?, direccion = ?, telefono = ?, especialidad = ? WHERE cedula = ?";
        try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellidoP());
            pstmt.setString(3, profesor.getApellidoM());
            pstmt.setString(4, profesor.getDireccion());
            pstmt.setString(5, profesor.getTelefono());
            pstmt.setString(6, profesor.getEspecialidad());
            pstmt.setString(7, profesor.getCedula());
          

            int filasActualizadas = pstmt.executeUpdate();
        return filasActualizadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
       
            return modificado;
        }
    }
     
     
     
     
     
     public static boolean actualizarProfesor(Profesor profesor, String cedula) {
         
        boolean modificado = false;
        Connection cn = Conexion.conectar();
      
        String sql = "UPDATE tb_profesor SET nombre = ?, apellidoP = ?, apellidoM = ?, direccion = ?, telefono = ?, especialidad = ? WHERE cedula = ?";
        try (PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setString(1, profesor.getNombre());
            consulta.setString(2, profesor.getApellidoP());
            consulta.setString(3, profesor.getApellidoM());
            consulta.setString(4, profesor.getDireccion());
            consulta.setString(5, profesor.getTelefono());
            consulta.setString(6, profesor.getEspecialidad());
            consulta.setString(7, profesor.getCedula());
          
            if (consulta.executeUpdate()> 0){
            modificado= true;
            }
            
            cn.close();
    } catch (SQLException e) {
        
        System.out.println ("Error al actualizar Profesor: " + e);
       
        }
         return modificado;
    }
     
     
    
     
     
      public static Profesor obtenerProfesorPorCedula(String cedula) {
        Profesor profesor = null;

        String sql = "SELECT IdProfesor, nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula, IdUsuario FROM tb_profesor WHERE cedula = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                profesor = new Profesor(
                    rs.getInt("IdProfesor"),
                    rs.getString("nombre"),
                    rs.getString("apellidoP"),
                    rs.getString("apellidoM"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("especialidad"),
                    rs.getString("cedula"),
                    rs.getInt("IdUsuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el profesor: " + e.getMessage());
        }

        return profesor;
    }
     
     
     
     
    
    
}
