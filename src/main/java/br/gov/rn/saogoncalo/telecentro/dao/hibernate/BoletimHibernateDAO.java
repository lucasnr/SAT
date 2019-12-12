package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.BoletimDAO;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.BoletimId;

public class BoletimHibernateDAO extends AbstractHibernateDAO<Boletim, BoletimId> implements BoletimDAO {

	public BoletimHibernateDAO() {
		super(Boletim.class);
	}

	@Override
	public boolean atualizarTodos(List<Boletim> boletins) {
		Session session = sessionFactory.getCurrentSession();

		try {			
			session.getTransaction().begin();
			
			boolean atualizou = true;
			for (Boletim boletim : boletins) {				
				Query<?> query = session.createQuery("update Boletim b set b.nota = :nota where b.id = :id");
				query.setParameter("nota", boletim.getNota());
				query.setParameter("id", boletim.getId());
				int linhasAlteradas = query.executeUpdate();
				atualizou = atualizou && linhasAlteradas == 1;
			}
			session.getTransaction().commit();
			return atualizou;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {			
			session.close();
		}
	}
	
}
