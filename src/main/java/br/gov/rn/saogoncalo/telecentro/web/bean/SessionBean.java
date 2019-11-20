package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import lombok.Getter;

@Named
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Usuario usuario;
	
	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String deslogar() {
		this.usuario = null;
		return "index?faces-redirect=true";
	}

	public Date dataNascimento() {
		return Date.from(usuario.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
