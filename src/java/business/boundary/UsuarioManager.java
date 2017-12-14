package business.boundary;

import business.dao.GenericImpl;
import business.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
@Stateless
public class UsuarioManager extends GenericImpl<Usuario, Integer> {

    protected Logger logger = Logger.getLogger(UsuarioManager.class);

    /**
     * Autentica a un usuario.
     * @param username
     * @param password
     * @return 
     */
    public Usuario authenticate(String username, String password) {
        
        Usuario usuario = null;
        try {
            List<Usuario> listaUsuarios = em.createNamedQuery("Usuario.findByUserAndPass").setParameter("username", username).setParameter("password", password).getResultList();
            if (null != listaUsuarios) {
                usuario = listaUsuarios.get(0);
            } 
        } catch (Exception ex) {
            logger.error("CLASS " + this.getClass().getName() + " Method: authenticate, ", ex);
        }
        return usuario;
    }

    /**
     * Cambia el estado de un usuario.
     * @param active
     * @param id
     * @return 
     */
    public Integer changeState(Integer active, Integer id) {
        try {
            Integer ret = em.createQuery("UPDATE Usuario u SET u.activo = :activo WHERE u.id = :id").setParameter("activo", active).setParameter("id", id).executeUpdate();
            logger.info("CLASS: "+this.getClass().getName()+" METHOD: changeState, cantidad de registros modificados: "+ret);
            return ret;
        } catch (Exception e) {
            logger.error("CLASS " + this.getClass().getName() + " Method: changeState, ", e);
        }
        return 0;
    }

}
