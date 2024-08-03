/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Validaciones.validacion;
import controlador.ControladorLogin;
import controlador.PasswordUtil;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itzel_CG
 */
public class VistaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    private boolean contraseñaVisible = false;
    validacion val = new validacion();
    public VistaLogin() {
        initComponents();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Login- SISTEMA DE LA INSTITUCIÓN");
        this.setSize(new Dimension (900, 560));
        lblObligatorio.setVisible(false);
        lblObligatorio2.setVisible(false);
    
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnIngreso = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        btnUnir1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbOjo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblObligatorio1 = new javax.swing.JLabel();
        lblObligatorio2 = new javax.swing.JLabel();
        lblObligatorio = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 25, 71));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 186, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setActionCommand("<Not Set>");
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 211, 32));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 247, -1, 32));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Correo Electrónico");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 211, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contraseña");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 211, -1));

        btnIngreso.setBackground(new java.awt.Color(0, 51, 152));
        btnIngreso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnIngreso.setText("Iniciar sesión");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        jPanel4.add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 211, 32));

        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        jPanel4.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 211, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel8.setText("¿No tiene una cuenta?");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        btnUnir1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        btnUnir1.setForeground(new java.awt.Color(0, 0, 153));
        btnUnir1.setText("Regístrate");
        btnUnir1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUnir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnir1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnUnir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 229, -1, -1));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 304, -1, 22));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/can3.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/us2.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ic6.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        lbOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojoA1.png"))); // NOI18N
        lbOjo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOjoMouseClicked(evt);
            }
        });
        jPanel4.add(lbOjo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 30, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojoA1.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 30, 30));

        lblObligatorio1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblObligatorio1.setForeground(new java.awt.Color(204, 0, 51));
        lblObligatorio1.setText("*obligatorio");
        jPanel4.add(lblObligatorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        lblObligatorio2.setForeground(new java.awt.Color(204, 0, 51));
        lblObligatorio2.setText("*obligatorio");
        jPanel4.add(lblObligatorio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 80, -1));

        lblObligatorio.setForeground(new java.awt.Color(204, 0, 51));
        lblObligatorio.setText("*obligatorio");
        jPanel4.add(lblObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 80, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 340, 460));

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Ebrima", 1, 40)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("EscuelaConnect ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 148, -1, 223));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/i6.1.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Vector.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, -70, 200, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        //leerArchivo();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
       
       
        
        try {
            this.Login2();
        } catch (Exception ex) {
            Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtUsuario.setText("");
        txtContraseña.setText("");
        

        
        
    }//GEN-LAST:event_btnIngresoActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnUnir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnir1ActionPerformed
        VistaRegistroUsuario ventanaRegistro = new VistaRegistroUsuario();
        ventanaRegistro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUnir1ActionPerformed

    private void lbOjoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOjoMouseClicked
        // TODO add your handling code here:
        
        if (contraseñaVisible) { 
                    txtContraseña.setEchoChar('*');
                } else {
                    txtContraseña.setEchoChar((char) 0);
                }
                contraseñaVisible = !contraseñaVisible;
            
      
    }//GEN-LAST:event_lbOjoMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        // TODO add your handling code here:
        if(!val.validacionCorreo(txtUsuario.getText())){
            lblObligatorio.setVisible(true);
        }else{
            lblObligatorio.setVisible(false);
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        // TODO add your handling code here:
        String te=new String(txtContraseña.getPassword());
        if(val.validacionContraseña(te)){
            lblObligatorio2.setVisible(false);
        }else{
            lblObligatorio2.setVisible(true);
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnUnir1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbOjo;
    private javax.swing.JLabel lblObligatorio;
    private javax.swing.JLabel lblObligatorio1;
    private javax.swing.JLabel lblObligatorio2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

private void Login2() throws Exception {
    
    
    if (!txtUsuario.getText().isEmpty() && !txtContraseña.getText().isEmpty()) {
        PasswordUtil encrip= new PasswordUtil();
        Usuario usuario = new Usuario();
        usuario.setCorreo(txtUsuario.getText().trim());
        usuario.setContraseña(encrip.hashPassword(txtContraseña.getText().trim()));

        //System.out.println("Intentando obtener el tipo de usuario...");
        String tipoUsuario = ControladorLogin.obtenerTipoUsuario(usuario);
        
        
        
        if (tipoUsuario != null) {
            
            switch (tipoUsuario) {
                case "Administrador":
                    VistaPrincipalP vistaAdmin = new VistaPrincipalP();
                    vistaAdmin.setVisible(true);
                    break;
                case "Alumno":
                    VistaPrincipalAlumno vistaAlumno = new VistaPrincipalAlumno();
                    vistaAlumno.setVisible(true);
                    break;
                case "Profesor":
                    
                    //EMPIEZAN LOS CAMBIOS
                    //VistaPrincipalProfesor vistaProfesor = new VistaPrincipalProfesor();
                    //vistaProfesor.setVisible(true);
                    VistaProfesor profesorVista = new VistaProfesor(txtUsuario.getText());
                    profesorVista.setVisible(true);
                   /*
                        Connection cn = Conexion.conectar();
                        UsuarioDAO usuarioDAO = new UsuarioDAO(cn);
                        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
                        ControladorVistaProfesor controller = new ControladorVistaProfesor(usuarioService);
                        String correo = txtUsuario.getText();
                        int usuarioId = controller.obtenerIdUsuarioPorCorreo(correo);
                        
                         Ensure lblidentificacion is not null and properly instantiated
                        if (VistaPrincipalProfesor.lblidentificacion != null) {
                            VistaPrincipalProfesor.lblidentificacion.setText("ID del usuario: " + (usuarioId != -1 ? usuarioId : "No encontrado"));
                        } else {
                            System.out.println("lblidentificacion is null!");
                        }
                       */
            
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de usuario desconocido");
                    break;
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Intentelo de nuevo");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Ingrese correctamente sus datos");
    }
}

    
    
    
    
    
    
    
    

}
