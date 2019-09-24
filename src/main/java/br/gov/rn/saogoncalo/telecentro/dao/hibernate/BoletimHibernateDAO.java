package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.BoletimDAO;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;

public class BoletimHibernateDAO extends AbstractHibernateDAO<Boletim> implements BoletimDAO {

	public BoletimHibernateDAO() {
		super(Boletim.class);
	}
	
}
