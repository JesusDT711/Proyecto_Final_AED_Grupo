
package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.cUsuario;

/**
 *
 * @author adria
 */
public class frmLogin extends javax.swing.JFrame {

    cUsuario oUsuario = new cUsuario("admin","lavidaescorta123");
    public frmLogin() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(!txtUsuario.getText().trim().isEmpty() && !String.valueOf(psContraseña.getPassword()).trim().isEmpty()){
            String usuario = txtUsuario.getText();
            String contraseña= String.valueOf(psContraseña.getPassword());
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

    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
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

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/panel.png"))); // NOI18N
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-340, 0, 660, 680));

        txtUsuario.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su usuario");
        txtUsuario.setBorder(null);
        background.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 330, 20));

        btnIngresar.setBackground(new java.awt.Color(153, 153, 153));
        btnIngresar.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        background.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setText("INICIAR SESIÓN");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 400, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Usuario:");
        jLabel4.setToolTipText("Ingrese su usuario");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 100, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 160, 40));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 330, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 340, 30));

        psContraseña.setForeground(new java.awt.Color(204, 204, 204));
        psContraseña.setText("jPasswordField1");
        psContraseña.setBorder(null);
        background.add(psContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 330, 40));

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE));
	layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE));
    }
// </editor-fold>//GEN-END:initComponents


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
