package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.InstrutorDAO;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.service.InstrutorService;

public class InstrutorServiceImpl implements InstrutorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private InstrutorDAO dao;

	@Override
	public Optional<Instrutor> buscarPorMatricula(String matricula) {
		return dao.buscarPorMatricula(matricula);
	}

}
