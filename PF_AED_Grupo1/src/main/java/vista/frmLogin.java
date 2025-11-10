
package vista;

import javax.swing.JOptionPane;
import modelo.cUsuario;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author adria
 */
public class frmLogin extends javax.swing.JFrame {

    cUsuario oUsuario = new cUsuario("admin","lavidaescorta123");
    
    public frmLogin() {
        initComponents();
        // ========== DISEÑO: Configuración inicial de la ventana ==========
        configurarVentana();
        // ========== DISEÑO: Cargar y mostrar el logo ==========
        cargarLogo();
        // ========== DISEÑO: Aplicar estilos a los componentes ==========
        aplicarEstilos();
        // ========== DISEÑO: Centrar la ventana después de pack() ==========
        setLocationRelativeTo(null);
    }
    
    /**
     * ========== DISEÑO: Método para configurar propiedades de la ventana ==========
     * Establece el título y desactiva el redimensionamiento
     */
    private void configurarVentana() {
        setTitle("Sistema de Login");
        setResizable(false);
    }
    
    /**
     * ========== DISEÑO: Método para cargar y mostrar el logo ==========
     * Carga la imagen del logo desde la carpeta resources y la muestra en la esquina superior izquierda
     * Logo de tamaño mediano (120x120 píxeles) para esquina
     */
    private void cargarLogo() {
        try {
            // ========== DISEÑO: Cargar la imagen del logo desde la carpeta resources ==========
            // La ruta debe ser relativa al classpath, sin el prefijo /vista ya que estamos en el mismo paquete
            java.net.URL urlLogo = getClass().getResource("resources/logo .png");
            if (urlLogo == null) {
                // Intentar con otra ruta posible
                urlLogo = getClass().getResource("/vista/resources/logo .png");
            }
            if (urlLogo != null) {
                ImageIcon iconoOriginal = new ImageIcon(urlLogo);
                // ========== DISEÑO: Redimensionar la imagen para esquina (tamaño más grande) ==========
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
                // ========== DISEÑO: Establecer el icono en el JLabel del logo en esquina ==========
                lblLogo.setIcon(iconoEscalado);
                lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            } else {
                // Si no se encuentra el logo, mostrar texto estilizado
                lblLogo.setText("LOGO");
                lblLogo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
                lblLogo.setForeground(Color.WHITE);
                lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            }
        } catch (Exception e) {
            // ========== DISEÑO: Si no se puede cargar el logo, mostrar texto alternativo estilizado ==========
            lblLogo.setText("LOGO");
            lblLogo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
            lblLogo.setForeground(Color.WHITE);
            lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        }
    }
    
