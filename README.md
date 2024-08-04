# TAP_SISTEMA_EDUCATIVO
Sistema para una secundaria para el control de alumnos, materias, profesores y calificaciones. Implementa el envío sistematizado de calificaciones al tutor de cada alumno por mail. 

##Descripción
Este sistema fue creado con la intención de automatizar el envió de calificaciones a los padres de familia (tutores) de los alumnos con los que cuenta el profesor, pies el alumno cuenta con un tutor y este mismo cuenta con un correo electrónico, datos que se ingresan al momento de captrurar los datos cuando se registra un nuevo alumno; acción que solo puede hacer el administrador, pues el sistema cuenta con dos niveles de usuario, el Profesor y el Administrador. 


## Características

### MVC
La estructura del proyecto sigue el patrón de diseño Modelo-Vista-Controlador 
La separación clara entre estos componentes permite una mejor organización del código, facilita el mantenimiento, la escalabilidad del sistema y hace que sea más fácil de probar y modificar de manera independiente cada componente.


## Paquetes
Cuenta con los siguientes paquetes 

• Validaciones: Contiene la clase validacion.java. Para algunas validaciones dentro del sistema, como por ejemplo la contraseña, donde tiene que tener en ella ciertas características 
  para que pueda ser acepta en el sistema, al momento de crear una cuenta (un nuevo usuario). 
    
• conexion: Contiene la clase Conexion.java; que es la conexión a la base de datos manejada en MySQL Workbench.

• controlador: Contiene controladores específicos para diferentes entidades y funcionalidades del sistema, lo cual facilita el mantenimiento y la escalabilidad del código.

• imagenes: Dentro de este paquete se encuentran todas las imágenes que se ocuparon para darle más diseño y estética al sistema. 

• modelo: Contiene las clases Alumno.java, Grupo.java, Horario.java, Materia.java, etc. En este paquete se representa cada entidad del sistema.

• vista: Contiene las clases VistaLogin.java, VistaModificarUsuario.java, VistaPrincipalAlumno.java, VistaPrincipalP.java, etc. Corresponde a las diferentes interfaces de usuario, la 
  vista que tiene el usurio.

### Modelo 

En el paquete MODELO contiene las clases de las tablas principales que se utilizaron en la base de datos como: Alumno, Grupo, Materia, Profesor, Usuario; dentro de cada uno están sus atributos, su constructor y los métodos get y set de cada atributo. 

### Controlador

En el paquete controlador hay clases- controladores de cada entidad que se encuentra en el paquete modelo, como también algunas que se encuentran en el paquete de VISTA. Y en este sistema los controladores se encargan de gestionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para la entidades que tenemos en la base de datos.

Por ejemplo la clase ControladorAlumno, que es parecida a los demás controladores. 

    import conexion.Conexion;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import modelo.Alumno;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

    public class ControladorAlumno {
   
    public static boolean insertarAlumno(Alumno alumno) {
        boolean insertado = false;
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO tb_alumno (IdAlumno, nombre, apellidoP, apellidoM, fechaNaci, genero, tutor, ocupacion, telefono, correo, IdGrupo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,           ?, ?)";
        
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
    String sql = "UPDATE tb_alumno SET nombre = ?, apellidoP = ?, apellidoM = ?, fechaNaci = ?, genero = ?, tutor = ?, ocupacion = ?, telefono = ?, correo = ?, IdGrupo = ? WHERE 
    IdAlumno = ?";

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
        
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, control);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.toString());
        }
        
        return eliminado;
        }     
        }


#### Métodos de la Clase ControladorAlumno

insertarAlumno(Alumno alumno)

  Descripción: Inserta un nuevo registro de alumno en la base de datos.
  Parámetros: Un objeto Alumno.
  Retorno: true si la inserción fue exitosa, false en caso contrario.
  Lógica:
  Conecta con la base de datos.
  Prepara una declaración SQL para insertar un nuevo alumno.
  Asigna los valores de los atributos del objeto Alumno a la declaración SQL.
  Ejecuta la inserción y verifica si se afectaron filas.
  existeAlumno(String control)

Descripción: Verifica si un alumno existe en la base de datos por su Id.
Parámetros: Un String que representa el Id del alumno.
Retorno: true si el alumno existe, false en caso contrario.
Lógica:
Conecta con la base de datos.
Prepara una declaración SQL para contar los registros con el Id del alumno proporcionado.
Ejecuta la consulta y verifica si el conteo es mayor a cero.
obtenerAlumnos()

Descripción: Obtiene una lista de todos los alumnos en la base de datos.
Parámetros: Ninguno.
Retorno: Una lista de objetos Alumno.
Lógica:
Conecta con la base de datos.
Prepara una declaración SQL para seleccionar todos los alumnos.
Ejecuta la consulta y recorre el ResultSet para llenar la lista de alumnos.
actualizarAlumno(Alumno alumno)

Descripción: Actualiza los datos de un alumno existente en la base de datos.
Parámetros: Un objeto Alumno.
Retorno: true si la actualización fue exitosa, false en caso contrario.
Lógica:
Conecta con la base de datos.
Prepara una declaración SQL para actualizar los datos del alumno.
Asigna los valores de los atributos del objeto Alumno a la declaración SQL.
Ejecuta la actualización y verifica si se afectaron filas.
getAlumno(String control)

Descripción: Obtiene los datos de un alumno específico por su Id.
Parámetros: Un String que representa el Id del alumno.
Retorno: Un objeto Alumno si se encuentra, null en caso contrario.
Lógica:
Conecta con la base de datos.
Prepara una declaración SQL para seleccionar un alumno por su Id.
Ejecuta la consulta y asigna los valores del ResultSet a un objeto Alumno.
eliminarAlumno(String control)

Descripción: Elimina un alumno de la base de datos por su Id.
Parámetros: Un String que representa el Id del alumno.
Retorno: true si la eliminación fue exitosa, false en caso contrario.
Lógica:
Conecta con la base de datos.
Prepara una declaración SQL para eliminar el alumno con el Id proporcionado.
Ejecuta la eliminación y verifica si se afectaron filas.
  
















  

