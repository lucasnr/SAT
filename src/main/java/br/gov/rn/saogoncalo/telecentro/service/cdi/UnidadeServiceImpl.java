package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;

public class UnidadeServiceImpl implements UnidadeService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public Optional<Unidade> buscarPorId(Long id) {
		return dao.buscarPorPK(id);
	}
	
}
