/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */

    
    public class profesor_materia_grupo {
    private int profesorId;
    private String materiaId;
    private int grupoId;

    // Constructor, getters y setters
    public profesor_materia_grupo(int profesorId, String materiaId, int grupoId) {
        this.profesorId = profesorId;
        this.materiaId = materiaId;
        this.grupoId = grupoId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }
}

    
 