
package controlador;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.cTrabajador;
/**
 *
 * @author Giuss
 */
public class cArreglo_Trabajador {
    private cTrabajador[] arreglo;
    private int n;
    private int capacidad;
    private double totalVentas; 

    public cArreglo_Trabajador(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new cTrabajador[this.capacidad];
        this.n = 0;
        this.totalVentas = 0.0;
    }
    
    public boolean agregar(cTrabajador trab) {
        boolean exito = false;
        if (this.n < this.capacidad) {
            this.arreglo[this.n] = trab;
            this.n++;
            exito = true;
        }
        return exito;
    }
    
    public cTrabajador obtener(int indice) {
        cTrabajador trabajador = null;
        if (indice >= 0 && indice < this.n) {
            trabajador = this.arreglo[indice];
        }
        return trabajador;
    }
    
    public int tamaño() {
        return this.n;
    }

    public cTrabajador buscar(String codigo) {
        cTrabajador trabajadorEncontrado = null;
        int i = 0;
        boolean encontrado = false;
        while (i < this.n && !encontrado) {
            if (this.arreglo[i].getCodigo().equalsIgnoreCase(codigo)) {
                trabajadorEncontrado = this.arreglo[i];
                encontrado = true;
            }
            i++; 
        }
        return trabajadorEncontrado;
    }
    
    public boolean eliminar(String codigo) {
        boolean exito = false;
        int indiceEncontrado = -1;
        int i = 0;
        boolean encontrado = false;

        while (i < this.n && !encontrado) {
            if (this.arreglo[i].getCodigo().equalsIgnoreCase(codigo)) {
                indiceEncontrado = i;
                exito = true;
                encontrado = true;
            }
            i++;
        }
        if (exito) {
            for (int j = indiceEncontrado; j < this.n - 1; j++) {
                this.arreglo[j] = this.arreglo[j + 1];
            }
            
            this.arreglo[this.n - 1] = null;
            this.n--;
        }

        return exito;
    }
    
    public void llenarComboTrabajadores(JComboBox combo){
        combo.removeAllItems();
        combo.addItem("Elegir");
        for(cTrabajador t:arreglo){
            if(t != null){
               combo.addItem(t.getCodigo()); 
            } 
        }
    }
    
    /*MODIFICAR EL MÉTODO PARA REGISTRAR LAS VENTAS QUE REALIZAN LOS TRABAJADORES
    public boolean registrarVenta(String codigo, int cantidadComprada) {
        boolean exito = false;
        cTrabajador trabajador = buscar(codigo);

        if (trabajador != null) {
            if (trabajador.getStock() >= cantidadComprada) {
                int nuevoStock = producto.getStock() - cantidadComprada;
                producto.setStock(nuevoStock);
                
                double montoDeVenta = producto.getPrecio() * cantidadComprada;
                this.totalVentas += montoDeVenta;
                
                exito = true;
            }
        }
        return exito;
    }
    */
    public double getTotalVentas() {
        return this.totalVentas;
    }
    
    public void recorrerArreglo(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for(int i=0; i<tamaño(); i++){
            cTrabajador trabajador = obtener(i);
            Object[] fila = {
                trabajador.getCodigo(),
                trabajador.getNombre(),
                trabajador.fecha_ingresoCadena(),
                trabajador.getSueldo(),
                trabajador.cargo()
            };
            modelo.addRow(fila); 
        }        
    }
}
