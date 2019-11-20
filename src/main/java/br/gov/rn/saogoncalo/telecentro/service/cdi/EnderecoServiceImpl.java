package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.EnderecoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EnderecoDAO dao;
	
	@Override
	public boolean salvar(Endereco endereco) {
		return this.dao.salvar(endereco);
	}
	
}
