
package clases;

/**
 *
 * @author a18danielmr
 */
public class CocheVenta extends Coche{
    
    private float precio;

    public CocheVenta() {
    }

    public CocheVenta(float precio, String codigo, String marca, String modelo) {
        super(codigo, marca, modelo);
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
