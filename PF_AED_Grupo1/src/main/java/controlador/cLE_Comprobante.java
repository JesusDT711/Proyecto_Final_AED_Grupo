
package controlador;

/**
 *
 * @author Giuss
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.cComprobante;

public class cLE_Comprobante {
    private cNodo_LE_Comprobante inicio, nuevo, p, q;
    
    public void insertarxFinal(cComprobante valor){
        nuevo = new cNodo_LE_Comprobante(valor);
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
    
    public void recorreLE(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cComprobante comprobante = p.getValor();
            Object[] fila = {
                comprobante.getCodigo(),
                comprobante.fechaCadena(),
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
