package presentation.converter;

import business.boundary.RolManager;
import business.entity.Ciudad;
import business.entity.Rol;
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
@FacesConverter(value = "rolConverter")
public class RolConverter implements Converter{
    
    protected Logger logger = Logger.getLogger(RolConverter.class);
    private final RolManager rolManager = CDI.current().select(RolManager.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        try {
            return rolManager.getByRol(value);
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
            if (value instanceof Ciudad) {
                return ((Rol) value).getRol();
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
        return null;
    }
    
}
