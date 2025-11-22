
package vista;

import java.awt.Color;
import modelo.cUsuario;
import controlador.cArreglo_Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class frmLogin extends javax.swing.JFrame {

    cArreglo_Usuario oArregloUsuario = new cArreglo_Usuario(10);
    
    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        cargarUsuarios();
         //Desactiva Echochar
    }

    private void cargarUsuarios() {
        oArregloUsuario.agregar(new cUsuario("admin", "lavidaescorta123"));
        oArregloUsuario.agregar(new cUsuario("reponedor1", "capybara3004"));
        oArregloUsuario.agregar(new cUsuario("cajero1", "ilzeji0604"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        psContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/panel.png"))); // NOI18N
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -20, 660, 680));

        txtUsuario.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtUsuario.setForeground(java.awt.Color.gray);
        txtUsuario.setText("Ingrese Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        background.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 320, 50));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 204));
        btnIngresar.setFont(new java.awt.Font("Roboto Condensed Black", 2, 18)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        background.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 110, 30));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 1, 59)); // NOI18N
        jLabel1.setText("INICIAR SESIÓN");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 460, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Usuario:");
        jLabel4.setToolTipText("Ingrese su usuario");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 160, 40));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 330, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 340, 30));

        psContraseña.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        psContraseña.setForeground(java.awt.Color.gray);
        psContraseña.setToolTipText("");
        psContraseña.setBorder(null);
        psContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                psContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                psContraseñaFocusLost(evt);
            }
        });
        psContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psContraseñaActionPerformed(evt);
            }
        });
        background.add(psContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 330, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        if (txtUsuario.getText().equals("Ingrese Usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese Usuario");
            txtUsuario.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void psContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_psContraseñaFocusGained
        String pass = String.valueOf(psContraseña.getPassword());

        if (pass.equals("Ingrese contraseña")) {
            psContraseña.setText("");
            psContraseña.setForeground(Color.BLACK);
            psContraseña.setEchoChar('●');  // activa los puntitos
        }
    }//GEN-LAST:event_psContraseñaFocusGained

    private void psContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_psContraseñaFocusLost
        String pass = String.valueOf(psContraseña.getPassword());

        if (pass.isEmpty()) {
            psContraseña.setText("Ingrese contraseña");
            psContraseña.setForeground(Color.GRAY);
            psContraseña.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_psContraseñaFocusLost

    private void psContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (!txtUsuario.getText().trim().isEmpty() && psContraseña.getPassword().length > 0) {
            String usuario = txtUsuario.getText();
            String contraseña = new String(psContraseña.getPassword());

            cUsuario oUsuario = oArregloUsuario.buscar(usuario, contraseña);
            
            if (usuario.equals(oUsuario.getUsuario()) && contraseña.equals(oUsuario.getContraseña())) {
                frmGeneral frmGeneral = new frmGeneral();
                frmGeneral.setVisible(true);
                this.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos :p");
            }
            //MEJORA DE SEGURIDAD: Limpiar el array de caracteres (opcional, pero buena práctica)
            java.util.Arrays.fill(psContraseña.getPassword(), '0');
        }else {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }       
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField psContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