    /**
     * ========== DISEÑO: Método para aplicar estilos visuales a los componentes ==========
     * Configura colores corporativos serios estilo empresa de tecnología
     * Colores: Azul oscuro corporativo (#1E3A5F), Gris oscuro (#34495E), Gris claro (#ECF0F1)
     */
    private void aplicarEstilos() {
        // ========== DISEÑO: Fondo principal - Gris muy claro profesional ==========
        getContentPane().setBackground(new Color(236, 240, 241)); // Gris muy claro corporativo
        
        // ========== DISEÑO: Panel lateral con color azul oscuro corporativo ==========
        panelLateral.setBackground(new Color(30, 58, 95)); // Azul oscuro corporativo (#1E3A5F)
        panelLateral.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        // ========== DISEÑO: Panel de formulario con fondo blanco ==========
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            javax.swing.BorderFactory.createEmptyBorder(50, 60, 50, 60)
        ));
        
        // ========== DISEÑO: Título "INICIAR SESIÓN" - Azul oscuro corporativo ==========
        jLabel1.setForeground(new Color(30, 58, 95)); // Azul oscuro corporativo
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36)); // Fuente más grande
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // ========== DISEÑO: Etiquetas de usuario y contraseña - Gris oscuro corporativo ==========
        jLabel2.setForeground(new Color(52, 73, 94)); // Gris oscuro corporativo (#34495E)
        jLabel2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16)); // Fuente más grande
        jLabel3.setForeground(new Color(52, 73, 94)); // Gris oscuro corporativo
        jLabel3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16)); // Fuente más grande
        
        // ========== DISEÑO: Campos de texto con bordes grises corporativos ==========
        txtUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new Color(189, 195, 199), 2), // Borde gris corporativo
            javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20) // Más padding interno
        ));
        txtUsuario.setBackground(new Color(249, 250, 251)); // Gris muy claro
        txtUsuario.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16)); // Fuente más grande
        
        // ========== DISEÑO: Campo de contraseña con el mismo estilo gris corporativo ==========
        txtContraseña.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new Color(189, 195, 199), 2), // Borde gris corporativo
            javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20) // Más padding interno
        ));
        txtContraseña.setBackground(new Color(249, 250, 251)); // Gris muy claro
        txtContraseña.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16)); // Fuente más grande
        
        // ========== DISEÑO: Botón de ingresar - Azul oscuro corporativo ==========
        btnIngresar.setBackground(new Color(30, 58, 95)); // Azul oscuro corporativo
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)); // Fuente más grande
        btnIngresar.setBorderPainted(false);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // ========== DISEÑO: Efecto hover - Azul más claro pero serio ==========
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresar.setBackground(new Color(52, 73, 94)); // Gris azulado al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresar.setBackground(new Color(30, 58, 95)); // Volver al azul oscuro corporativo
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateral = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // ========== DISEÑO: Título más grande y llamativo ==========
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36)); // NOI18N
        jLabel1.setText("INICIAR SESIÓN");

        jLabel2.setText("USUARIO:");

        jLabel3.setText("CONTRASEÑA:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        // ========== DISEÑO: Configuración del layout con diseño de dos paneles ==========
        // Panel lateral naranja a la izquierda y panel de formulario blanco a la derecha
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        // ========== DISEÑO: Configuración del panel lateral (azul oscuro corporativo) ==========
        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap(30, 30)
                // ========== DISEÑO: Logo en esquina superior izquierda más grande ==========
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap(30, 30)
                // ========== DISEÑO: Logo en esquina superior izquierda más grande ==========
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // ========== DISEÑO: Configuración del panel de formulario (blanco) - Más grande ==========
        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // ========== DISEÑO: Título "INICIAR SESIÓN" centrado ==========
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(50, 50, 50)
                    // ========== DISEÑO: Etiqueta y campo de usuario más grandes ==========
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    // ========== DISEÑO: Etiqueta y campo de contraseña más grandes ==========
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    // ========== DISEÑO: Botón de ingresar más grande y centrado ==========
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                // ========== DISEÑO: Título "INICIAR SESIÓN" más grande ==========
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                // ========== DISEÑO: Etiqueta de usuario ==========
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                // ========== DISEÑO: Campo de texto de usuario más alto ==========
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                // ========== DISEÑO: Etiqueta de contraseña ==========
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                // ========== DISEÑO: Campo de contraseña más alto ==========
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                // ========== DISEÑO: Botón de ingresar más grande ==========
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        
        // ========== DISEÑO: Configuración horizontal del layout principal - Más grande ==========
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                // ========== DISEÑO: Panel lateral azul oscuro a la izquierda más grande ==========
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                // ========== DISEÑO: Panel de formulario blanco a la derecha ==========
                .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // ========== DISEÑO: Configuración vertical del layout principal ==========
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if(!txtUsuario.getText().trim().isEmpty() && !String.valueOf(txtContraseña.getPassword()).trim().isEmpty()){
            String usuario = txtUsuario.getText();
            String contraseña = String.valueOf(txtContraseña.getPassword());
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // ========== DISEÑO: Componentes del formulario ==========
    private javax.swing.JButton btnIngresar;          // Botón para ingresar al sistema
    private javax.swing.JLabel jLabel1;              // Título "INICIAR SESIÓN"
    private javax.swing.JLabel jLabel2;               // Etiqueta "USUARIO:"
    private javax.swing.JLabel jLabel3;               // Etiqueta "CONTRASEÑA:"
    private javax.swing.JLabel lblLogo;               // Label para mostrar el logo en esquina
    private javax.swing.JPanel panelFormulario;       // Panel blanco con el formulario
    private javax.swing.JPanel panelLateral;         // Panel lateral naranja con el logo
    private javax.swing.JPasswordField txtContraseña; // Campo de contraseña (JPasswordField para ocultar texto)
    private javax.swing.JTextField txtUsuario;        // Campo de texto para el usuario
    // End of variables declaration//GEN-END:variables
}
