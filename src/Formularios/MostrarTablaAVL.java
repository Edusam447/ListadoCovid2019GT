/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Clases.NodoPersona;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalcovid.ProyectoFinalCovid;

/**
 *
 * @author Edu
 */
public class MostrarTablaAVL extends javax.swing.JFrame {
    private static final DecimalFormat df = new DecimalFormat("#");
    DefaultTableModel mt = new DefaultTableModel();
    /**
     * Creates new form MostrarTabla
     */
    public MostrarTablaAVL(){
        initComponents();
        String ids[] = {"Nombre","Dpi","Departamento","Municipio","Lugar de vacunacion","Numero de dosis","Fecha Dosis 1","Fecha Dosis 2","Fecha Dosis 3"};
        mt.setColumnIdentifiers(ids);
        jTableDatos.setModel(mt);
        PreOrden(ProyectoFinalCovid.formu.arbolAVL.raiz);
        
        
        this.setLocationRelativeTo(null);
    }
    
        public void PreOrden (NodoPersona r){
        if (r!=null){
            mt.addRow(new Object[ ]{r.getNombre(), df.format(r.getDpi()), r.getDepartamento(), r.getMunicipio(), r.getLugarVacunacion(), r.getcDosis(), r.getdVacuna1(), r.getdVacuna2(), r.getdVacuna3(),});
            PreOrden(r.getHijoIzquierdo());
            PreOrden(r.getHijoDerecho());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        botonReiniciar = new javax.swing.JButton();
        botonGraficar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(jTableDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 430));

        jTextFieldBuscar.setText("DPI");
        jPanel1.add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 252, -1));

        botonReiniciar.setText("Reiniciar Tabla");
        botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(botonReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 195, -1));

        botonGraficar.setText("Mostrar grafico");
        botonGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGraficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 480, 129, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 440, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo blue dw.jpg"))); // NOI18N
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
this.setVisible(false);
ProyectoFinalCovid.formu.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
mt.setRowCount(0);  //Limpiar tabla
NodoPersona tmp;
double dpiBuscar = Double.parseDouble(jTextFieldBuscar.getText());
tmp = ProyectoFinalCovid.formu.arbolAVL.BuscarNodo(dpiBuscar);
        if (tmp==null){
                                JOptionPane.showMessageDialog(null,"El nodo buscado no se encuentra en el arbol","Nodo No Encontrado",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                mt.addRow(new Object[ ]{tmp.getNombre(), df.format(tmp.getDpi()), tmp.getDepartamento(), tmp.getMunicipio(), tmp.getLugarVacunacion(), tmp.getcDosis(), tmp.getdVacuna1(), tmp.getdVacuna2(), tmp.getdVacuna3()});
                            }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarActionPerformed
       mt.setRowCount(0);  //Limpiar tabla
       PreOrden(ProyectoFinalCovid.formu.arbolAVL.raiz);
    }//GEN-LAST:event_botonReiniciarActionPerformed

    public void generarImagen(String dotPath, String outputPath) {
    try {
        Process process = Runtime.getRuntime().exec("dot -Tpng " + dotPath + " -o " + outputPath);
        process.waitFor();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}

private void abrirImagen(String imagePath) {
    try {
        Runtime.getRuntime().exec("explorer " + imagePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void botonGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficarActionPerformed
       try {
            String dotPath = "arbolAVL.dot";
            String outputPath = "arbolAVL.png";
            ProyectoFinalCovid.formu.arbolAVL.generarDot(dotPath);
            generarImagen(dotPath, outputPath);
            abrirImagen(outputPath);
    } catch (IOException e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_botonGraficarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarTablaAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarTablaAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarTablaAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarTablaAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarTablaAVL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonGraficar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonReiniciar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
