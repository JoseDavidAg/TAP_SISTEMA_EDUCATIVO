/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Itzel_CG
 */
// UsuarioDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

   public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        String query = "SELECT * FROM tb_usuario WHERE correo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("IdUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setContraseña(rs.getString("password"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdentificacion(rs.getInt("identificacion"));
               
                return usuario;
            } else {
                return null;
            }
        }
   }
}
