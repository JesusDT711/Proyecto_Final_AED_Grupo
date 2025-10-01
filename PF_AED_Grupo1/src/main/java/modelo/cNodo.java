
package modelo;

/**
 *
 * @author Giuss
 */
public class cNodo {
    private int valor;
    private cNodo sgte, ant;
    
    public cNodo(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public cNodo getSgte() {
        return sgte;
    }

    public void setSgte(cNodo sgte) {
        this.sgte = sgte;
    }

    public cNodo getAnt() {
        return ant;
    }

    public void setAnt(cNodo ant) {
        this.ant = ant;
    }
    
}
