
package vista;

import controlador.cArreglo_Producto;
import controlador.cArreglo_Trabajador;
import controlador.cLE_Comprobante;
import controlador.cLE_Cliente;
import controlador.cCola;
import controlador.cLE_Detalle;
import controlador.cNodo_LE_Detalle;
import controlador.cNodo_Pila;
import controlador.cPila;
import controlador.cABB;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.cProducto;
import modelo.cBoleta;
import modelo.cFactura;
import modelo.cComprobante;
import modelo.cDetalle_Comprobante;
import modelo.cCliente;
import modelo.cTrabajador;
import modelo.cAccion;

/**
 *
 * @author Giuss
 */
public class frmGeneral extends javax.swing.JFrame {

    public static cArreglo_Producto oArregloProd = new cArreglo_Producto(1000);
    public static cLE_Comprobante oLEComprobante = new cLE_Comprobante();
    public static cLE_Cliente oLECliente = new cLE_Cliente();
    public static cArreglo_Trabajador oArregloTrab = new cArreglo_Trabajador(100);
    public static cCola oColaDespachoAlta = new cCola(100);  
    public static cCola oColaDespachoBaja = new cCola(100);
    public static cPila oPilaAcciones = new cPila();
    public static cABB oABBProd = new cABB();
    public static frmGeneral instancia;

    public frmGeneral() {
        instancia = this;
        initComponents();
        setLocationRelativeTo(null);
        cargarProductosBase();   
        cargarClientesBase();
        cargarTrabajadoresBase();
        cargarComprobantesBase();
        mostrarHistorial();

        habilitarBotonesProductos();
        habilitarBotonesComprobantes();
        habilitarBotonesClientes();
        habilitarBotonesTrabajadores();
    }

    //MANEJO DE HISTORIAL DE ACCIONES
    
    public JTextArea getTxtAcciones(){
        return txtaAcciones;
    }
    
    public static void mostrarHistorial(){
        if(instancia != null){
            JTextArea txta = instancia.getTxtAcciones();
            txta.setText("");
            cPila pilaTemp = new cPila();
            cNodo_Pila tope = oPilaAcciones.getTope();
            while(tope != null){
                pilaTemp.apilar(tope.getValor());
                tope = tope.getSgte();
            }
            if(pilaTemp.getTope() == null){
                txta.append("No hay acciones registradas");
            }else{
                while(pilaTemp.getTope() != null){
                    cAccion accion = pilaTemp.verTope();
                    String des = accion.getDescripcion();
                    String fecha = accion.fechaCadena();
                    txta.append("Descripción: "+des);
                    txta.append("\nFecha y hora: "+fecha);
                    txta.append("\n======================\n");
                    pilaTemp.desapilar();
                }
            }
        }   
    }
    
    //MÉTODOS PARA CARGAR LOS OBJETOS BASE
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
        oArregloProd.agregar(new cProducto("LAPTOP I7 13400k", 2999.90, 100));
        oArregloProd.agregar(new cProducto("MOUSE LOGITECH G645", 119.90, 100));
        oArregloProd.agregar(new cProducto("TECLADO RGB DRAGON", 249.90, 100));
        oArregloProd.agregar(new cProducto("AURICULARES GAMER HYPERX CLOUD II", 349.90, 35));
        oArregloProd.agregar(new cProducto("PARLANTES BLUETOOTH JBL GO 3", 129.90, 60));
        oArregloProd.agregar(new cProducto("MICRÓFONO USB FIFINE K669B", 159.90, 20));
        oArregloProd.agregar(new cProducto("DISCO SSD KINGSTON 480GB", 169.90, 65));
        oArregloProd.agregar(new cProducto("TARJETA DE VIDEO GTX 1650 4GB", 899.90, 8));
        oArregloProd.agregar(new cProducto("CARGADOR RÁPIDO SAMSUNG 25W", 79.90, 100));
        oArregloProd.agregar(new cProducto("CARGADOR TIPO C XIAOMI 33W", 69.90, 120));
        oArregloProd.agregar(new cProducto("CABLE USB TIPO C DURABLE 1M", 19.90, 200));
        oArregloProd.agregar(new cProducto("TABLET LENOVO TAB M10", 699.90, 15));
        oArregloProd.agregar(new cProducto("LÁPIZ DIGITAL PARA TABLET", 49.90, 70));
        oArregloProd.agregar(new cProducto("TECLADO BLUETOOTH PARA TABLET", 79.90, 40));

