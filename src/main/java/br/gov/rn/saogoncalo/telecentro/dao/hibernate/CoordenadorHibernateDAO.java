package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.CoordenadorDAO;
import br.gov.rn.saogoncalo.telecentro.model.Coordenador;

public class CoordenadorHibernateDAO<T extends Coordenador> extends UsuarioHibernateDAO<T> implements CoordenadorDAO<T> {

	protected CoordenadorHibernateDAO(Class<T> type) {
		super(type);
	}

}
