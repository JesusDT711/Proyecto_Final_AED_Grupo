package vista;

import controlador.cArreglo_Producto;
import controlador.cArreglo_Trabajador;
import controlador.cLE_Comprobante;
import controlador.cLE_Cliente;
import controlador.cCola;
import controlador.cPila;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.cProducto;
import modelo.cBoleta;
import modelo.cFactura;
import modelo.cComprobante;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import modelo.cDetalle_Comprobante;
import modelo.cCliente;
import modelo.cTrabajador;

/**
 *
 * @author Giuss
 */
public class frmGeneral extends javax.swing.JFrame {

    public static cArreglo_Producto oArregloProd = new cArreglo_Producto(1000);
    public static cLE_Comprobante oLEComprobante = new cLE_Comprobante();
    public static cLE_Cliente oLECliente = new cLE_Cliente();
    public static cArreglo_Trabajador oArregloTrab = new cArreglo_Trabajador(100);

    public frmGeneral() {
        initComponents();
        setLocationRelativeTo(null);
        cargarProductosBase();
        cargarComprobantesBase();
        cargarClientesBase();
        cargarTrabajadoresBase();

        habilitarBotonesProductos();
        habilitarBotonesComprobantes();
        habilitarBotonesClientes();
        habilitarBotonesTrabajadores();
    }

    //METODO PARA CARGAR LOS OBJETOS BASE
    private void mostrarProductos(JTable tablaProd) {
        oArregloProd.recorreLE(tablaProd);
    }

    private void mostrarComprobantes(JTable tablaCompro) {
        oLEComprobante.recorreLE(tablaCompro);
    }

    private void mostrarClientes(JTable tablaCli) {
        oLECliente.recorrerLE(tablaCli);
    }

    private void mostrarTrabajadores(JTable tablaTrab) {
        oArregloTrab.recorrerArreglo(tablaTrab);
    }

    private void cargarProductosBase() {
        oArregloProd.agregar(new cProducto("LAPTOP - I7 13400k", 2999.99, 100));
        oArregloProd.agregar(new cProducto("MOUSE - LOGITECH G645", 119.99, 100));
        oArregloProd.agregar(new cProducto("TECLADO RGB - DRAGON", 249.99, 100));

        mostrarProductos(tablaProd);
    }

