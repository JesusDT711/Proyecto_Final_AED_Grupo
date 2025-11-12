
package controlador;

/**
 *
 * @author Giuss
 */

import javax.swing.table.DefaultTableModel;
import modelo.cComprobante;

public class cCola {
    private cComprobante[] cola;
    private int frente;
    private int fin;
    private int tamañoMax;
    private int nElementos;

    public cCola(int tamañoMax) {
        this.tamañoMax = tamañoMax;
        this.cola = new cComprobante[tamañoMax];
        this.frente = 0;
        this.fin = -1;
        this.nElementos = 0;
    }

    public boolean encolar(cComprobante comprobante) {
        boolean exito = false; 
        
        if (!estaLlena()) {
            if (fin == tamañoMax - 1) {
                fin = -1;
            }
            
            fin++;
            cola[fin] = comprobante;
            nElementos++;
            
            exito = true; 
        }
        return exito;
    }

    public cComprobante desencolar() {
        cComprobante temp = null; 
        
        if (!estaVacia()) {
            temp = cola[frente];
            frente++;
            
            if (frente == tamañoMax) {
                frente = 0;
            }
            
            nElementos--;
        }
        return temp;
    }

    public boolean estaVacia() {
        boolean res=false;
        if(nElementos!=0){
            res=true;
        }
        return res;
    }

    public boolean estaLlena() {
        boolean res=false;
        if(nElementos < tamañoMax){
            res=true;
        }
        return res;
    }

    public void recorrerCola() {
     
    }
}
    
