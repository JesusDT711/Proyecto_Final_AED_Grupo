
package vista;

import javax.swing.JOptionPane;
import controlador.cArreglo_Trabajador;
import modelo.cTrabajador;

/**
 *
 * @author adria
 */
public class frmTrabajadoresSee extends javax.swing.JFrame {

    private cArreglo_Trabajador arregloTrabajadores = frmGeneral.oArregloTrab;
    
    public frmTrabajadoresSee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConT = new javax.swing.JButton();
        btnLimpiaT = new javax.swing.JButton();
        txtCodT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaTrabajador = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConT.setText("Consultar");
        btnConT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConTActionPerformed(evt);
            }
        });

        btnLimpiaT.setText("Limpiar");
        btnLimpiaT.setEnabled(false);
        btnLimpiaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaTActionPerformed(evt);
            }
        });

        jLabel1.setText("INGRESE CÓDIGO DEL TRABAJADOR:");

        txtaTrabajador.setColumns(20);
        txtaTrabajador.setRows(5);
        jScrollPane1.setViewportView(txtaTrabajador);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("CONSULTA DE TRABAJADORES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnConT)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiaT)
                        .addGap(224, 224, 224))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConT))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiaT)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //FUNCIONALIDADES DE LOS BOTONES
    private void btnConTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConTActionPerformed
        if(txtCodT.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete el campo");
        }else{
            String codigo = txtCodT.getText();
            cTrabajador trabajador = arregloTrabajadores.buscar(codigo);
            if(trabajador==null){
                txtaTrabajador.setText("Cliente no Encontrado.");
            }else{
                txtaTrabajador.setText("Código: "+trabajador.getCodigo());
                txtaTrabajador.append("\nNombres: "+trabajador.getNombre());
                txtaTrabajador.append("\nFecha de ingreso: "+trabajador.fecha_ingresoCadena());
                txtaTrabajador.append("\nSueldo: "+trabajador.getSueldo());
                txtaTrabajador.append("\nCargo: "+trabajador.cargo());
                
                btnLimpiaT.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnConTActionPerformed

    private void btnLimpiaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaTActionPerformed
        txtCodT.setText("");
        txtaTrabajador.setText("");
        
        btnLimpiaT.setEnabled(false);
    }//GEN-LAST:event_btnLimpiaTActionPerformed

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
            java.util.logging.Logger.getLogger(frmTrabajadoresSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresSee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrabajadoresSee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConT;
    private javax.swing.JButton btnLimpiaT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodT;
    private javax.swing.JTextArea txtaTrabajador;
    // End of variables declaration//GEN-END:variables
}
