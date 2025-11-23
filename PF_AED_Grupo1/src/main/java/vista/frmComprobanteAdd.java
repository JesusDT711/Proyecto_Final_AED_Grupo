
package vista;

import controlador.cLE_Detalle;
import controlador.cNodo_LE_Detalle;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.cBoleta;
import modelo.cComprobante;
import modelo.cDetalle_Comprobante;
import modelo.cFactura;
import modelo.cProducto;
import modelo.cAccion;
import modelo.cCliente;

/**
 *
 * @author adria
 */
public class frmComprobanteAdd extends javax.swing.JFrame {
            
    private cComprobante comprobante; 
    private cBoleta boleta;
    private cFactura factura;
    
    public frmComprobanteAdd() {
        initComponents();
        setLocationRelativeTo(null);
        this.comprobante=null;
        llenarComboClientes();
        llenarComboTrabajador();
        llenarComboProductos();
    }
    public frmComprobanteAdd(cComprobante compro){
        initComponents();
        setLocationRelativeTo(null);
        this.comprobante = compro;
        llenarComboClientes();
        llenarComboTrabajador();
        llenarComboProductos();
        cargarDatos();
    }

    //LLENADO Y SELECCIONADO DE ITEMS DE LOS COMBOBOX
    private void llenarComboClientes(){
        if(frmGeneral.oLECliente != null){
            frmGeneral.oLECliente.llenarComboClientes(cbCliente);
        }
        seleccionaCliente(comprobante);
    }
    
    private void llenarComboTrabajador(){
        if(frmGeneral.oArregloTrab != null){
            frmGeneral.oArregloTrab.llenarComboTrabajadores(cbVendedor);
        }
        seleccionaTrabajador(comprobante);
    }
    
    private void llenarComboProductos(){
        if(frmGeneral.oArregloProd != null){
            frmGeneral.oArregloProd.llenarComboProductos(cbNomP);
        }
    }
    
