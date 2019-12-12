package br.gov.rn.saogoncalo.telecentro.service;

import java.util.List;

import br.gov.rn.saogoncalo.telecentro.model.RegistroAula;

public interface RegistroAulaService {

	public boolean salvarRegistros(List<RegistroAula> registrosAula);
	
}
