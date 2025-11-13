package controlador;

/**
 *
 * @author Giuss
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import modelo.cBoleta;
import modelo.cComprobante;
import modelo.cFactura;

public class cLE_Comprobante {
    private cNodo_LE_Comprobante inicio, nuevo, p, q;
    
    public void insertarxInicio(cComprobante valor){
        nuevo = new cNodo_LE_Comprobante(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            nuevo.setSgte(inicio);
            inicio.setAnt(nuevo);
            inicio=nuevo;
        }
    }
    
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
    
    public void insertaEntreNodosSgte(cComprobante valor, String desde){
        nuevo = new cNodo_LE_Comprobante(valor);
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
                nuevo.setAnt(p);
                p.getSgte().setAnt(nuevo);
            }
        }
    }
    
    public void insertaEntreNodosAnt(cComprobante valor, String antes){
        nuevo = new cNodo_LE_Comprobante(valor);
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
                p.setAnt(nuevo);  
                nuevo.setAnt(q);
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
    
    public cComprobante busqueda(String valor){
        cComprobante compro =null;
        if(inicio != null){
            p = inicio;
            while(!p.getValor().getCodigo().equalsIgnoreCase(valor) && p.getSgte() != null){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(valor)){
                compro=p.getValor();
            }
        }
        return compro;
    }
    
    public void recorreLE(JTable tabla){
        DecimalFormat df = new DecimalFormat("#.00");
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cComprobante comprobante = p.getValor();
            Object[] fila = {
                comprobante.getCodigo(),
                comprobante.fechaCadena(),
                comprobante.getCliente(),
                comprobante.getVendedor(),
                df.format(comprobante.getSubTotal()),
                df.format(comprobante.getTotal())
            };
            modelo.addRow(fila);
            p = p.getSgte();
        }
    }
    
    public void recorreLEBoleta(JTable tabla){
        DecimalFormat df = new DecimalFormat("#.00");
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cComprobante comprobante = p.getValor();
            if(comprobante instanceof cBoleta){
                Object[] fila = {
                    comprobante.getCodigo(),
                    comprobante.fechaCadena(),
                    comprobante.getCliente(),
                    comprobante.getVendedor(),
                    df.format(comprobante.getSubTotal()),
                    df.format(comprobante.getTotal())
                };
                modelo.addRow(fila);
            }
            p = p.getSgte();
        }
    }
    
    public void recorreLEFactura(JTable tabla){
        DecimalFormat df = new DecimalFormat("#.00");
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cComprobante comprobante = p.getValor();
            if(comprobante instanceof cFactura){
                Object[] fila = {
                    comprobante.getCodigo(),
                    comprobante.fechaCadena(),
                    comprobante.getCliente(),
                    comprobante.getVendedor(),
                    df.format(comprobante.getSubTotal()),
                    df.format(comprobante.getTotal())
                };
                modelo.addRow(fila);
            }
            p = p.getSgte();
        }
    }
}
