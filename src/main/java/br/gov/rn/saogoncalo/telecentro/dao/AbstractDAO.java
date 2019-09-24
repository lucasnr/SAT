package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.List;

public interface AbstractDAO<T> {

	public boolean salvar(T obj);
	public boolean deletar(T obj);
	public List<T> listar(int offset, int limit);
}
