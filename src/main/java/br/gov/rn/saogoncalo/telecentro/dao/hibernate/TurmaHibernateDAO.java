package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.TurmaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Turma;

public class TurmaHibernateDAO extends AbstractHibernateDAO<Turma, Long> implements TurmaDAO {

	public TurmaHibernateDAO() {
		super(Turma.class);
	}

	@Override
	public Optional<Turma> buscarPorCodigo(String codigo) {
		return super.buscarPorCampoUnico("codigo", codigo);
	}

	@Override
	public boolean atualizar(Turma turma) {
		Session session = super.sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Query<?> query = session.createQuery("update Turma t SET t.instrutor = :instrutor, t.turno = :turno where t.id = :id");
		query.setParameter("instrutor", turma.getInstrutor());
		query.setParameter("turno", turma.getTurno());
		query.setParameter("id", turma.getId());
		int linhasAlteradas = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return linhasAlteradas == 1;
	}
}
