package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.CoordenadorGeralDAO;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;

public class CoordenadorGeralHibernateDAO extends CoordenadorHibernateDAO<CoordenadorGeral> implements CoordenadorGeralDAO {

	public CoordenadorGeralHibernateDAO() {
		super(CoordenadorGeral.class);
	}

}
