package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AtribuirNotasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private List<Boletim> boletins = new ArrayList<>();
	
	@Getter
	@Setter
	private long id;
	
	@Inject
	private TurmaService service;

	@Getter
	private Turma turma;
	
	public void carregarTurmaPorId() {
		Optional<Turma> optional = service.buscarPorId(id);
		if(optional.isPresent()) {
			turma = optional.get();
		} else {
			//nao encontrou a turma com o id
		}
	}
}
