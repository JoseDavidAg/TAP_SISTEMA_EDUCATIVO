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

    public static void insertarProfesor(Profesor profesor) throws SQLException {
        if (existeProfesorPorCedula(profesor.getCedula())) {
            throw new SQLException("El profesor con esta cédula ya existe.");
        }
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.conectar();
            String sql = "INSERT INTO tb_profesor (nombre, apellidoP, apellidoM, direccion, telefono, especialidad, cedula, IdUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellidoP());
            pstmt.setString(3, profesor.getApellidoM());
            pstmt.setString(4, profesor.getDireccion());
            pstmt.setString(5, profesor.getTelefono());
            pstmt.setString(6, profesor.getEspecialidad());
            pstmt.setInt(7, profesor.getCedula());
            pstmt.setInt(8, profesor.getIdUsuario());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    public static boolean existeProfesorPorCedula(int cedula) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.conectar();
            String sql = "SELECT COUNT(*) FROM tb_profesor WHERE cedula = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cedula);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

            return false;
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    public static boolean eliminarProfesor(int cedula) {
        boolean eliminado = false;
        Connection cn = Conexion.conectar();
        String sql = "DELETE FROM tb_profesor WHERE cedula = ?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, cedula);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar profesor: " + e.getMessage());
        }

        return eliminado;
    }

    public static List<Profesor> obtenerProfesor() {
        List<Profesor> listaProfesor = new ArrayList<>();
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
                profesor.setCedula(rs.getInt("cedula"));
                profesor.setIdUsuario(rs.getInt("IdUsuario"));

                listaProfesor.add(profesor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los profesores: " + e.getMessage());
        }

        return listaProfesor;
    }

    public static boolean actualizarProfesor(Profesor profesor) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean actualizado = false;

        try {
            conn = Conexion.conectar();
            String sql = "UPDATE tb_profesor SET nombre = ?, apellidoP = ?, apellidoM = ?, direccion = ?, telefono = ?, especialidad = ?, IdUsuario = ? WHERE cedula = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellidoP());
            pstmt.setString(3, profesor.getApellidoM());
            pstmt.setString(4, profesor.getDireccion());
            pstmt.setString(5, profesor.getTelefono());
            pstmt.setString(6, profesor.getEspecialidad());
            pstmt.setInt(7, profesor.getIdUsuario());
            pstmt.setInt(8, profesor.getCedula());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actualizado;
    }

    public static Profesor getProfesorPorCedula(int cedula) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Profesor profesor = null;

        try {
            conn = Conexion.conectar();
            String sql = "SELECT * FROM tb_profesor WHERE cedula = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cedula);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                profesor = new Profesor();
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellidoP(rs.getString("apellidoP"));
                profesor.setApellidoM(rs.getString("apellidoM"));
                profesor.setDireccion(rs.getString("direccion"));
                profesor.setTelefono(rs.getString("telefono"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setCedula(rs.getInt("cedula"));
                profesor.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return profesor;
    }
}
