/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bala
 */
@Entity
@Table(name = "pantalla", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalla.findAll", query = "SELECT p FROM Pantalla p"),
    @NamedQuery(name = "Pantalla.findByPantalla", query = "SELECT p FROM Pantalla p WHERE p.pantalla = :pantalla"),
    @NamedQuery(name = "Pantalla.findByFecAlta", query = "SELECT p FROM Pantalla p WHERE p.fecAlta = :fecAlta"),
    @NamedQuery(name = "Pantalla.findByFecModificacion", query = "SELECT p FROM Pantalla p WHERE p.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "Pantalla.findByActivo", query = "SELECT p FROM Pantalla p WHERE p.activo = :activo")})
public class Pantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pantalla", nullable = false, length = 100)
    private String pantalla;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pantalla1")
    private List<RolPantalla> rolPantallaList;

    public Pantalla() {
    }

    public Pantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Pantalla(String pantalla, int activo) {
        this.pantalla = pantalla;
        this.activo = activo;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
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

    @XmlTransient
    public List<RolPantalla> getRolPantallaList() {
        return rolPantallaList;
    }

    public void setRolPantallaList(List<RolPantalla> rolPantallaList) {
        this.rolPantallaList = rolPantallaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pantalla != null ? pantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalla)) {
            return false;
        }
        Pantalla other = (Pantalla) object;
        if ((this.pantalla == null && other.pantalla != null) || (this.pantalla != null && !this.pantalla.equals(other.pantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.Pantalla[ pantalla=" + pantalla + " ]";
    }
    
}
