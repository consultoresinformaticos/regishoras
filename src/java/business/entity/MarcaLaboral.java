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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "marca_laboral", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaLaboral.findAll", query = "SELECT m FROM MarcaLaboral m"),
    @NamedQuery(name = "MarcaLaboral.findById", query = "SELECT m FROM MarcaLaboral m WHERE m.id = :id"),
    @NamedQuery(name = "MarcaLaboral.findByFecMarcacion", query = "SELECT m FROM MarcaLaboral m WHERE m.fecMarcacion = :fecMarcacion")})
public class MarcaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Lob
    @Column(name = "det_motivo", length = 65535)
    private String detMotivo;
    @Basic(optional = false)
    @Column(name = "fec_marcacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecMarcacion;
    @JoinColumn(name = "motivo", referencedColumnName = "motivo", nullable = false)
    @ManyToOne(optional = false)
    private MarcaMotivo motivo;
    @JoinColumn(name = "sucursal", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sucursal sucursal;
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public MarcaLaboral() {
    }

    public MarcaLaboral(Integer id) {
        this.id = id;
    }

    public MarcaLaboral(Integer id, Date fecMarcacion) {
        this.id = id;
        this.fecMarcacion = fecMarcacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetMotivo() {
        return detMotivo;
    }

    public void setDetMotivo(String detMotivo) {
        this.detMotivo = detMotivo;
    }

    public Date getFecMarcacion() {
        return fecMarcacion;
    }

    public void setFecMarcacion(Date fecMarcacion) {
        this.fecMarcacion = fecMarcacion;
    }

    public MarcaMotivo getMotivo() {
        return motivo;
    }

    public void setMotivo(MarcaMotivo motivo) {
        this.motivo = motivo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof MarcaLaboral)) {
            return false;
        }
        MarcaLaboral other = (MarcaLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.MarcaLaboral[ id=" + id + " ]";
    }
    
}
