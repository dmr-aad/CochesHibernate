
package clases;

import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author a18danielmr
 */
public class CocheAlquiler extends Coche{
    
    private float precio;
    private char estado;
    private Set<Uso> usos;

    public CocheAlquiler() {
    }

    public CocheAlquiler(float precio, char estado, String codigo, String marca, String modelo) {
        super(codigo, marca, modelo);
        this.precio = precio;
        this.estado = estado;
        this.usos = new HashSet<>();
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Set<Uso> getUsos() {
        return usos;
    }

    public void setUsos(Set<Uso> usos) {
        this.usos = usos;
    }
    
    
}
