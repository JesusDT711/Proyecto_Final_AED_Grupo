
package controlador;

import modelo.cAccion;
/**
 *
 * @author Giuss
 */
public class cNodo_Pila {
    private cAccion valor;
    private cNodo_Pila sgte;
    
    public cNodo_Pila(cAccion valor){
        this.valor = valor;
    }

    public cAccion getValor() {
        return valor;
    }

    public void setValor(cAccion valor) {
        this.valor = valor;
    }

    public cNodo_Pila getSgte() {
        return sgte;
    }

    public void setSgte(cNodo_Pila sgte) {
        this.sgte = sgte;
    }
}
