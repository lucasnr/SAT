package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.CoordenadorUnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorUnidade;

public class CoordenadorUnidadeHibernateDAO extends CoordenadorHibernateDAO<CoordenadorUnidade> implements CoordenadorUnidadeDAO {

	public CoordenadorUnidadeHibernateDAO() {
		super(CoordenadorUnidade.class);
	}
}
