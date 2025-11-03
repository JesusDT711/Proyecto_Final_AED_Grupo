
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cComprobante;

public class cNodo_LE_Comprobante {
    private cComprobante valor;
    private cNodo_LE_Comprobante sgte, ant;
    
    public cNodo_LE_Comprobante(cComprobante valor){
        this.valor = valor;
    }

    public cComprobante getValor() {
        return valor;
    }

    public void setValor(cComprobante valor) {
        this.valor = valor;
    }

    public cNodo_LE_Comprobante getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_LE_Comprobante sgte) {
        this.sgte = sgte;
    }

    public cNodo_LE_Comprobante getAnt() {
        return ant;
    }

    public void setAnt(cNodo_LE_Comprobante ant) {
        this.ant = ant;
    }
    
}
