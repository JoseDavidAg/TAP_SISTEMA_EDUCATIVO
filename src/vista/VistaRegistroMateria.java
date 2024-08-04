/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorGrupo;
import controlador.ControladorMateria;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.Materia;

/**
 *
 * @author Itzel_CG
 */
public class VistaRegistroMateria extends javax.swing.JFrame {

    /**
     * Creates new form VistaRegistroUsuario
     */
   
    
    public VistaRegistroMateria() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro Materia- SISTEMA DE LA INSTITUCIÓN");
        this.setSize(new Dimension (900, 550));
       
        
        
         llenarComboBoxCursos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVentanaAnterior = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnVentanaAnterior1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        imgGuardar = new javax.swing.JLabel();
        msg5 = new javax.swing.JLabel();
        txtGuardar = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        comboGrado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();

        btnVentanaAnterior.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        btnVentanaAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnVentanaAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anterior.png"))); // NOI18N
        btnVentanaAnterior.setText("Ventana anterior");
        btnVentanaAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentanaAnteriorMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(1, 25, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 25, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 30));

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 148, -1, 223));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/i6.1.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Ebrima", 1, 32)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("EscuelaConnect ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        btnVentanaAnterior1.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        btnVentanaAnterior1.setForeground(new java.awt.Color(255, 255, 255));
        btnVentanaAnterior1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anterior.png"))); // NOI18N
        btnVentanaAnterior1.setText("Ventana anterior");
        btnVentanaAnterior1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentanaAnterior1MouseClicked(evt);
            }
        });
        jPanel3.add(btnVentanaAnterior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 460));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 51, 102));
        jLabel13.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("Nueva Materia");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        imgGuardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        imgGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        imgGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgGuardarMouseClicked(evt);
            }
        });
        jPanel4.add(imgGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 70, 80));

        msg5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        msg5.setForeground(new java.awt.Color(255, 0, 0));
        msg5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(msg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        txtGuardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtGuardar.setText("Guardar");
        txtGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGuardarMouseClicked(evt);
            }
        });
        jPanel4.add(txtGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 60, 20));

        txtMateria.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        txtMateria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });
        txtMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMateriaKeyTyped(evt);
            }
        });
        jPanel4.add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 310, -1));

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Complete la información con los datos de la materia");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 270, 20));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel24.setText("Nombre de la materia");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, 26));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel25.setText("Grado");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 130, 26));

        jPanel4.add(comboGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 150, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 500, 460));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector.png"))); // NOI18N
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 90, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed

    private void txtMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMateriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaKeyTyped

    private void txtGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseClicked

    }//GEN-LAST:event_txtGuardarMouseClicked

    private void imgGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGuardarMouseClicked
        guardarMateria();
    }//GEN-LAST:event_imgGuardarMouseClicked

    private void btnVentanaAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentanaAnteriorMouseClicked
      

    }//GEN-LAST:event_btnVentanaAnteriorMouseClicked

    private void btnVentanaAnterior1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentanaAnterior1MouseClicked
         VistaPrincipalP VistaPrincipalP = new VistaPrincipalP();
        VistaPrincipalP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVentanaAnterior1MouseClicked

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
            java.util.logging.Logger.getLogger(VistaRegistroMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistroMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVentanaAnterior;
    private javax.swing.JLabel btnVentanaAnterior1;
    private javax.swing.JComboBox<String> comboGrado;
    private javax.swing.JLabel imgGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel msg5;
    private javax.swing.JLabel txtGuardar;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables

    
    

public void guardarMateria() {
    // Retrieve values from user input
    String nombre = txtMateria.getText().trim();
    
    // Retrieve selected item and convert to int
    Object selectedItem = comboGrado.getSelectedItem();
    int idCurso = 0;
    
    // Validate input
    if (nombre.equals("") || selectedItem == null) {
        JOptionPane.showMessageDialog(null, "Complete todos los campos");
        if (nombre.equals("")) {
            txtMateria.setBackground(Color.RED);
        }
        if (selectedItem == null) {
            comboGrado.setBackground(Color.RED);
        }
        return;
    }
    
    try {
        idCurso = Integer.parseInt(selectedItem.toString());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error al convertir el ID del curso", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Create and set up the Materia object
    Materia materia = new Materia();
    materia.setIdMateria(nombre);
    materia.setIdCurso(idCurso); // Assuming you have a method to set this in the Materia class

    // Check if the materia already exists
    if (!ControladorMateria.existeMateria(nombre)) {
        if (ControladorMateria.insertarMateria(materia)) {
            JOptionPane.showMessageDialog(null, "Materia guardada correctamente");
            Limpiar(); // Clear fields after saving
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Ya existe una materia con ese nombre");
    }
}

    
    
    
    
    
    
    
    
    
    
    



private void Limpiar() {
        txtMateria.setText("");
       // comboGrado.setModel(null);
        //comboAlumno.setModel(null);
        
    }

private void llenarComboBoxCursos() {
        ArrayList<String> idCursos = ControladorGrupo.obtenerIdCursos();
        for (String idCurso : idCursos) {
            comboGrado.addItem(idCurso);
        }
    }




}

