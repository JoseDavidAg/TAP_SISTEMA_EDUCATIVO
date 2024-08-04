/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Itzel_CG
 */
// UsuarioService.java
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioService {
    public UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        return usuarioDAO.obtenerUsuarioPorCorreo(correo);
    }
}

