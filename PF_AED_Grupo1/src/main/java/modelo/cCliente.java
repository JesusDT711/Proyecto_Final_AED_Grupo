
package modelo;

/**
 *
 * @author Giuss
 */

import java.text.DecimalFormat;

public class cCliente {
    private String codigo;
    private String rsocial;
    private int telefono;
    private int docIdentifica;
    private String fecha_compra;
    private int tipo; //1=Persona Natural o 2=Empresa
    private String contacto;
    static int cuenta=1;
    
    public cCliente(){
        DecimalFormat cod = new DecimalFormat("C000");
        this.codigo = cod.format(cuenta++);
    }
    
    public cCliente(String rsocial, int telefono, int docIdentifica, String fecha_compra, int tipo, String contacto){
        this();
        this.rsocial = rsocial;
        this.telefono = telefono;
        this.docIdentifica = docIdentifica;
        this.fecha_compra = fecha_compra;
        this.tipo = tipo;
        this.contacto = contacto;
    }
    
    public String tipoCadena(){
        String[] vec = {"","Persona Natural","Empresa"};
        return vec[tipo];
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDocIdentifica() {
        return docIdentifica;
    }

    public void setDocIdentifica(int docIdentifica) {
        this.docIdentifica = docIdentifica;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
