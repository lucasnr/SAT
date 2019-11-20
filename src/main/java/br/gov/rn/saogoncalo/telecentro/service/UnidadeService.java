package br.gov.rn.saogoncalo.telecentro.service;

import java.util.List;
import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public interface UnidadeService {

	public boolean salvar(Unidade unidade);
	public Optional<Unidade> buscarPorId(Long id);
	public List<Unidade> listar();
}
