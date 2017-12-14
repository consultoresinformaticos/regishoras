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
@Table(name = "ciudad", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findById", query = "SELECT c FROM Ciudad c WHERE c.id = :id"),
    @NamedQuery(name = "Ciudad.findByDepartamento", query = "SELECT c FROM Ciudad c WHERE c.departamento.departamento = :departamento"),
    @NamedQuery(name = "Ciudad.findByCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Ciudad.findByFechAlta", query = "SELECT c FROM Ciudad c WHERE c.fechAlta = :fechAlta"),
    @NamedQuery(name = "Ciudad.findByFechModificacion", query = "SELECT c FROM Ciudad c WHERE c.fechModificacion = :fechModificacion"),
    @NamedQuery(name = "Ciudad.findByActivo", query = "SELECT c FROM Ciudad c WHERE c.activo = :activo")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "ciudad", length = 45)
    private String ciudad;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechModificacion;
    @Column(name = "activo")
    private Integer activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadId")
    private List<Presona> presonaList;
    @JoinColumn(name = "departamento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Sucursal> sucursalList;

    public Ciudad() {
    }

    public Ciudad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFechModificacion() {
        return fechModificacion;
    }

    public void setFechModificacion(Date fechModificacion) {
        this.fechModificacion = fechModificacion;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Presona> getPresonaList() {
        return presonaList;
    }

    public void setPresonaList(List<Presona> presonaList) {
        this.presonaList = presonaList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.Ciudad[ id=" + id + " ]";
    }
    
}
