# TAP_SISTEMA_EDUCATIVO
Sistema para una secundaria para el control de alumnos, materias, profesores y calificaciones. Implementa el envío sistematizado de calificaciones al tutor de cada alumno por mail. 

##Descripción
Este sistema fue creado con la intención de automatizar el envió de calificaciones a los padres de familia (tutores) de los alumnos con los que cuenta el profesor, pies el alumno cuenta con un tutor y este mismo cuenta con un correo electrónico, datos que se ingresan al momento de captrurar los datos cuando se registra un nuevo alumno; acción que solo puede hacer el administrador, pues el sistema cuenta con dos niveles de usuario, el Profesor y el Administrador. 


## Características

### MVC
La estructura del proyecto sigue el patrón de diseño Modelo-Vista-Controlador 
La separación clara entre estos componentes permite una mejor organización del código, facilita el mantenimiento, la escalabilidad del sistema y hace que sea más fácil de probar y modificar de manera independiente cada componente.


### Paquetes
Cuenta con los siguientes paquetes 
• Validaciones: Contiene la clase validacion.java. Para algunas validaciones dentro del sistema, como por ejemplo la contraseña, donde tiene que tener en ella ciertas características 
  para que pueda ser acepta en el sistema, al momento de crear una cuenta (un nuevo usuario). 
    
• conexion: Contiene la clase Conexion.java; que es la conexión a la base de datos manejada en MySQL Workbench.

• controlador: Contiene controladores específicos para diferentes entidades y funcionalidades del sistema, lo cual facilita el mantenimiento y la escalabilidad del código.

• imagenes: Dentro de este paquete se encuentran todas las imágenes que se ocuparon para darle más diseño y estética al sistema. 

• modelo: Contiene las clases Alumno.java, Grupo.java, Horario.java, Materia.java, etc. En este paquete se representa cada entidad del sistema.

• vista: Contiene las clases VistaLogin.java, VistaModificarUsuario.java, VistaPrincipalAlumno.java, VistaPrincipalP.java, etc. Corresponde a las diferentes interfaces de usuario, la 
  vista que tiene el usurio.

  
  

