package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.AulaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aula;

public class AulaHibernateDAO extends EntidadeHibernateDAO<Aula> implements AulaDAO {

	public AulaHibernateDAO() {
		super(Aula.class);
	}

}
