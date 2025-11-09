
package controlador;

/**
 *
 * @author Giuss
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.cCliente;

public class cCola_LE {
    private cNodo_Cola first, last, nuevo, p;

    public cCola_LE(){
        colaVacia();
    }
    
    public void colaVacia(){
        first=null;
        last=null;
    }
    
    public void incluir(cCliente valor){
        nuevo = new cNodo_Cola(valor);
        if(first == null){
            first = nuevo;
            last = nuevo;
        }else{
            last.setSgte(nuevo);
            last = nuevo;
        }
    }
    
    public cCliente eliminar(){
        cCliente valor=null;
        if(first != null){
            valor = first.getValor();
            first = first.getSgte();
            first.setAnt(null);
        }else{
            last = null;
        }
        return valor;
    }
    
    public cCliente acceso(){
        cCliente valor=null;
        if(first != null){
            valor = first.getValor();
        }
        return valor;
    }
    
    public void recorrerCola(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        p = first;
        while(p != null){
            cCliente cliente = p.getValor();
            Object[] fila = {
                cliente.getCodigo(),
                cliente.getRsocial(),
                cliente.getTelefono(),
                cliente.getDocIdentifica(),
                cliente.fecha_compraCadena(),
                cliente.tipoCadena(),
                cliente.getContacto()
            };
            modelo.addRow(fila);
            p = p.getSgte();
        }
    }
  
    public void recorrerColaP (JTable tabla){
        int tipo = 1;
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        dt.setRowCount(0);
        p = first;
        while(p != null){
            cCliente cliente = p.getValor();
            if (cliente.getTipo()==tipo) {
                Object[] fila = {
                    cliente.getCodigo(),
                    cliente.getRsocial(),
                    cliente.getTelefono(),
                    cliente.getDocIdentifica(),
                    cliente.fecha_compraCadena(),
                    cliente.tipoCadena(),
                    cliente.getContacto()
                };
                dt.addRow(fila);   
            }
            p = p.getSgte();
        }    
    }
 
    public void recorrerColaE (JTable tabla){
        int tipo = 2;
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        dt.setRowCount(0);
        p = first;
        while(p != null){
            cCliente cliente = p.getValor();
            if (cliente.getTipo()==tipo) {
                Object[] fila = {
                    cliente.getCodigo(),
                    cliente.getRsocial(),
                    cliente.getTelefono(),
                    cliente.getDocIdentifica(),
                    cliente.fecha_compraCadena(),
                    cliente.tipoCadena(),
                    cliente.getContacto()
                };
                dt.addRow(fila);    
            }
            p = p.getSgte();
        }    
    }
}
