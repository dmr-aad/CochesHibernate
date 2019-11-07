
package clases;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a18danielmr
 */
public class Empresa implements Serializable{
    
    private String cif;
    private String nombre;
    private int telefono;
    private Set<Coche> coches;

    public Empresa() {
    }

    public Empresa(String cif, String nombre, int telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.coches = new HashSet<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Set<Coche> getCoches() {
        return coches;
    }

    public void setCoches(Set<Coche> coches) {
        this.coches = coches;
    }
    
    
}
