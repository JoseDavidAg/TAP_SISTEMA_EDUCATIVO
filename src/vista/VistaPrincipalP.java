/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itzel_CG
 */
public class VistaPrincipalP extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipalP() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Vista Principal- SISTEMA DE LA INSTITUCIÓN");
        this.setSize(new Dimension (920, 500));
        
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
        jPanel3 = new javax.swing.JPanel();
        btnProfesor = new javax.swing.JButton();
        btnGrupo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMateria = new javax.swing.JButton();
        btnAlumno1 = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnAlumno3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnMateria1 = new javax.swing.JButton();
        btnHorario1 = new javax.swing.JButton();
        btnHorario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 25, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfesor.setBackground(new java.awt.Color(0, 51, 153));
        btnProfesor.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnProfesor.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prf.png"))); // NOI18N
        btnProfesor.setText("Profesor");
        btnProfesor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorActionPerformed(evt);
            }
        });
        jPanel3.add(btnProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 50));

        btnGrupo.setBackground(new java.awt.Color(0, 51, 153));
        btnGrupo.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnGrupo.setForeground(new java.awt.Color(255, 255, 255));
        btnGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/g.png"))); // NOI18N
        btnGrupo.setText("Grupo");
        btnGrupo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrupoActionPerformed(evt);
            }
        });
        jPanel3.add(btnGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 220, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/i6.21.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnMateria.setBackground(new java.awt.Color(0, 51, 153));
        btnMateria.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnMateria.setForeground(new java.awt.Color(255, 255, 255));
        btnMateria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N
        btnMateria.setText("Materia");
        btnMateria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMateriaMouseClicked(evt);
            }
        });
        jPanel3.add(btnMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 50));

        btnAlumno1.setBackground(new java.awt.Color(0, 51, 153));
        btnAlumno1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnAlumno1.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/a.png"))); // NOI18N
        btnAlumno1.setText("Alumno");
        btnAlumno1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlumno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumno1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAlumno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 220, 30));

        btnCerrarSesion.setBackground(new java.awt.Color(0, 51, 153));
        btnCerrarSesion.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 220, 60));

        btnAlumno3.setBackground(new java.awt.Color(0, 51, 153));
        btnAlumno3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnAlumno3.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mj2.png"))); // NOI18N
        btnAlumno3.setText("Usuario");
        btnAlumno3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlumno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumno3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAlumno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, 50));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("EscuelaConnect ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btnMateria1.setBackground(new java.awt.Color(0, 51, 153));
        btnMateria1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnMateria1.setForeground(new java.awt.Color(255, 255, 255));
        btnMateria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N
        btnMateria1.setText("Materia");
        btnMateria1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMateria1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMateria1MouseClicked(evt);
            }
        });
        jPanel3.add(btnMateria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 50));

        btnHorario1.setBackground(new java.awt.Color(0, 51, 153));
        btnHorario1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnHorario1.setForeground(new java.awt.Color(255, 255, 255));
        btnHorario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hr.png"))); // NOI18N
        btnHorario1.setText("Horari0");
        btnHorario1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHorario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorario1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, 50));

        btnHorario.setBackground(new java.awt.Color(0, 51, 153));
        btnHorario.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnHorario.setForeground(new java.awt.Color(255, 255, 255));
        btnHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hr.png"))); // NOI18N
        btnHorario.setText("Horario-Profesor");
        btnHorario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorarioActionPerformed(evt);
            }
        });
        jPanel3.add(btnHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hola, bienvenido");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel13)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel13)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 420, 410));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, -20, 200, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorActionPerformed
        VistaRegistroProfesor ventanaProfesor = new VistaRegistroProfesor();
        ventanaProfesor.setVisible(true);
        this.dispose();  
        
    }//GEN-LAST:event_btnProfesorActionPerformed

    private void btnAlumno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumno1ActionPerformed
        VistaRegistroAlumno ventanaAlumno = new VistaRegistroAlumno();
        ventanaAlumno.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_btnAlumno1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        VistaLogin ventanaLogin = new VistaLogin();
        ventanaLogin.setVisible(true);
         this.dispose();  
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnAlumno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumno3ActionPerformed
        VistaModificarUsuario VistaUsuario = null;
        try {
            VistaUsuario = new VistaModificarUsuario();
        } catch (Exception ex) {
            Logger.getLogger(VistaPrincipalP.class.getName()).log(Level.SEVERE, null, ex);
        }
        VistaUsuario.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnAlumno3ActionPerformed

    private void btnMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMateriaMouseClicked
       
        VistaRegistroMateria VistaMateria = new VistaRegistroMateria();
        VistaMateria.setVisible(true);
        this.dispose(); 
        
        
    }//GEN-LAST:event_btnMateriaMouseClicked

    private void btnGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrupoActionPerformed
        VistaRegistroGrupo VistaGrupo = new VistaRegistroGrupo();
        VistaGrupo.setVisible(true);
        this.dispose(); 
        
    }//GEN-LAST:event_btnGrupoActionPerformed

    private void btnHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorarioActionPerformed
       ScheduleFrame vista = null;
        try {
            vista = new ScheduleFrame();
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipalP.class.getName()).log(Level.SEVERE, null, ex);
        }
      vista.setVisible(true);
      this.dispose();
               
        
    }//GEN-LAST:event_btnHorarioActionPerformed

    private void btnMateria1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMateria1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMateria1MouseClicked

    private void btnHorario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHorario1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipalP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumno1;
    private javax.swing.JButton btnAlumno3;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGrupo;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnHorario1;
    private javax.swing.JButton btnMateria;
    private javax.swing.JButton btnMateria1;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
