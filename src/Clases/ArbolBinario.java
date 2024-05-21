/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.text.DecimalFormat;
import java.util.HashSet;
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
        NodoPersona nuevo = new NodoPersona(n, d, m, lv, dpi, cDosis, dVacuna1, dVacuna2, dVacuna3);
       
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
    
    //Metodo para recorrer el arbol InOrden (Izquierda, Raiz, Derecha)
    public void InOrden (NodoPersona r){
        if (r!=null){
            InOrden(r.hijoIzquierdo);
            System.out.println(r.nombre + ", " + df.format(r.dpi)) ;
            InOrden(r.hijoDerecho);
        }
    }
    
    //Metodo para recorrer el arboel PreOrden (Raiz, Izquierda, Derecha)
    public void PreOrden (NodoPersona r){
        if (r!=null){
            System.out.println(r.nombre + ", " + df.format(r.dpi));
            PreOrden(r.hijoIzquierdo);
            PreOrden(r.hijoDerecho);
        }
    }
    
    //Metodo para recorrer el arbol PostOrden (Izquierda, Derecha, Raiz)
    public void PostOrden (NodoPersona r){
        if (r!=null){
            PostOrden(r.hijoIzquierdo);
            PostOrden(r.hijoDerecho);
            System.out.println(r.nombre + ", " + df.format(r.dpi));
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
    
}


