package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.EnderecoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService {

	@Inject
	private EnderecoDAO dao;
	
	@Override
	public boolean salvar(Endereco endereco) {
		return this.dao.salvar(endereco);
	}
	
}
