package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.Modulo;
import br.gov.rn.saogoncalo.telecentro.service.AlunoService;
import br.gov.rn.saogoncalo.telecentro.service.GeradorDeMatricula;
import br.gov.rn.saogoncalo.telecentro.service.ModuloService;

public class AlunoServiceImpl implements AlunoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDAO dao;
	
	@Override
	public Optional<Aluno> buscarUltimoAlunoDaTurma(String codigoDaTurma) {
		return dao.buscarUltimoAlunoDaTurma(codigoDaTurma);
	}

	@Override
	public Optional<Aluno> buscarPorMatricula(String matricula) {
		return dao.buscarPorMatricula(matricula);
	}

	@Override
	public boolean atualizar(Aluno aluno) {
		return dao.atualizar(aluno);
	}
	
	@Inject
	private ModuloService moduloService;

	@Override
	public boolean salvar(Aluno aluno) {
		Long lastId = dao.buscarUltimoId();
		String matriculaGerada = GeradorDeMatricula.gerar(aluno, lastId);
		aluno.setMatricula(matriculaGerada);

		List<Modulo> modulos = moduloService.listar();
		for (Modulo modulo : modulos) {
			Boletim boletim = new Boletim(aluno, modulo, 0);
			aluno.addBoletim(boletim);
		}
		
		return dao.salvar(aluno);
	}
}
