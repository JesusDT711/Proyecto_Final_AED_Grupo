
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author Giuss
 */
public class cProducto {
    private String codigo;
    private String descripcion;
    private double precio;
    private int stock;
    static int cuenta=1;

    public cProducto(){
        DecimalFormat cod = new DecimalFormat("P000");
        this.codigo = cod.format(cuenta++);
    }
    public cProducto(String descripcion, double precio, int stock) {
        this();
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }    
}
