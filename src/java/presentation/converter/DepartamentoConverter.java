package presentation.converter;

import business.boundary.DepartamentoManager;
import business.entity.Departamento;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
@FacesConverter(value = "departamentoConverter")
public class DepartamentoConverter implements Converter{
    protected Logger logger = Logger.getLogger(DepartamentoConverter.class);
    private final DepartamentoManager departamentoManager = CDI.current().select(DepartamentoManager.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || value.equals("")) {
            return null;
        }
        try {
            return departamentoManager.getByName(value);
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsObject ", e);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value == null || value.equals("")) {
            return null;
        }
        try {
            if (value instanceof Departamento) {
                return ((Departamento) value).getDepartamento();
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsString ", e);
        }

        return null;
    }
    
}
