package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Aula;

public interface AulaService {

	public boolean salvar(Aula aula);

	public Optional<Aula> buscarPorId(Long id);

}
