package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.InstrutorDAO;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;

public class InstrutorHibernateDAO extends UsuarioHibernateDAO<Instrutor> implements InstrutorDAO {

	public InstrutorHibernateDAO() {
		super(Instrutor.class);
	}

}
