package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

public interface EntidadeDAO<T> extends AbstractDAO<T> {
	public Optional<T> buscarPorId(Long id);
}
