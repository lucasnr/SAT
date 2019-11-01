package br.gov.rn.saogoncalo.telecentro.web.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class UnidadeBean {

	@Getter @Setter
	private Unidade unidade;
	
	@Inject
	private UnidadeService service;
	
	public UnidadeBean() {
		this.unidade = new Unidade();
	}
	
	public void salvar() {
		try {			
			boolean salvou = this.service.salvar(this.unidade);
			if (salvou) {
				FacesMessageUtil.addSuccessMessage("Salvo com sucesso!");
				this.unidade = new Unidade();
			}
			else 
				FacesMessageUtil.addErrorMessage("Falha ao salvar!");
		} catch (IllegalArgumentException e) {
			FacesMessageUtil.addErrorMessage(e.getMessage());
		}
	}
}
