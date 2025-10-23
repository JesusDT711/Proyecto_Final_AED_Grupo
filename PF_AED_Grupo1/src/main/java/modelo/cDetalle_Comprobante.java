
package modelo;

/**
 *
 * @author Giuss
 */
public class cDetalle_Comprobante {
    private String codPro;
    private int cantidad;
    private double precio;

    public cDetalle_Comprobante(String codPro, int cantidad, double precio) {
        this.codPro = codPro;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public double subTotal(){
        return cantidad*precio;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
