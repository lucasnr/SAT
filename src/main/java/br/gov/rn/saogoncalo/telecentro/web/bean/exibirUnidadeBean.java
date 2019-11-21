package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class exibirUnidadeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private Unidade unidade;
	
	@Inject
	private UnidadeService service;
	
	public void carregarUnidade() {
		Optional<Unidade> optional = service.buscarPorId(id);
		
		if (optional.isPresent()) {
			this.unidade = optional.get();
		}
	}
}
