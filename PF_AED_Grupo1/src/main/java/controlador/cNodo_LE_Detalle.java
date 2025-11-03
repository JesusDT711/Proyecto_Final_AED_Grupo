
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cDetalle_Comprobante;

public class cNodo_LE_Detalle {
    private cDetalle_Comprobante valor;
    private cNodo_LE_Detalle sgte, ant;
    
    public cNodo_LE_Detalle(cDetalle_Comprobante valor){
        this.valor = valor;
    }

    public cDetalle_Comprobante getValor() {
        return valor;
    }

    public void setValor(cDetalle_Comprobante valor) {
        this.valor = valor;
    }

    public cNodo_LE_Detalle getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_LE_Detalle sgte) {
        this.sgte = sgte;
    }

    public cNodo_LE_Detalle getAnt() {
        return ant;
    }

    public void setAnt(cNodo_LE_Detalle ant) {
        this.ant = ant;
    }
    
}
