package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;
import br.gov.rn.saogoncalo.telecentro.service.LoginService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter 
	@Inject
	private CredenciaisDTO credenciais;
	@Inject
	private LoginService loginService;
	
	public String logar() {
		Optional<Usuario> optional = loginService.login(credenciais);
		if (optional.isPresent()) {
			logarUsuario(optional.get());
			return "home?faces-redirect=true";
		}
		
		String mensagemDeErro = "As credenciais informadas não são inválidas, certifique-se de que as digitou corretamente e tente novamente";
		FacesMessageUtil.addErrorMessage(mensagemDeErro);
		return null;
	}

	@Inject
	private LogadoBean logadoBean;
	
	private void logarUsuario(Usuario usuario) {
		logadoBean.logar(usuario);
	}

}
