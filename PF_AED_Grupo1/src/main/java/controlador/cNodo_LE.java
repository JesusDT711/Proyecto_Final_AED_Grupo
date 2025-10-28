
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cComprobante;

public class cNodo_LE {
    private cComprobante valor;
    private cNodo_LE sgte, ant;
    
    public cNodo_LE(cComprobante valor){
        this.valor = valor;
    }

    public cComprobante getValor() {
        return valor;
    }

    public void setValor(cComprobante valor) {
        this.valor = valor;
    }

    public cNodo_LE getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_LE sgte) {
        this.sgte = sgte;
    }

    public cNodo_LE getAnt() {
        return ant;
    }

    public void setAnt(cNodo_LE ant) {
        this.ant = ant;
    }
    
}
