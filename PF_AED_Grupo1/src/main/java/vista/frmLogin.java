package vista;

import javax.swing.JOptionPane;
import modelo.cUsuario;
import java.awt.Color; // Necesario para los colores

/**
 *
 * @author adria
 */
public class frmLogin extends javax.swing.JFrame {

    cUsuario oUsuario = new cUsuario("admin","lavidaescorta123");
    
    public frmLogin() {
        initComponents();
        // Centrar el formulario al iniciar
        this.setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        // *** CAMBIO CLAVE: Usar JPasswordField para la contraseña ***
        txtContraseña = new javax.swing.JPasswordField(); 
        btnIngresar = new javax.swing.JButton();
        // *** Nuevo componente para el Icono/Imagen ***
        jLabel4 = new javax.swing.JLabel(); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Opcional: Establecer un color de fondo diferente para la ventana
        getContentPane().setBackground(new java.awt.Color(240, 248, 255)); // Azul muy claro
        
        // --- 1. CONFIGURACIÓN DEL TÍTULO Y EL ICONO ---
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // *** Cargar Imagen del logo desde resources ***
        try {
             java.net.URL urlLogo = getClass().getResource("resources/logo .png");
             if (urlLogo == null) {
                 urlLogo = getClass().getResource("/vista/resources/logo .png");
             }
             if (urlLogo != null) {
                 jLabel4.setIcon(new javax.swing.ImageIcon(urlLogo));
             } else {
                 jLabel4.setText("[LOGO AQUÍ]");
             }
        } catch (Exception e) {
             // Esto se ejecuta si la imagen no se encuentra. Puedes poner un icono alternativo.
             jLabel4.setText("[LOGO AQUÍ]");
        }
        
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // Fuente más grande y negrita
        jLabel1.setText("INICIAR SESIÓN");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Centrar el texto
        
        // --- 2. CONFIGURACIÓN DE ETIQUETAS Y CAMPOS ---
        jLabel2.setText("USUARIO:");
        jLabel3.setText("CONTRASEÑA:");
        
        // --- 3. CONFIGURACIÓN DEL BOTÓN ---
        btnIngresar.setText("INGRESAR");
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // Fuente más fuerte
        btnIngresar.setBackground(new java.awt.Color(0, 153, 204)); // Color Azul de fondo
        btnIngresar.setForeground(Color.WHITE); // Texto en blanco
        btnIngresar.setFocusPainted(false); // Quitar el borde de enfoque
        
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        // --- 4. LAYOUT MEJORADO (USANDO EL MISMO GROUP LAYOUT) ---
        // Este layout lo genera NetBeans, solo se agregan los nuevos elementos (jLabel4)

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // Nuevo: Añadir el icono arriba del título
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE) // Ajustado a 218 para centrar mejor
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))) // Botón más ancho
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                // Nuevo: El icono antes del título
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    // ... (El resto del código como btnIngresarActionPerformed y main se mantiene igual)

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(!txtUsuario.getText().trim().isEmpty() && txtContraseña.getPassword().length > 0){
            String usuario = txtUsuario.getText();
            // *** IMPORTANTE: Para JPasswordField se usa getPassword() ***
            String contraseña= new String(txtContraseña.getPassword()); 
            if(usuario.equals(oUsuario.getUsuario())&& contraseña.equals(oUsuario.getContraseña())){
                frmGeneral frmGeneral = new frmGeneral();
                frmGeneral.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos :p");
            }   
        }else{
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }
    } 

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseña; // Ahora es JPasswordField
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}