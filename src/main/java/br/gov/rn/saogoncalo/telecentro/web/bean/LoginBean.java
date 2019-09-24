package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;
import br.gov.rn.saogoncalo.telecentro.service.LoginService;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "loginBean")
public class LoginBean {

	@Getter @Setter 
	private CredenciaisDTO credenciais;
	
	private LoginService loginService;
	
	@PostConstruct
	private void init() {
		this.credenciais = new CredenciaisDTO();
		this.loginService = new LoginService();
	}

	public String logar() {
		Optional<Usuario> login = loginService.login(credenciais);
		if (login.isPresent()) {
			return "bemvindo.xhmtl?faces-redirect=true";
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais inválidas", "Credenciais inválidas");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}

}
