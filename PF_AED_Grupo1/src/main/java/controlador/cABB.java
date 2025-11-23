
package controlador;

import modelo.cProducto;

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
    
    public void insertarNodoR(cNodo_ABB p, cNodo_ABB nuevo){
        if(p==null){
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
    public cProducto buscaIndexadoMonto(double monto){
        return buscaIndexadoMontoR(raiz, monto);
    }
    
    public cProducto buscaIndexadoMontoR(cNodo_ABB p, double monto){
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
    public cProducto buscaSecuencialCantidad(int cantidad){
        return buscaSecuencialCantidadR(raiz, cantidad);
    }
    
    public cProducto buscaSecuencialCantidadR(cNodo_ABB p, int cantidad){
        cProducto producto = null;
        if(p!=null){
            cProducto encontrado = buscaSecuencialCantidadR(p.getIzq(), cantidad);
            if(encontrado != null){
                producto = encontrado;
            }
            
            if(producto==null && p.getProducto().getCantidadVentas() == cantidad){
               producto = p.getProducto();
            }
            
            if(producto == null){
               producto = buscaSecuencialCantidadR(p.getDer(), cantidad);
            }
        }
        return producto;
    }
}
