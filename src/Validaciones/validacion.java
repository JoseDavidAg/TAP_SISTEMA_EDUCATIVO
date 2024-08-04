/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

/**
 *
 * @author Itzel_CG
 */
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Itzel_CG
 */
public class validacion {
    
    public boolean validacionCorreo(String email) {
//aceptar valores con aroba @n,  un dominio .com, .gmail, .net @itoaxaca, mayuscula, minuscula, vocales con acento
        
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@")&&( email.endsWith("itoaxaca.edu.mx")|| email.endsWith("gmail.com")||email.endsWith("yahoo.com")||email.endsWith("outlook.com")||email.endsWith("hotmail.com"));

    }

        
        
        public boolean validacionNumero(String numero, int longitud){ 
         if (numero.length()>longitud){
         return true; 
         }
         return false;
        }



        public boolean validacionMayEdad (Date fechaNacimiento){
            
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaNac = Calendar.getInstance();

            fechaNac.setTime(fechaNacimiento);
            int añoActual = fechaActual.get(Calendar.YEAR);
            int añoNac = fechaNac.get(Calendar.YEAR);
            int edad = añoActual - añoNac;
            
            if (edad >18){
            return true;
            } 
            return false;
        }

        public boolean validacionContraseña (String contraseña){

                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+])[A-Za-z\\d@$!%*?&]{7,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(contraseña);
            return matcher.matches();
        }
}
    