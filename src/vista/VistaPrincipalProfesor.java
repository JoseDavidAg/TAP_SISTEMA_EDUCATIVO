/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


/**
 *
 * @author Itzel_CG
 */

import conexion.Conexion;
import java.sql.*;
import controlador.ControladorVistaProfesor;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import modelo.Materia;
import modelo.Profesor;





public class VistaPrincipalProfesor extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
       //private JComboBox<String> materiaComboBox;
    
    
   private ControladorVistaProfesor ControladorVistaProfesor;
    
    public VistaPrincipalProfesor() {
        
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Profesor- SISTEMA DE LA INSTITUCIÓN");
        this.setSize(new Dimension (900, 560));
  
        
        
        
        
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        comboMateria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblidentificacion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 25, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/i6.21.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnCerrarSesion.setBackground(new java.awt.Color(0, 51, 153));
        btnCerrarSesion.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 90, 60));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Ebrima", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("EscuelaConnect ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 30));

        comboMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMateriaActionPerformed(evt);
            }
        });
        jPanel3.add(comboMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Profesor ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        lblidentificacion.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblidentificacion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 140, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 480));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCalificaciones);

        jPanel2.add(jScrollPane1);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 700, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        VistaLogin ventanaLogin = new VistaLogin();
        ventanaLogin.setVisible(true);
         this.dispose();  
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void comboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMateriaActionPerformed
 
    }//GEN-LAST:event_comboMateriaActionPerformed

    
        
         
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(VistaPrincipalProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipalProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JComboBox<String> comboMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblidentificacion;
    private javax.swing.JTable tablaCalificaciones;
    // End of variables declaration//GEN-END:variables

  
    
    public void LimpiarCamposProfesor() {
    lblNombre.setText("");
   
}

    
      
      private String getMateriaNombre(int idMateria) {
        String materiaNombre = "";
            Connection cn = Conexion.conectar();
        try {
            String query = "SELECT Nombre FROM Materias WHERE IdMateria = ?";
            PreparedStatement statement = cn.prepareStatement(query);
            statement.setInt(1, idMateria);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                materiaNombre = resultSet.getString("Nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiaNombre;
    }

   
      
     
   
      
      
      
      
      
      
      
      
}
