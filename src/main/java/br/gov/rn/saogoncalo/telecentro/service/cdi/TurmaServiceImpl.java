package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.TurmaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;

public class TurmaServiceImpl implements TurmaService {

	@Inject
	private TurmaDAO dao;
	
	@Override
	public Optional<Turma> buscarPorId(Long id) {
		return dao.buscarPorPK(id);
	}
	
}
