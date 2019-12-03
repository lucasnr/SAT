package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.AulaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aula;
import br.gov.rn.saogoncalo.telecentro.service.AulaService;

public class AulaServiceImpl implements AulaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private AulaDAO dao;
	
	@Override
	public boolean salvar(Aula aula) {
		return dao.salvar(aula);
	}

	@Override
	public Optional<Aula> buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

}
