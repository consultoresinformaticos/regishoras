package business.boundary;

import business.dao.GenericImpl;
import business.entity.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author bala
 */
@Stateless
public class CiudadManager extends GenericImpl<Ciudad, Integer> {
    
    protected Logger logger = Logger.getLogger(CiudadManager.class);
    
    public Ciudad getByName(String value) {
        Ciudad ciudadReturn = null;
        try {
            if (null != value && value.trim().equalsIgnoreCase("")) {
                ciudadReturn = (Ciudad) em.createNamedQuery("Ciudad.findByCiudad").setParameter("ciudad", value).getSingleResult();
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getByName ", e);
            
        }
        
        return ciudadReturn;
        
    }
    
    public List<Ciudad> getByDepartamento(String departamento) {
        List<Ciudad> ciudadList = new ArrayList<Ciudad>();
        try {
            ciudadList = em.createNamedQuery("Ciudad.findByDepartamento").setParameter("departamento", departamento).getResultList();
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getByDepartamento ", e);
            if (null == ciudadList) {
                ciudadList = new ArrayList<Ciudad>();
            }
        }
        return ciudadList;
        
    }
    
}
