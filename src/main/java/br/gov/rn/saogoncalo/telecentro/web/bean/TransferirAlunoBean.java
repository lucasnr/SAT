package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.AlunoService;
import br.gov.rn.saogoncalo.telecentro.service.GeradorDeMatricula;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class TransferirAlunoBean {

	@Getter
	@Setter
	private String matricula;

	@Getter
	@Setter
	private String codigoDaTurma;

	@Inject
	private TurmaService turmaService;

	@Inject
	private AlunoService alunoService;

	public void transferir() {
		System.out.println(codigoDaTurma);
		
		Optional<Aluno> optional = alunoService.buscarPorMatricula(matricula);
		if (optional.isPresent()) {
			Aluno aluno = optional.get();

			Optional<Turma> optionalDaTurma = turmaService.buscarPorCodigo(codigoDaTurma);

			if (optionalDaTurma.isPresent()) {
				Optional<Aluno> ultimoAlunoDaTurma = alunoService.buscarUltimoAlunoDaTurma(codigoDaTurma);
				Turma turma = optionalDaTurma.get();

				if (ultimoAlunoDaTurma.isPresent()) {
					String matriculaDoUltimoAluno = ultimoAlunoDaTurma.get().getMatricula();
					String novaMatricula = GeradorDeMatricula.gerarNovaMatricula(matricula, turma, matriculaDoUltimoAluno);

					aluno.setMatricula(novaMatricula);
					aluno.setTurma(turma);
					boolean atualizou = alunoService.atualizar(aluno);

					if (atualizou) {
						FacesMessageUtil.addSuccessMessage("Transferido com sucesso");
						return;
					}
				}
			} else {
				FacesMessageUtil.addErrorMessage("Não exitem turma com esse código");
				return;
			}
		} else {
			FacesMessageUtil.addErrorMessage("Não existe aluno com essa matrícula");
			return;
		}
		
		FacesMessageUtil.addErrorMessage("Falha ao transferir aluno");
	}

}
