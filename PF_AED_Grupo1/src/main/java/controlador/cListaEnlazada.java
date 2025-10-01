
package controlador;

/**
 *
 * @author Giuss
 */
import modelo.*;
public class cListaEnlazada {
    private cNodo inicio, nuevo, p, q;
    
    public void insertarxInicio(int valor){
        nuevo = new cNodo(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            nuevo.setSgte(inicio);
            inicio=nuevo;
        }
    }
    
    public void insertarxFinal(int valor){
        nuevo = new cNodo(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            p=inicio;
            while(p.getSgte()!=null){
                p = p.getSgte();
            }
            p.setSgte(nuevo);
        }
    }
    
    
    public void insertaEntreNodosSgte(int valor, int desde){
        nuevo = new cNodo(valor);
        if(inicio == null){
            inicio = nuevo;
        }else{
            p=inicio;
            while(p.getSgte() != null && p.getValor() != desde){
                p = p.getSgte();
            }
            if(p.getValor()==desde){
                nuevo.setSgte(p.getSgte());
                p.setSgte(nuevo);
            }
        }
    }
    
    public void insertaEntreNodosAnt(int valor, int antes){
        nuevo = new cNodo(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            p=inicio; q=inicio;
            while(p.getSgte() != null && p.getValor() != antes){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor()==antes){
                nuevo.setSgte(p);
                q.setSgte(nuevo);
            }
        }
    }
    
    public void insertarDigitos(int valor){
        nuevo = new cNodo(valor);
        int num = Math.abs(nuevo.getValor());
        if(num==0){
            insertarxInicio(0);
        }else{
            while(num>0){
                int digito = num % 10;
                insertarxInicio(digito);
                num = num/10;
            }
        }
    }
    
    public void eliminaxInicio(){
        if(inicio != null){
            inicio = inicio.getSgte();
        }
    }
    
    public void eliminaxFinal(){
        if(inicio != null){
            if(inicio.getSgte()==null){
                inicio=null;
            }else{
                p = inicio; q = inicio;
                while(p.getSgte() != null){
                    q = p;
                    p = p.getSgte();
                }
                q.setSgte(null);
            }  
        }
    }
    
    public void eliminaEntreNodos(int valor){
        if(inicio != null){
            p = inicio; q = inicio;
            while(p.getValor() != valor && p.getSgte() != null){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor() == valor){
                q.setSgte(p.getSgte());
            }
        }
        
    }
    
    public String recorreLE(){
        String cadena="";
        p = inicio;
        while(p != null){
            cadena += p.getValor()+" - ";
            p = p.getSgte();
        }
        return cadena;
    }
    
    public boolean busqueda(int valor){
        boolean res=false;
        if(inicio != null){
            p = inicio;
            while(p.getValor() != valor && p.getSgte() != null){
                p = p.getSgte();
            }
            if(p.getValor()==valor){
                res=true;
            }
        }
        return res;
    }
    
    
}
