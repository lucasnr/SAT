package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;
import br.gov.rn.saogoncalo.telecentro.service.LoginService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named("loginBean")
public class LoginBean {

	@Getter @Setter 
	private CredenciaisDTO credenciais;
	
	@Inject
	private LoginService loginService;
	
	@PostConstruct
	private void init() {
		this.credenciais = new CredenciaisDTO();
	}

	public String logar() {
		Optional<Usuario> login = loginService.login(credenciais);
		if (login.isPresent()) {
			System.out.println(login);
			return "bemvindo.xhmtl?faces-redirect=true";
		}
		
		String mensagemDeErro = "As credenciais informadas não são inválidas, certifique-se de que as digitou corretamente e tente novamente";
		FacesMessageUtil.addErrorMessage(mensagemDeErro);
		return null;
	}

}
