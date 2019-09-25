package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class LogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String deslogar() {
		this.usuario = null;
		return "index?faces-redirect=true";
	}

}
