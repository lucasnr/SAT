package br.gov.rn.saogoncalo.telecentro.web.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.service.EnderecoService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class EnderecoBean {

	@Getter @Setter
	private Endereco endereco;
	
	@Inject
	private EnderecoService service;
	
	public EnderecoBean() {
		this.endereco = new Endereco();
	}
	
	@Transactional
	public void salvar() {
		try {			
			System.out.println(this.endereco);
			boolean salvou = this.service.salvar(this.endereco);
			if(salvou)
				FacesMessageUtil.addSuccessMessage("Salvo com sucesso");
			else
				FacesMessageUtil.addErrorMessage("Falha ao salvar");
		} catch (IllegalArgumentException e) {
			FacesMessageUtil.addErrorMessage("Falha ao salvar: " + e.getMessage());
		}
	}
}
