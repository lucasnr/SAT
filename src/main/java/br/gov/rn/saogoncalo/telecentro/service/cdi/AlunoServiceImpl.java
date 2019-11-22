package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.service.AlunoService;

public class AlunoServiceImpl implements AlunoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public boolean atualizar(Aluno aluno) {
		return dao.atualizar(aluno);
	}
}
