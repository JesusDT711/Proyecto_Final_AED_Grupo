
package modelo;

/**
 *
 * @author Giuss
 */
public class cNodo {
    private cProducto valor;
    private cNodo sgte, ant;
    
    public cNodo(cProducto valor){
        this.valor = valor;
    }

    public cProducto getValor() {
        return valor;
    }

    public void setValor(cProducto valor) {
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
