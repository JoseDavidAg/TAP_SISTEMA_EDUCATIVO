/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.DataBaseConection;
import com.itextpdf.text.BadElementException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ambro
 */
public class inicio {
    
     public int usuarioID;//maestro
     public String grupoID;
     public String materiaID;
     
     DataBaseConection connection; 
     
    public void start(String correo) throws SQLException{
        connection= new DataBaseConection();
        
        
        //prueba de inicio de sesion
        //String correo="Renelarana@gmail.com";
        //String contraseña="SanR3#1";
        /*
        String correo="ambrosiojosedavid@gmail.com";
        String contraseña="lucaS2\"?";
        */
        //obtener el ID usuario
        ResultSet idResultado = connection.getValor("SELECT idUsuario FROM tb_usuario WHERE correo = ?", correo);
        
        if(idResultado.next()){
           usuarioID= idResultado.getInt("idUsuario");                          //obtenemos el id, depues se utilizara para imprimir el datos del maestro
        } 
        
        
        
    }
    
    //obtenemos todos los grupoID correspondientes al maestroID
    public ArrayList<String> getModels(String consulta,String dato) throws SQLException {
    ArrayList<String> grupos = new ArrayList<>();
    try (ResultSet gruposResultado = connection.getValor(consulta, usuarioID)) {
        while (gruposResultado.next()) {
            grupos.add(gruposResultado.getString(dato));
        }
    }
    return grupos;

}
    
    
    //Obtenemos un Array<String> de todos los usuariosID del grupoID
    public ArrayList<String> getModels2(String grupoID) throws SQLException {
    ArrayList<String> grupos = new ArrayList<>();
    try (ResultSet gruposResultado = connection.getValor("SELECT IdAlumno FROM tb_alumno WHERE IdGrupo = ?", grupoID)) {
        while (gruposResultado.next()) {
            grupos.add(gruposResultado.getString("IdAlumno"));
        }
    }
    return grupos;
}
    
    
    

    public DefaultTableModel obtenerDatosUsuarios(ArrayList<String> usuarioIDs) throws SQLException {
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Las columnas de calificación son editables
            return column >= 4;
        }
    };
    
    modelo.addColumn("Usuario ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido P");
    modelo.addColumn("Apellido M");
    modelo.addColumn("Calificación Periodo 1");
    modelo.addColumn("Calificación Periodo 2");
    modelo.addColumn("Calificación Periodo 3");

    // Verificar que la lista de IDs no esté vacía
    if (usuarioIDs.isEmpty()) {
        return modelo; // Devuelve el modelo vacío si no hay IDs
    }
    
    StringBuilder consultaUsuarios = new StringBuilder("SELECT IdAlumno, nombre, apellidoP, apellidoM FROM tb_alumno WHERE idAlumno IN (");
    for (int i = 0; i < usuarioIDs.size(); i++) {
        consultaUsuarios.append("?");
        if (i < usuarioIDs.size() - 1) {
            consultaUsuarios.append(", ");
        }
    }
    consultaUsuarios.append(")");
  
    
    modelo = connection.getListaModel(usuarioIDs, consultaUsuarios, modelo);
   //va bien
   
    ArrayList<String> boletaIDs = obtenerBoletasPorEstudiantes(usuarioIDs);

    verificarYCrearCalificaciones(boletaIDs, materiaID);
   
    String consultaCalificaciones = "SELECT IdAlumno, IdPeriodo, calificacion FROM calificacionperiodo WHERE IdAlumno = ? AND IdMateria = ?";

    return connection.obtenerDatosUsuarios(modelo,materiaID,consultaCalificaciones);
}


    public ArrayList<String> obtenerBoletasPorEstudiantes(ArrayList<String> usuarioIDs) throws SQLException {
    ArrayList<String> boletaIDs = new ArrayList<>();
    StringBuilder consulta = new StringBuilder("SELECT IdAlumno FROM tb_alumno WHERE IdAlumno IN (");
    
    for (int i = 0; i < usuarioIDs.size(); i++) {
        consulta.append("?");
        if (i < usuarioIDs.size() - 1) {
            consulta.append(", ");
        }
    }
   
    consulta.append(")");
      
    return connection.obtenerBoletasPorEstudiantes(consulta, usuarioIDs, boletaIDs);
}
    public ArrayList<String> obtenerRelacion(ArrayList<String> usuario, String buscar,String elemento) throws SQLException {
    ArrayList<String> correoIDs = new ArrayList<>();
    StringBuilder consulta = new StringBuilder(buscar);
    
    for (int i = 0; i < usuario.size(); i++) {
        consulta.append("?");
        if (i < usuario.size() - 1) {
            consulta.append(", ");
        }
    }
   
    consulta.append(")");
    
      
    return connection.obtenerCorreoTutor(consulta, usuario, correoIDs, elemento);
}
    
    public void verificarYCrearCalificaciones(ArrayList<String> boletaIDs, String materiaID) throws SQLException {
    String consulta = "SELECT IdAlumno FROM calificacionPeriodo WHERE IdAlumno = ? AND IdMateria = ? AND IdPeriodo = ?";
    String insercion = "INSERT INTO calificacionPeriodo (IdAlumno, IdMateria, IdPeriodo, calificacion) VALUES (?, ?, ?, ?)";
    
    connection.verificarYCrearCalificaciones(boletaIDs,materiaID,consulta,insercion);
}

    
    public DefaultTableModel Test() throws SQLException{
       
        
        //materiaID=connection.obtenerMateriaID(this.grupoID, usuarioID,"SELECT materiaID FROM profesor_materia_horario WHERE grupoID = ? AND usuarioID = ?" );
     
        
        ArrayList<String> id_usuario= getModels2(grupoID);
       
        
        return obtenerDatosUsuarios(id_usuario);   
    }
    
    //obtener el boletaID a partir del usuarioID
    public int getBoletaID(String usuarioID) throws SQLException{
        String consulta= "SELECT IdAlumno FROM tb_alumno WHERE IdAlumno=?";
        ResultSet idResultado = connection.getValor(consulta,usuarioID);
        
        if(idResultado.next()){
           return idResultado.getInt("IdAlumno");                      
        }  
        return 0;
    }
    
    
    public void actualizarCalificacion(int boletaID, int periodoID, double calificacion, String materiaID) throws SQLException {
    String consulta = "UPDATE calificacionperiodo SET calificacion=? WHERE IdAlumno = ? AND IdMateria = ? AND IdPeriodo =?";
    // Debugging print statement
    
    connection.actualizarCalificacion(boletaID, periodoID, calificacion, materiaID, consulta);
}
    
   
   