    private void cargarComprobantesBase() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "02/04/2005";
        String fecha2str = "04/09/2010";
        String fecha3str = "07/10/2006";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;

        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
        } catch (ParseException e) {
            System.out.println("Error al convertir una de las fechas:" + e.getMessage());
        }

        cFactura f1 = new cFactura(fecha1, "C008", "V002");
        cBoleta b1 = new cBoleta(fecha2, "C004", "V003");
        cFactura f2 = new cFactura(fecha3, "C002", "V001");

        f1.setDetalle(new cDetalle_Comprobante(f1.getCodigo(),
                oArregloProd.obtener(0).getCodigo(),
                2,
                oArregloProd.obtener(0).getPrecio()));
        f1.setDetalle(new cDetalle_Comprobante(f1.getCodigo(),
                oArregloProd.obtener(1).getCodigo(),
                3,
                oArregloProd.obtener(1).getPrecio()));

        b1.setDetalle(new cDetalle_Comprobante(b1.getCodigo(),
                oArregloProd.obtener(0).getCodigo(),
                3,
                oArregloProd.obtener(0).getPrecio()));
        b1.setDetalle(new cDetalle_Comprobante(b1.getCodigo(),
                oArregloProd.obtener(2).getCodigo(),
                1,
                oArregloProd.obtener(2).getPrecio()));

        f2.setDetalle(new cDetalle_Comprobante(f2.getCodigo(),
                oArregloProd.obtener(0).getCodigo(),
                1,
                oArregloProd.obtener(0).getPrecio()));

        oLEComprobante.insertarxFinal(f1);
        oLEComprobante.insertarxFinal(b1);
        oLEComprobante.insertarxFinal(f2);

        mostrarComprobantes(tablaCompro);
    }

    private void cargarClientesBase() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "02/04/2005";
        String fecha2str = "04/09/2010";
        String fecha3str = "07/10/2006";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;

        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
        } catch (ParseException e) {
            System.out.println("Error al convertir una de las fechas:" + e.getMessage());
        }

        long tel1 = 991992990;
        long tel2 = 959192231;
        long tel3 = 910233677;

        long doc1 = 1078181921;
        long doc2 = 76192192;
        long doc3 = 1071623251;

        oLECliente.insertarxFinal(new cCliente("Tenda", tel1, doc1, fecha1, 2, "Lizardo Silva"));
        oLECliente.insertarxFinal(new cCliente("Juan Quillo", tel2, doc2, fecha2, 1, "Juan Quillo"));
        oLECliente.insertarxFinal(new cCliente("Gatitas.com", tel3, doc3, fecha3, 2, "Jesús Giussepe"));

        mostrarClientes(tablaCli);
    }

    private void cargarTrabajadoresBase() {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "05/11/2024";
        String fecha2str = "15/03/2024";
        String fecha3str = "20/01/2023";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        
        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar trabajadores base: " + e.getMessage());
        }

        cTrabajador t1 = new cTrabajador("Cristiano Ronaldo", fecha1, 1); // tipo administrador
        cTrabajador t2 = new cTrabajador("Lionel Messi", fecha2, 2); // tipo cajero
        cTrabajador t3 = new cTrabajador("Zinedine Zidane", fecha3, 3);  // tipo reponedor

        oArregloTrab.agregar(t1);
        oArregloTrab.agregar(t2);
        oArregloTrab.agregar(t3);

        mostrarTrabajadores(tablaTrab);

    }

    //MÉTODOS PARA HABILITAR LOS BOTONES ACTUALIZAR & ELIMINAR
    private void habilitarBotonesProductos() {
        tablaProd.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean filaSeleccionada = tablaProd.getSelectedRow() != -1;
                btnActualizaPro.setEnabled(filaSeleccionada);
                btnBorraPro.setEnabled(filaSeleccionada);
            }
        });
    }

    private void habilitarBotonesComprobantes() {
        tablaCompro.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean filaSeleccionada = tablaCompro.getSelectedRow() != -1;
                btnActualizaCom.setEnabled(filaSeleccionada);
                btnBorraCom.setEnabled(filaSeleccionada);
            }
        });
    }
    
    private void habilitarBotonesClientes(){
        tablaCli.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean filaSeleccionada = tablaCli.getSelectedRow() != -1;
                btnActualizaCli.setEnabled(filaSeleccionada);
                btnBorraCli.setEnabled(filaSeleccionada);
            }
        });
    }
    
    private void habilitarBotonesTrabajadores(){
        tablaTrab.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean filaSeleccionada = tablaTrab.getSelectedRow() != -1;
                btnActualizaTrab.setEnabled(filaSeleccionada);
                btnBorraTrab.setEnabled(filaSeleccionada);
            }
        });
    }

    //MÉTODOS PARA REFRESCAR LAS TABLAS (uso la logica de cuando se cierre un form externo se refresque por sí solo)
    private void refrescarTablaProd(javax.swing.JFrame ventana) {
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                //aca uso el metodo para mostrar los productos en la tabla
                mostrarProductos(tablaProd);
            }
        });
    }

    private void refrescarTablaCompro(javax.swing.JFrame ventana) {
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                //aca uso el metodo para mostrar los productos en la tabla
                mostrarComprobantes(tablaCompro);
            }
        });
    }

    private void refrescarTablaCli(javax.swing.JFrame ventana) {
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                //aca uso el metodo para mostrar los productos en la tabla
                mostrarClientes(tablaCli);
            }
        });
    }

    private void refrescarTablaTrab(javax.swing.JFrame ventana) {
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                //aca uso el metodo para mostrar los TRABAJADORES en la tabla
                mostrarTrabajadores(tablaTrab);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProd = new javax.swing.JTable();
        btnIngresaPro = new javax.swing.JButton();
        btnActualizaPro = new javax.swing.JButton();
        btnBorraPro = new javax.swing.JButton();
        btnConsultaPro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCompro = new javax.swing.JTable();
        btnIngresaCom = new javax.swing.JButton();
        btnActualizaCom = new javax.swing.JButton();
        btnBorraCom = new javax.swing.JButton();
        btnConsultaCom = new javax.swing.JButton();
        panCompro = new javax.swing.JPanel();
        rbBol = new javax.swing.JRadioButton();
        rbFac = new javax.swing.JRadioButton();
        rbTodo = new javax.swing.JRadioButton();
        btnRecuperaCom = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCli = new javax.swing.JTable();
        btnIngresaCli = new javax.swing.JButton();
        btnActualizaCli = new javax.swing.JButton();
        btnBorraCli = new javax.swing.JButton();
        panCliente = new javax.swing.JPanel();
        rbPersona = new javax.swing.JRadioButton();
        rbEmpresa = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btnConsultaCli = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaTrab = new javax.swing.JTable();
        btnIngresaTrab = new javax.swing.JButton();
        btnActualizaTrab = new javax.swing.JButton();
        btnBorraTrab = new javax.swing.JButton();
        btnConsultaTrab = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIntegrantes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablaProd);

        btnIngresaPro.setText("Añadir");
        btnIngresaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaProActionPerformed(evt);
            }
        });

        btnActualizaPro.setText("Actualizar");
        btnActualizaPro.setEnabled(false);
        btnActualizaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaProActionPerformed(evt);
            }
        });

        btnBorraPro.setText("Eliminar");
        btnBorraPro.setEnabled(false);
        btnBorraPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraProActionPerformed(evt);
            }
        });

        btnConsultaPro.setText("Consultar");
        btnConsultaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIngresaPro)
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizaPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(btnBorraPro)
                        .addGap(54, 54, 54)
                        .addComponent(btnConsultaPro)))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaPro)
                    .addComponent(btnActualizaPro)
                    .addComponent(btnBorraPro)
                    .addComponent(btnConsultaPro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Productos", jPanel1);

        tablaCompro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Fecha", "Código_Cliente", "Código_Vendedor", "Subotal", "Total"
            }
        ));
        jScrollPane2.setViewportView(tablaCompro);

        btnIngresaCom.setText("Añadir");
        btnIngresaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaComActionPerformed(evt);
            }
        });

        btnActualizaCom.setText("Actualizar");
        btnActualizaCom.setEnabled(false);
        btnActualizaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaComActionPerformed(evt);
            }
        });

        btnBorraCom.setText("Eliminar");
        btnBorraCom.setEnabled(false);
        btnBorraCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraComActionPerformed(evt);
            }
        });

        btnConsultaCom.setText("Consultar");
        btnConsultaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaComActionPerformed(evt);
            }
        });

        panCompro.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar"));

        buttonGroup2.add(rbBol);
        rbBol.setText("Boleta");
        rbBol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBolActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbFac);
        rbFac.setText("Factura");
        rbFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFacActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbTodo);
        rbTodo.setText("Todos");
        rbTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panComproLayout = new javax.swing.GroupLayout(panCompro);
        panCompro.setLayout(panComproLayout);
        panComproLayout.setHorizontalGroup(
            panComproLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panComproLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbBol)
                .addGap(18, 18, 18)
                .addComponent(rbFac)
                .addGap(18, 18, 18)
                .addComponent(rbTodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panComproLayout.setVerticalGroup(
            panComproLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panComproLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panComproLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBol)
                    .addComponent(rbFac)
                    .addComponent(rbTodo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRecuperaCom.setText("Recuperar Eliminado");
        btnRecuperaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperaComActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnIngresaCom)
                .addGap(41, 41, 41)
                .addComponent(btnActualizaCom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorraCom)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaCom)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(panCompro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRecuperaCom)
                        .addGap(270, 270, 270))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaCom)
                    .addComponent(btnActualizaCom)
                    .addComponent(btnBorraCom)
                    .addComponent(btnConsultaCom))
                .addGap(18, 18, 18)
                .addComponent(panCompro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRecuperaCom)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Comprobantes", jPanel2);

        tablaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Razón Social", "Teléfono", "DNI/RUC", "Fecha_Compra", "Tipo", "Contacto"
            }
        ));
        jScrollPane3.setViewportView(tablaCli);

        btnIngresaCli.setText("Añadir");
        btnIngresaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaCliActionPerformed(evt);
            }
        });

        btnActualizaCli.setText("Actualizar");
        btnActualizaCli.setEnabled(false);
        btnActualizaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaCliActionPerformed(evt);
            }
        });

        btnBorraCli.setText("Eliminar");
        btnBorraCli.setEnabled(false);
        btnBorraCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraCliActionPerformed(evt);
            }
        });

        panCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar"));

        buttonGroup1.add(rbPersona);
        rbPersona.setText("Persona Natural");
        rbPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPersonaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEmpresa);
        rbEmpresa.setText("Empresa");
        rbEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEmpresaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panClienteLayout = new javax.swing.GroupLayout(panCliente);
        panCliente.setLayout(panClienteLayout);
        panClienteLayout.setHorizontalGroup(
            panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbPersona)
                .addGap(18, 18, 18)
                .addComponent(rbEmpresa)
                .addGap(18, 18, 18)
                .addComponent(rbTodos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panClienteLayout.setVerticalGroup(
            panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPersona)
                    .addComponent(rbEmpresa)
                    .addComponent(rbTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnConsultaCli.setText("Consultar");
        btnConsultaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnIngresaCli)
                        .addGap(51, 51, 51)
                        .addComponent(btnActualizaCli)
                        .addGap(60, 60, 60)
                        .addComponent(btnBorraCli)
                        .addGap(62, 62, 62)
                        .addComponent(btnConsultaCli)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(panCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizaCli)
                    .addComponent(btnBorraCli)
                    .addComponent(btnIngresaCli)
                    .addComponent(btnConsultaCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        tablaTrab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Fecha de Ingreso", "Sueldo", "Cargo"
            }
        ));
        jScrollPane4.setViewportView(tablaTrab);

        btnIngresaTrab.setText("Añadir");
        btnIngresaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaTrabActionPerformed(evt);
            }
        });

        btnActualizaTrab.setText("Actualizar");
        btnActualizaTrab.setEnabled(false);
        btnActualizaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaTrabActionPerformed(evt);
            }
        });

        btnBorraTrab.setText("Eliminar");
        btnBorraTrab.setEnabled(false);
        btnBorraTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraTrabActionPerformed(evt);
            }
        });

        btnConsultaTrab.setText("Consultar");
        btnConsultaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTrabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnIngresaTrab)
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizaTrab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(btnBorraTrab)
                        .addGap(40, 40, 40)
                        .addComponent(btnConsultaTrab))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaTrab)
                    .addComponent(btnActualizaTrab)
                    .addComponent(btnBorraTrab)
                    .addComponent(btnConsultaTrab))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Trabajadores", jPanel4);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("GESTIÓN GENERAL");

        btnIntegrantes.setText("Integrantes");
        btnIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126)
                .addComponent(btnIntegrantes)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnIntegrantes))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BOTONES DE LA PESTAÑA PRODUCTOS
    private void btnIngresaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaProActionPerformed
        //ABRE CON EL CONSTRUCTOR PARA AÑADIR 
        frmProductoAdd ventana = new frmProductoAdd();
        refrescarTablaProd(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnIngresaProActionPerformed

    private void btnActualizaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaProActionPerformed
        //ABRE CON EL CONSTRUCTOR PARA ACTUALIZAR
        cProducto producto = oArregloProd.obtener(tablaProd.getSelectedRow());
        frmProductoAdd ventana = new frmProductoAdd(producto);

        refrescarTablaProd(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnActualizaProActionPerformed

    private void btnBorraProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraProActionPerformed
        cProducto p = oArregloProd.obtener(tablaProd.getSelectedRow());

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            oArregloProd.eliminar(p.getCodigo());
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            mostrarProductos(tablaProd);
        }
    }//GEN-LAST:event_btnBorraProActionPerformed

    private void btnConsultaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaProActionPerformed
        frmProductoSee ventana = new frmProductoSee();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultaProActionPerformed

    
    //BOTÓN DE INTEGRANTES
    private void btnIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntegrantesActionPerformed
        frmIntegrantes integrantes = new frmIntegrantes();
        integrantes.setVisible(true);
    }//GEN-LAST:event_btnIntegrantesActionPerformed

    
    //BOTONES DE LA PESTAÑA COMPROBANTES
    private void btnIngresaComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaComActionPerformed
        frmComprobanteAdd ventana = new frmComprobanteAdd();
        refrescarTablaCompro(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnIngresaComActionPerformed

    private void btnActualizaComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaComActionPerformed
        int fila = tablaCompro.getSelectedRow();
        String codigo = String.valueOf(tablaCompro.getValueAt(fila, 0));
        cComprobante comprobante = oLEComprobante.busqueda(codigo);
        
        frmComprobanteAdd ventana = new frmComprobanteAdd(comprobante);
        refrescarTablaCompro(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnActualizaComActionPerformed

    private void btnBorraComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraComActionPerformed
        int fila = tablaCompro.getSelectedRow();
        String codigo = String.valueOf(tablaCompro.getValueAt(fila, 0));
        cComprobante compro = oLEComprobante.busqueda(codigo);

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este comprobante?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            oLEComprobante.eliminaEntreNodos(compro.getCodigo());
            JOptionPane.showMessageDialog(this, "Comprobante eliminado correctamente");
            mostrarComprobantes(tablaCompro);
        }
    }//GEN-LAST:event_btnBorraComActionPerformed

    private void btnConsultaComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaComActionPerformed
        frmComprobanteSee ventana = new frmComprobanteSee();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultaComActionPerformed

    
    //BOTONES DE LA PESTAÑA CLIENTES
    private void btnIngresaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaCliActionPerformed
        frmClienteAdd ventana = new frmClienteAdd();
        refrescarTablaCli(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnIngresaCliActionPerformed

    private void btnActualizaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaCliActionPerformed
        int fila = tablaCli.getSelectedRow();
        String codigo = String.valueOf(tablaCli.getValueAt(fila, 0));
        cCliente cliente = oLECliente.busqueda(codigo);
        frmClienteAdd ventana = new frmClienteAdd(cliente);
        
        refrescarTablaCli(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnActualizaCliActionPerformed

    private void btnBorraCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraCliActionPerformed
        int fila = tablaCli.getSelectedRow();
        String codigo = String.valueOf(tablaCli.getValueAt(fila, 0));
        cCliente cliente = oLECliente.busqueda(codigo);
        
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este cliente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            oLECliente.eliminaEntreNodos(cliente.getCodigo());
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            mostrarClientes(tablaCli);
        }
    }//GEN-LAST:event_btnBorraCliActionPerformed

    private void btnConsultaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCliActionPerformed
        frmClienteSee ventana = new frmClienteSee();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultaCliActionPerformed

    //FILTROS DE CLIENTES
    private void rbPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPersonaActionPerformed
        oLECliente.recorrerLeP(tablaCli);
    }//GEN-LAST:event_rbPersonaActionPerformed

    private void rbEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEmpresaActionPerformed
        oLECliente.recorrerLeE(tablaCli);
    }//GEN-LAST:event_rbEmpresaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        mostrarClientes(tablaCli);
    }//GEN-LAST:event_rbTodosActionPerformed

    //FILTROS PARA COMPROBANTES
    private void rbBolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBolActionPerformed
        oLEComprobante.recorreLEBoleta(tablaCompro);
    }//GEN-LAST:event_rbBolActionPerformed

    private void rbFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFacActionPerformed
        oLEComprobante.recorreLEFactura(tablaCompro);
    }//GEN-LAST:event_rbFacActionPerformed

    private void rbTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodoActionPerformed
        mostrarComprobantes(tablaCompro);
    }//GEN-LAST:event_rbTodoActionPerformed

    
    //BOTONES DE LA PESTAÑA TRABAJADORES
    private void btnIngresaTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaTrabActionPerformed
        frmTrabajadoresAdd ventana = new frmTrabajadoresAdd();
        refrescarTablaTrab(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnIngresaTrabActionPerformed

    private void btnActualizaTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaTrabActionPerformed
        int fila = tablaTrab.getSelectedRow();
        cTrabajador trabajador=oArregloTrab.obtener(fila);
        
        frmTrabajadoresAdd ventana = new frmTrabajadoresAdd(trabajador);
        refrescarTablaTrab(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnActualizaTrabActionPerformed

    private void btnBorraTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraTrabActionPerformed
        int fila = tablaTrab.getSelectedRow();
        cTrabajador trabajador=oArregloTrab.obtener(fila);
        
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este trabajador?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            oArregloTrab.eliminar(trabajador.getCodigo());
            JOptionPane.showMessageDialog(this, "Trabajador eliminado correctamente");
            mostrarClientes(tablaCli);
        }
    }//GEN-LAST:event_btnBorraTrabActionPerformed

    private void btnConsultaTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaTrabActionPerformed
        frmTrabajadoresSee ventana=new frmTrabajadoresSee();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultaTrabActionPerformed

    
    //FUNCIONALIDAD DE CPILA PARA RECUPERAR COMPROBANTES
    private void btnRecuperaComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperaComActionPerformed
        
    }//GEN-LAST:event_btnRecuperaComActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Activa el look and feel "Nimbus" (moderno por defecto en NetBeans)
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(frmGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new frmGeneral().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizaCli;
    private javax.swing.JButton btnActualizaCom;
    private javax.swing.JButton btnActualizaPro;
    private javax.swing.JButton btnActualizaTrab;
    private javax.swing.JButton btnBorraCli;
    private javax.swing.JButton btnBorraCom;
    private javax.swing.JButton btnBorraPro;
    private javax.swing.JButton btnBorraTrab;
    private javax.swing.JButton btnConsultaCli;
    private javax.swing.JButton btnConsultaCom;
    private javax.swing.JButton btnConsultaPro;
    private javax.swing.JButton btnConsultaTrab;
    private javax.swing.JButton btnIngresaCli;
    private javax.swing.JButton btnIngresaCom;
    private javax.swing.JButton btnIngresaPro;
    private javax.swing.JButton btnIngresaTrab;
    private javax.swing.JButton btnIntegrantes;
    private javax.swing.JButton btnRecuperaCom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panCliente;
    private javax.swing.JPanel panCompro;
    private javax.swing.JRadioButton rbBol;
    private javax.swing.JRadioButton rbEmpresa;
    private javax.swing.JRadioButton rbFac;
    private javax.swing.JRadioButton rbPersona;
    private javax.swing.JRadioButton rbTodo;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tablaCli;
    private javax.swing.JTable tablaCompro;
    private javax.swing.JTable tablaProd;
    private javax.swing.JTable tablaTrab;
    // End of variables declaration//GEN-END:variables
}
