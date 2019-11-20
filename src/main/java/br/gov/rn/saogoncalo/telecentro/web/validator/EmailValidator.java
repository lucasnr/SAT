/*
* INFO4M - 20161164010034
* @author Anderson dos Santos Lucio
*/

package br.gov.rn.saogoncalo.telecentro.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent toValidate, Object value) {
		String email = (String) value;
		if (email.indexOf('@') == -1) {
			((UIInput) toValidate).setValid(false);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um email válido", "Informe um email válido");
			context.addMessage(toValidate.getClientId(context), message);
		}
	}
}
