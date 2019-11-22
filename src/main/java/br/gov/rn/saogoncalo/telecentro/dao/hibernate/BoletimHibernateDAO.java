package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.BoletimDAO;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.BoletimId;

public class BoletimHibernateDAO extends AbstractHibernateDAO<Boletim, BoletimId> implements BoletimDAO {

	public BoletimHibernateDAO() {
		super(Boletim.class);
	}

	@Override
	public boolean atualizarTodos(List<Boletim> boletins) {
		Session session = getSession();
		session.getTransaction().begin();
		
		boletins.forEach(b -> session.update(b));
		
		session.getTransaction().commit();
		return true;
	}
	
}
