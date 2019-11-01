package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public class UnidadeHibernateDAO extends AbstractHibernateDAO<Unidade, Long> implements UnidadeDAO {

	public UnidadeHibernateDAO() {
		super(Unidade.class);
	}

	@Override
	protected void salva(Session session, Unidade obj) {
		Endereco endereco = obj.getEndereco();
		if (enderecoNotSaved(endereco)) {
			session.save(endereco);
		}
		session.save(obj);
	}

	private boolean enderecoNotSaved(Endereco endereco) {
		return endereco.getId() == null;
	}

}
