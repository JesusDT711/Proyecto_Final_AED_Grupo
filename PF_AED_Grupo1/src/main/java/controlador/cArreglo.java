
package controlador;

import modelo.cProducto;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cArreglo {
    private cProducto[] productos;
    private int n;
    private int capacidad;
    private double totalVentas; 

    public cArreglo(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new cProducto[this.capacidad];
        this.n = 0;
        this.totalVentas = 0.0;
    }
    
    public boolean agregar(cProducto p) {
        boolean exito = false;
        if (this.n < this.capacidad) {
            this.productos[this.n] = p;
            this.n++;
            exito = true;
        }
        return exito;
    }
    
    public cProducto obtener(int indice) {
        cProducto producto = null;
        
        if (indice >= 0 && indice < this.n) {
            producto = this.productos[indice];
        }
        
        return producto;
    }
    
    public int tamaño() {
        return this.n;
    }

    public cProducto buscar(String codigo) {
        cProducto productoEncontrado = null;
        int i = 0;
        boolean encontrado = false;
        
        while (i < this.n && !encontrado) {
            if (this.productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                productoEncontrado = this.productos[i];
                encontrado = true;
            }
            i++; 
        }
        
        return productoEncontrado;
    }
    
    public boolean eliminar(String codigo) {
        boolean exito = false;
        int indiceEncontrado = -1;
        int i = 0;
        boolean encontrado = false;

        while (i < this.n && !encontrado) {
            if (this.productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                indiceEncontrado = i;
                exito = true;
                encontrado = true;
            }
            i++;
        }
        if (exito) {
            for (int j = indiceEncontrado; j < this.n - 1; j++) {
                this.productos[j] = this.productos[j + 1];
            }
            
            this.productos[this.n - 1] = null;
            this.n--;
        }

        return exito;
    }
    
    public void recorreLE(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for(int i=0; i<tamaño(); i++){
            cProducto producto = obtener(i);
            Object[] fila = {
                producto.getCodigo(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock()
            };
            modelo.addRow(fila); 
        }        
    }

    public boolean registrarVenta(String codigo, int cantidadComprada) {
        boolean exito = false;
        cProducto producto = buscar(codigo);

        if (producto != null) {
            if (producto.getStock() >= cantidadComprada) {
                int nuevoStock = producto.getStock() - cantidadComprada;
                producto.setStock(nuevoStock);
                
                double montoDeVenta = producto.getPrecio() * cantidadComprada;
                this.totalVentas += montoDeVenta;
                
                exito = true;
            }
        }
        return exito;
    }
    
    public double getTotalVentas() {
        return this.totalVentas;
    }
}
