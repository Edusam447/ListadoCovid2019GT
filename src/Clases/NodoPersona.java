/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Edu
 */
public class NodoPersona {
    String nombre, departamento, municipio, lugarVacunacion;
    double dpi;
    int  cDosis, dVacuna1, dVacuna2, dVacuna3;
    NodoPersona hijoIzquierdo, hijoDerecho;

    public NodoPersona(String nombre, String departamento, String municipio, String lugarVacunacion, double dpi, int cDosis, int dVacuna1, int dVacuna2, int dVacuna3) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.municipio = municipio;
        this.lugarVacunacion = lugarVacunacion;
        this.dpi = dpi;
        this.cDosis = cDosis;
        this.dVacuna1 = dVacuna1;
        this.dVacuna2 = dVacuna2;
        this.dVacuna3 = dVacuna3;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null; 
    }
    
    
    
    
}
