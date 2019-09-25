package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public class UnidadeHibernateDAO extends AbstractHibernateDAO<Unidade, Long> implements UnidadeDAO {

	public UnidadeHibernateDAO() {
		super(Unidade.class);
	}

}
