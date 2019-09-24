package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;

public class AlunoHibernateDAO extends UsuarioHibernateDAO<Aluno> implements AlunoDAO {

	public AlunoHibernateDAO() {
		super(Aluno.class);
	}

}
