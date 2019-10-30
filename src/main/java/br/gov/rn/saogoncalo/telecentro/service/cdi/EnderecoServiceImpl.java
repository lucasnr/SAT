package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import org.hibernate.exception.ConstraintViolationException;

import br.gov.rn.saogoncalo.telecentro.dao.EnderecoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService {

	private static final int DUPLICATE_CONSTRAINT = 1062;
	private static final int NULL_COLUMN = 1048;
	
	@Inject
	private EnderecoDAO dao;
	
	@Override
	public boolean salvar(Endereco endereco) {
		try {
			dao.salvar(endereco);
			return true;
		} catch(ConstraintViolationException e) {
			if(e.getErrorCode() == NULL_COLUMN)
				throw new IllegalArgumentException("Algum campo n�o foi especificado");
			else if(e.getErrorCode() == DUPLICATE_CONSTRAINT) 
				throw new IllegalArgumentException("O endere�o j� existe");
		}
		return false;
	}
	
}
