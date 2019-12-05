package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.List;

import br.gov.rn.saogoncalo.telecentro.model.RegistroAula;

public interface RegistroAulaDAO {

	public boolean salvarTodos(List<RegistroAula> registrosAula);

}
