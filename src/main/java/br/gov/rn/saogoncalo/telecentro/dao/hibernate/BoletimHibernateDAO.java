package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.BoletimDAO;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.BoletimId;

public class BoletimHibernateDAO extends AbstractHibernateDAO<Boletim, BoletimId> implements BoletimDAO {

	public BoletimHibernateDAO() {
		super(Boletim.class);
	}
	
}
