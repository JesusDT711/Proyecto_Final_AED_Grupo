
package vista;

import controlador.cLE_Detalle;
import controlador.cNodo_LE_Detalle;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import modelo.cComprobante;
import modelo.cDetalle_Comprobante;
/**
 *
 * @author adria
 */
public class frmComprobanteSee extends javax.swing.JFrame {

    public frmComprobanteSee() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodCo = new javax.swing.JTextField();
        btnConsultaCo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaComprobante = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiarCo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("INGRESE CÓDIGO DEL COMPROBANTE:");

        btnConsultaCo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnConsultaCo.setText("Consultar");
        btnConsultaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCoActionPerformed(evt);
            }
        });

        txtaComprobante.setColumns(20);
        txtaComprobante.setRows(5);
        jScrollPane1.setViewportView(txtaComprobante);

        jLabel2.setFont(new java.awt.Font("Roboto Condensed Black", 0, 36)); // NOI18N
        jLabel2.setText("CONSULTA DE COMPROBANTE");

        btnLimpiarCo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnLimpiarCo.setText("Limpiar");
        btnLimpiarCo.setEnabled(false);
        btnLimpiarCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/logo1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodCo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnConsultaCo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiarCo)
                        .addGap(225, 225, 225))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCo))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarCo)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //FUNCIONALIDADES DE LOS BOTONES
    private void btnConsultaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCoActionPerformed
        if(txtCodCo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Complete el campo");
        }else{
            String codigo = txtCodCo.getText();
            cComprobante compro = frmGeneral.oLEComprobante.busqueda(codigo);
            if(compro==null){
                txtaComprobante.setText("Comprobante no Encontrado.");
            }else{
                DecimalFormat df = new DecimalFormat("#.00");
                txtaComprobante.setText("Código del Comprobante: "+compro.getCodigo());
                txtaComprobante.append("\nFecha de Emisión: "+compro.fechaCadena());
                txtaComprobante.append("\nCódigo de Cliente: "+compro.getCliente());
                txtaComprobante.append("\nCódigo de Vendedor: "+compro.getVendedor());
                txtaComprobante.append("\n\nProductos Comprados:");
                cLE_Detalle listaDetalle = compro.getDetalle();
                cNodo_LE_Detalle p = listaDetalle.getInicio();
                while(p!=null){
                    cDetalle_Comprobante detalle = p.getValor();
                    if(detalle.getCodigo().equals(codigo)){
                        txtaComprobante.append("\nCódigo de Producto: "+detalle.getCodPro());
                        txtaComprobante.append("\nCantidad Comprada: "+detalle.getCantidad());
                        txtaComprobante.append("\nSub Total: "+df.format(detalle.subTotal()));
                        txtaComprobante.append("\nIGV: "+df.format(detalle.igv()));
                        txtaComprobante.append("\nTotal: "+df.format(detalle.total()));
                        txtaComprobante.append("\n===================================");
                    }
                    p = p.getSgte();
                }
                txtaComprobante.append("\n\nSub Total General: "+df.format(compro.getSubTotal()));
                txtaComprobante.append("\nIGV General: "+df.format(compro.getIGV()));
                txtaComprobante.append("\nTotal General: "+df.format(compro.getTotal()));
                
                btnLimpiarCo.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnConsultaCoActionPerformed

    private void btnLimpiarCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCoActionPerformed
        txtCodCo.setText("");
        txtaComprobante.setText("");
        btnLimpiarCo.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarCoActionPerformed

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
            java.util.logging.Logger.getLogger(frmComprobanteSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmComprobanteSee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaCo;
    private javax.swing.JButton btnLimpiarCo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodCo;
    private javax.swing.JTextArea txtaComprobante;
    // End of variables declaration//GEN-END:variables
}
