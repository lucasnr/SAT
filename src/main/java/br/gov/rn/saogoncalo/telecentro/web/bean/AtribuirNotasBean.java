package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.BoletimService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named(value="atribuirNotasBean")
@ViewScoped
public class AtribuirNotasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	@Inject
	private BoletimService boletimService;
	
	public void atribuirNotas() {
		
		List<Boletim> boletins = new ArrayList<>();
		List<Aluno> alunos = turma.getAlunos();
		
		for (Aluno aluno : alunos) {
			for (Boletim b : aluno.getBoletins()) {
				boletins.add(b);
			}
		}
		
		boolean atualizouTodos = boletimService.atualizarTodos(boletins);
		if (atualizouTodos) {
			FacesMessageUtil.addSuccessMessage("Boletins atualizados com sucesso");
		} else {
			FacesMessageUtil.addErrorMessage("Falha ao atualizar boletins");
		}
	}
}
