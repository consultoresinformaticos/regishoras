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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bala
 */
@Entity
@Table(name = "rol", catalog = "regishoras", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rol"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByRol", query = "SELECT r FROM Rol r WHERE r.rol = :rol"),
    @NamedQuery(name = "Rol.findByFecAlta", query = "SELECT r FROM Rol r WHERE r.fecAlta = :fecAlta"),
    @NamedQuery(name = "Rol.findByFecModificacion", query = "SELECT r FROM Rol r WHERE r.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "Rol.findByActivo", query = "SELECT r FROM Rol r WHERE r.activo = :activo")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rol", nullable = false, length = 20)
    private String rol;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol1")
    private List<RolPantalla> rolPantallaList;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;

    public Rol() {
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public Rol(String rol, int activo) {
        this.rol = rol;
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<RolPantalla> getRolPantallaList() {
        return rolPantallaList;
    }

    public void setRolPantallaList(List<RolPantalla> rolPantallaList) {
        this.rolPantallaList = rolPantallaList;
    }

    public Usuario getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(Usuario usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    public Usuario getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(Usuario usuAlta) {
        this.usuAlta = usuAlta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rol != null ? rol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rol == null && other.rol != null) || (this.rol != null && !this.rol.equals(other.rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getRol();
    }
    
}
