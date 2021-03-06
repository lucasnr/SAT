package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Turma;

public interface TurmaDAO extends AbstractDAO<Turma, Long> {
	public Optional<Turma> buscarPorCodigo(String codigo);
}
