package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Aula;
import br.gov.rn.saogoncalo.telecentro.model.RegistroAula;
import br.gov.rn.saogoncalo.telecentro.service.AulaService;
import br.gov.rn.saogoncalo.telecentro.service.RegistroAulaService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AtribuirFrequenciaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private Aula aula;

	@Getter
	@Setter
	private List<RegistroAula> registrosAula;

	@Inject
	private AulaService aulaService;

	public void carregarAulaPorId() {
		Optional<Aula> optional = aulaService.buscarPorId(id);
		if (optional.isPresent()) {
			this.aula = optional.get();
			this.registrosAula = new ArrayList<>();
			for (Aluno aluno : aula.getTurma().getAlunos()) {
				RegistroAula registroAula = new RegistroAula(aluno, aula);
				registrosAula.add(registroAula);
			}
		} else {
			// nao encontrou a turma com o id
		}
	}

	@Inject
	private RegistroAulaService service;

	public void atribuirFrequencia() {
		boolean sucesso = service.salvarRegistros(registrosAula);
		if (sucesso) {
			FacesMessageUtil.addSuccessMessage("Frequencias atribuidas com sucesso");
		} else {
			FacesMessageUtil.addErrorMessage("Erro ao atribuir frequencias");
		}
	}

}
