
package controlador;

/**
 *
 * @author Giuss
 */
public class cPila {
    private int[] pila;
    private int tope;
    private int indMax;
    
    public cPila(int n){
        pila = new int[n];
        indMax = n-1;
        pilavacia();
    }
    
    public int getTope() {
        return tope;
    }
        
    public void pilavacia(){
        tope=-1;
    }
    
    public void insertar(int valor){
        if(tope < indMax){
            tope++;
            pila[tope]=valor;
        }
    }
    
    public int eliminar(){
        int valor=0;
        if(tope > -1){
            valor=pila[tope];
            tope--;
        }
        return valor;
    }
    
    public int accesar(){
        int valor=0;
        if(tope > -1){
            valor=pila[tope];
        }
        return valor;
    }
    
    public String muestraArreglo(){
        String cadena="Pila Vacia";
        if(tope > -1){
            cadena="";
            for(int i=0; i<=tope; i++){
                cadena += pila[i]+" - ";
            }
        }
        return cadena;
    }
}
