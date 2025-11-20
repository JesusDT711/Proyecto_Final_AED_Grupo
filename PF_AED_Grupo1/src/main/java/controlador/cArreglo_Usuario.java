
package controlador;

import modelo.cUsuario;
/**
 *
 * @author Giuss
 */
public class cArreglo_Usuario {
    private cUsuario[] usuarios;
    private int n;
    private int total;
    
    public cArreglo_Usuario(int total){
        this.total = total;
        this.usuarios = new cUsuario[this.total];
        this.n = 0;
    }
    
    public boolean agregar(cUsuario u) {
        boolean exito = false;
        if (this.n < this.total) {
            this.usuarios[this.n] = u;
            this.n++;
            exito = true;
        }
        return exito;
    }

    public cUsuario buscar(String usuario, String contraseña) {
        cUsuario usuarioEncontrado = null;
        int i = 0;
        boolean encontrado = false;
        while (i < this.n && !encontrado) {
            if (this.usuarios[i].getUsuario().equalsIgnoreCase(usuario) && this.usuarios[i].getContraseña().equalsIgnoreCase(contraseña)){
                usuarioEncontrado = this.usuarios[i];
                encontrado = true;
            }
            i++; 
        }
        return usuarioEncontrado;
    }
}