        int tamaño = oArregloProd.tamaño();
        for(int i=0; i<tamaño; i++){
            cProducto oProducto = oArregloProd.obtener(i);
            oABBProd.insertarNodo(oProducto);
        }
        mostrarProductos(tablaProd);
    }

    private void cargarComprobantesBase() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "12/01/2025";
        String fecha2str = "15/02/2025";
        String fecha3str = "14/03/2025";
        String fecha4str = "02/04/2025";
        String fecha5str = "29/05/2025";
        String fecha6str = "23/07/2025";
        String fecha7str = "04/09/2025";
        String fecha8str = "07/10/2025";
        String fecha9str = "18/11/2025";
        String fecha10str = "30/12/2025";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        Date fecha8 = null;
        Date fecha9 = null;
        Date fecha10 = null;

        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
            fecha4 = formato.parse(fecha4str);
            fecha5 = formato.parse(fecha5str);
            fecha6 = formato.parse(fecha6str);
            fecha7 = formato.parse(fecha7str);
            fecha8 = formato.parse(fecha8str);
            fecha9 = formato.parse(fecha9str);
            fecha10 = formato.parse(fecha10str);
        } catch (ParseException e) {
            System.out.println("Error al convertir una de las fechas:" + e.getMessage());
        }

        int cant1 = 1;
        int cant2 = 2;
        int cant3 = 3;
        int cant4 = 4;
        int cant5 = 5;
        
        cProducto prod1 = oArregloProd.obtener(0);
        cProducto prod2 = oArregloProd.obtener(1);
        cProducto prod3 = oArregloProd.obtener(2);
        cProducto prod4 = oArregloProd.obtener(3);
        cProducto prod5 = oArregloProd.obtener(4);
        cProducto prod6 = oArregloProd.obtener(5);
        cProducto prod7 = oArregloProd.obtener(6);
        
        cFactura f1 = new cFactura(fecha1, "C001", "V002");
        f1.setDetalle(new cDetalle_Comprobante(f1.getCodigo(),
                prod1.getCodigo(),
                cant2,
                prod1.getPrecio()));
        
        f1.setDetalle(new cDetalle_Comprobante(f1.getCodigo(),
                prod2.getCodigo(),
                cant3,
                prod2.getPrecio()));
        
        prod1.registrarVenta(cant2);
        prod2.registrarVenta(cant3);

        
        cBoleta b1 = new cBoleta(fecha2, "C002", "V003");
        b1.setDetalle(new cDetalle_Comprobante(b1.getCodigo(),
                prod1.getCodigo(),
                cant3,
                prod1.getPrecio()));
        
        b1.setDetalle(new cDetalle_Comprobante(b1.getCodigo(),
                prod3.getCodigo(),
                cant1,
                prod3.getPrecio()));
        
        prod1.registrarVenta(cant3);
        prod3.registrarVenta(cant1);
        
        
        cFactura f2 = new cFactura(fecha3, "C003", "V006");
        f2.setDetalle(new cDetalle_Comprobante(f2.getCodigo(),
                prod1.getCodigo(),
                cant1,
                prod1.getPrecio()));
        
        prod1.registrarVenta(cant1);
                
        
        cBoleta b2 = new cBoleta(fecha4, "C004", "V007");
        b2.setDetalle(new cDetalle_Comprobante(b2.getCodigo(),
                prod4.getCodigo(),
                cant1,
                prod4.getPrecio()));
        
        b2.setDetalle(new cDetalle_Comprobante(b2.getCodigo(),
                prod6.getCodigo(),
                cant2,
                prod6.getPrecio()));
        
        prod4.registrarVenta(cant1);
        prod6.registrarVenta(cant2);
        
        
        cFactura f3 = new cFactura(fecha5, "C005", "V004");
        f3.setDetalle(new cDetalle_Comprobante(f3.getCodigo(),
                prod5.getCodigo(),
                cant1,
                prod5.getPrecio()));
        
        f3.setDetalle(new cDetalle_Comprobante(f3.getCodigo(),
                prod1.getCodigo(),
                cant4,
                prod1.getPrecio()));
        
        prod5.registrarVenta(cant1);
        prod1.registrarVenta(cant4);
        

        cBoleta b3 = new cBoleta(fecha6, "C006", "V005");
        b3.setDetalle(new cDetalle_Comprobante(b3.getCodigo(),
                prod3.getCodigo(),
                cant2,
                prod3.getPrecio()));
        
        prod3.registrarVenta(cant2);
                

        cFactura f4 = new cFactura(fecha7, "C007", "V002");
        f4.setDetalle(new cDetalle_Comprobante(f4.getCodigo(),
                prod2.getCodigo(),
                cant5,
                prod2.getPrecio()));
        
        prod2.registrarVenta(cant5);
        

        cBoleta b4 = new cBoleta(fecha8, "C008", "V001");
        b4.setDetalle(new cDetalle_Comprobante(b4.getCodigo(),
                prod7.getCodigo(),
                cant1,
                prod7.getPrecio()));
        
        prod7.registrarVenta(cant1);


        cFactura f5 = new cFactura(fecha9, "C009", "V003");
        f5.setDetalle(new cDetalle_Comprobante(f5.getCodigo(),
                prod4.getCodigo(),
                cant3,
                prod4.getPrecio()));
        
        f5.setDetalle(new cDetalle_Comprobante(f5.getCodigo(),
                prod6.getCodigo(),
                cant1,
                prod6.getPrecio()));
        
        prod4.registrarVenta(cant3);
        prod6.registrarVenta(cant1);
 

        cBoleta b5 = new cBoleta(fecha10, "C010", "V002");
        b5.setDetalle(new cDetalle_Comprobante(b5.getCodigo(),
                prod5.getCodigo(),
                cant2,
                prod5.getPrecio()));
        
        prod5.registrarVenta(cant2);
        
        oLEComprobante.insertarxFinal(f1);
        oLEComprobante.insertarxFinal(b1);
        oLEComprobante.insertarxFinal(f2);
        oLEComprobante.insertarxFinal(b2);
        oLEComprobante.insertarxFinal(f3);
        oLEComprobante.insertarxFinal(b3);
        oLEComprobante.insertarxFinal(f4);
        oLEComprobante.insertarxFinal(b4);
        oLEComprobante.insertarxFinal(f5);
        oLEComprobante.insertarxFinal(b5);
        
        mostrarComprobantes(tablaCompro);
    }

    private void cargarClientesBase() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "12/01/2025";
        String fecha2str = "15/02/2025";
        String fecha3str = "14/03/2025";
        String fecha4str = "02/04/2025";
        String fecha5str = "29/05/2025";
        String fecha6str = "23/07/2025";
        String fecha7str = "04/09/2025";
        String fecha8str = "07/10/2025";
        String fecha9str = "18/11/2025";
        String fecha10str = "30/12/2025";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        Date fecha8 = null;
        Date fecha9 = null;
        Date fecha10 = null;

        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
            fecha4 = formato.parse(fecha4str);
            fecha5 = formato.parse(fecha5str);
            fecha6 = formato.parse(fecha6str);
            fecha7 = formato.parse(fecha7str);
            fecha8 = formato.parse(fecha8str);
            fecha9 = formato.parse(fecha9str);
            fecha10 = formato.parse(fecha10str);
        } catch (ParseException e) {
            System.out.println("Error al convertir una de las fechas:" + e.getMessage());
        }

        long tel1 = 991992990;
        long tel2 = 959192231;
        long tel3 = 910233677;
        long tel4 = 987654321;
        long tel5 = 912345678;
        long tel6 = 998877665;
        long tel7 = 945112230;
        long tel8 = 922334455;
        long tel9 = 933221198;
        long tel10 = 987112245;

        long doc1 = 1078181921;
        long doc2 = 76192192;
        long doc3 = 1071623251;     
        long doc4 = 1045567891;
        long doc5 = 76234512;
        long doc6 = 1079981123;
        long doc7 = 1082235491;
        long doc8 = 74211822;
        long doc9 = 1078893344;
        long doc10 = 73345122;

        oLECliente.insertarxFinal(new cCliente("Tenda", tel1, doc1, fecha1, 2, "Lizardo Silva"));
        oLECliente.insertarxFinal(new cCliente("Juan Quillo", tel2, doc2, fecha2, 1, "Juan Quillo"));
        oLECliente.insertarxFinal(new cCliente("Kit Kat", tel3, doc3, fecha3, 2, "Giussepe Delgado"));
        oLECliente.insertarxFinal(new cCliente("TechNova", tel4, doc4, fecha4, 2, "Carlos Álvarez"));
        oLECliente.insertarxFinal(new cCliente("Valeria Ramos", tel5, doc5, fecha5, 1, "Valeria Ramos"));
        oLECliente.insertarxFinal(new cCliente("PixelPro", tel6, doc6, fecha6, 2, "Marco Torres"));
        oLECliente.insertarxFinal(new cCliente("ByteHouse", tel7, doc7, fecha7, 2, "Fernando Castañeda"));
        oLECliente.insertarxFinal(new cCliente("Reichel Saavedra", tel8, doc8, fecha8, 1, "Reichel Saavedra"));
        oLECliente.insertarxFinal(new cCliente("TecnoStore", tel9, doc9, fecha9, 2, "Ricardo Paredes"));
        oLECliente.insertarxFinal(new cCliente("Aaron Palomino", tel10, doc10, fecha10, 1, "Aaron Palomino"));

        mostrarClientes(tablaCli);
    }

    private void cargarTrabajadoresBase() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fecha1str = "05/11/2024";
        String fecha2str = "15/03/2024";
        String fecha3str = "20/01/2023";
        String fecha4str = "10/02/2023";
        String fecha5str = "28/07/2024";
        String fecha6str = "03/09/2022";
        String fecha7str = "19/12/2023";

        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        
        try {
            fecha1 = formato.parse(fecha1str);
            fecha2 = formato.parse(fecha2str);
            fecha3 = formato.parse(fecha3str);
            fecha4 = formato.parse(fecha4str);
            fecha5 = formato.parse(fecha5str);
            fecha6 = formato.parse(fecha6str);
            fecha7 = formato.parse(fecha7str);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar trabajadores base: " + e.getMessage());
        }

        cTrabajador t1 = new cTrabajador("Michael Gómez", fecha1, 1); //administrador
        cTrabajador t2 = new cTrabajador("Aaron Palomino", fecha2, 2); //cajero
        cTrabajador t3 = new cTrabajador("Cristian Castro", fecha3, 3);  //reponedor
        cTrabajador t4 = new cTrabajador("Mariana Torres", fecha4, 2); //
        cTrabajador t5 = new cTrabajador("Rodrigo Salazar", fecha5, 3); //
        cTrabajador t6 = new cTrabajador("Elena Villanueva", fecha6, 1);
        cTrabajador t7 = new cTrabajador("Héctor Paredes", fecha7, 2);
        
        oArregloTrab.agregar(t1);
        oArregloTrab.agregar(t2);
        oArregloTrab.agregar(t3);
        oArregloTrab.agregar(t4);
        oArregloTrab.agregar(t5);
        oArregloTrab.agregar(t6);
        oArregloTrab.agregar(t7);

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
                while(!oColaDespachoAlta.estaVacia()){
                    oLEComprobante.insertarxFinal(oColaDespachoAlta.desencolar());
                }
                while(!oColaDespachoBaja.estaVacia()){
                    oLEComprobante.insertarxFinal(oColaDespachoBaja.desencolar());
                }
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jLabel7 = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtaAcciones = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnConsultaVenta = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtaVenta = new javax.swing.JTextArea();
        btnLimpiaVenta = new javax.swing.JButton();
        txtVenta = new javax.swing.JTextField();
        panValor = new javax.swing.JPanel();
        rbMenor = new javax.swing.JRadioButton();
        rbExacto = new javax.swing.JRadioButton();
        rbMayor = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProd = new javax.swing.JTable();
        btnIngresaPro = new javax.swing.JButton();
        btnActualizaPro = new javax.swing.JButton();
        btnBorraPro = new javax.swing.JButton();
        btnConsultaPro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaTrab = new javax.swing.JTable();
        btnIngresaTrab = new javax.swing.JButton();
        btnActualizaTrab = new javax.swing.JButton();
        btnBorraTrab = new javax.swing.JButton();
        btnConsultaTrab = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnIntegrantes = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/resources/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 1, 58)); // NOI18N
        jLabel1.setText("GESTIÓN GENERAL");

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 51, 51));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 32900));

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

        btnIngresaCom.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnIngresaCom.setText("Añadir");
        btnIngresaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaComActionPerformed(evt);
            }
        });

        btnActualizaCom.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizaCom.setText("Actualizar");
        btnActualizaCom.setEnabled(false);
        btnActualizaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaComActionPerformed(evt);
            }
        });

        btnBorraCom.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBorraCom.setText("Eliminar");
        btnBorraCom.setEnabled(false);
        btnBorraCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraComActionPerformed(evt);
            }
        });

        btnConsultaCom.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnConsultaCom.setText("Consultar");
        btnConsultaCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaComActionPerformed(evt);
            }
        });

        panCompro.setBackground(new java.awt.Color(255, 255, 255));
        panCompro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
        panCompro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Punto (C)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(540, 540, 540))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnIngresaCom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnActualizaCom)
                        .addGap(200, 200, 200)
                        .addComponent(btnBorraCom)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultaCom)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panCompro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaCom)
                    .addComponent(btnActualizaCom)
                    .addComponent(btnConsultaCom)
                    .addComponent(btnBorraCom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCompro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Comprobantes", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        tablaCli.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        btnIngresaCli.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnIngresaCli.setText("Añadir");
        btnIngresaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaCliActionPerformed(evt);
            }
        });

        btnActualizaCli.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizaCli.setText("Actualizar");
        btnActualizaCli.setEnabled(false);
        btnActualizaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaCliActionPerformed(evt);
            }
        });

        btnBorraCli.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBorraCli.setText("Eliminar");
        btnBorraCli.setEnabled(false);
        btnBorraCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraCliActionPerformed(evt);
            }
        });

        panCliente.setBackground(new java.awt.Color(255, 255, 255));
        panCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

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
                .addComponent(rbPersona)
                .addGap(24, 24, 24)
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

        btnConsultaCli.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnConsultaCli.setText("Consultar");
        btnConsultaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCliActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Punto (C)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnIngresaCli)
                .addGap(18, 18, 18)
                .addComponent(btnActualizaCli)
                .addGap(113, 113, 113)
                .addComponent(btnBorraCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultaCli)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(panCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizaCli)
                    .addComponent(btnIngresaCli)
                    .addComponent(btnBorraCli)
                    .addComponent(btnConsultaCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        txtaAcciones.setColumns(20);
        txtaAcciones.setRows(5);
        jScrollPane5.setViewportView(txtaAcciones);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Punto (E)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historial de Acciones", jPanel5);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setText("INGRESE UN MONTO:");

        btnConsultaVenta.setText("Consultar");
        btnConsultaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaVentaActionPerformed(evt);
            }
        });

        txtaVenta.setColumns(20);
        txtaVenta.setRows(5);
        jScrollPane6.setViewportView(txtaVenta);

        btnLimpiaVenta.setText("Limpiar");
        btnLimpiaVenta.setEnabled(false);
        btnLimpiaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaVentaActionPerformed(evt);
            }
        });

        panValor.setBackground(new java.awt.Color(255, 255, 255));
        panValor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Criterio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        buttonGroup4.add(rbMenor);
        rbMenor.setText("Menor");

        buttonGroup4.add(rbExacto);
        rbExacto.setText("Exacto");

        buttonGroup4.add(rbMayor);
        rbMayor.setText("Mayor");

        javax.swing.GroupLayout panValorLayout = new javax.swing.GroupLayout(panValor);
        panValor.setLayout(panValorLayout);
        panValorLayout.setHorizontalGroup(
            panValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panValorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMenor)
                .addGap(18, 18, 18)
                .addComponent(rbExacto)
                .addGap(18, 18, 18)
                .addComponent(rbMayor)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panValorLayout.setVerticalGroup(
            panValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panValorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMenor)
                    .addComponent(rbExacto)
                    .addComponent(rbMayor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Punto (F)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultaVenta))
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnLimpiaVenta)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(panValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnConsultaVenta)
                    .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiaVenta)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta Ventas", jPanel8);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tablaProd.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        btnIngresaPro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnIngresaPro.setText("Añadir");
        btnIngresaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaProActionPerformed(evt);
            }
        });

        btnActualizaPro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizaPro.setText("Actualizar");
        btnActualizaPro.setEnabled(false);
        btnActualizaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaProActionPerformed(evt);
            }
        });

        btnBorraPro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBorraPro.setText("Eliminar");
        btnBorraPro.setEnabled(false);
        btnBorraPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraProActionPerformed(evt);
            }
        });

        btnConsultaPro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnConsultaPro.setText("Consultar");
        btnConsultaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaProActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Punto (B)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnIngresaPro)
                .addGap(41, 41, 41)
                .addComponent(btnActualizaPro)
                .addGap(106, 106, 106)
                .addComponent(btnBorraPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnConsultaPro)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaPro)
                    .addComponent(btnActualizaPro)
                    .addComponent(btnBorraPro)
                    .addComponent(btnConsultaPro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Productos", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

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

        btnIngresaTrab.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnIngresaTrab.setText("Añadir");
        btnIngresaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaTrabActionPerformed(evt);
            }
        });

        btnActualizaTrab.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizaTrab.setText("Actualizar");
        btnActualizaTrab.setEnabled(false);
        btnActualizaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaTrabActionPerformed(evt);
            }
        });

        btnBorraTrab.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBorraTrab.setText("Eliminar");
        btnBorraTrab.setEnabled(false);
        btnBorraTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraTrabActionPerformed(evt);
            }
        });

        btnConsultaTrab.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnConsultaTrab.setText("Consultar");
        btnConsultaTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTrabActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Punto (B)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnIngresaTrab)
                .addGap(35, 35, 35)
                .addComponent(btnActualizaTrab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(btnBorraTrab)
                .addGap(36, 36, 36)
                .addComponent(btnConsultaTrab)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresaTrab)
                    .addComponent(btnActualizaTrab)
                    .addComponent(btnBorraTrab)
                    .addComponent(btnConsultaTrab))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Trabajadores", jPanel4);

        btnCerrarSesion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnIntegrantes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIntegrantes.setText("Integrantes");
        btnIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntegrantesActionPerformed(evt);
            }
        });

        btnDeshacer.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDeshacer.setText("Deshacer última acción");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Punto (A):Formulario General");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Punto (D): Función aplicada al emitir un comprobante");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Punto (E)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeshacer)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnCerrarSesion)))
                                .addGap(19, 19, 19))))
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeshacer)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrarSesion))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 850, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        cProducto prod = oArregloProd.obtener(tablaProd.getSelectedRow());

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            oArregloProd.eliminar(prod.getCodigo());
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            oPilaAcciones.apilar(new cAccion("Se eliminó un producto",prod));
            frmGeneral.mostrarHistorial();
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
            oPilaAcciones.apilar(new cAccion("Se eliminó un comprobante",compro));
            frmGeneral.mostrarHistorial();
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
            oPilaAcciones.apilar(new cAccion("Se eliminó un cliente",cliente));
            mostrarHistorial();
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
            oPilaAcciones.apilar(new cAccion("Se eliminó un trabajador",trabajador));
            frmGeneral.mostrarHistorial();
            mostrarTrabajadores(tablaTrab);
        }
    }//GEN-LAST:event_btnBorraTrabActionPerformed

    private void btnConsultaTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaTrabActionPerformed
        frmTrabajadoresSee ventana=new frmTrabajadoresSee();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultaTrabActionPerformed

    
    //FUNCIONALIDAD BOTÓN "DESHACER ÚLTIMA ACCIÓN"
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        cAccion accion = oPilaAcciones.desapilar();
        if(accion != null){
            String des = accion.getDescripcion();
            JOptionPane.showMessageDialog(this, "Se deshizo: "+des);
            switch(des){
                case "Registró un producto" -> {
                    cProducto prod = (cProducto) accion.getObjeto();
                    oArregloProd.eliminar(prod.getCodigo());
                    mostrarProductos(tablaProd);
                    mostrarHistorial();
                }
                case "Encoló una boleta" -> {
                    cComprobante compB = (cComprobante) accion.getObjeto();
                    oLEComprobante.eliminaEntreNodos(compB.getCodigo());
                    mostrarComprobantes(tablaCompro);
                    mostrarHistorial();
                }
                case "Encoló una factura" -> {
                    cComprobante compF = (cComprobante) accion.getObjeto();
                    oLEComprobante.eliminaEntreNodos(compF.getCodigo());
                    mostrarComprobantes(tablaCompro);
                    mostrarHistorial();
                }
                case "Registró un cliente" -> {
                    cCliente cli = (cCliente) accion.getObjeto();
                    oLECliente.eliminaEntreNodos(cli.getCodigo());
                    mostrarClientes(tablaCli);
                    mostrarHistorial();
                }
                case "Registró un trabajador" -> {
                    cTrabajador trab = (cTrabajador) accion.getObjeto();
                    oArregloTrab.eliminar(trab.getCodigo());
                    mostrarTrabajadores(tablaTrab);
                    mostrarHistorial();
                }
                case "Se eliminó un producto" -> {
                    cProducto prodEli = (cProducto) accion.getObjeto();
                    oArregloProd.agregar(prodEli);
                    mostrarProductos(tablaProd);
                    mostrarHistorial();
                }
                case "Se eliminó un comprobante" -> {
                    cComprobante compEli = (cComprobante) accion.getObjeto();
                    oLEComprobante.insertarxFinal(compEli);
                    mostrarComprobantes(tablaCompro);
                    mostrarHistorial();
                }
                case "Se eliminó un cliente" -> {
                    cCliente cliEli = (cCliente) accion.getObjeto();
                    oLECliente.insertarxFinal(cliEli);
                    mostrarClientes(tablaCli);
                    mostrarHistorial();
                }
                case "Se eliminó un trabajador" -> {
                    cTrabajador trabEli = (cTrabajador) accion.getObjeto();
                    oArregloTrab.agregar(trabEli);
                    mostrarTrabajadores(tablaTrab);
                    mostrarHistorial();
                }
                case "Actualizó un producto" -> {
                    cProducto prodPre = (cProducto) accion.getObjeto();
                    cProducto prodAct = oArregloProd.buscar(prodPre.getCodigo());
                    prodAct.setDescripcion(prodPre.getDescripcion());
                    prodAct.setPrecio(prodPre.getPrecio());
                    prodAct.setStock(prodPre.getStock());
                    mostrarProductos(tablaProd);
                    mostrarHistorial();
                }
                case "Actualizó un comprobante" -> {
                    cComprobante compPre = (cComprobante) accion.getObjeto();
                    cComprobante compAct = oLEComprobante.busqueda(compPre.getCodigo());
                    compAct.setFecha(compPre.getFecha());
                    compAct.setCliente(compPre.getCliente());
                    compAct.setVendedor(compPre.getVendedor());
                    cLE_Detalle detPre = compPre.getDetalle();
                    cNodo_LE_Detalle p = detPre.getInicio();
                    while(p!=null){
                        compAct.setDetalle(p.getValor());
                        p = p.getSgte();
                    }
                    mostrarComprobantes(tablaCompro);
                    mostrarHistorial();
                }
                case "Actualizó un cliente" -> {
                    cCliente cliPre = (cCliente) accion.getObjeto();
                    cCliente cliAct = oLECliente.busqueda(cliPre.getCodigo());
                    cliAct.setRsocial(cliPre.getRsocial());
                    cliAct.setTelefono(cliPre.getTelefono());
                    cliAct.setDocIdentifica(cliPre.getDocIdentifica());
                    cliAct.setFecha_compra(cliPre.getFecha_compra());
                    cliAct.setTipo(cliPre.getTipo());
                    cliAct.setContacto(cliPre.getContacto());
                    mostrarClientes(tablaCli);
                    mostrarHistorial();
                }
                case "Actualizó un trabajador" -> {
                    cTrabajador trabPre = (cTrabajador) accion.getObjeto();
                    cTrabajador trabAct = oArregloTrab.buscar(trabPre.getCodigo());
                    trabAct.setNombre(trabPre.getNombre());
                    trabAct.setFecha_ingreso(trabPre.getFecha_ingreso());
                    trabAct.setTipo(trabPre.getTipo());
                    trabAct.setSueldo(trabPre.getSueldo());
                    mostrarTrabajadores(tablaTrab);
                    mostrarHistorial();
                }
            } 
        }else{
            JOptionPane.showMessageDialog(this, "No hay acciones por deshacer");
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

    //FUNCIONALIDAD DEL BOTÓN CERRAR SESIÓN
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        frmLogin ventana = new frmLogin();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    //BOTONES DE LA PESTAÑA CONSULTA VENTAS
    private void btnConsultaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaVentaActionPerformed
        if(!rbMayor.isSelected() && !rbMenor.isSelected() && !rbExacto.isSelected()){
            JOptionPane.showMessageDialog(this, "Seleccione un criterio de búsqueda");
        }else if(txtVenta.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete el campo del monto");
        }else{
            double monto = Double.parseDouble(txtVenta.getText());
            if(rbMayor.isSelected()){
                oABBProd.buscaMayoresMonto(monto, txtaVenta);
            }else if(rbMenor.isSelected()){
                oABBProd.buscaMenoresMonto(monto, txtaVenta);
            }else{
                oABBProd.buscaIndexadoMonto(monto, txtaVenta);
            }
            btnLimpiaVenta.setEnabled(true);
            btnConsultaVenta.setEnabled(false);
        }
    }//GEN-LAST:event_btnConsultaVentaActionPerformed

    private void btnLimpiaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaVentaActionPerformed
        buttonGroup4.clearSelection();
        txtVenta.setText("");
        txtaVenta.setText("");
        btnConsultaVenta.setEnabled(true);
        btnLimpiaVenta.setEnabled(false);
    }//GEN-LAST:event_btnLimpiaVentaActionPerformed

    
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
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultaCli;
    private javax.swing.JButton btnConsultaCom;
    private javax.swing.JButton btnConsultaPro;
    private javax.swing.JButton btnConsultaTrab;
    private javax.swing.JButton btnConsultaVenta;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnIngresaCli;
    private javax.swing.JButton btnIngresaCom;
    private javax.swing.JButton btnIngresaPro;
    private javax.swing.JButton btnIngresaTrab;
    private javax.swing.JButton btnIntegrantes;
    private javax.swing.JButton btnLimpiaVenta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panCliente;
    private javax.swing.JPanel panCompro;
    private javax.swing.JPanel panValor;
    private javax.swing.JRadioButton rbBol;
    private javax.swing.JRadioButton rbEmpresa;
    private javax.swing.JRadioButton rbExacto;
    private javax.swing.JRadioButton rbFac;
    private javax.swing.JRadioButton rbMayor;
    private javax.swing.JRadioButton rbMenor;
    private javax.swing.JRadioButton rbPersona;
    private javax.swing.JRadioButton rbTodo;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tablaCli;
    private javax.swing.JTable tablaCompro;
    private javax.swing.JTable tablaProd;
    private javax.swing.JTable tablaTrab;
    private javax.swing.JTextField txtVenta;
    private javax.swing.JTextArea txtaAcciones;
    private javax.swing.JTextArea txtaVenta;
    // End of variables declaration//GEN-END:variables
}
