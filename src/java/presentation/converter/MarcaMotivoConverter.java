package presentation.converter;

import business.boundary.MarcaMotivoManager;
import business.entity.MarcaLaboral;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.log4j.Logger;
import presentation.Util;

/**
 *
 * @author enrique
 */
@FacesConverter(value = "marcaMotivoConverter")
public class MarcaMotivoConverter implements Converter {

    protected Logger logger = Logger.getLogger(MarcaMotivoConverter.class);
    private final MarcaMotivoManager marcaMotivoManager = CDI.current().select(MarcaMotivoManager.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("") || value.equalsIgnoreCase(Util.getMessage().getProperty("marcacion.generic.select"))) {
            return null;
        }
        try {
            return marcaMotivoManager.getByName(value);
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
            if (value instanceof MarcaLaboral) {
                
            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsString ", e);
        }

        return null;

    }

}