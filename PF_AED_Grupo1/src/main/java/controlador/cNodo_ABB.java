
package controlador;

import modelo.cProducto;
/**
 *
 * @author Giuss
 */
public class cNodo_ABB {
    private cProducto producto;
    private cNodo_ABB izq,der;
    
    public cNodo_ABB(cProducto prod){
        this.producto = prod;
    }
    
    public cProducto getProducto(){
        return producto;
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
