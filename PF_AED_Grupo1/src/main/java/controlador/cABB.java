
package controlador;

import modelo.cProducto;
import javax.swing.JTextArea;

/**
 *
 * @author Giuss
 */
public class cABB {
    private cNodo_ABB raiz,nuevo,p;
    
    public cABB(){
        raiz=null;
    }
    
    //Inserción por Total de Ventas
    public void insertarNodo(cProducto valor){
        nuevo = new cNodo_ABB(valor);
        if(raiz==null){
            raiz=nuevo;
        }else{
            p = raiz;
            insertarNodoR(p, nuevo);
        }
    }
    
    private void insertarNodoR(cNodo_ABB p, cNodo_ABB nuevo){
        if(p == null){
            p = nuevo;
        }else{
            if(nuevo.getProducto().getTotalVentas() < p.getProducto().getTotalVentas()){
                if(p.getIzq() == null){
                    p.setIzq(nuevo);
                }else{
                    insertarNodoR(p.getIzq(),nuevo);
                }
            }else{
                if(p.getDer() == null){
                    p.setDer(nuevo);
                }else{
                    insertarNodoR(p.getDer(),nuevo);
                } 
            }
        }
    }
    
    //Búsqueda Indexada
    
    //Coincidencia exacta al monto ingresado
    public void buscaIndexadoMonto(double monto, JTextArea txtArea){
        cProducto producto = buscaIndexadoMontoR(raiz, monto);
        if(producto != null){
            txtArea.setText("Código: "+producto.getCodigo());
            txtArea.append("\nDescripción: "+producto.getDescripcion());
            txtArea.append("\nPrecio: "+producto.getPrecio());
            txtArea.append("\nStock Actual: "+producto.getStock());
            txtArea.append("\nCantidad Vendida: "+producto.getCantidadVentas());
            txtArea.append("\nTotal Vendido: "+producto.getTotalVentas());  
        }else{
            txtArea.setText("No hay producto que coincida con ese monto.");
        }
    }
    
    private cProducto buscaIndexadoMontoR(cNodo_ABB p, double monto){
        cProducto producto = null;
        if(p != null){
            if(p.getProducto().getTotalVentas() == monto){
                producto = p.getProducto();
            }else if(monto < p.getProducto().getTotalVentas()){
                producto = buscaIndexadoMontoR(p.getIzq(), monto);
            }else{
                producto = buscaIndexadoMontoR(p.getDer(), monto);
            }
        }
        return producto;
    }
    
    
    //Búsqueda Secuencial (inOrden)
    
    //Menores al monto ingresado
    public void buscaMenoresMonto(double monto, JTextArea txtArea){
        txtArea.setText("");
        buscaMenoresMontoR(raiz, monto, txtArea);

        if(txtArea.getText().isEmpty()){
            txtArea.setText("No hay productos con un monto menor al ingresado.");
        } 
    }

    private void buscaMenoresMontoR(cNodo_ABB p, double monto, JTextArea txtArea){
        if(p != null){
            buscaMenoresMontoR(p.getIzq(), monto, txtArea);

            if(p.getProducto().getTotalVentas() < monto){
                cProducto producto = p.getProducto();
                txtArea.append("Código: "+producto.getCodigo());
                txtArea.append("\nDescripción: "+producto.getDescripcion());
                txtArea.append("\nPrecio: "+producto.getPrecio());
                txtArea.append("\nStock Actual: "+producto.getStock());
                txtArea.append("\nCantidad Vendida: "+producto.getCantidadVentas());
                txtArea.append("\nTotal Vendido: "+producto.getTotalVentas());
                txtArea.append("\n========================================\n\n");
            }

            buscaMenoresMontoR(p.getDer(), monto, txtArea);
        }
    }

    
    //Menores al monto ingresado
    public void buscaMayoresMonto(double monto, JTextArea txtArea){
        txtArea.setText("");
        buscaMayoresMontoR(raiz, monto, txtArea);

        if(txtArea.getText().isEmpty()){
            txtArea.setText("No hay productos con un monto mayor al ingresado.");
        } 
    }

    private void buscaMayoresMontoR(cNodo_ABB p, double monto, JTextArea txtArea){
        if(p != null){
            buscaMayoresMontoR(p.getIzq(), monto, txtArea);
            if(p.getProducto().getTotalVentas() > monto){
                cProducto producto = p.getProducto();
                txtArea.append("Código: "+producto.getCodigo());
                txtArea.append("\nDescripción: "+producto.getDescripcion());
                txtArea.append("\nPrecio: "+producto.getPrecio());
                txtArea.append("\nStock Actual: "+producto.getStock());
                txtArea.append("\nCantidad Vendida: "+producto.getCantidadVentas());
                txtArea.append("\nTotal Vendido: "+producto.getTotalVentas());
                txtArea.append("\n========================================\n\n");
            }
            buscaMayoresMontoR(p.getDer(), monto, txtArea);
        }
    } 
}
