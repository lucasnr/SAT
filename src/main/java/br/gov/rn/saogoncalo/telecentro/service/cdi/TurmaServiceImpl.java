package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.TurmaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;

public class TurmaServiceImpl implements TurmaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TurmaDAO dao;
	
	@Override
	public Optional<Turma> buscarPorId(Long id) {
		return dao.buscarPorPK(id);
	}

	@Override
	public Optional<Turma> buscarPorCodigo(String codigo) {
		return dao.buscarPorCodigo(codigo);
	}

	@Override
	public List<Turma> listar() {
		return dao.listar(0, 0);
	}

	@Override
	public boolean salvar(Turma turma) {
		return dao.salvar(turma);
	}
	
}
