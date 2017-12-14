package business.boundary;

import business.dao.GenericImpl;
import business.entity.Sucursal;
import javax.ejb.Stateless;

/**
 *
 * @author bala
 */
@Stateless
public class SucursalManager extends GenericImpl<Sucursal, Integer>{

    public Sucursal getByName(String value) {
        try {
            if(null != value){
                return (Sucursal) em.createNamedQuery("Sucursal.findByNombre").setParameter("nombre", value).getSingleResult();
            }
        } catch (Exception e) {
            logger.error("CLASS"+this.getClass().getName()+" METHOD: getByName() ", e);
        }
        return null;
    }
    
}
