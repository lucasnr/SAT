package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.ModuloDAO;
import br.gov.rn.saogoncalo.telecentro.model.Modulo;
import br.gov.rn.saogoncalo.telecentro.service.ModuloService;

public class ModuloServiceImpl implements ModuloService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ModuloDAO dao;
	
	@Override
	public List<Modulo> listar() {
		return dao.listar(0, 0);
	}

}
