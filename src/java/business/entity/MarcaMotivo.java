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
@Table(name = "marca_motivo", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaMotivo.findAll", query = "SELECT m FROM MarcaMotivo m"),
    @NamedQuery(name = "MarcaMotivo.findByMotivo", query = "SELECT m FROM MarcaMotivo m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "MarcaMotivo.findByFecAlta", query = "SELECT m FROM MarcaMotivo m WHERE m.fecAlta = :fecAlta"),
    @NamedQuery(name = "MarcaMotivo.findByFecModificacion", query = "SELECT m FROM MarcaMotivo m WHERE m.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "MarcaMotivo.findByActivo", query = "SELECT m FROM MarcaMotivo m WHERE m.activo = :activo")})
public class MarcaMotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "motivo", nullable = false, length = 200)
    private String motivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivo")
    private List<MarcaLaboral> marcaLaboralList;

    public MarcaMotivo() {
    }

    public MarcaMotivo(String motivo) {
        this.motivo = motivo;
    }

    public MarcaMotivo(String motivo, int activo) {
        this.motivo = motivo;
        this.activo = activo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
    public List<MarcaLaboral> getMarcaLaboralList() {
        return marcaLaboralList;
    }

    public void setMarcaLaboralList(List<MarcaLaboral> marcaLaboralList) {
        this.marcaLaboralList = marcaLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motivo != null ? motivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaMotivo)) {
            return false;
        }
        MarcaMotivo other = (MarcaMotivo) object;
        if ((this.motivo == null && other.motivo != null) || (this.motivo != null && !this.motivo.equals(other.motivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.MarcaMotivo[ motivo=" + motivo + " ]";
    }
    
}
