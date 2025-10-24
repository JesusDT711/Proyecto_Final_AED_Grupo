
package controlador;

/**
 *
 * @author Giuss
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;

public class cListaEnlazada {
    private cNodo inicio, nuevo, p, q;
    //josejeri
    public void insertarxInicio(cComprobante valor){
        nuevo = new cNodo(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            nuevo.setSgte(inicio);
            inicio=nuevo;
        }
    }
    
    public void insertarxFinal(cComprobante valor){
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
    
    
    public void insertaEntreNodosSgte(cComprobante valor, String desde){
        nuevo = new cNodo(valor);
        if(inicio == null){
            inicio = nuevo;
        }else{
            p=inicio;
            while(p.getSgte() != null && !p.getValor().getCodigo().equals(desde)){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(desde)){
                nuevo.setSgte(p.getSgte());
                p.setSgte(nuevo);
            }
        }
    }
    
    public void insertaEntreNodosAnt(cComprobante valor, String antes){
        nuevo = new cNodo(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            p=inicio; q=inicio;
            while(p.getSgte() != null && !p.getValor().getCodigo().equals(antes)){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(antes)){
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
            while(!p.getValor().getCodigo().equals(valor) && p.getSgte() != null){
                q = p;
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(valor)){
                q.setSgte(p.getSgte());
            }
        }
        
    }
    
    //Modificado según la clase cProducto y para usarse en un JTable
    public void recorreLE(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cComprobante comprobante = p.getValor();
            Object[] fila = {
                comprobante.getCodigo(),
                comprobante.getFecha(),
                comprobante.getCliente(),
                comprobante.getVendedor()
            };
            modelo.addRow(fila);
            p = p.getSgte();
        }
    }
    
    public boolean busqueda(String valor){
        boolean res=false;
        if(inicio != null){
            p = inicio;
            while(!p.getValor().getCodigo().equals(valor) && p.getSgte() != null){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(valor)){
                res=true;
            }
        }
        return res;
    }  
}
