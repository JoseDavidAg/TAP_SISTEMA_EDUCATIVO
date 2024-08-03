/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Itzel_CG
 */

import conexion.Conexion;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import javax.swing.table.DefaultTableModel;
    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Materia;
import modelo.Profesor;
import modelo.Usuario;

public class ControladorVistaProfesor {
    private UsuarioService usuarioService;

    public ControladorVistaProfesor(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public int obtenerIdUsuarioPorCorreo(String correo) {
        try {
            Usuario usuario = usuarioService.obtenerUsuarioPorCorreo(correo);
            if (usuario != null) {
                return usuario.getIdentificacion();
            } else {
                // Manejar caso de usuario no encontrado
                return -1; // o cualquier valor que indique que no se encontró el usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
            return -1;
        }
    }

    
    
    
    
    
    public List<Materia> obtenerMateriasPorProfesor(int profesorId) {
        List<Materia> materias = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String query = "SELECT m.IdMateria, m.IdCurso FROM profesor_materia_grupo pmg " +
                       "JOIN materia m ON pmg.materiaId = m.IdMateria " +
                       "WHERE pmg.profesorId = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, profesorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idMateria = rs.getString("IdMateria");
                int idCurso = rs.getInt("IdCurso");
                materias.add(new Materia(idMateria, idCurso));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<String> obtenerMateriasYGrupos(String nombreUsuario) throws SQLException {
        List<String> materiasYGrupos = new ArrayList<>();
        String query = "SELECT materia, grupo " +
                       "FROM tb_materias_grupos " +
                       "WHERE profesor = ?";

        try (Connection connection = Conexion.conectar(); // Usa el método estático para obtener la conexión
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, nombreUsuario);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                String materia = resultSet.getString("materia");
                String grupo = resultSet.getString("grupo");
                materiasYGrupos.add(materia + " - " + grupo);
            }
        }

        return materiasYGrupos;
    }
    
    
    public static boolean insertarProfesor(Profesor profesor) {
    boolean insertado = false;
    Connection cn = Conexion.conectar();
    String sql = "INSERT INTO tb_profesor (nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula, IdUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, profesor.getNombre());
        ps.setString(2, profesor.getApellidoP());
        ps.setString(3, profesor.getApellidoM());
        ps.setString(4, profesor.getDireccion());
        ps.setString(5, profesor.getTelefono());
        ps.setString(6, profesor.getEspecialidad());
        ps.setString(7, profesor.getCedula());
         ps.setInt(8, profesor.getIdProfesor());

        insertado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar profesor: " + e.toString());
    }

    return insertado;
}

    
    public static boolean actualizarProfesor(Profesor profesor) {
    boolean actualizado = false;
    Connection cn = Conexion.conectar();
    String sql = "UPDATE tb_profesor SET nombre = ?, apellidoP = ?,  apellidoM = ?,  direccion = ?,  telefono = ?,  especialidad = ?, cedula = ?, IdUsuario =? WHERE idProfesor = ?";

     //String sql = "INSERT INTO tb_profesor (nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, profesor.getNombre());
        ps.setString(2, profesor.getApellidoP());
        ps.setString(3, profesor.getApellidoM());
        ps.setString(4, profesor.getDireccion());
        ps.setString(5, profesor.getTelefono());
        ps.setString(6, profesor.getEspecialidad());
        ps.setString(7, profesor.getCedula());
        ps.setInt(8, profesor.getIdProfesor());

        actualizado = ps.executeUpdate() > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar profesor: " + e.toString());
    }

    return actualizado;
}

    
    public static List<Profesor> obtenerProfesores() {
    List<Profesor> listaProfesores = new ArrayList<>();
    Connection cn = Conexion.conectar();
    String sql = "SELECT nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula, IdUsuario FROM tb_profesor";

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
            profesor.setIdUsuario(rs.getInt("usuarioId"));

            listaProfesores.add(profesor);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los profesores: " + e.toString());
    }

    return listaProfesores;
}

    
    
     public static void loadMaterias() {
        List<String> materias = new ArrayList<>();
        //List<Profesor> listaProfesores = new ArrayList<>();
       Connection cn = Conexion.conectar();
        
        try {
            // Especifica el ID del profesor para el que quieres cargar las materias
            int idProfesor = 2;  // Cambia esto según sea necesario
            String query = "SELECT IdMateria FROM ProfesorMateriaGrupo WHERE IdProfesor = ?";
            
            PreparedStatement statement = cn.prepareStatement(query);
            statement.setInt(1, idProfesor);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String idMateria = resultSet.getString("IdMateria");
                // Recuperar el nombre de la materia, puedes necesitar otra consulta
                String materiaNombre = getMateriaNombre(idMateria);
                materias.add(materiaNombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
     
     public static  String getMateriaNombre(String idMateria) {
         
           Connection cn = Conexion.conectar();
    String materiaNombre = "";
    // Consulta SQL para obtener el nombre de la materia
    String query = "SELECT Nombre FROM Materias WHERE IdMateria = ?";

    try (PreparedStatement statement = cn.prepareStatement(query)) {
        // Establece el parámetro en la consulta
        statement.setString(1, idMateria);

        // Ejecuta la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se obtiene un resultado, extrae el nombre de la materia
            if (resultSet.next()) {
                materiaNombre = resultSet.getString("Nombre");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return materiaNombre;
}

    
    
}

      

