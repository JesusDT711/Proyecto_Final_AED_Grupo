
package vista;

import javax.swing.JOptionPane;
import modelo.cCliente;
import modelo.cAccion;
import java.util.Date;

/**
 *
 * @author adria
 */
public class frmClienteAdd extends javax.swing.JFrame {

    private cCliente cliente;
    private int tipo;
    
    public frmClienteAdd() {
        initComponents();
        setLocationRelativeTo(null);
        this.cliente=null;
    }
    
    public frmClienteAdd(cCliente c){
        initComponents();
        setLocationRelativeTo(null);
        this.cliente = c;
        cargarDatos();
    }

    
    //CARGA DE DATOS EXTRAÍDOS DE LA TABLAC
    private void cargarDatos() {
        int tipo = cliente.getTipo();
        if(tipo==1){
            rbDni.setSelected(true);
        }else if(tipo==2){
            rbRuc.setSelected(true);
        }
        txtDocIndentifica.setText(String.valueOf(cliente.getDocIdentifica()));
        txtRazon.setText(cliente.getRsocial());
        txtTelf.setText(String.valueOf(cliente.getTelefono()));
        dcFechaCompraCli.setDate(cliente.getFecha_compra());
        txtTipoCliente.setText(cliente.tipoCadena());
        txtContacto.setText(cliente.getContacto());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbDni = new javax.swing.JRadioButton();
        rbRuc = new javax.swing.JRadioButton();
        txtDocIndentifica = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRazon = new javax.swing.JTextField();
        txtTelf = new javax.swing.JTextField();
        txtTipoCliente = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnRegistarC = new javax.swing.JButton();
        btnLimpiarC = new javax.swing.JButton();
        dcFechaCompraCli = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("RAZÓN SOCIAL:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("TELÉFONO:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("FECHA DE COMPRA:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("TIPO DE CLIENTE:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("CONTACTO:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento de Indentificación"));
        jPanel1.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N

        buttonGroup1.add(rbDni);
        rbDni.setText("DNI");
        rbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDniActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRuc);
        rbRuc.setText("RUC");
        rbRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRucActionPerformed(evt);
            }
        });

        jLabel3.setText("INGRESAR N° DOCUMENTO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(rbDni)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbRuc)
                    .addComponent(txtDocIndentifica, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDni)
                    .addComponent(rbRuc))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocIndentifica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTipoCliente.setEditable(false);

        txtContacto.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        jLabel7.setText("REGISTRO DE CLIENTES");

        btnRegistarC.setFont(new java.awt.Font("Roboto SemiCondensed", 0, 12)); // NOI18N
        btnRegistarC.setText("Registrar");
        btnRegistarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarCActionPerformed(evt);
            }
        });

        btnLimpiarC.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        btnLimpiarC.setText("Limpiar");
        btnLimpiarC.setEnabled(false);
        btnLimpiarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/logo1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimpiarC)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRazon)
                                    .addComponent(txtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoCliente)
                                    .addComponent(txtContacto)
                                    .addComponent(btnRegistarC)
                                    .addComponent(dcFechaCompraCli, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)))
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dcFechaCompraCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarC)
                    .addComponent(btnRegistarC))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //RADIO BUTTONS
    private void rbRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRucActionPerformed
        tipo=2;
        txtTipoCliente.setText("Empresa");
        txtContacto.setText("");
        txtContacto.setEditable(true);
    }//GEN-LAST:event_rbRucActionPerformed

    private void rbDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDniActionPerformed
        tipo=1;
        txtTipoCliente.setText("Persona Natural");
        txtContacto.setText("DNI");
        txtContacto.setEditable(false);
    }//GEN-LAST:event_rbDniActionPerformed

    
    //FUNCIONALIDADES DE LOS BOTONES
    private void btnRegistarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarCActionPerformed
        if(!rbDni.isSelected() && !rbRuc.isSelected()
                || txtDocIndentifica.getText().trim().isEmpty() 
                || txtRazon.getText().trim().isEmpty()
                || txtTelf.getText().trim().isEmpty()
                || dcFechaCompraCli.getDate() == null
                || txtContacto.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }else{
            long docIdentifi = Long.parseLong(txtDocIndentifica.getText());
            String rSocial = txtRazon.getText();
            long telf = Long.parseLong(txtTelf.getText());
            Date fecha_compra = dcFechaCompraCli.getDate();
            String contacto = "";
            if(txtContacto.getText().equals("DNI")){
                contacto = rSocial;
            }else{
                contacto = txtContacto.getText();
            }
            if (cliente != null) {
                // Actualizar cliente existente
                frmGeneral.oPilaAcciones.apilar(new cAccion("Actualizó un cliente",cliente));
                cliente.setRsocial(rSocial);
                cliente.setTelefono(telf);
                cliente.setDocIdentifica(docIdentifi);
                cliente.setFecha_compra(fecha_compra);
                cliente.setTipo(tipo);
                cliente.setContacto(contacto);
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
                frmGeneral.mostrarHistorial();
                this.dispose();
            }else {  
                cCliente nuevoCli = new cCliente(rSocial,telf,docIdentifi,fecha_compra,tipo,contacto);
                frmGeneral.oLECliente.insertarxFinal(nuevoCli);
                JOptionPane.showMessageDialog(this, "Cliente añadido correctamente");
                frmGeneral.oPilaAcciones.apilar(new cAccion("Registró un cliente",nuevoCli));
                frmGeneral.mostrarHistorial();
            
                btnLimpiarC.setEnabled(true);
                btnRegistarC.setEnabled(false);
            }
        } 
    }//GEN-LAST:event_btnRegistarCActionPerformed

    private void btnLimpiarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCActionPerformed
        buttonGroup1.clearSelection();
        txtDocIndentifica.setText("");
        txtRazon.setText("");
        txtTelf.setText("");
        dcFechaCompraCli.setDate(null);
        txtTipoCliente.setText("");
        txtContacto.setText("");
        
        btnLimpiarC.setEnabled(false);
        btnRegistarC.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCActionPerformed

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
            java.util.logging.Logger.getLogger(frmClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClienteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClienteAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiarC;
    private javax.swing.JButton btnRegistarC;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dcFechaCompraCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbDni;
    private javax.swing.JRadioButton rbRuc;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDocIndentifica;
    private javax.swing.JTextField txtRazon;
    private javax.swing.JTextField txtTelf;
    private javax.swing.JTextField txtTipoCliente;
    // End of variables declaration//GEN-END:variables
}
