package br.gov.rn.saogoncalo.telecentro.service.cdi;

import javax.inject.Inject;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

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
			return this.dao.salvar(endereco);
		} catch(ConstraintViolationException e) {
			if(e.getErrorCode() == NULL_COLUMN)
				throw new IllegalArgumentException("Algum campo não foi especificado");
			else if(e.getErrorCode() == DUPLICATE_CONSTRAINT) 
				throw new IllegalArgumentException("O endereço já existe");
		} catch (DataException e) {
			throw new IllegalArgumentException("Algum campo informado não é válido");
		}
		return false;
	}
	
}
