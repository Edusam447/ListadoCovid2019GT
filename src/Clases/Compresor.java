/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Edu
 */

public class Compresor {

    public static void comprimirArchivo(String FilePath) {
        HashMap<String, Integer> diccionario = new HashMap<>();
        StringBuilder contenido = new StringBuilder();
        int index = 1; // Índice inicial para el diccionario
        String saltoDeLineaMarcador = "<EOL>"; // Marcador para los saltos de línea

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(" ").append(saltoDeLineaMarcador).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] palabras = contenido.toString().split("\\s+");
        StringBuilder contenidoComprimido = new StringBuilder();
        
        for (String palabra : palabras) {
            if (!diccionario.containsKey(palabra)) {
                diccionario.put(palabra, index++);
            }
            contenidoComprimido.append(diccionario.get(palabra)).append(" ");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FilePath))) {
            // Escribir el diccionario al principio del archivo
            for (Map.Entry<String, Integer> entry : diccionario.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            bw.write("---\n"); // Separador entre diccionario y contenido comprimido
            bw.write(contenidoComprimido.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
