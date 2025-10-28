
package modelo;

/**
 *
 * @author Giuss
 */

import java.text.DecimalFormat;
import java.util.*;
import java.text.SimpleDateFormat;

public class cTrabajador {
    private String codigo;
    private String nombre;
    private Date fecha_ingreso;
    private double sueldo;
    private int tipo; //1=Administrador , 2=Cajero o 3=Reponedor
    static int cuenta=1;
    
    public cTrabajador(){
        DecimalFormat cod = new DecimalFormat("V000");
        this.codigo = cod.format(cuenta++);
    }
    
    public cTrabajador(String nombre, Date fecha_ingreso, int tipo){
        this();
        this.nombre = nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.sueldo = sueldoxTipo();
        this.tipo = tipo;
    }
    
    public double sueldoxTipo(){
        double[] vec = {0,3000,2050,1250};
        return vec[tipo];
    }
    
    //Esta función se usará para mostrarse en el JTable de Vendedores
    public String cargo(){
        String[] vec = {"","Administrador","Cajero","Reponedor"};
        return vec[tipo];
    }
    
    public String fecha_ingresoCadena(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String cadena = sdf.format(getFecha_ingreso());
        return cadena;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
