/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *jdbc:mysql://127.0.0.1:3306/?user=DavidAG
 * @author ambro
 */
public class DataBaseConection {
    private static final String URL = "jdbc:mysql://localhost/finaldata2";
    private static final String USER = "root";
    private static final String PASSWORD = "Da+!R947}5N3a";
    private Connection connection;
    
    // Constructor de la clase
    public DataBaseConection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas en la conexión: " + e.toString());
        }
    }
    
    public ResultSet Consulta(String consulta) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        return preparedStatement.executeQuery();
    }
    
    public ResultSet getValor(String consulta, String referencia) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, referencia);
        return preparedStatement.executeQuery();
    }
    
    public ResultSet getValor(String consulta, int valor) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setInt(1, valor);
        return preparedStatement.executeQuery();
    }


    public ResultSet getValor(String consulta, String valor1, String valor2) throws SQLException{
         PreparedStatement preparedStatement = connection.prepareStatement(consulta);
         preparedStatement.setString(1, valor1);
         preparedStatement.setString(2, valor2);
         return preparedStatement.executeQuery();
    }
    
    public ResultSet obtenerDatosTabla(String consulta) throws SQLException {
         java.sql.Statement statement = connection.createStatement();
        return statement.executeQuery(consulta);
    }
    
    public DefaultTableModel getListaModel(ArrayList<String> usuarioIDs, StringBuilder consulta, DefaultTableModel modelo) throws SQLException{
try (PreparedStatement preparedStatement = connection.prepareStatement(consulta.toString())) {
        for (int i = 0; i < usuarioIDs.size(); i++) {
            preparedStatement.setString(i + 1, usuarioIDs.get(i));
        }

        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("IdAlumno");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellidoP");
                fila[3] = rs.getString("apellidoM");
                modelo.addRow(fila);
            }
        }
    }
    return modelo;
    }
    
    public String obtenerMateriaID(String grupoID, int usuarioID, String consulta) throws SQLException {
    String materiaID="";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
        preparedStatement.setString(1, grupoID);
        preparedStatement.setInt(2, usuarioID);

        try (ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                materiaID = rs.getString("materiaID");
            }
        }
    }
    return materiaID;
}
    
    public ArrayList<String> obtenerBoletasPorEstudiantes(StringBuilder consulta, ArrayList<String> usuarioIDs, ArrayList<String> boletaIDs) throws SQLException {
    

    try (PreparedStatement preparedStatement = connection.prepareStatement(consulta.toString())) {
        for (int i = 0; i < usuarioIDs.size(); i++) {
            preparedStatement.setString(i + 1, usuarioIDs.get(i));
        }

        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                boletaIDs.add(rs.getString("IdAlumno"));
            }
        }
    }
    return boletaIDs;
}
    
    public ArrayList<String> obtenerCorreoTutor(StringBuilder consulta, ArrayList<String> usuarioIDs, ArrayList<String> boletaIDs, String elemento) throws SQLException {

    try (PreparedStatement preparedStatement = connection.prepareStatement(consulta.toString())) {
        for (int i = 0; i < usuarioIDs.size(); i++) {
            preparedStatement.setString(i + 1, usuarioIDs.get(i));
        }

        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                boletaIDs.add(rs.getString(elemento));
            }
        }
    }
    return boletaIDs;
}
    
    public void verificarYCrearCalificaciones(ArrayList<String> boletaIDs, String materiaID, String consulta, String insercion) throws SQLException {
    for (String boletaID : boletaIDs) {
        for (int periodoID = 1; periodoID <= 3; periodoID++) {
            try (PreparedStatement selectStmt = connection.prepareStatement(consulta)) {
                selectStmt.setString(1, boletaID);
                selectStmt.setString(2, materiaID);
                selectStmt.setInt(3, periodoID);

                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (!rs.next()) {
                        try (PreparedStatement insertStmt = connection.prepareStatement(insercion)) {
                            insertStmt.setString(1, boletaID);
                            insertStmt.setString(2, materiaID);
                            insertStmt.setInt(3, periodoID);
                            insertStmt.setDouble(4, 0.0); // Calificación inicial
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
        }
    }
}
    
    public DefaultTableModel obtenerDatosUsuarios(DefaultTableModel modelo, String materiaID, String consulta) throws SQLException {
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String usuario_aux = (String) modelo.getValueAt(i, 0);

        int boletaID = 0; 
        int user = Integer.parseInt(usuario_aux);
       

        // La consulta selecciona boletaID, así que recupera boletaID del ResultSet
        ResultSet idResultado = getValor("SELECT IdAlumno FROM tb_alumno WHERE IdAlumno= ?", user);
       

        if (idResultado.next()) {
            boletaID = idResultado.getInt("IdAlumno");  
        }
        
        
        double[] calificaciones = new double[3];

        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setInt(1, boletaID);
            preparedStatement.setString(2, materiaID);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int periodoID = rs.getInt("IdPeriodo");
                    double calificacion = rs.getDouble("calificacion");
                    calificaciones[periodoID - 1] = calificacion;
                }
            }
        }

        modelo.setValueAt(calificaciones[0], i, 4);
        modelo.setValueAt(calificaciones[1], i, 5);
        modelo.setValueAt(calificaciones[2], i, 6);
    }
    return modelo;
}

    public void actualizarCalificacion(int boletaID, int periodoID, double calificacion, String materiaID, String consulta) throws SQLException {
    // Verifica si la consulta está correctamente formateada
   

    try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
        preparedStatement.setDouble(1, calificacion);
        preparedStatement.setInt(2, boletaID);
        preparedStatement.setString(3, materiaID);
        preparedStatement.setInt(4, periodoID);

        // Ejecutar la actualización
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: " + rowsAffected);

        // Verifica si se actualizaron filas
        if (rowsAffected == 0) {
            System.out.println("No se actualizó ninguna fila. Verifica los datos de entrada y la consulta.");
        }
    } catch (SQLException ex) {
        // Captura y muestra cualquier excepción SQL
        System.err.println("Error al ejecutar la consulta: " + ex.getMessage());
        throw ex; // Opcional: re-lanzar la excepción después de registrarla
    }
}
    
     public void actualizaMateria(String idMateria, int idProfesor, String idGrupo) throws SQLException {
    // Verifica si la consulta está correctamente formateada
   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas en la conexión: " + e.toString());
        }
        
     String checkQuery = "SELECT COUNT(*) FROM profesor_materia_grupo WHERE IdMateria = ? AND IdProfesor = ? AND IdGrupo = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setString(1,  idMateria);
            checkStmt.setInt(2,idProfesor);
            checkStmt.setString(3, idGrupo);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // La combinación ya existe
                JOptionPane.showMessageDialog(null, "La combinación de IdAlumno, IdMateria e IdPeriodo ya existe.");
            } else {
                // La combinación no existe, proceder con la actualización
                String updateQuery = "INSERT INTO profesor_materia_grupo (IdMateria,IdProfesor, IdGrupo)VALUES (?, ?, ?)";
                try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                    updateStmt.setString(1,  idMateria);
                    updateStmt.setInt(2,idProfesor);
                    updateStmt.setString(3, idGrupo);
                    
                    int rowsUpdated = updateStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Calificación actualizada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la fila para actualizar.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar la calificación.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la combinación.");
        } 
        
}
    
    
public ArrayList<String> obtenerCalificaciones(String consulta, int boletaID, int periodoID) {
    // Lista para almacenar las calificaciones
    ArrayList<String> calificaciones = new ArrayList<>();

    
    // Conexión, declaración y resultado
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        

        // Crear PreparedStatement
        pstmt = connection.prepareStatement(consulta);
        pstmt.setInt(1, boletaID);
        pstmt.setInt(2, periodoID);

        // Ejecutar consulta
        rs = pstmt.executeQuery();

        // Procesar resultados
        while (rs.next()) {
            // Obtener calificación como String
            String calificacion = rs.getString("calificacion");
            calificaciones.add(calificacion);
        }
    } catch (SQLException e) {
      
    } 

    return calificaciones;
}
    

//otros metodos


    
    
}
