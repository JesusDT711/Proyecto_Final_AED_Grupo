
package vista;

import controlador.cArreglo;
import controlador.cCola_LE;
import controlador.cLE_Comprobante;
import modelo.cBoleta;
import modelo.cComprobante;
import modelo.cFactura;

/**
 *
 * @author adria
 */
public class frmComprobanteAdd extends javax.swing.JFrame {
            
    private cComprobante comprobante;
    private cArreglo arre_Pro = frmGeneral.arregloProductos;
    private cCola_LE colaClientes = frmGeneral.leCola;
    private cLE_Comprobante listaComprobante = frmGeneral.leComprobante;
    
    
    public frmComprobanteAdd() {
        initComponents();
        this.comprobante= null;
        llenarComboClientes();
        llenarComboTrabajador();
        llenarComboProductos();
    }
    public frmComprobanteAdd(cComprobante compro){
        initComponents();
        this.comprobante = compro;
        llenarComboClientes();
        llenarComboTrabajador();
        llenarComboProductos();
        cargarDatos();
    }

    //LLENADO Y SELECCIONADO DE ITEMS DE LOS COMBOBOX
    private void llenarComboClientes(){
        colaClientes.llenarComboClientes(cbCliente);
    }
    
    private void llenarComboTrabajador(){
        
    }
    
    private void llenarComboProductos(){
        arre_Pro.llenarComboProductos(cbCliente);
    }
    
    private void seleccionaCliente(){
        if(comprobante != null){
            String cod_cli = comprobante.getCliente();
            for(int i=0; i<cbCliente.getItemCount(); i++){
                Object item = cbCliente.getItemAt(i);
                if(item.toString().startsWith(cod_cli)){
                    cbCliente.setSelectedIndex(i);
                }
            }
        }
    }
    
    private void seleccionaTrabajador(){
        
    }
    
    //CARGA DE DATSO EXTRAÍDOS DE LA TABLALE
    private void cargarDatos(){
        if(comprobante instanceof cBoleta){
            rbBoleta.setSelected(true);
        }
        if(comprobante instanceof cFactura){
            rbFactura.setSelected(true);
        }
        dcFechaEmisionCo.setDate(comprobante.getFecha());
        seleccionaCliente();
        //FALTA COMPLETAR PARA LLAMADO DEL VENDEDOR
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panCod = new javax.swing.JPanel();
        rbBoleta = new javax.swing.JRadioButton();
        rbFactura = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox<>();
        btnAddCo = new javax.swing.JButton();
        btnLimpiarCo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        dcFechaEmisionCo = new com.toedter.calendar.JDateChooser();
        panAddProduct = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFinaliza = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtCanp = new javax.swing.JTextField();
        cbNomP = new javax.swing.JComboBox<>();
        cbCliente = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panCod.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Comprobante"));

        buttonGroup1.add(rbBoleta);
        rbBoleta.setText("Boleta");

        buttonGroup1.add(rbFactura);
        rbFactura.setText("Factura");

        javax.swing.GroupLayout panCodLayout = new javax.swing.GroupLayout(panCod);
        panCod.setLayout(panCodLayout);
        panCodLayout.setHorizontalGroup(
            panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCodLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbFactura)
                .addGap(30, 30, 30))
        );
        panCodLayout.setVerticalGroup(
            panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCodLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBoleta)
                    .addComponent(rbFactura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("INGRESE FECHA DE COMPRA:");

        jLabel2.setText("ESCOJA UN VENDEDOR:");

        jLabel3.setText("ESCOJA UN CLIENTE:");

        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));

        btnAddCo.setText("Emitir");
        btnAddCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCoActionPerformed(evt);
            }
        });

        btnLimpiarCo.setText("Limpiar");
        btnLimpiarCo.setEnabled(false);
        btnLimpiarCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("EMISIÓN DE COMPROBANTE");

        panAddProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadido de Productos"));

        jLabel5.setText("NOMBRE DEL PRODUCTO");

        jLabel6.setText("CANTIDAD");

        btnFinaliza.setText("Finalizar");
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cbNomP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));

        javax.swing.GroupLayout panAddProductLayout = new javax.swing.GroupLayout(panAddProduct);
        panAddProduct.setLayout(panAddProductLayout);
        panAddProductLayout.setHorizontalGroup(
            panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAddProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinaliza)
                .addGap(14, 14, 14))
            .addGroup(panAddProductLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(51, 51, 51)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCanp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panAddProductLayout.setVerticalGroup(
            panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAddProductLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbNomP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCanp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinaliza)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(btnLimpiarCo)
                                .addGap(37, 37, 37)
                                .addComponent(btnAddCo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(panCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFechaEmisionCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(panAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addComponent(panCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(dcFechaEmisionCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarCo)
                    .addComponent(btnAddCo))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //FUNCIONALIDADES DE LOS BOTONES
    private void btnLimpiarCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCoActionPerformed
        buttonGroup1.clearSelection();
        dcFechaEmisionCo.setDate(null);
        cbCliente.setSelectedIndex(0);
        cbVendedor.setSelectedIndex(0);
        cbNomP.setSelectedIndex(0);
        txtCanp.setText("");
        
        btnLimpiarCo.setEnabled(false);
        btnAddCo.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        
    }//GEN-LAST:event_btnFinalizaActionPerformed

    private void btnAddCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCoActionPerformed
        
    }//GEN-LAST:event_btnAddCoActionPerformed

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
            java.util.logging.Logger.getLogger(frmComprobanteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmComprobanteAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmComprobanteAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnLimpiarCo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbNomP;
    private javax.swing.JComboBox<String> cbVendedor;
    private com.toedter.calendar.JDateChooser dcFechaEmisionCo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panAddProduct;
    private javax.swing.JPanel panCod;
    private javax.swing.JRadioButton rbBoleta;
    private javax.swing.JRadioButton rbFactura;
    private javax.swing.JTextField txtCanp;
    // End of variables declaration//GEN-END:variables
}
