package br.gov.rn.saogoncalo.telecentro.web.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;

@ManagedBean(name = "loginBean")
public class LoginBean {

	private CredenciaisDTO credenciais;
	
	@PostConstruct
	private void init() {
		this.credenciais = new CredenciaisDTO();
	}

	public String logar() {
		System.out.println(credenciais.getMatricula());
		return null;
	}

	public CredenciaisDTO getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(CredenciaisDTO login) {
		this.credenciais = login;
	}

}
