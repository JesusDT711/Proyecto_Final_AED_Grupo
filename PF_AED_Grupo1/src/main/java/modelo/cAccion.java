
package modelo;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Giuss
 */
public class cAccion {
    private String descripcion;
    private Object objeto;
    private Date fecha;
    
    public cAccion(String descripcion, Object objeto){
        this.descripcion = descripcion;
        this.objeto = objeto;
        this.fecha = new Date();
    }
    
    public String fechaCadena(){
        SimpleDateFormat df = new SimpleDateFormat("dd//MM/yyyy HH:mm:ss");
        String cadena = df.format(getFecha());
        return cadena;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }  
}
