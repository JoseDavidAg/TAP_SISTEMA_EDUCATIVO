/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */
public class Grupo {
    
    private String IdGrupo;
    private  int IdCurso;

    public Grupo(String IdGrupo, int IdCurso) {
        this.IdGrupo = IdGrupo;
        this.IdCurso = IdCurso;
    }
    
    
    public Grupo(){
    
    this.IdGrupo ="";
    this.IdCurso =0;
    }
    

    public String getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(String IdGrupo) {
        this.IdGrupo = IdGrupo;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

 

    
    
    @Override
    public String toString() {
        return IdGrupo; 
    }
}
