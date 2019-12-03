package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.RegistroAulaDAO;
import br.gov.rn.saogoncalo.telecentro.model.RegistroAula;
import br.gov.rn.saogoncalo.telecentro.service.RegistroAulaService;

public class RegistroAulaServiceImpl implements RegistroAulaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private RegistroAulaDAO dao;
	
	@Override
	public boolean salvarRegistros(List<RegistroAula> registrosAula) {
		return dao.salvarTodos(registrosAula);
	}

}
