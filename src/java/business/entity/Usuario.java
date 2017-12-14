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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bala
 */
@Entity
@Table(name = "usuario", catalog = "regishoras", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUserAndPass", query = "SELECT u FROM Usuario u WHERE UPPER(u.username) = UPPER(:username) AND u.password = :password"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByFecAlta", query = "SELECT u FROM Usuario u WHERE u.fecAlta = :fecAlta"),
    @NamedQuery(name = "Usuario.findByFecModificacion", query = "SELECT u FROM Usuario u WHERE u.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "Usuario.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic(optional = false)
    @Column(name = "fec_alta", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private int activo;
    @OneToMany(mappedBy = "usuAlta")
    private List<Pantalla> pantallaList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Pantalla> pantallaList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<Presona> presonaList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Presona> presonaList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<Ciudad> ciudadList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Ciudad> ciudadList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<Sucursal> sucursalList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Sucursal> sucursalList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<MarcaMotivo> marcaMotivoList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<MarcaMotivo> marcaMotivoList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<Departamento> departamentoList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Departamento> departamentoList1;
    @OneToMany(mappedBy = "usuAlta")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuAlta;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Usuario> usuarioList1;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuModificacion;
    @JoinColumn(name = "presona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Presona presona;
    @JoinColumn(name = "rol", referencedColumnName = "rol", nullable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @OneToMany(mappedBy = "usuAlta")
    private List<RolPantalla> rolPantallaList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<RolPantalla> rolPantallaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<MarcaLaboral> marcaLaboralList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Rol> rolList;
    @OneToMany(mappedBy = "usuAlta")
    private List<Rol> rolList1;

    public Usuario() {
    }

    public Usuario(Integer id, String username, String password, Date fecAlta, int activo) {
        //this.id = id;
        this.username = username;
        this.password = password;
        this.fecAlta = fecAlta;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public List<Pantalla> getPantallaList() {
        return pantallaList;
    }

    public void setPantallaList(List<Pantalla> pantallaList) {
        this.pantallaList = pantallaList;
    }

    @XmlTransient
    public List<Pantalla> getPantallaList1() {
        return pantallaList1;
    }

    public void setPantallaList1(List<Pantalla> pantallaList1) {
        this.pantallaList1 = pantallaList1;
    }

    @XmlTransient
    public List<Presona> getPresonaList() {
        return presonaList;
    }

    public void setPresonaList(List<Presona> presonaList) {
        this.presonaList = presonaList;
    }

    @XmlTransient
    public List<Presona> getPresonaList1() {
        return presonaList1;
    }

    public void setPresonaList1(List<Presona> presonaList1) {
        this.presonaList1 = presonaList1;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList1() {
        return ciudadList1;
    }

    public void setCiudadList1(List<Ciudad> ciudadList1) {
        this.ciudadList1 = ciudadList1;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList1() {
        return sucursalList1;
    }

    public void setSucursalList1(List<Sucursal> sucursalList1) {
        this.sucursalList1 = sucursalList1;
    }

    @XmlTransient
    public List<MarcaMotivo> getMarcaMotivoList() {
        return marcaMotivoList;
    }

    public void setMarcaMotivoList(List<MarcaMotivo> marcaMotivoList) {
        this.marcaMotivoList = marcaMotivoList;
    }

    @XmlTransient
    public List<MarcaMotivo> getMarcaMotivoList1() {
        return marcaMotivoList1;
    }

    public void setMarcaMotivoList1(List<MarcaMotivo> marcaMotivoList1) {
        this.marcaMotivoList1 = marcaMotivoList1;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList1() {
        return departamentoList1;
    }

    public void setDepartamentoList1(List<Departamento> departamentoList1) {
        this.departamentoList1 = departamentoList1;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getUsuAlta() {
        return usuAlta;
    }

    public void setUsuAlta(Usuario usuAlta) {
        this.usuAlta = usuAlta;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList1() {
        return usuarioList1;
    }

    public void setUsuarioList1(List<Usuario> usuarioList1) {
        this.usuarioList1 = usuarioList1;
    }

    public Usuario getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(Usuario usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    public Presona getPresona() {
        return presona;
    }

    public void setPresona(Presona presona) {
        this.presona = presona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<RolPantalla> getRolPantallaList() {
        return rolPantallaList;
    }

    public void setRolPantallaList(List<RolPantalla> rolPantallaList) {
        this.rolPantallaList = rolPantallaList;
    }

    @XmlTransient
    public List<RolPantalla> getRolPantallaList1() {
        return rolPantallaList1;
    }

    public void setRolPantallaList1(List<RolPantalla> rolPantallaList1) {
        this.rolPantallaList1 = rolPantallaList1;
    }

    @XmlTransient
    public List<MarcaLaboral> getMarcaLaboralList() {
        return marcaLaboralList;
    }

    public void setMarcaLaboralList(List<MarcaLaboral> marcaLaboralList) {
        this.marcaLaboralList = marcaLaboralList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Rol> getRolList1() {
        return rolList1;
    }

    public void setRolList1(List<Rol> rolList1) {
        this.rolList1 = rolList1;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.Usuario[ id=" + id + " ]";
    }
    
}
