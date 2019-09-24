package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory newInstance() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
}
