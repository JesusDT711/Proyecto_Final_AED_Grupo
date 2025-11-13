
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
