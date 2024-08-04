/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Itzel_CG
 */
public class Alumno {

    public Alumno(int IdAlumno, String nombre, String apellidoP, String apellidoM, String fechaNaci, String genero, String tutor, String telefono, String correo, String ocupacion, String IdGrupo) {
        
        this.IdAlumno = IdAlumno;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNaci = fechaNaci;
        this.genero = genero;
        this.tutor = tutor;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.correo = correo;
        this.IdGrupo = IdGrupo;
    }

   

    private int IdAlumno;
  
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaNaci;
    private String genero;
    private String tutor;
    private String telefono;
    private String correo;
    private String ocupacion;
    private String IdGrupo;
   

 
    
    //ATRIBUTOS
    public Alumno() {
        this.IdAlumno = 0;
        this.nombre = "";
        this.apellidoP = "";
        this.apellidoM = "";
        this.fechaNaci = "";
        this.genero = "";
        this.tutor = "";
        this.telefono = "";
        this.correo = "";
        this.ocupacion = "";
        this.IdGrupo = "";
    }
    

    //SET Y GET
    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdAlumno = IdAlumno;
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

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
  
    
    
    public String getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(String IdGrupo) {
        this.IdGrupo = IdGrupo;
    }
    
    
    public String toString() {
        // Devuelve una representación adecuada para mostrar en el JComboBox
        return nombre + " " + apellidoP + " " + apellidoM;
    }
    
}
