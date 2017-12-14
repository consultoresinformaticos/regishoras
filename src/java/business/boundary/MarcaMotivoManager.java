package business.boundary;

import business.dao.GenericImpl;
import business.entity.MarcaMotivo;
import javax.ejb.Stateless;

/**
 *
 * @author bala
 */
@Stateless
public class MarcaMotivoManager extends GenericImpl<MarcaMotivo, Integer>{

    public MarcaMotivo getByName(String value) {
        try {
            return (MarcaMotivo) em.createNamedQuery("MarcaMotivo.findByMotivo").setParameter("motivo", value).getSingleResult();
        } catch (Exception e) {
            logger.error("CLASS: "+this.getClass().getName()+" METHOD: getByName() ",e);
        }
        return null;
    }
    
}
