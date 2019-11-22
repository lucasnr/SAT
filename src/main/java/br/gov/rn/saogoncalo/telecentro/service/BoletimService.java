package br.gov.rn.saogoncalo.telecentro.service;

import java.util.List;

import br.gov.rn.saogoncalo.telecentro.model.Boletim;

public interface BoletimService {

	public boolean atualizarTodos(List<Boletim> boletins);

}
