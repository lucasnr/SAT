package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import lombok.Getter;
import lombok.Setter;


@Named
@ViewScoped
public class AtribuirFrequenciaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter	
	private Long aulaId;
	
	@Getter
	@Setter
	private Turma turma;
	
	@Inject
	private TurmaService service;
	
	
	public void carregarTurmaPorId() {
		Optional<Turma> optional = service.buscarPorId(id);
		if(optional.isPresent()) {
			turma = optional.get();
		} else {
			//nao encontrou a turma com o id
		}
	}
	
	public void atribuirFrequencia() {
		
	}
	
	
	
}
