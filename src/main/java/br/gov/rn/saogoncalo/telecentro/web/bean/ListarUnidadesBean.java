package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped

public class ListarUnidadesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeService service;

	@Getter
	@Setter
	private List<Unidade> lista;

	public void carregarUnidades() {
		lista = service.listar();
	}
	
	
	
	public String acao() {
		return "exibirUnidade.xhtml?faces-redirect=true&id="; 
	}
}
