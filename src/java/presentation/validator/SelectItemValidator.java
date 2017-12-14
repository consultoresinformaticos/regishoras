package presentation.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import presentation.Util;

/**
 *
 * @author enrique
 */
@FacesValidator("selectItemValidator")
public class SelectItemValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String selectItem = Util.getMessage().getProperty("marcacion.generic.select");
        
        if(null == value || value.toString().trim().equalsIgnoreCase(selectItem)){
            FacesMessage message = new FacesMessage(Util.getMessage().getProperty("marcacion.generic.select.validation")+" "+component.getAttributes().get("role"));
            throw new ValidatorException(message);
        }
    }
    
}
