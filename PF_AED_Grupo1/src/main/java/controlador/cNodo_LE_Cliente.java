
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cCliente;

public class cNodo_LE_Cliente {
    private cCliente valor;
    private cNodo_LE_Cliente sgte, ant;
    
    public cNodo_LE_Cliente(cCliente valor){
        this.valor = valor;
    }

    public cCliente getValor() {
        return valor;
    }

    public void setValor(cCliente valor) {
        this.valor = valor;
    }

    public cNodo_LE_Cliente getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_LE_Cliente sgte) {
        this.sgte = sgte;
    }

    public cNodo_LE_Cliente getAnt() {
        return ant;
    }

    public void setAnt(cNodo_LE_Cliente ant) {
        this.ant = ant;
    }
    
}
