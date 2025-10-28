
package modelo;

/**
 *
 * @author Giuss
 */

import java.text.DecimalFormat;
import java.util.*;

public class cFactura extends cComprobante{
    static int cuenta=1;
    
    public cFactura(Date fecha, String cliente, String vendedor) {
        super(fecha, cliente, vendedor);
    }

    @Override
    public String generarCodigo() {
        DecimalFormat cod = new DecimalFormat("F000");
        return cod.format(cuenta++);
    }
    
}
