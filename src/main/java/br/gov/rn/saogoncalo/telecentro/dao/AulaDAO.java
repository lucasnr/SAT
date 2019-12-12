package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Aula;

public interface AulaDAO {

	public boolean salvar(Aula aula);

	public Optional<Aula> buscarPorId(Long id);

}
