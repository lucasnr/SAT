package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.List;
import java.util.Optional;

public interface AbstractDAO<T, PK> {

	public boolean salvar(T obj);
	public boolean deletar(T obj);
	public List<T> listar(int offset, int limit);
	public Optional<T> buscarPorPK(PK primaryKey);
}
