package presentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
public class Util {

    protected static Logger logger = Logger.getLogger(Util.class);

    /**
     * Agrega un mensaje de tipo FacesMessage al contexto.
     *
     * @param summary
     * @param facesMessage
     */
    public static void addMessage(String summary, Severity facesMessage) {
        FacesMessage message = new FacesMessage(facesMessage, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Devuelve el property que contiene los literales de idiomas.
     *
     * @return
     */
    public static Properties getMessage() {
        Locale browserLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        String lang = browserLocale.getLanguage();
        try {
            Properties prop = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = Util.class.getClassLoader().getResourceAsStream("lang/marcacion_" + lang + ".properties");
                if (null == inputStream) {
                    inputStream = Util.class.getClassLoader().getResourceAsStream("lang/marcacion.properties");
                }
            } catch (Exception e) {
                inputStream = Util.class.getClassLoader().getResourceAsStream("lang/marcacion.properties");
            }

            prop.load(inputStream);
            return prop;
        } catch (IOException ex) {
            logger.error("CLASS: PresentationUtil, METHOD: getMessage", ex);
            return null;
        }
    }
    
}
