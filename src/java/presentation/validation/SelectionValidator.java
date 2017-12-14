package presentation.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author enrique
 */
public class SelectionValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || !value.toString().trim().equalsIgnoreCase("") || value.toString().trim().equalsIgnoreCase("--Seleccione una opcción--")) {
            FacesMessage msg
                    = new FacesMessage("Debe elegir una opción",
                            "Por favor seleccione una opción");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
