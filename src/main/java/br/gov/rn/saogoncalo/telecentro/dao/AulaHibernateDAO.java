package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.hibernate.AbstractHibernateDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aula;

public class AulaHibernateDAO extends AbstractHibernateDAO<Aula, Long> implements AulaDAO {

	protected AulaHibernateDAO() {
		super(Aula.class);
	}

	@Override
	public Optional<Aula> buscarPorId(Long id) {
		return super.buscarPorPK(id);
	}

}
