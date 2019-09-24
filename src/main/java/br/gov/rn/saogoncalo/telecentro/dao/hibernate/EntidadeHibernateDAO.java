package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.EntidadeDAO;

public class EntidadeHibernateDAO<T> extends AbstractHibernateDAO<T> implements EntidadeDAO<T> {

	protected EntidadeHibernateDAO(Class<T> type) {
		super(type);
	}

	@Override
	public Optional<T> buscarPorId(Long id) {
		Session session = sessionFactory.openSession();
		T obj = session.find(type, id);
		return Optional.ofNullable(obj);
	}
	
}
