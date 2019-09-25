package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

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

}
