
package modelo;

/**
 *
 * @author Giuss
 */

import java.util.*;
import java.text.SimpleDateFormat;
import controlador.*;

public abstract class cComprobante {
    private String codigo;
    private Date fecha;
    private String cliente;
    private String vendedor;
    private ArrayList<cDetalle_Comprobante> detalle;

    public cComprobante(Date fecha, String cliente, String vendedor) {
        this.codigo = generarCodigo();
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.detalle = new ArrayList();
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

    public ArrayList getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<cDetalle_Comprobante> detalle) {
        this.detalle = detalle;
    } 
}
