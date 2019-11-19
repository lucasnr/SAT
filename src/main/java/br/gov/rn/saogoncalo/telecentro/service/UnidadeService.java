package br.gov.rn.saogoncalo.telecentro.service;

import java.util.List;

import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public interface UnidadeService {

	public boolean salvar(Unidade unidade);
	public List<Unidade> listar();
}
