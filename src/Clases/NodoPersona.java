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
    String nombre, departamento, municipio, lugarVacunacion, dVacuna1, dVacuna2, dVacuna3;;
    double dpi;
    int  fe, cDosis;
    NodoPersona hijoIzquierdo, hijoDerecho;

    public NodoPersona(String n, String d, String m, String lv, double dpi, int cDosis, int fe, String dVacuna1, String dVacuna2, String dVacuna3) {
        this.nombre = n;
        this.departamento = d;
        this.municipio = m;
        this.lugarVacunacion = lv;
        this.dpi = dpi;
        this.fe = fe;
        this.cDosis = cDosis;
        this.dVacuna1 = dVacuna1;
        this.dVacuna2 = dVacuna2;
        this.dVacuna3 = dVacuna3;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLugarVacunacion() {
        return lugarVacunacion;
    }

    public void setLugarVacunacion(String lugarVacunacion) {
        this.lugarVacunacion = lugarVacunacion;
    }

    public double getDpi() {
        return dpi;
    }

    public void setDpi(double dpi) {
        this.dpi = dpi;
    }

    public int getcDosis() {
        return cDosis;
    }

    public void setcDosis(int cDosis) {
        this.cDosis = cDosis;
    }

    public String getdVacuna1() {
        return dVacuna1;
    }

    public void setdVacuna1(String dVacuna1) {
        this.dVacuna1 = dVacuna1;
    }

    public String getdVacuna2() {
        return dVacuna2;
    }

    public void setdVacuna2(String dVacuna2) {
        this.dVacuna2 = dVacuna2;
    }

    public String getdVacuna3() {
        return dVacuna3;
    }

    public void setdVacuna3(String dVacuna3) {
        this.dVacuna3 = dVacuna3;
    }

    

    public NodoPersona getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoPersona hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoPersona getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoPersona hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
    
    
    
}