    private void seleccionaCliente(cComprobante comprobante){
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
    
    private void seleccionaTrabajador(cComprobante comprobante){
        if(comprobante != null){
            String cod_trab = comprobante.getVendedor();
            for(int i=0; i<cbVendedor.getItemCount(); i++){
                Object item = cbVendedor.getItemAt(i);
                if(item.toString().startsWith(cod_trab)){
                    cbVendedor.setSelectedIndex(i);
                }
            }
        }
    }
    
    //CARGA DE DATOS EXTRAÍDOS DE LA TABLACOM
    private void cargarDatos(){
        if(comprobante instanceof cBoleta){
            rbBoleta.setSelected(true);
        }
        if(comprobante instanceof cFactura){
            rbFactura.setSelected(true);
        }
        dcFechaEmisionCo.setDate(comprobante.getFecha());            
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
        rbFactura = new javax.swing.JRadioButton();
        rbBoleta = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox<>();
        btnEmitirCom = new javax.swing.JButton();
        btnLimpiarCo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        dcFechaEmisionCo = new com.toedter.calendar.JDateChooser();
        panAddProduct = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFinaliza = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtCantidadP = new javax.swing.JTextField();
        cbNomP = new javax.swing.JComboBox<>();
        btnIniciar = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panCod.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Comprobante"));

        buttonGroup1.add(rbFactura);
        rbFactura.setText("Factura");

        buttonGroup1.add(rbBoleta);
        rbBoleta.setText("Boleta");

        javax.swing.GroupLayout panCodLayout = new javax.swing.GroupLayout(panCod);
        panCod.setLayout(panCodLayout);
        panCodLayout.setHorizontalGroup(
            panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCodLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(rbBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFactura)
                .addGap(30, 30, 30))
        );
        panCodLayout.setVerticalGroup(
            panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCodLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panCodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFactura)
                    .addComponent(rbBoleta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("INGRESE FECHA DE COMPRA:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("ESCOJA UN VENDEDOR:");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("ESCOJA UN CLIENTE:");

        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));

        btnEmitirCom.setText("Emitir");
        btnEmitirCom.setEnabled(false);
        btnEmitirCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirComActionPerformed(evt);
            }
        });

        btnLimpiarCo.setText("Limpiar");
        btnLimpiarCo.setEnabled(false);
        btnLimpiarCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 45)); // NOI18N
        jLabel4.setText("EMISIÓN DE COMPROBANTE");

        panAddProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadido de Productos"));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("NOMBRE DEL PRODUCTO");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("CANTIDAD");

        btnFinaliza.setText("Finalizar");
        btnFinaliza.setEnabled(false);
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCantidadP.setEnabled(false);

        cbNomP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));
        cbNomP.setEnabled(false);

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAddProductLayout = new javax.swing.GroupLayout(panAddProduct);
        panAddProduct.setLayout(panAddProductLayout);
        panAddProductLayout.setHorizontalGroup(
            panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAddProductLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(panAddProductLayout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addGap(28, 28, 28)))
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panAddProductLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbNomP, javax.swing.GroupLayout.Alignment.LEADING, 0, 185, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panAddProductLayout.createSequentialGroup()
                                .addComponent(txtCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panAddProductLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnAgregar)
                        .addGap(31, 31, 31)
                        .addComponent(btnFinaliza)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
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
                    .addComponent(txtCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnIniciar)
                    .addComponent(btnFinaliza))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/logo1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(btnLimpiarCo)
                                .addGap(100, 100, 100)
                                .addComponent(btnEmitirCom))
                            .addComponent(panAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFechaEmisionCo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(panCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(dcFechaEmisionCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmitirCom)
                    .addComponent(btnLimpiarCo))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //FUNCIONALIDADES DE LOS BOTONES
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(!rbBoleta.isSelected() && !rbFactura.isSelected()
                || dcFechaEmisionCo.getDate()==null
                || cbCliente.getSelectedIndex()==0
                || cbVendedor.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Primero complete los campos previos");
        }else{
            Date fecha = dcFechaEmisionCo.getDate();
            String cod_Cli = cbCliente.getSelectedItem().toString();
            String cod_Ven = cbVendedor.getSelectedItem().toString();
            if(comprobante==null){
                if(rbBoleta.isSelected()){
                    boleta = new cBoleta(fecha, cod_Cli, cod_Ven);
                }else if(rbFactura.isSelected()){
                    factura = new cFactura(fecha, cod_Cli, cod_Ven);
                }
            }
            cbNomP.setEnabled(true);
            txtCantidadP.setEnabled(true);
            cbNomP.setSelectedIndex(0);
            txtCantidadP.setText("");
            btnAgregar.setEnabled(true);
            btnFinaliza.setEnabled(true);
            btnLimpiarCo.setEnabled(true);
            btnIniciar.setEnabled(false);
            rbBoleta.setEnabled(false);
            rbFactura.setEnabled(false);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed
    

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(boleta==null && factura==null && comprobante==null){
            JOptionPane.showMessageDialog(this,"Primero inicie un comprobante");
        }else{
            if(cbNomP.getSelectedIndex()==0 || txtCantidadP.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Escoja el producto o ingrese la cantidad primero");
            }else{
                if(rbBoleta.isSelected()){
                    String cod_Com = (boleta!=null) ? boleta.getCodigo() : comprobante.getCodigo();
                    int indProd = cbNomP.getSelectedIndex()-1;
                    if(indProd>=0){
                        cProducto producto = frmGeneral.oArregloProd.obtener(indProd);
                        String cod_Pro = producto.getCodigo();
                        double cod_Precio = producto.getPrecio();
                        int cantidad = Integer.parseInt(txtCantidadP.getText());
                        cDetalle_Comprobante detalle = new cDetalle_Comprobante(cod_Com, cod_Pro, cantidad, cod_Precio);
                        if(boleta!=null){
                            boleta.setDetalle(detalle);
                        }else{
                            comprobante.setDetalle(detalle);
                        }
                        cbNomP.setSelectedIndex(0);
                        txtCantidadP.setText("");
                    }
                }else if(rbFactura.isSelected()){
                    String cod_Com = (factura!=null) ? factura.getCodigo() : comprobante.getCodigo();
                    int indProd = cbNomP.getSelectedIndex()-1;
                    if(indProd>=0){
                        cProducto producto = frmGeneral.oArregloProd.obtener(indProd);
                        String cod_Pro = producto.getCodigo();
                        double cod_Precio = producto.getPrecio();
                        int cantidad = Integer.parseInt(txtCantidadP.getText());
                        cDetalle_Comprobante detalle = new cDetalle_Comprobante(cod_Com, cod_Pro, cantidad, cod_Precio);
                        if(factura!=null){
                            factura.setDetalle(detalle);
                        }else{
                            comprobante.setDetalle(detalle);
                        }
                        cbNomP.setSelectedIndex(0);
                        txtCantidadP.setText("");
                    } 
                }
            }   
        }  
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        if(boleta==null && factura==null && comprobante==null){
            JOptionPane.showMessageDialog(this,"Primero inicie un comprobante");
        }else{
            if(rbBoleta.isSelected()){
            cLE_Detalle det = (boleta!=null) ? boleta.getDetalle() : comprobante.getDetalle();
                if(det==null || det.getInicio()==null){
                JOptionPane.showMessageDialog(this, "Primero debe ingresar un producto");
                }else{
                    btnEmitirCom.setEnabled(true);
                    cbNomP.setEnabled(false);
                    txtCantidadP.setEnabled(false);
                    btnAgregar.setEnabled(false);
                    btnFinaliza.setEnabled(false);
                }
            }else if(rbFactura.isSelected()){
                cLE_Detalle det = (factura!=null) ? factura.getDetalle() : comprobante.getDetalle();
                if(det==null || det.getInicio()==null){
                    JOptionPane.showMessageDialog(this, "Primero debe ingresar un producto");
                }else{
                    btnEmitirCom.setEnabled(true);
                    cbNomP.setEnabled(false);
                    txtCantidadP.setEnabled(false);
                    btnAgregar.setEnabled(false);
                    btnFinaliza.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnFinalizaActionPerformed

    
    private void btnEmitirComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirComActionPerformed
        if (boleta != null || factura != null || comprobante != null) {
            cLE_Detalle detB = (boleta != null) ? boleta.getDetalle() : null;
            cLE_Detalle detF = (factura != null) ? factura.getDetalle() : null;
            cLE_Detalle detC = (comprobante != null) ? comprobante.getDetalle() : null;

            if ((!rbBoleta.isSelected() && !rbFactura.isSelected())
                    || dcFechaEmisionCo.getDate() == null
                    || cbCliente.getSelectedIndex() == 0
                    || cbVendedor.getSelectedIndex() == 0
                    || (detB == null && detF == null && detC == null)) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
            } else {
                
                cComprobante documentoFinal = null;
                if(comprobante != null) documentoFinal = comprobante; 
                else if(rbBoleta.isSelected()) documentoFinal = boleta; 
                else if(rbFactura.isSelected()) documentoFinal = factura; 

                documentoFinal.setFecha(dcFechaEmisionCo.getDate());
                documentoFinal.setCliente(cbCliente.getSelectedItem().toString());
                documentoFinal.setVendedor(cbVendedor.getSelectedItem().toString());

                String codCliente = cbCliente.getSelectedItem().toString();
                cCliente objCliente = frmGeneral.oLECliente.busqueda(codCliente); 
                int tipoCliente = (objCliente != null) ? objCliente.getTipo() : 1; 

                if (comprobante != null) {
                     frmGeneral.oPilaAcciones.apilar(new cAccion("Actualizó un comprobante", comprobante));
                } else {
                    if(tipoCliente == 2) {
                        frmGeneral.oColaDespachoAlta.encolar(documentoFinal);
                        JOptionPane.showMessageDialog(this, "Comprobante emitido para Empresa.");
                    } else {
                        frmGeneral.oColaDespachoBaja.encolar(documentoFinal);
                        JOptionPane.showMessageDialog(this, "Comprobante emitido para Cliente");
                    }
                    String tipoComp = rbBoleta.isSelected() ? "Boleta" : "Factura";
                    frmGeneral.oPilaAcciones.apilar(new cAccion("Encoló una " + tipoComp, documentoFinal));
                }

                btnIniciar.setEnabled(true);
                rbBoleta.setEnabled(true);
                rbFactura.setEnabled(true);
                boleta = null;
                factura = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero inicie o cargue un comprobante");
        }
    }//GEN-LAST:event_btnEmitirComActionPerformed

    
    private void btnLimpiarCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCoActionPerformed
        buttonGroup1.clearSelection();
        rbBoleta.setEnabled(true);
        rbFactura.setEnabled(true);
        dcFechaEmisionCo.setDate(null);
        cbCliente.setSelectedIndex(0);
        cbVendedor.setSelectedIndex(0);
        cbNomP.setSelectedIndex(0);
        txtCantidadP.setText("");
        
        btnLimpiarCo.setEnabled(false);
        btnEmitirCom.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnFinaliza.setEnabled(false);
        btnIniciar.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarCoActionPerformed


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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEmitirCom;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnIniciar;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panAddProduct;
    private javax.swing.JPanel panCod;
    private javax.swing.JRadioButton rbBoleta;
    private javax.swing.JRadioButton rbFactura;
    private javax.swing.JTextField txtCantidadP;
    // End of variables declaration//GEN-END:variables
}
