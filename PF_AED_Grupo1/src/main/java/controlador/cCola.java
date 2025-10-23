
package controlador;

/**
 *
 * @author Giuss
 */
public class cCola {
    private int cola[];
    private int first, last;
    private int tamanio;
    public cCola(int n){
        cola = new int[n];
        tamanio = n-1;
        colaVacia();
    }
    
    public void colaVacia(){
        first=-1; last=-1;
    }
    
    public void incluir(int valor){
        if(last < tamanio){
            last++;
            cola[last]=valor;
            if(first==-1){
                first=0;
            }
        }
    }
    
    public void insertarRandom(){
        if(last < tamanio){
            last++;
            int valor = (int)(Math.random()*(30-2+1)+2);
            cola[last]=valor;
            if(first==-1){
                first=0;
            }
        }
    }
    
    public int eliminar(){
        int valor=0;
        if(first >=0){
            valor = cola[first];
            first++;
            if(first > last){
                colaVacia();
            }
        }
        return valor;
    }
    
    public int eliminarParImpar(){
        int valor=0;
        if(first >=0){
            valor = cola[first];
            first++;
            if(valor%2!=0){
                incluir(valor);
            }
            if(first > last){
                colaVacia();
            }
            
        }
        return valor;
    }
    
    public int acceso(){
        int valor=0;
        if(first >=0){
            valor = cola[first];
        }
        return valor;
    }
    
    public String recorrerArreglo(){
        String cadena="Cola Vacia";
        if(first >= 0){
            cadena="";
            for(int i = first; i <= last; i++){
                cadena+=cola[i]+" - ";
            }
        }
        return cadena;
    }
}
