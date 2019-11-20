package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;

public class AlunoHibernateDAO extends UsuarioHibernateDAO<Aluno> implements AlunoDAO {

	public AlunoHibernateDAO() {
		super(Aluno.class);
	}

	@Override
	public Optional<Aluno> buscarUltimoAlunoDaTurma(String codigoDaTurma) {
		Session session = getSession();
		
		Query<Aluno> query = session.createQuery("from Aluno a where a.turma.codigo = :codigo order by dataCadastro desc limit 1", Aluno.class);
		query.setParameter("codigo", codigoDaTurma);
		Aluno resultado = query.uniqueResult();
		return Optional.ofNullable(resultado);
	}

}
