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
@Table(name = "sucursal", catalog = "regishoras", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findById", query = "SELECT s FROM Sucursal s WHERE s.id = :id"),
    @NamedQuery(name = "Sucursal.findByNombre", query = "SELECT s FROM Sucursal s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursal.findByActivo", query = "SELECT s FROM Sucursal s WHERE s.activo = :activo"),
    @NamedQuery(name = "Sucursal.findByFecAlta", query = "SELECT s FROM Sucursal s WHERE s.fecAlta = :fecAlta"),
    @NamedQuery(name = "Sucursal.findByFechModificacion", query = "SELECT s FROM Sucursal s WHERE s.fechModificacion = :fechModificacion")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "direccion", length = 45)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fech_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechModificacion;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @JoinColumn(name = "ciudad", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private List<MarcaLaboral> marcaLaboralList;

    public Sucursal() {
    }

    public Sucursal(Integer id) {
        this.id = id;
    }

    public Sucursal(Integer id, String nombre, int activo) {
        this.id = id;
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}