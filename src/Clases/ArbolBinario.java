/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Edu
 */

public class ArbolBinario {
    public static NodoPersona raiz;
    private static final DecimalFormat df = new DecimalFormat("#");
    
    public ArbolBinario(){
    raiz = null;
}
    
       //Metodo para insertar un nodo en el arbol
    public static void AgregarNodo(String n, String d, String m, String lv, double dpi, int cDosis, String dVacuna1, String dVacuna2, String dVacuna3){
        NodoPersona nuevo = new NodoPersona(n, d, m, lv, dpi, cDosis, 0, dVacuna1, dVacuna2, dVacuna3);
       
        if (raiz == null){
            raiz = nuevo;
        }else{
            NodoPersona auxiliar = raiz;
            NodoPersona padre;
            
            while (true){
                padre = auxiliar;
                if (dpi<auxiliar.dpi){
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }else{
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean EstaVacio(){
        return raiz == null;
    }
    
    //Recorridos
    
    //Metodo para recorrer el arbol InOrden (Izquierda, Raiz, Derecha)
    public void InOrden (NodoPersona r){
        if (r!=null){
            InOrden(r.hijoIzquierdo);
            System.out.println(r.nombre + ", " + df.format(r.dpi) + ", " + r.departamento + ", " + r.municipio + ", " + r.lugarVacunacion + ", " + r.cDosis + ", " + r.dVacuna1 + ", " + r.dVacuna2 + ", " + r.dVacuna3  ) ;
            InOrden(r.hijoDerecho);
        }
    }
    
    //Metodo para recorrer el arboel PreOrden (Raiz, Izquierda, Derecha)
    public void PreOrden (NodoPersona r){
        if (r!=null){
            System.out.println(r.nombre + ", " + df.format(r.dpi) + ", " + r.departamento + ", " + r.municipio + ", " + r.lugarVacunacion + ", " + r.cDosis + ", " + r.dVacuna1 + ", " + r.dVacuna2 + ", " + r.dVacuna3  ) ;
            PreOrden(r.hijoIzquierdo);
            PreOrden(r.hijoDerecho);
        }
    }
    
    //Metodo para recorrer el arbol PostOrden (Izquierda, Derecha, Raiz)
    public void PostOrden (NodoPersona r){
        if (r!=null){
            PostOrden(r.hijoIzquierdo);
            PostOrden(r.hijoDerecho);
            System.out.println(r.nombre + ", " + df.format(r.dpi) + ", " + r.departamento + ", " + r.municipio + ", " + r.lugarVacunacion + ", " + r.cDosis + ", " + r.dVacuna1 + ", " + r.dVacuna2 + ", " + r.dVacuna3  ) ;
        }
    }
    
    //Metodo para buscar un Nodo en el Arbol
    public NodoPersona BuscarNodo(double d){
        NodoPersona aux = raiz;
        
        while(aux.dpi!=d){
            if(d<aux.dpi){
                aux = aux.hijoIzquierdo;
            }else{
                aux = aux.hijoDerecho;
            }
            if (aux==null){
                return null;
            }
        }
        return aux;
    }
    
    //Métodos para guardar en archivo de texto usando InOrden
    public void guardarEnArchivoInOrden(String nombreArchivo) {
    File archivo = new File(nombreArchivo);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        guardarInOrden(raiz, writer);
        JOptionPane.showMessageDialog(null, "Datos guardados en el archivo " + nombreArchivo + " usando InOrden. Ruta: " + archivo.getAbsolutePath() , "Guardado", JOptionPane.INFORMATION_MESSAGE);   
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void guardarInOrden(NodoPersona r, BufferedWriter writer) throws IOException {
        if (r != null) {
            guardarInOrden(r.hijoIzquierdo, writer);
            writer.write(r.nombre + "\t" + df.format(r.dpi) + "\t" + r.departamento + "\t" + r.municipio + "\t" + r.lugarVacunacion + "\t" + r.cDosis + "\t" + r.dVacuna1 + "\t" + r.dVacuna2 + "\t" + r.dVacuna3);
            writer.newLine();
            guardarInOrden(r.hijoDerecho, writer);
        }
    }

    //Métodos para guardar en archivo de texto usando PreOrden
 public void guardarEnArchivoPreOrden(String nombreArchivo) {
    File archivo = new File(nombreArchivo);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        guardarPreOrden(raiz, writer);
        JOptionPane.showMessageDialog(null, "Datos guardados en el archivo " + nombreArchivo + " usando PreOrden. Ruta: " + archivo.getAbsolutePath() , "Guardado", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void guardarPreOrden(NodoPersona r, BufferedWriter writer) throws IOException {
        if (r != null) {
            writer.write(r.nombre + "\t" + df.format(r.dpi) + "\t" + r.departamento + "\t" + r.municipio + "\t" + r.lugarVacunacion + "\t" + r.cDosis + "\t" + r.dVacuna1 + "\t" + r.dVacuna2 + "\t" + r.dVacuna3);
            writer.newLine();
            guardarPreOrden(r.hijoIzquierdo, writer);
            guardarPreOrden(r.hijoDerecho, writer);
        }
    }

    //Métodos para guardar en archivo de texto usando PostOrden
public void guardarEnArchivoPostOrden(String nombreArchivo) {
    File archivo = new File(nombreArchivo);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        guardarPostOrden(raiz, writer);
        JOptionPane.showMessageDialog(null, "Datos guardados en el archivo " + nombreArchivo + " usando PostOrden. Ruta: " + archivo.getAbsolutePath() , "Guardado", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void guardarPostOrden(NodoPersona r, BufferedWriter writer) throws IOException {
        if (r != null) {
            guardarPostOrden(r.hijoIzquierdo, writer);
            guardarPostOrden(r.hijoDerecho, writer);
            writer.write(r.nombre + "\t" + df.format(r.dpi) + "\t" + r.departamento + "\t" + r.municipio + "\t" + r.lugarVacunacion + "\t" + r.cDosis + "\t" + r.dVacuna1 + "\t" + r.dVacuna2 + "\t" + r.dVacuna3);
            writer.newLine();
        }
    }
    
    public boolean EliminarNodo(double d){
        NodoPersona auxiliar = raiz;
        NodoPersona padre = raiz;
        boolean EsHijoIzq = true;
        
        while(auxiliar.dpi != d){
            padre = auxiliar;
            if (d<auxiliar.dpi){
                EsHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            }else{
                EsHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar ==null){
                return false; //nunca lo encontro
            }
        }//fin del while
        
        if(auxiliar.hijoIzquierdo==null && auxiliar.hijoDerecho==null){//Si es una HOja o solo la raiz
            if(auxiliar==raiz){
                raiz = null; //el nodo a eliminar es la raiz y apuntamos a null
            }else if(EsHijoIzq){
                padre.hijoIzquierdo = null;
            }else{
                padre.hijoDerecho = null;
            }
        }else if(auxiliar.hijoDerecho==null){
            if(auxiliar==raiz){
                raiz = auxiliar.hijoIzquierdo;
            }else if(EsHijoIzq){
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            }else{
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        }else if (auxiliar.hijoIzquierdo == null){
            if(auxiliar==raiz){
                raiz = auxiliar.hijoDerecho;
            }else if(EsHijoIzq){
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            }else{
                padre.hijoDerecho = auxiliar.hijoDerecho;
            }
        }else{
            NodoPersona reemplazo = ObtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz){
                raiz = reemplazo;
            }else if(EsHijoIzq){
                padre.hijoIzquierdo = reemplazo;
            }else{
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    
    public NodoPersona ObtenerNodoReemplazo(NodoPersona nodoreemp){
        NodoPersona reemplazopadre = nodoreemp;
        NodoPersona reemplazo = nodoreemp;
        NodoPersona auxiliar = nodoreemp.hijoDerecho;
        
        while(auxiliar != null){
            reemplazopadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoreemp.hijoDerecho){
            reemplazopadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoreemp.hijoDerecho;
        }
        return reemplazo;
    }
  
        public void actualizarNodo(double dpi, String nombre, String departamento, String municipio, String lugarVacunacion, int cantidadDosis, String fechaVacuna1, String fechaVacuna2, String fechaVacuna3) {
        NodoPersona nodo = BuscarNodo(dpi);
        if (nodo != null) {
            nodo.setNombre(nombre);
            nodo.setDepartamento(departamento);
            nodo.setMunicipio(municipio);
            nodo.setLugarVacunacion(lugarVacunacion);
            nodo.setcDosis(cantidadDosis);
            nodo.setdVacuna1(fechaVacuna1);
            nodo.setdVacuna2(fechaVacuna2);
            nodo.setdVacuna3(fechaVacuna3);
            JOptionPane.showMessageDialog(null, "Nodo actualizado correctamente", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nodo no encontrado", "Actualizacion", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        // Método para generar el archivo DOT
    public void generarDot(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write("digraph G {\n");
        if (raiz != null) {
            escribirNodoDOT(raiz, fileWriter);
        }
        fileWriter.write("}\n");
        fileWriter.close();
    }

    private void escribirNodoDOT(NodoPersona nodo, FileWriter fileWriter) throws IOException {
        if (nodo.hijoIzquierdo != null) {
            fileWriter.write("\"" + nodo.nombre + "\n(" + df.format(nodo.dpi) + ")\" -> \"" + nodo.hijoIzquierdo.nombre + "\n(" + df.format(nodo.hijoIzquierdo.dpi) + ")\";\n");
            escribirNodoDOT(nodo.hijoIzquierdo, fileWriter);
        }
        if (nodo.hijoDerecho != null) {
            fileWriter.write("\"" + nodo.nombre + "\n(" + df.format(nodo.dpi) + ")\" -> \"" + nodo.hijoDerecho.nombre + "\n(" + df.format(nodo.hijoDerecho.dpi) + ")\";\n");
            escribirNodoDOT(nodo.hijoDerecho, fileWriter);
        }
    }    
}


