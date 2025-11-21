
package controlador;

import modelo.cTrabajador;
/**
 *
 * @author Giuss
 */
public class cNodo_ABB {
    private cTrabajador trabajador;
    private cNodo_ABB izq,der;
    
    public cNodo_ABB(cTrabajador trab){
        this.trabajador = trab;
    }
    
    public cTrabajador getTrabajador(){
        return trabajador;
    }
    
    public cNodo_ABB getIzq(){
        return izq;
    }
    
    public void setIzq(cNodo_ABB izq){
        this.izq= izq;
    }

    public cNodo_ABB getDer() {
        return der;
    }

    public void setDer(cNodo_ABB der) {
        this.der = der;
    }
}
