package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.InstrutorService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class CadastrarTurmaBean {

	@Getter
	@Setter
	private Turma turma;

	@Getter
	@Setter
	private Date dataInicio;

	@Getter
	@Setter
	private Date dataFim;

	@Getter
	@Setter
	private String matriculaInstrutor;

	@Getter
	@Setter
	private Long unidadeId;

	public CadastrarTurmaBean() {
		turma = new Turma();
	}

	@Inject
	private InstrutorService instrutorService;

	@Inject
	private UnidadeService unidadeService;

	@Inject
	private TurmaService turmaService;

	public void salvar() {
		Optional<Instrutor> instrutor = instrutorService.buscarPorMatricula(matriculaInstrutor);
		if (instrutor.isPresent()) {
			turma.setInstrutor(instrutor.get());
		} else {
			FacesMessageUtil.addErrorMessage("Não existe instrutor com essa matrícula");
			return;
		}

		Optional<Unidade> unidade = unidadeService.buscarPorId(unidadeId);
		if (unidade.isPresent()) {
			turma.setUnidade(unidade.get());
		} else {
			FacesMessageUtil.addErrorMessage("Não existe unidade com esse id");
			return;
		}

		LocalDate dataInicioLD = dataInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dataFimLD = dataFim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		turma.setDataInicio(dataInicioLD);
		turma.setDataFim(dataFimLD);
		
		boolean salvou = turmaService.salvar(turma);
		if (salvou) {
			FacesMessageUtil.addSuccessMessage("Salvo com sucesso");
		} else {
			FacesMessageUtil.addErrorMessage("Falha ao salvar");
		}
	}
	
	public List<Unidade> unidades() {
		return unidadeService.listar();
	}
}
