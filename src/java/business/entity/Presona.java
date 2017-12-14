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
@Table(name = "presona", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presona.findAll", query = "SELECT p FROM Presona p")
    ,
    @NamedQuery(name = "Presona.findById", query = "SELECT p FROM Presona p WHERE p.id = :id")
    ,
    @NamedQuery(name = "Presona.findByNombre", query = "SELECT p FROM Presona p WHERE p.nombre = :nombre")
    ,
    @NamedQuery(name = "Presona.findByApellido", query = "SELECT p FROM Presona p WHERE p.apellido = :apellido")
    ,
    @NamedQuery(name = "Presona.findByFecNac", query = "SELECT p FROM Presona p WHERE p.fecNac = :fecNac")
    ,
    @NamedQuery(name = "Presona.findByTelefono", query = "SELECT p FROM Presona p WHERE p.telefono = :telefono")
    ,
    @NamedQuery(name = "Presona.findByEmail", query = "SELECT p FROM Presona p WHERE p.email = :email")
    ,
    @NamedQuery(name = "Presona.findByDireccion", query = "SELECT p FROM Presona p WHERE p.direccion = :direccion")
    ,
    @NamedQuery(name = "Presona.findByFechAlta", query = "SELECT p FROM Presona p WHERE p.fechAlta = :fechAlta")
    ,
    @NamedQuery(name = "Presona.findByFechModificacion", query = "SELECT p FROM Presona p WHERE p.fechModificacion = :fechModificacion")
    ,
    @NamedQuery(name = "Presona.findByActivo", query = "SELECT p FROM Presona p WHERE p.activo = :activo")})
public class Presona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 200)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fec_nac", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecNac;
    @Column(name = "telefono", length = 45)
    private String telefono;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "direccion", length = 200)
    private String direccion;
    @Column(name = "fech_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "fech_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechModificacion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudadId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "presona")
    private List<Usuario> usuarioList;

    public Presona() {
    }

    public Presona(Integer id) {
        this.id = id;
    }

    public Presona(Integer id, String nombre, String apellido, Date fecNac, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        if (null != fecNac) {
            this.fecNac = fecNac;
        } else {
            this.fecNac = new Date();
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presona other = (Presona) obj;
        if (this.activo != other.activo) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.apellido == null) ? (other.apellido != null) : !this.apellido.equals(other.apellido)) {
            return false;
        }
        if ((this.telefono == null) ? (other.telefono != null) : !this.telefono.equals(other.telefono)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.direccion == null) ? (other.direccion != null) : !this.direccion.equals(other.direccion)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.fecNac != other.fecNac && (this.fecNac == null || !this.fecNac.equals(other.fecNac))) {
            return false;
        }
        if (this.fechAlta != other.fechAlta && (this.fechAlta == null || !this.fechAlta.equals(other.fechAlta))) {
            return false;
        }
        if (this.fechModificacion != other.fechModificacion && (this.fechModificacion == null || !this.fechModificacion.equals(other.fechModificacion))) {
            return false;
        }
        if (this.usuAlta != other.usuAlta && (this.usuAlta == null || !this.usuAlta.equals(other.usuAlta))) {
            return false;
        }
        if (this.usuModificacion != other.usuModificacion && (this.usuModificacion == null || !this.usuModificacion.equals(other.usuModificacion))) {
            return false;
        }
        if (this.ciudadId != other.ciudadId && (this.ciudadId == null || !this.ciudadId.equals(other.ciudadId))) {
            return false;
        }
        if (this.usuarioList != other.usuarioList && (this.usuarioList == null || !this.usuarioList.equals(other.usuarioList))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return nombre+" "+apellido;
    }

}
