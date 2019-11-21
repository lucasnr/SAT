package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.InstrutorService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AtualizarCadastroTurmaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Turma turma;
	
	@Getter @Setter
	private Long id;

	public AtualizarCadastroTurmaBean() {
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

	@Inject
	private InstrutorService instrutorService;
	
	public void atualizar() {
		String matricula = turma.getInstrutor().getMatricula();
		System.out.println(matricula);
		Optional<Instrutor> instrutor = instrutorService.buscarPorMatricula(matricula);
		System.out.println(instrutor.isPresent());
		if(instrutor.isPresent()) {
			turma.setInstrutor(instrutor.get());
		} else {
			FacesMessageUtil.addErrorMessage("Não existe instrutor com essa matricula");
			return;
		}
		boolean atualizou = service.atualizar(turma);
		if(atualizou) {
			FacesMessageUtil.addSuccessMessage("Sucesso ao atualizar");
		} else {
			FacesMessageUtil.addErrorMessage("Falha ao atualizar");
		}
		
	} 

}
