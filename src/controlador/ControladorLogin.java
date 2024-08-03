/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Usuario;




/**
 *
 * @author Itzel_CG
 */
public class ControladorLogin {
    
    public static boolean verificacion(Usuario objeto) throws Exception {
    boolean respuesta = false;
    Connection cn = Conexion.conectar();
    String sql = "SELECT correo, password FROM tb_usuario WHERE correo = ? AND password = ?";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, objeto.getCorreo());
        ps.setString(2, objeto.getContraseña());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            respuesta = true;
        } else {
        
            String sqlCorreo = "SELECT correo FROM tb_usuario WHERE correo = ?";
            try (PreparedStatement psCorreo = cn.prepareStatement(sqlCorreo)) {
                psCorreo.setString(1, objeto.getCorreo());
                ResultSet rsCorreo = psCorreo.executeQuery();

                if (!rsCorreo.next()) {
                    JOptionPane.showMessageDialog(null, "Correo INCORRECTO");
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión: " + e.toString());
    }

    return respuesta;
    }
    
    
    public static String obtenerTipoUsuario(Usuario usuario) {
    String tipoUsuario = null;
    
    //System.out.println("Conectando a la base de datos...");
    try (Connection conn = Conexion.conectar()) {
        String sql = "SELECT tipo FROM tb_usuario WHERE password = ? AND correo = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getContraseña());
        ps.setString(2, usuario.getCorreo());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            tipoUsuario = rs.getString("tipo");
            //System.out.println("Tipo de usuario encontrado: " + tipoUsuario);
        } else {
            System.out.println("No se encontró el usuario.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return tipoUsuario;
}



    
}
