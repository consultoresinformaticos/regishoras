package business.boundary;

import business.dao.GenericImpl;
import business.entity.Rol;
import javax.ejb.Stateless;

/**
 *
 * @author bala
 */
@Stateless
public class RolManager extends GenericImpl<Rol, Integer>{

    public Rol getByRol(String value) {
        return (Rol) em.createNamedQuery("Rol.findByRol").setParameter("rol", value).getSingleResult();
    }
    
}
