
package controlador;

import modelo.cAccion;
/**
 *
 * @author Giuss
 */
public class cPila {

    private cNodo_Pila tope;

    public cPila() {
        this.tope = null;
    }

    public void apilar(cAccion valor) {
        cNodo_Pila nuevo = new cNodo_Pila(valor);
        nuevo.setSgte(tope);
        tope = nuevo;
    }

    public cAccion desapilar() {
        cAccion accion=null;
        if(tope != null){
            accion = tope.getValor();
            tope = tope.getSgte();
        }
        return accion;
    }

    public cAccion verTope() {
        cAccion accion=null;
        if(tope != null){
            accion = tope.getValor();
        }
        return accion;
    }
}
