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
import modelo.Alumno;
import modelo.Usuario;

/**
 *
 * @author Itzel_CG
 */
public class ControladorUsuario {
    

    
    public static boolean existeUsuario(String correo) {
        boolean existe = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT correo FROM tb_usuario WHERE correo = ?";
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar existencia del usuario: " + e.toString());
        }
        
        return existe;
    }
    
  public static boolean insertarUsuario(Usuario usuario) throws Exception {
    boolean insertado = false;
    Connection cn = Conexion.conectar();
    String sql = "INSERT INTO tb_usuario (usuario, tipo, nombre, apellidos, password, correo, identificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getTipo());
        ps.setString(3, usuario.getNombre());
        ps.setString(4, usuario.getApellidos());
        ps.setString(5, usuario.getContraseña());
        ps.setString(6, usuario.getCorreo());
        ps.setInt(7, usuario.getIdentificacion());

        insertado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e.toString());
        e.printStackTrace();  // Añadir para ver detalles del error en la consola
    }

    return insertado;
}

    
    
    public static List<Usuario> obtenerUsuario() throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario, tipo, nombre, apellidos, password, correo, identificacion FROM tb_usuario";

        try (PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setContraseña(rs.getString("password"));
                usuario.setCorreo(rs.getString("correo"));
                 usuario.setIdentificacion(rs.getInt("identificacion"));
               
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los alumnos: " + e.toString());
        }

        return listaUsuarios;
    }
    
    
    public static Usuario getUsuario(String correo) throws Exception {
    Usuario usuario = null;
    Connection cn = Conexion.conectar();
    String sql = "SELECT usuario, tipo, nombre, apellidos, password, correo, identificacion FROM tb_usuario WHERE correo = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setContraseña(rs.getString("password"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setIdentificacion(rs.getInt("identificacion"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.toString());
    }

    return usuario;
}

    
    
    
   public static boolean actualizarUsuario(Usuario usuario) throws Exception {
    boolean actualizado = false;
    Connection cn = Conexion.conectar();
    String sql = "UPDATE tb_usuario SET usuario = ?, tipo = ?, nombre = ?, apellidos = ?, password = ?, identificacion = ? WHERE correo = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getTipo());
        ps.setString(3, usuario.getNombre());
        ps.setString(4, usuario.getApellidos());
        ps.setString(5, usuario.getContraseña());
        ps.setInt(6, usuario.getIdentificacion());
        ps.setString(7, usuario.getCorreo());

        actualizado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.toString());
        e.printStackTrace();  // Añadir para ver detalles del error en la consola
    }

    return actualizado;
}

    
    
    
 
 public static boolean eliminarUsuario(String correo) {
    boolean eliminado = false;
    Connection cn = Conexion.conectar();
    String sql = "DELETE FROM tb_usuario WHERE correo = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, correo);
        eliminado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.toString());
    }

    return eliminado;
}

 
 
 
    
  
    
    
    
    
    
    
    
    
    
    
    
}  
    
    
    
    
    

