/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author bala
 */
@Embeddable
public class RolPantallaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rol", nullable = false, length = 20)
    private String rol;
    @Basic(optional = false)
    @Column(name = "pantalla", nullable = false, length = 100)
    private String pantalla;

    public RolPantallaPK() {
    }

    public RolPantallaPK(String rol, String pantalla) {
        this.rol = rol;
        this.pantalla = pantalla;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rol != null ? rol.hashCode() : 0);
        hash += (pantalla != null ? pantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPantallaPK)) {
            return false;
        }
        RolPantallaPK other = (RolPantallaPK) object;
        if ((this.rol == null && other.rol != null) || (this.rol != null && !this.rol.equals(other.rol))) {
            return false;
        }
        if ((this.pantalla == null && other.pantalla != null) || (this.pantalla != null && !this.pantalla.equals(other.pantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.entity.RolPantallaPK[ rol=" + rol + ", pantalla=" + pantalla + " ]";
    }
    
}
