
package modelo;

/**
 *
 * @author Giuss
 */

import java.util.*;
import java.text.SimpleDateFormat;
import controlador.cLE_Detalle;

public abstract class cComprobante {
    private String codigo;
    private Date fecha;
    private String cliente;
    private String vendedor;
    private cLE_Detalle oDetalle;

    public cComprobante(Date fecha, String cliente, String vendedor) {
        this.codigo = generarCodigo();
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.oDetalle = new cLE_Detalle();
    }
    
    public abstract String generarCodigo();

    public String fechaCadena(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String cadena = sdf.format(getFecha());
        return cadena;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    public double getSubTotal(){
        return oDetalle.subTotalGeneral();
    }
    
    public double getIGV(){
        return oDetalle.igvGeneral();
    }
    
    public double getTotal(){
        return oDetalle.totalGeneral();
    }
    
    public void setDetalle(cDetalle_Comprobante nuevo){
        oDetalle.insertarxFinal(nuevo);
    }
    
    public cLE_Detalle getDetalle(){
        return oDetalle;
    }
    
    
}
