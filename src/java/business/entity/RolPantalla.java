/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bala
 */
@Entity
@Table(name = "rol_pantalla", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPantalla.findAll", query = "SELECT r FROM RolPantalla r"),
    @NamedQuery(name = "RolPantalla.findByRol", query = "SELECT r FROM RolPantalla r WHERE r.rolPantallaPK.rol = :rol"),
    @NamedQuery(name = "RolPantalla.findByPantalla", query = "SELECT r FROM RolPantalla r WHERE r.rolPantallaPK.pantalla = :pantalla"),
    @NamedQuery(name = "RolPantalla.findByOperacion", query = "SELECT r FROM RolPantalla r WHERE r.operacion = :operacion"),
    @NamedQuery(name = "RolPantalla.findByFechAlta", query = "SELECT r FROM RolPantalla r WHERE r.fechAlta = :fechAlta"),
    @NamedQuery(name = "RolPantalla.findByFecModificacion", query = "SELECT r FROM RolPantalla r WHERE r.fecModificacion = :fecModificacion")})
public class RolPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolPantallaPK rolPantallaPK;
    @Basic(optional = false)
    @Column(name = "operacion", nullable = false, length = 10)
    private String operacion;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @JoinColumn(name = "pantalla", referencedColumnName = "pantalla", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pantalla pantalla1;
    @JoinColumn(name = "rol", referencedColumnName = "rol", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol1;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;

    public RolPantalla() {
    }

    public RolPantalla(RolPantallaPK rolPantallaPK) {
        this.rolPantallaPK = rolPantallaPK;
    }

    public RolPantalla(RolPantallaPK rolPantallaPK, String operacion) {
        this.rolPantallaPK = rolPantallaPK;
        this.operacion = operacion;
    }

    public RolPantalla(String rol, String pantalla) {
        this.rolPantallaPK = new RolPantallaPK(rol, pantalla);
    }

    public RolPantallaPK getRolPantallaPK() {
        return rolPantallaPK;
    }

    public void setRolPantallaPK(RolPantallaPK rolPantallaPK) {
        this.rolPantallaPK = rolPantallaPK;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public Pantalla getPantalla1() {
        return pantalla1;
    }

    public void setPantalla1(Pantalla pantalla1) {
        this.pantalla1 = pantalla1;
    }

    public Rol getRol1() {
        return rol1;
    }

    public void setRol1(Rol rol1) {
        this.rol1 = rol1;
    }

    public Usuario getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(Usuario usuAlta) {
        this.usuAlta = usuAlta;
    }

    public Usuario getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(Usuario usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolPantallaPK != null ? rolPantallaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPantalla)) {
            return false;
        }
        RolPantalla other = (RolPantalla) object;
        if ((this.rolPantallaPK == null && other.rolPantallaPK != null) || (this.rolPantallaPK != null && !this.rolPantallaPK.equals(other.rolPantallaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.RolPantalla[ rolPantallaPK=" + rolPantallaPK + " ]";
    }
    
}
