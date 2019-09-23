package br.gov.rn.saogoncalo.telecentro.web.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "loginBean")
public class LoginBean {

	@Getter @Setter private CredenciaisDTO credenciais;
	
	@PostConstruct
	private void init() {
		this.credenciais = new CredenciaisDTO();
	}

	public String logar() {
		System.out.println(credenciais);
		return null;
	}

}
