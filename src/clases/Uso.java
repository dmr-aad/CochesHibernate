
package clases;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author a18danielmr
 */
public class Uso implements Serializable{
    
    private String codigo;
    private Date fechaAlquiler;
    private Date fechaEntrega;
    private float importe;
    private CocheAlquiler coche;

    public Uso() {
    }

    public Uso(String codigo, Date fechaAlquiler, Date fechaEntrega, float importe) {
        this.codigo = codigo;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.importe = importe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public CocheAlquiler getCoche() {
        return coche;
    }

    public void setCoche(CocheAlquiler coche) {
        this.coche = coche;
    }
    
    
}
