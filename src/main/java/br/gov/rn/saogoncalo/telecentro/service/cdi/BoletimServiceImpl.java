package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.BoletimDAO;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.service.BoletimService;

public class BoletimServiceImpl implements BoletimService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private BoletimDAO dao;
	
	@Override
	public boolean atualizarTodos(List<Boletim> boletins) {
		return dao.atualizarTodos(boletins);
	}

}
