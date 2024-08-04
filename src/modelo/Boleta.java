/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Itzel_CG
 */
public class Boleta {
    
    private String boleta;
    private double periodo1;
    private double periodo2;
    private double periodo3;
    private double promedio;
    

    public Boleta(String boleta, double periodo1, double periodo2, double periodo3, double promedio) {
        this.boleta = boleta;
        this.periodo1 = periodo1;
        this.periodo2 = periodo2;
        this.periodo3 = periodo3;
        this.promedio = promedio;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public double getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(double periodo1) {
        this.periodo1 = periodo1;
    }

    public double getPeriodo2() {
        return periodo2;
    }

    public void setPeriodo2(double periodo2) {
        this.periodo2 = periodo2;
    }

    public double getPeriodo3() {
        return periodo3;
    }

    public void setPeriodo3(double periodo3) {
        this.periodo3 = periodo3;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    
   
    
    
    
    
    
    
    
}
