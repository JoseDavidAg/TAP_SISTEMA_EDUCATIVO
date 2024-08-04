/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */ 
public class Materia {

    private String IdMateria;
    private int IdCurso;
    
    
    public Materia(String IdMateria, int IdCurso) {
        this.IdMateria = IdMateria;
        this.IdCurso = IdCurso;
    }

    public Materia (){
    
    this.IdMateria  = "";
    this.IdCurso =0;
    
    }
    
    
    public String getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(String IdMateria) {
        this.IdMateria = IdMateria;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }
    
  
    
  
    @Override
    public String toString() {
        return IdMateria; 
    }
    
    
    
    
    
    
    
    
    
}
