package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Modulo;

public interface ModuloDAO extends EntidadeDAO<Modulo> {
	public Optional<Modulo> buscarPorTitulo(String titulo);
}
