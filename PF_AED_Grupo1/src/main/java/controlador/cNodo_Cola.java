
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cCliente;

public class cNodo_Cola {
    private cCliente valor;
    private cNodo_Cola sgte, ant;
    
    public cNodo_Cola(cCliente valor){
        this.valor = valor;
    }

    public cCliente getValor() {
        return valor;
    }

    public void setValor(cCliente valor) {
        this.valor = valor;
    }

    public cNodo_Cola getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_Cola sgte) {
        this.sgte = sgte;
    }

    public cNodo_Cola getAnt() {
        return ant;
    }

    public void setAnt(cNodo_Cola ant) {
        this.ant = ant;
    }
    
}
