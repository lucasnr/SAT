package br.gov.rn.saogoncalo.telecentro.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

	private static void addMessage(Severity severity, String mensagem) {
		FacesMessage message = new FacesMessage(severity, mensagem, mensagem);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void addErrorMessage(String mensagem) {
		addMessage(FacesMessage.SEVERITY_ERROR, mensagem);
	}

	public static void addSuccessMessage(String mensagem) {
		addMessage(FacesMessage.SEVERITY_INFO, mensagem);
	}
}
