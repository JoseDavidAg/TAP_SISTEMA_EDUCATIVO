/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author Itzel_CG
 */
public class Profesor {
    
    
    private int IdProfesor;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String telefono;
    private String especialidad;
    private String cedula;
    private int IdUsuario;

    

    public Profesor(int IdProfesor, String nombre, String apellidoP, String apellidoM, String direccion, String telefono, String especialidad, String cedula, int IdUsuario) {
        this.IdProfesor = IdProfesor;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
       
        this.direccion = direccion;
        this.telefono = telefono;
      
        this.especialidad = especialidad;
        this.cedula =  cedula;
        this.IdUsuario = IdUsuario;
    }
    
    
    
    
    
    public Profesor (){
        this.IdProfesor =0;
        this.nombre = "";
        this.apellidoP = "";
        this.apellidoM = "";
      
        this.direccion = "";
        this.telefono = "";
        
        this.especialidad = "";
        this.cedula = "";
        this.IdUsuario= 0;
    
    
    }

    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int IdEmpleado) {
        this.IdProfesor = IdEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
       public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
    
     @Override
    public String toString() {
        return nombre + " " + apellidoP + " " + apellidoM ;
    }

    
    
    
    
    
    
    
    
}
