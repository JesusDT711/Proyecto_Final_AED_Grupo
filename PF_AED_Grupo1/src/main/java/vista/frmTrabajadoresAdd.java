
package vista;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.cTrabajador;

/**
 *
 * @author adria
 */
public class frmTrabajadoresAdd extends javax.swing.JFrame {

    cTrabajador trabajador;    
    
    public frmTrabajadoresAdd() {
        initComponents();
        setLocationRelativeTo(null);
        this.trabajador=null;
    }
    
    public frmTrabajadoresAdd(cTrabajador tra){
        initComponents();
        setLocationRelativeTo(null);
        this.trabajador=tra;
        cargarDatos();
    }

    
    //CARGA DE DATOS EXTRAÍDOS DE LA TABLAP
    private void cargarDatos(){
        txtNombreT.setText(trabajador.getNombre());
        cbTipoT.setSelectedIndex(trabajador.getTipo());
        dcFechaIngresoT.setDate(trabajador.getFecha_ingreso());
        txtSueldoT.setText(String.valueOf(trabajador.getSueldo()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreT = new javax.swing.JTextField();
        cbTipoT = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAddT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiarT = new javax.swing.JButton();
        dcFechaIngresoT = new com.toedter.calendar.JDateChooser();
        txtSueldoT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("INGRESE NOMBRE DEL TRABAJADOR:");

        jLabel2.setText("SELECCIONE EL TIPO DE TRABAJADOR:");

        jLabel3.setText("INTRODUZCA FECHA DE INGRESO:");

        cbTipoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Administrador", "Cajero", "Reponedor" }));
        cbTipoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoTActionPerformed(evt);
            }
        });

        jLabel4.setText("SUELDO BASE:");

        btnAddT.setText("Añadir");
        btnAddT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setText("REGISTRO DE TRABAJADORES");

        btnLimpiarT.setText("Limpiar");
        btnLimpiarT.setEnabled(false);
        btnLimpiarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTActionPerformed(evt);
            }
        });

        txtSueldoT.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(txtNombreT))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnLimpiarT)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnAddT))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(txtSueldoT, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoT, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFechaIngresoT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dcFechaIngresoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSueldoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarT)
                    .addComponent(btnAddT))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //FUNCIONALIDADES DE LOS BOTONES
    private void btnAddTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTActionPerformed
        if(txtNombreT.getText().trim().isEmpty()
                || cbTipoT.getSelectedIndex()==-1
                || dcFechaIngresoT.getDate()==null
                || txtSueldoT.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }else{
            String nombre=txtNombreT.getText();
            int tipo=cbTipoT.getSelectedIndex();
            Date fecha=dcFechaIngresoT.getDate();
            double sueldo=Double.parseDouble(txtSueldoT.getText());
        
            if (trabajador != null) {
                trabajador.setNombre(nombre);
                trabajador.setTipo(tipo);
                trabajador.setFecha_ingreso(fecha);
                trabajador.setSueldo(sueldo);
                JOptionPane.showMessageDialog(this, "Trabajador actualizado correctamente.");
                this.dispose();
            }else{
                cTrabajador nuevoTrab=new cTrabajador(nombre, fecha, tipo);
                frmGeneral.oArregloTrab.agregar(nuevoTrab);
                JOptionPane.showMessageDialog(this, "Trabajador registrado correctamente.");
            }
            btnAddT.setEnabled(false);
            btnLimpiarT.setEnabled(true);
        }    
    }//GEN-LAST:event_btnAddTActionPerformed

    private void btnLimpiarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTActionPerformed
        txtNombreT.setText("");
        cbTipoT.setSelectedIndex(0);
        dcFechaIngresoT.setDate(null);
        txtSueldoT.setText("");
        
        btnAddT.setEnabled(true);
        btnLimpiarT.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarTActionPerformed

    private void cbTipoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoTActionPerformed
        int tipo=cbTipoT.getSelectedIndex();
        
        cTrabajador temp=new cTrabajador();
        temp.setTipo(tipo);
        double sueldo= temp.sueldoxTipo();
        txtSueldoT.setText(String.valueOf(sueldo));
    }//GEN-LAST:event_cbTipoTActionPerformed

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
            java.util.logging.Logger.getLogger(frmTrabajadoresAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrabajadoresAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrabajadoresAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddT;
    private javax.swing.JButton btnLimpiarT;
    private javax.swing.JComboBox<String> cbTipoT;
    private com.toedter.calendar.JDateChooser dcFechaIngresoT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNombreT;
    private javax.swing.JTextField txtSueldoT;
    // End of variables declaration//GEN-END:variables
}