public void sendEmail(String fromEmail, String password, String toEmail, String subject, String htmlMessage, String filePath) throws MessagingException, IOException {
    // Configuración de las propiedades del correo
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");

    // Crear la sesión de correo
    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(fromEmail, password);
        }
    });

    // Crear el mensaje de correo
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(fromEmail));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
    msg.setSubject(subject);

    // Crear el contenido del mensaje con el archivo adjunto
    Multipart multipart = new MimeMultipart();

    // Parte del mensaje en formato HTML con imagen centrada
    MimeBodyPart htmlPart = new MimeBodyPart();
    String htmlContent = "<html><body style='text-align: center;'>" +
            "<h2>ESCUELA SECUNDARIA TÉCNICA NO.192</h2>" +
            "<p>Querido/a tutor/a</p>" +
            "<p>Aquí estan las calificaciones de su tutorado:v</p>" +
            "<img src='cid:image1' alt='Imagen' style='max-width: 100%; height: auto;'/>" +
            "<p>Por su apoyo incondicional. GRACIAS!!</p>" +
            "<p>-Personal de la institución</p>" +
            "</body></html>";

    htmlPart.setContent(htmlContent, "text/html; charset=UTF-8");
    multipart.addBodyPart(htmlPart);

    // Parte del archivo adjunto
    MimeBodyPart attachmentPart = new MimeBodyPart();
    File file = new File(filePath);
    try (FileInputStream fis = new FileInputStream(file)) {
        DataSource source = new FileDataSource(file);
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName(file.getName());
        multipart.addBodyPart(attachmentPart);
    }

    // Parte de la imagen
    MimeBodyPart imagePart = new MimeBodyPart();
    DataSource imageSource = new FileDataSource("C:\\Users\\ambro\\OneDrive\\Documentos\\INSTITUTO TECNOLOGICO DE OAXACA\\VERANO\\TOPICOS AVANZADOS DE PROGRAMCIÓN\\logoEducacion.jpg"); // Asegúrate de especificar la ruta correcta de la imagen
    imagePart.setDataHandler(new DataHandler(imageSource));
    imagePart.setHeader("Content-ID", "<image1>");
    multipart.addBodyPart(imagePart);

    // Agregar el contenido al mensaje
    msg.setContent(multipart);

    // Enviar el mensaje
    Transport.send(msg);
    System.out.println("Mensaje enviado");
}
    
    //obtenemos todos los grupoID correspondientes al maestroID
    public ArrayList<String> getModels(String consulta,String dato, int valor) throws SQLException {
    ArrayList<String> grupos = new ArrayList<>();
    try (ResultSet gruposResultado = connection.getValor(consulta, valor)) {
        while (gruposResultado.next()) {
            grupos.add(gruposResultado.getString(dato));
        }
    }
    return grupos;

}
    //metodo para obtener calificaciones por unidad
    public ArrayList<String> obtenerCalificaciones( String consulta, int boletaID, int periodoID) throws SQLException {
    
    return connection.obtenerCalificaciones(consulta,boletaID,periodoID);
         

    }
    
     public static double truncarADosDecimales(double numero) {
        BigDecimal decimal = new BigDecimal(numero);
        // Truncar a un solo dígito decimal
        BigDecimal truncado = decimal.setScale(1, RoundingMode.DOWN);
        return truncado.doubleValue();
    }
    
    //metodos usados para la boleta
    
    
    
    public void enviarCorreo() throws SQLException, MessagingException, FileNotFoundException, BadElementException, IOException{
       
        ArrayList<String> id_usuario= getModels2(grupoID);  //una lista de usuariosID(alumnos) del grupo
        ArrayList<String> boletas = obtenerBoletasPorEstudiantes(id_usuario);
      
        
        ArrayList<String> correoTutor= obtenerRelacion(id_usuario,"SELECT correo FROM tb_alumno WHERE IdAlumno IN (", "correo"); //lista de correoTutor de cada usuario
        ArrayList<String> nombre_estudiante= obtenerRelacion(id_usuario,"SELECT nombre FROM tb_alumno WHERE IdAlumno IN (", "nombre");         //lista de nombres de estudiantes
        ArrayList<String> apellidoP_estudiante= obtenerRelacion(id_usuario,"SELECT apellidoP FROM tb_alumno WHERE IdAlumno IN (", "apellidoP");
        ArrayList<String> apellidoM_estudiante= obtenerRelacion(id_usuario,"SELECT apellidoM FROM tb_alumno WHERE IdAlumno IN (","apellidoM" );
         
        ResultSet idResultado = connection.getValor("SELECT IdCurso FROM grupo WHERE IdGrupo = ?", grupoID);
        int curso=0;
        if(idResultado.next()){
           curso= idResultado.getInt("IdCurso");                          //obtenemos el cursoID
        }
        
        
        //concatenar el nombre completo del alumno
        for(int i=0;i<nombre_estudiante.size();i++){
            nombre_estudiante.set(i, nombre_estudiante.get(i)+" "+apellidoP_estudiante.get(i)+" "+apellidoM_estudiante.get(i));
        }
        
        
        ReportCardPDFGenerator pdf= new ReportCardPDFGenerator();
        
        
 
        //metodo para generar PDF con los datos personales del alumno
        int walk=0;
        while(walk<correoTutor.size()){
            //obtener lista de materias, calificaciones por unidad
            ArrayList<String> materias= getModels("SELECT IdMateria FROM materia WHERE IdCurso = ?" ,"IdMateria", curso);
           
            
            int boleta = Integer.parseInt(boletas.get(walk));
            
            ArrayList<String> unidad1= obtenerCalificaciones("SELECT calificacion FROM calificacionperiodo WHERE IdAlumno=? and IdPeriodo=? ",boleta,1 );
            ArrayList<String> unidad2= obtenerCalificaciones("SELECT calificacion FROM calificacionperiodo WHERE IdAlumno=? and IdPeriodo=? ",boleta,2 );
            ArrayList<String> unidad3= obtenerCalificaciones("SELECT calificacion FROM calificacionperiodo WHERE IdAlumno=? and IdPeriodo=? ",boleta,2 );
           
            //generar pdf
            String ruta= pdf.generarPDF(nombre_estudiante.get(walk), id_usuario.get(walk), grupoID, materias,unidad1,unidad2,unidad3); 
            System.out.println(ruta);
            
            sendEmail(Constantes. FROM_EMAIL,Constantes.PASSWORD, correoTutor.get(walk),"Boleta de Curso.", "<h1>Hola,</h1><p>Adjunto encontrarás tu boleta de calificaciones en formato PDF.</p>",ruta);
            walk++;
        }
             //String fromEmail, String password, String toEmail, String subject, String message, String filePath
                  
              
              
        
    }
    
    
    
}

/*
10 ejercicios.

** Agregar diseño a mi correo
crear mi pdf encriptacion de la contraseña: implementar metodo para gaurdar: has

crear interfaz para agregar al alumno 

*/