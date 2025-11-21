
package controlador;

import modelo.cTrabajador;
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
    public void insertarNodo(cTrabajador valor){
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
            if(nuevo.getTrabajador().getTotalVentas() < p.getTrabajador().getTotalVentas()){
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
    public cTrabajador buscaIndexadoMonto(double monto){
        return buscaIndexadoMontoR(raiz, monto);
    }
    
    public cTrabajador buscaIndexadoMontoR(cNodo_ABB p, double monto){
        cTrabajador trabajador = null;
        if(p != null){
            if(p.getTrabajador().getTotalVentas() == monto){
                trabajador = p.getTrabajador();
            }else if(monto < p.getTrabajador().getTotalVentas()){
                trabajador = buscaIndexadoMontoR(p.getIzq(), monto);
            }else{
                trabajador = buscaIndexadoMontoR(p.getDer(), monto);
            }
        }
        return trabajador;
    }
    
    
    //Búsqueda Secuencial (inOrden)
    public cTrabajador buscaSecuencialCantidad(int cantidad){
        return buscaSecuencialCantidadR(raiz, cantidad);
    }
    
    public cTrabajador buscaSecuencialCantidadR(cNodo_ABB p, int cantidad){
        cTrabajador trababajador = null;
        if(p!=null){
            cTrabajador encontrado = buscaSecuencialCantidadR(p.getIzq(), cantidad);
            if(encontrado != null){
                trababajador = encontrado;
            }
            
            if(trababajador==null && p.getTrabajador().getCantidadVentas() == cantidad){
               trababajador = p.getTrabajador();
            }
            
            if(trababajador == null){
               trababajador = buscaSecuencialCantidadR(p.getDer(), cantidad);
            }
        }
        return trababajador;
    }
}
