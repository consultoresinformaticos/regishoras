package presentation.converter;

import business.boundary.CiudadManager;
import business.entity.Ciudad;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.log4j.Logger;

/**
 *
 * @author bala
 */
@FacesConverter(value = "ciudadConverter")
public class CiudadConverter implements Converter {

    private CiudadManager ciudadManager = CDI.current().select(CiudadManager.class).get();
    protected Logger logger = Logger.getLogger(CiudadConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        try {
            return ciudadManager.getByName(value);
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
                return ((Ciudad) value).getCiudad();
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsString ", e);
        }

        return null;
    }

}
