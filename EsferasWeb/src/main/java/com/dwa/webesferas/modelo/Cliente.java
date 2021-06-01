// Generated with g9.

package com.dwa.webesferas.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Cliente")
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idcliente";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Idcliente", unique=true, nullable=false, precision=10)
    private int idcliente;
    @Column(name="Nombre", nullable=false, length=40)
    private String nombre;
    @Column(name="Direccion", nullable=false, length=40)
    private String direccion;
    @Column(name="Telefono", nullable=false, length=15)
    private String telefono;
    @Column(name="Sexo", nullable=false, length=10)
    private String sexo;
    @Column(name="Contrasena", nullable=false, length=20)
    private byte[] contrasena;
    @Column(name="Correo", nullable=false, length=50)
    private String correo;
    @OneToMany(mappedBy="cliente")
    private Set<Venta> venta;

    /** Default constructor. */
    public Cliente() {
        super();
    }

    /**
     * Access method for idcliente.
     *
     * @return the current value of idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * Setter method for idcliente.
     *
     * @param aIdcliente the new value for idcliente
     */
    public void setIdcliente(int aIdcliente) {
        idcliente = aIdcliente;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for sexo.
     *
     * @return the current value of sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Setter method for sexo.
     *
     * @param aSexo the new value for sexo
     */
    public void setSexo(String aSexo) {
        sexo = aSexo;
    }

    /**
     * Access method for contrasena.
     *
     * @return the current value of contrasena
     */
    public byte[] getContrasena() {
        return contrasena;
    }

    /**
     * Setter method for contrasena.
     *
     * @param aContrasena the new value for contrasena
     */
    public void setContrasena(byte[] aContrasena) {
        contrasena = aContrasena;
    }

    /**
     * Access method for correo.
     *
     * @return the current value of correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Setter method for correo.
     *
     * @param aCorreo the new value for correo
     */
    public void setCorreo(String aCorreo) {
        correo = aCorreo;
    }

    /**
     * Access method for venta.
     *
     * @return the current value of venta
     */
    public Set<Venta> getVenta() {
        return venta;
    }

    /**
     * Setter method for venta.
     *
     * @param aVenta the new value for venta
     */
    public void setVenta(Set<Venta> aVenta) {
        venta = aVenta;
    }

    /**
     * Compares the key for this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cliente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cliente)) {
            return false;
        }
        Cliente that = (Cliente) other;
        if (this.getIdcliente() != that.getIdcliente()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cliente)) return false;
        return this.equalKeys(other) && ((Cliente)other).equalKeys(this);
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
        i = getIdcliente();
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
        StringBuffer sb = new StringBuffer("[Cliente |");
        sb.append(" idcliente=").append(getIdcliente());
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
        ret.put("idcliente", Integer.valueOf(getIdcliente()));
        return ret;
    }

}
