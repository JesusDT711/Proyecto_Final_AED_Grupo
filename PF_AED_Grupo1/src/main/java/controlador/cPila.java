
package controlador;

import javax.swing.JComboBox;
import modelo.cTrabajador;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Giuss
 */
public class cPila {

    private cTrabajador[] pila;
    private int capacidad;
    private int tope;
    private int indMax;

    public cPila(int n) {
        this.capacidad = n;
        pila = new cTrabajador[n];
        indMax = n - 1;
        pilavacia();
    }

    public int getTope() {
        return tope;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void pilavacia() {
        tope = -1;
    }

    public void insertar(cTrabajador valor) {
        if (tope < indMax) {
            tope++;
            pila[tope] = valor;
        }
    }

    public cTrabajador eliminar() {
        cTrabajador valor = null;
        if (tope > -1) {
            valor = pila[tope];
            tope--;
        }
        return valor;
    }

    public cTrabajador accesar() {
        cTrabajador valor = null;
        if (tope > -1) {
            valor = pila[tope];
        }
        return valor;
    }

    public cTrabajador busqueda(String codigo) {
        cTrabajador trab = null;
        for (int i = 0; i <= tope; i++) {
            if (pila[i].getCodigo().equalsIgnoreCase(codigo)) {
                trab = pila[i];
            }
        }
        return trab;
    }

    public void recorrePila(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i <= tope; i++) {
            cTrabajador trabajador = pila[i];
            Object[] vec = {
                trabajador.getCodigo(),
                trabajador.getNombre(),
                trabajador.fecha_ingresoCadena(),
                trabajador.getSueldo(),
                trabajador.cargo()
            };
            modelo.addRow(vec);
        }
    }
}
