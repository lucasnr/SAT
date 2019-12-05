package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.RegistroAulaDAO;
import br.gov.rn.saogoncalo.telecentro.model.RegistroAula;
import br.gov.rn.saogoncalo.telecentro.model.RegistroAulaId;

public class RegistroAulaHibernateDAO extends AbstractHibernateDAO<RegistroAula, RegistroAulaId> implements RegistroAulaDAO {

	protected RegistroAulaHibernateDAO() {
		super(RegistroAula.class);
	}

	@Override
	public boolean salvarTodos(List<RegistroAula> registrosAula) {
		Session session = getSession();
		session.getTransaction().begin();
		registrosAula.forEach(registro -> session.save(registro));
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
