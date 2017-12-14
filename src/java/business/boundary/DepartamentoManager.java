package business.boundary;

import business.dao.GenericImpl;
import business.entity.Departamento;
import javax.ejb.Stateless;

/**
 *
 * @author bala
 */
@Stateless
public class DepartamentoManager extends GenericImpl<Departamento, Integer>{

    public Departamento getByName(String value) {
        return (Departamento) em.createNamedQuery("Departamento.findByDepartamento").setParameter("departamento", value).getSingleResult();
    }
    
}
