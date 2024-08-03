/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */
public class Horario {
    
    
    private int IdHorario;
    private String hora;
    private String dia;
    private String profesor;
    private String materia;
    private String salon;

    public Horario(int IdHorario, String hora, String dia, String profesor, String materia, String salon) {
        this.IdHorario = IdHorario;
        this.hora = hora;
        this.dia = dia;
        this.profesor = profesor;
        this.materia = materia;
        this.salon = salon;
    }

    public int getIdHorario() {
        return IdHorario;
    }

    public void setIdHorario(int IdHorario) {
        this.IdHorario = IdHorario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    
    
  
    
}
