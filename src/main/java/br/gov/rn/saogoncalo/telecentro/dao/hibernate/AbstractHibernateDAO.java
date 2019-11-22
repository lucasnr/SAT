package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.AbstractDAO;

public class AbstractHibernateDAO<T, PK> implements AbstractDAO<T, PK> {

	protected SessionFactory sessionFactory;
	protected Class<T> type;

	protected AbstractHibernateDAO(Class<T> type) {
		sessionFactory = SessionFactorySingleton.newInstance();
		this.type = type;
	}

	@Override
	public final boolean salvar(T obj) {
		Session session = getSession();
		session.getTransaction().begin();
		try {
			salva(session, obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	protected void salva(Session session, T obj) {
		session.save(obj);
	}

	@Override
	public boolean deletar(T obj) {
		Session session = getSession();
		session.getTransaction().begin();
		session.delete(obj);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public List<T> listar(int offset, int limit) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(type);
		criteriaQuery.from(type);
		Query<T> query = session.createQuery(criteriaQuery);
		return query.list();
	}

	@Override
	public Optional<T> buscarPorPK(PK primaryKey) {
		Session session = getSession();
		session.getTransaction().begin();
		T obj = session.find(type, primaryKey);
		session.getTransaction().commit();
		return Optional.ofNullable(obj);
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	protected Optional<T> buscarPorCampoUnico(String campo, Object valor) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);

		Root<T> root = criteria.from(type);
		Path<T> path = root.get(campo);
		Predicate equal = builder.equal(path, valor);
		criteria.where(equal);

		Query<T> query = session.createQuery(criteria);
		T resultado = query.uniqueResult();
		return Optional.ofNullable(resultado);
	}

	protected Optional<T> buscarPorCamposUnicos(Map<String, Object> parametros) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		Root<T> root = criteria.from(type);

		Predicate[] restrictions = new Predicate[parametros.size()];
		int index = 0;
		for (Entry<String, Object> parametro : parametros.entrySet()) {
			Path<T> path = root.get(parametro.getKey());
			Predicate restriction = builder.equal(path, parametro.getValue());
			restrictions[index++] = restriction;
		}
		criteria.where(restrictions);

		Query<T> query = session.createQuery(criteria);
		T resultado = query.uniqueResult();
		return Optional.ofNullable(resultado);
	}

	@Override
	public boolean atualizar(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
