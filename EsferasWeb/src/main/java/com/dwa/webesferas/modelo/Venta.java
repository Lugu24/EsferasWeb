// Generated with g9.

package com.dwa.webesferas.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="venta")
public class Venta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idventa";
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Idventa", unique=true, nullable=false, precision=10)
    private int idventa;
    @Column(name="Fecha", nullable=false)
    private LocalDate fecha;
    @Column(name="Total", nullable=false, precision=10)
    private BigDecimal total;
    @ManyToOne(optional=false)
    @JoinColumn(name="Idcliente", nullable=false)
    private Cliente cliente;
    @ManyToOne(optional=false)
    @JoinColumn(name="Idproducto", nullable=false)
    private Producto producto;

    /** Default constructor. */
    public Venta() {
        super();
    }

    /**
     * Access method for idventa.
     *
     * @return the current value of idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * Setter method for idventa.
     *
     * @param aIdventa the new value for idventa
     */
    public void setIdventa(int aIdventa) {
        idventa = aIdventa;
    }

    /**
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(LocalDate aFecha) {
        fecha = aFecha;
    }

    /**
     * Access method for total.
     *
     * @return the current value of total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Setter method for total.
     *
     * @param aTotal the new value for total
     */
    public void setTotal(BigDecimal aTotal) {
        total = aTotal;
    }

    /**
     * Access method for cliente.
     *
     * @return the current value of cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Setter method for cliente.
     *
     * @param aCliente the new value for cliente
     */
    public void setCliente(Cliente aCliente) {
        cliente = aCliente;
    }

    /**
     * Access method for producto.
     *
     * @return the current value of producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Setter method for producto.
     *
     * @param aProducto the new value for producto
     */
    public void setProducto(Producto aProducto) {
        producto = aProducto;
    }

    /**
     * Compares the key for this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Venta and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Venta)) {
            return false;
        }
        Venta that = (Venta) other;
        if (this.getIdventa() != that.getIdventa()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Venta)) return false;
        return this.equalKeys(other) && ((Venta)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdventa();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Venta |");
        sb.append(" idventa=").append(getIdventa());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idventa", Integer.valueOf(getIdventa()));
        return ret;
    }

}
