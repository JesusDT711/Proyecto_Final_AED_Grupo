
package modelo;

/**
 *
 * @author Giuss
 */

import java.text.DecimalFormat;
import java.util.*;

public class cBoleta extends cComprobante{
    static int cuenta=1;

    public cBoleta(Date fecha, String cliente, String vendedor) {
        super(fecha, cliente, vendedor);
    }

    @Override
    public String generarCodigo() {
        DecimalFormat cod = new DecimalFormat("B000");
        return cod.format(cuenta++);
    }   
}
