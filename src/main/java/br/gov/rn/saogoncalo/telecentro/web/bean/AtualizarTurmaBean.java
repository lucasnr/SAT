package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Turno;
import br.gov.rn.saogoncalo.telecentro.service.InstrutorService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AtualizarTurmaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Turma turma;

	@Getter
	@Setter
	private Long id;

	public AtualizarTurmaBean() {
		turma = new Turma();
	}

	@Inject
	private TurmaService service;

	public void carregarTurma() {
		Optional<Turma> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			this.turma = optional.get();
		} else {
			System.out.println("erro");
		}
	}

	@Inject
	private InstrutorService instrutorService;

	public void atualizar() {
		List<Turma> turmasDaUnidade = turma.getUnidade().getTurmas();
		Turno turnoEscolhido = this.turma.getTurno();

		for (Turma turma : turmasDaUnidade) {
			if(this.turma.getId() == turma.getId())
				continue;
			
			Integer trimestreDaMinhaTurma = DataUtil.getTrimestre(this.turma.getDataInicio());
			Integer trimestre = DataUtil.getTrimestre(turma.getDataInicio());
			if(trimestre != trimestreDaMinhaTurma)
				continue;
			
			boolean turnosIguais = turma.getTurno().equals(turnoEscolhido);
			if (turnosIguais) {
				FacesMessageUtil.addErrorMessage("Já existe uma turma com este turno neste mesmo trimestre, escolha um turno diferente");
				return;
			}
			
		}

		String matricula = turma.getInstrutor().getMatricula();
		Optional<Instrutor> instrutor = instrutorService.buscarPorMatricula(matricula);
		if (instrutor.isPresent()) {
			turma.setInstrutor(instrutor.get());
		} else {
			FacesMessageUtil.addErrorMessage("Não existe instrutor com essa matricula");
			return;
		}
		boolean atualizou = service.atualizar(turma);
		if (atualizou) {
			FacesMessageUtil.addSuccessMessage("Sucesso ao atualizar");
		} else {
			FacesMessageUtil.addErrorMessage("Falha ao atualizar");
		}

	}

}
