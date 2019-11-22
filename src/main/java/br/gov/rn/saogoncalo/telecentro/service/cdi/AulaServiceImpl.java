package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.AulaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aula;
import br.gov.rn.saogoncalo.telecentro.service.AulaService;

public class AulaServiceImpl implements AulaService {

	@Inject
	private AulaDAO dao;
	
	@Override
	public boolean salvar(Aula aula) {
		return dao.salvar(aula);
	}

}
