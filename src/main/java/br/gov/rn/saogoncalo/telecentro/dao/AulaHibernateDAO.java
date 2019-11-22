package br.gov.rn.saogoncalo.telecentro.dao;

import br.gov.rn.saogoncalo.telecentro.dao.hibernate.AbstractHibernateDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aula;

public class AulaHibernateDAO extends AbstractHibernateDAO<Aula, Long> implements AulaDAO {

	protected AulaHibernateDAO() {
		super(Aula.class);
	}

}
