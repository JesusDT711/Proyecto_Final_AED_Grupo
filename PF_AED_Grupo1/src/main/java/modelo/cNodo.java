
package modelo;

/**
 *
 * @author Giuss
 */
public class cNodo {
    private cComprobante valor;
    private cNodo sgte, ant;
    
    public cNodo(cComprobante valor){
        this.valor = valor;
    }

    public cComprobante getValor() {
        return valor;
    }

    public void setValor(cComprobante valor) {
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
