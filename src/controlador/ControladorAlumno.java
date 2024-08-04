/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Alumno;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Itzel_CG
 */
public class ControladorAlumno {
   
    public static boolean insertarAlumno(Alumno alumno) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO tb_alumno (IdAlumno, nombre, apellidoP, apellidoM, fechaNaci, genero, tutor, ocupacion, telefono, correo, IdGrupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, alumno.getIdAlumno());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellidoP());
            ps.setString(4, alumno.getApellidoM());            
            ps.setString(5, alumno.getFechaNaci());   
            ps.setString(6, alumno.getGenero());
            ps.setString(7, alumno.getTutor());
            ps.setString(8, alumno.getOcupacion());
            ps.setString(9, alumno.getTelefono());
            ps.setString(10, alumno.getCorreo());
            ps.setString(11, alumno.getIdGrupo());
          
            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar alumno: " + e.toString());
        }
        
        return insertado;
    }
    
    
    
      public static boolean existeAlumno(String control) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT COUNT(*) FROM tb_alumno WHERE IdAlumno= ?";
        
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, control);
           
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                existe = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al comprobar existencia del alumno: " + e.toString());
        }
        
        
        return existe;
    }
    

      public static List<Alumno> obtenerAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT IdAlumno, nombre, apellidoP, apellidoM, fechaNaci, genero, tutor, ocupacion, telefono, correo, IdGrupo FROM tb_alumno";

        try (PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alumno alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("IdAlumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidoP(rs.getString("apellidoP"));
                alumno.setApellidoM(rs.getString("apellidoM"));
                alumno.setFechaNaci(rs.getString("fechaNaci"));
                alumno.setGenero(rs.getString("genero"));
                alumno.setTutor(rs.getString("tutor"));
                alumno.setOcupacion(rs.getString("ocupacion"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setIdGrupo(rs.getString("IdGrupo"));
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los alumnos: " + e.toString());
        }

        return listaAlumnos;
    }
    
      
      
      
    
    
    
    
    public static boolean actualizarAlumno(Alumno alumno) {
    boolean actualizado = false;
    Connection cn = Conexion.conectar();
    String sql = "UPDATE tb_alumno SET nombre = ?, apellidoP = ?, apellidoM = ?, fechaNaci = ?, genero = ?, tutor = ?, ocupacion = ?, telefono = ?, correo = ?, IdGrupo = ? WHERE IdAlumno = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        // Establecer los valores de los parámetros en el orden correcto
        ps.setString(1, alumno.getNombre());
        ps.setString(2, alumno.getApellidoP());
        ps.setString(3, alumno.getApellidoM());
        ps.setString(4, alumno.getFechaNaci());
        ps.setString(5, alumno.getGenero());
        ps.setString(6, alumno.getTutor());
        ps.setString(7, alumno.getOcupacion());
        ps.setString(8, alumno.getTelefono());
        ps.setString(9, alumno.getCorreo());
        ps.setString(10, alumno.getIdGrupo());  
        ps.setInt(11, alumno.getIdAlumno());

        // Ejecutar la actualización y verificar si se actualizó al menos una fila
        actualizado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar alumno: " + e.getMessage());
    }

    return actualizado;
}

    

    
    
    public static Alumno getAlumno(String control) {
    Alumno alumno = null;
    Connection cn = Conexion.conectar();
    String sql = "SELECT IdAlumno, nombre, apellidoP, apellidoM, fechaNaci, genero, tutor, ocupacion, telefono, correo, IdGrupo FROM tb_alumno WHERE IdAlumno = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, control);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            alumno = new Alumno();
            
            alumno.setIdAlumno(rs.getInt("IdAlumno"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellidoP(rs.getString("apellidoP"));
            alumno.setApellidoM(rs.getString("apellidoM"));
            alumno.setFechaNaci(rs.getString("fechaNaci"));
            alumno.setGenero(rs.getString("genero"));
            alumno.setTutor(rs.getString("tutor"));
            alumno.setOcupacion(rs.getString("ocupacion"));
            alumno.setTelefono(rs.getString("telefono"));
            alumno.setCorreo(rs.getString("correo"));
            alumno.setIdGrupo(rs.getString("IdGrupo"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el alumno: " + e.toString());
    }

    return alumno;
}

 public static boolean eliminarAlumno(String control) {
        boolean eliminado = false;
        Connection cn = Conexion.conectar();
        String sql = "DELETE FROM tb_alumno WHERE IdAlumno = ?";
        String sql2= "DELETE FROM calificacionperiodo WHERE idAlumno =?";  
        try (PreparedStatement ps = cn.prepareStatement(sql2)) {
            ps.setString(1, control);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la boleta: " + e.toString());
        }
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, control);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.toString());
        }
        
        return eliminado;
    }     
    
 
 
      
    
}
