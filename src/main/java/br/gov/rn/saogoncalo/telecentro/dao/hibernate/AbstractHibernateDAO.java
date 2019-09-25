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
	public boolean salvar(T obj) {
		Session session = getSession();
		session.getTransaction().begin();
		session.save(obj);
		session.getTransaction().commit();
		return true;
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
		T obj = session.find(type, primaryKey);
		return Optional.ofNullable(obj);
	}

	private Session getSession() {
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

		for (Entry<String, Object> parametro : parametros.entrySet()) {			
			Path<T> path = root.get(parametro.getKey());
			Predicate equal = builder.equal(path, parametro.getValue());
			criteria = criteria.where(equal);
		}

		Query<T> query = session.createQuery(criteria);
		T resultado = query.uniqueResult();
		return Optional.ofNullable(resultado);
	}

}
