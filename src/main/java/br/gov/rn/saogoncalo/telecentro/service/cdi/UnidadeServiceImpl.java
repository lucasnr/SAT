package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.util.List;

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

	@Override
	public List<Unidade> listar() {
		return dao.listar(0, 0);
	}
	
}
