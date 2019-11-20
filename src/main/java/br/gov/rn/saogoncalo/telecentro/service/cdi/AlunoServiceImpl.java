package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.service.AlunoService;

public class AlunoServiceImpl implements AlunoService {

	@Override
	public Optional<Aluno> buscarUltimoAlunoDaTurma(String codigoDaTurma) {
		return dao.buscarUltimoAlunoDaTurma(codigoDaTurma);
	}

	@Inject
	private AlunoDAO dao;

	@Override
	public Optional<Aluno> buscarPorMatricula(String matricula) {
		return dao.buscarPorMatricula(matricula);
	}
}
