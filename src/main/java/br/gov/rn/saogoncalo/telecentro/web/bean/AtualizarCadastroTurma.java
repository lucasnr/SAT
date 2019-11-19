package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class AtualizarCadastroTurma {
	
	@Getter @Setter
	private Turma turma;
	
	@Getter @Setter
	private Long id;

	public AtualizarCadastroTurma() {
		turma = new Turma();
	
	}
	
	@Inject
	private TurmaService service;
	
	public void carregarTurma() {
		Optional<Turma> optional = service.buscarPorId(id);
		if(optional.isPresent()) {
			this.turma = optional.get();
		}
		else {
			System.out.println("erro");
		}
	}
	
	
	
	

}
