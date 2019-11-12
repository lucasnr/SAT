package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;

public class UnidadeServiceImpl implements UnidadeService {

	@Inject
	private UnidadeDAO dao;

	@Override
	public boolean salvar(Unidade unidade) {
		return this.dao.salvar(unidade);
	}

}
