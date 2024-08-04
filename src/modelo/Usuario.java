/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */


 import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Usuario {
    
    
    private int IdUsuario;
    private String usuario;
    private String tipo;
    private String nombre;
    private String apellidos;
    private String contraseña;
    private String correo;
    private int identificacion;
    
    
    //ATRIBUTOS
    public Usuario(String usuario, String tipo, String nombre, String apellidos, String contraseña, String correo, int identificacion) {
     
        this.usuario = usuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correo = correo;
        this.identificacion = identificacion;
    }
   
    
   
    
     //CONSTRUCTOR
    public Usuario() {
        this.IdUsuario = 0;
        this.usuario = "";
        this.tipo = "";
        this.nombre = "";
        this.apellidos = "";
        this.contraseña = "";
        this.correo = "";
        this.identificacion =0;
      
    }
    
    
    //SET AND GET
    
     public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getContraseña() {
    
       return contraseña;
    }
   
       
    

        //return contraseña;}
    //}

    public void setContraseña(String contraseña) {
      

        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
   
    
    
   
    
    
}
