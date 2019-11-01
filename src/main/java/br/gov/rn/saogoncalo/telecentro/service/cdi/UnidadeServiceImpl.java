package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;

public class UnidadeServiceImpl implements UnidadeService {

	@Inject
	private UnidadeDAO dao;

	@Override
	public boolean salvar(Unidade unidade) {
		try {
			return this.dao.salvar(unidade);
		} catch (ConstraintViolationException e) {
			throw new IllegalArgumentException("Algum dado não foi informado ou já existe");
		} catch (DataException e) {
			throw new IllegalArgumentException("Algum campo informado não é válido");
		}
	}

}
