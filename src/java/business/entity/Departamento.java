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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "departamento", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findById", query = "SELECT d FROM Departamento d WHERE d.id = :id"),
    @NamedQuery(name = "Departamento.findByDepartamento", query = "SELECT d FROM Departamento d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "Departamento.findByActivo", query = "SELECT d FROM Departamento d WHERE d.activo = :activo"),
    @NamedQuery(name = "Departamento.findByFecAlta", query = "SELECT d FROM Departamento d WHERE d.fecAlta = :fecAlta"),
    @NamedQuery(name = "Departamento.findByFechModificacion", query = "SELECT d FROM Departamento d WHERE d.fechModificacion = :fechModificacion")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "departamento", nullable = false, length = 45)
    private String departamento;
    @Column(name = "activo")
    private Integer activo;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fech_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Ciudad> ciudadList;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;

    public Departamento() {
    }

    public Departamento(Integer id) {
        this.id = id;
    }

    public Departamento(Integer id, String departamento) {
        this.id = id;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFechModificacion() {
        return fechModificacion;
    }

    public void setFechModificacion(Date fechModificacion) {
        this.fechModificacion = fechModificacion;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.Departamento[ id=" + id + " ]";
    }
    
}
