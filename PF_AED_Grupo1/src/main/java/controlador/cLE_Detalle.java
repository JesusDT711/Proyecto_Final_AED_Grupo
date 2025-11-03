
package controlador;

/**
 *
 * @author Giuss
 */

import modelo.cDetalle_Comprobante;

public class cLE_Detalle {
    private cNodo_LE_Detalle inicio, nuevo, p, q;
    //jose
    public void insertarxInicio(cDetalle_Comprobante valor){
        nuevo = new cNodo_LE_Detalle(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            nuevo.setSgte(inicio);
            inicio=nuevo;
        }
    }
    
    public void insertarxFinal(cDetalle_Comprobante valor){
        nuevo = new cNodo_LE_Detalle(valor);
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
    
    
    public void insertaEntreNodosSgte(cDetalle_Comprobante valor, String desde){
        nuevo = new cNodo_LE_Detalle(valor);
        if(inicio == null){
            inicio = nuevo;
        }else{
            p=inicio;
            while(p.getSgte() != null && !p.getValor().getCodigo().equalsIgnoreCase(desde)){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equalsIgnoreCase(desde)){
                nuevo.setSgte(p.getSgte());
                p.setSgte(nuevo);
            }
        }
    }
    
    public void insertaEntreNodosAnt(cDetalle_Comprobante valor, String antes){
        nuevo = new cNodo_LE_Detalle(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            p=inicio; q=inicio;
            while(p.getSgte() != null && !p.getValor().getCodigo().equalsIgnoreCase(antes)){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equalsIgnoreCase(antes)){
                nuevo.setSgte(p);
                q.setSgte(nuevo);
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
    
    public void eliminaEntreNodos(String valor){
        if(inicio != null){
            p = inicio; q = inicio;
            while(!p.getValor().getCodigo().equalsIgnoreCase(valor) && p.getSgte() != null){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equalsIgnoreCase(valor)){
                q.setSgte(p.getSgte());
            }
        }
        
    }
    
    
    public boolean busqueda(String valor){
        boolean res=false;
        if(inicio != null){
            p = inicio;
            while(!p.getValor().getCodigo().equalsIgnoreCase(valor) && p.getSgte() != null){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(valor)){
                res=true;
            }
        }
        return res;
    }  
}
