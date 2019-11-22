package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.List;

import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.BoletimId;

public interface BoletimDAO extends AbstractDAO<Boletim, BoletimId> {

	public boolean atualizarTodos(List<Boletim> boletins);

}
