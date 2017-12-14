package business.boundary;

import business.dao.GenericImpl;
import business.entity.MarcaLaboral;
import business.entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author bala
 */
@Stateless
public class MarcaLaboralManager extends GenericImpl<MarcaLaboral, Integer> {

    public MarcaLaboral getByName(String value) {
        try {
            if (null != value) {
                return (MarcaLaboral) em.createNamedQuery("MarcaMotivo.findByMotivo").setParameter("motivo", value).getSingleResult();
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getByName", e);
            return null;
        }
        return null;
    }

    public List<MarcaLaboral> getFromParam(Date iniDate, Date endDate, Usuario usuario) {

        String query = "SELECT m FROM MarcaLaboral ";
        if (null != usuario) {
            query += "LEFT JOIN Usuario u ";
        }
        query += "WHERE ";

        if (null != usuario) {
            query += "m.usuario = :usuario ";
        }

        if (null != iniDate && null != endDate) {
            query += "m.fecMarcacion BETWEEN (:iniDate,:endDate)";
        }

        query += "ORDER BY m.fecMarcacion DESC";

        try {
            Query q = em.createQuery(query);

            if (null != usuario) {
                q.setParameter("usuario", usuario);
            }

            if (null != iniDate && null != endDate) {
                q.setParameter("iniDate", iniDate);
                q.setParameter("endDate", endDate);
            }
            return (List<MarcaLaboral>) q.getResultList();
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getFromParam", e);
            return new ArrayList<MarcaLaboral>();
        }
    }

}
