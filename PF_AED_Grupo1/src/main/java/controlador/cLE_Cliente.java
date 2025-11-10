
package controlador;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.cCliente;
        
/**
 *
 * @author Giuss
 */
public class cLE_Cliente {
    private cNodo_LE_Cliente inicio,nuevo,p,q;
    
    public void insertarxInicio(cCliente valor){
        nuevo = new cNodo_LE_Cliente(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            nuevo.setSgte(inicio);
            inicio.setAnt(nuevo);
            inicio=nuevo;
        }
    }
    
    public void insertarxFinal(cCliente valor){
        nuevo = new cNodo_LE_Cliente(valor);
        if(inicio==null){
            inicio = nuevo;
        }else{
            p=inicio;
            while(p.getSgte()!=null){
                p = p.getSgte();
            }
            p.setSgte(nuevo);
            nuevo.setAnt(p);
        }
    }
    
    
    public void insertaEntreNodosSgte(cCliente valor, String desde){
        nuevo = new cNodo_LE_Cliente(valor);
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
    
    public void insertaEntreNodosAnt(cCliente valor, String antes){
        nuevo = new cNodo_LE_Cliente(valor);
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
    
    public void eliminaxInicio(){
        if(inicio != null){
            if(inicio.getSgte()==null){
                inicio=null;
            }else{
                inicio = inicio.getSgte();
                inicio.setAnt(null);
            } 
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
                p=null;
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
                p.getSgte().setAnt(q);
            }
        }
        
    }
    
    public void llenarComboClientes(JComboBox combo){
        combo.removeAllItems();
        combo.addItem("Elegir");
        p = inicio;
        while(p != null){
            cCliente cliente = p.getValor();
            combo.addItem(cliente.getCodigo());
            p = p.getSgte();
        }
    }
        
    public void recorrerLE(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cCliente cliente = p.getValor();
            Object[] vec = {
                cliente.getCodigo(),
                cliente.getRsocial(),
                cliente.getTelefono(),
                cliente.getDocIdentifica(),
                cliente.fecha_compraCadena(),
                cliente.tipoCadena(),
                cliente.getContacto()
            };
            modelo.addRow(vec);
            p = p.getSgte();
        }
    }
    
    public void recorrerLeP(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cCliente cliente = p.getValor();
            if(cliente.getTipo()==1){
                Object[] vec = {
                    cliente.getCodigo(),
                    cliente.getRsocial(),
                    cliente.getTelefono(),
                    cliente.getDocIdentifica(),
                    cliente.fecha_compraCadena(),
                    cliente.tipoCadena(),
                    cliente.getContacto()
                };
                modelo.addRow(vec);
            }
            p = p.getSgte();
        }
    }
    
    public void recorrerLeE(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        p = inicio;
        while(p != null){
            cCliente cliente = p.getValor();
            if(cliente.getTipo()==2){
                Object[] vec = {
                    cliente.getCodigo(),
                    cliente.getRsocial(),
                    cliente.getTelefono(),
                    cliente.getDocIdentifica(),
                    cliente.fecha_compraCadena(),
                    cliente.tipoCadena(),
                    cliente.getContacto()
                };
                modelo.addRow(vec);
            }
            p = p.getSgte();
        }
    }
    
     public cCliente busqueda(String valor){
        cCliente cliente =null;
        if(inicio != null){
            p = inicio;
            while(!p.getValor().getCodigo().equalsIgnoreCase(valor) && p.getSgte() != null){
                p = p.getSgte();
            }
            if(p.getValor().getCodigo().equals(valor)){
                cliente = p.getValor();
            }
        }
        return cliente;
    }  
}
