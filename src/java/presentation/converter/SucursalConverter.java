package presentation.converter;

import business.boundary.SucursalManager;
import business.entity.Sucursal;
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
@FacesConverter(value = "sucursalConverter")
public class SucursalConverter implements Converter {

    protected Logger logger = Logger.getLogger(MarcaMotivoConverter.class);
    private SucursalManager sucursalManager = CDI.current().select(SucursalManager.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("") || value.equalsIgnoreCase(Util.getMessage().getProperty("marcacion.generic.select"))) {
            return null;
        }
        try {
            return sucursalManager.getByName(value);
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
            if (value instanceof Sucursal) {

            }
        } catch (Exception e) {
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: getAsString ", e);
        }

        return null;

    }

}
