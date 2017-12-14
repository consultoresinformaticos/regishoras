package business.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 * @param <ET>
 * @param <PK>
 */
public class GenericImpl<ET, PK extends Serializable>
        implements GenericDao<ET, PK> {

    @PersistenceContext
    public EntityManager em;
    protected Logger logger = Logger.getLogger(GenericImpl.class);

    @Override
    public ET add(ET entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            logger.error("CLASS: " + this.getEntityName() + " METHOD: add", ex);
            return null;
        }
    }

    @Override
    public ET update(ET entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            logger.error("CLASS: " + this.getEntityName() + " METHOD: update", ex);
            return null;
        }
    }

    @Override
    public ET getById(PK key) {
        try {
            return em.find(getEntityClass(), key);
        } catch (Exception e) {
            logger.error("CLASS: " + this.getEntityName() + " METHOD: getById", e);
            return null;
        }
    }

    @Override
    public List<ET> getAll() {
        try {
            return (List<ET>) em.createNamedQuery(getEntityName() + ".findAll").getResultList();
        } catch (Exception ex) {
            logger.error("CLASS: " + this.getEntityName() + " METHOD: getAll", ex);
            return null;
        }
    }

    @Override
    public void delete(ET entity) {
        try {
            em.remove(entity);
        } catch (Exception e) {
            logger.error("CLASS: " + this.getEntityName() + " METHOD: delete", e);
        }
    }

    private String getEntityName() {
        return this.getGenericName().replace("Manager", "");
    }

    protected String getGenericName() {
        return ((Class<ET>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

    public Class<ET> getEntityClass() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<ET>) genericSuperclass.getActualTypeArguments()[0];
    }

}
