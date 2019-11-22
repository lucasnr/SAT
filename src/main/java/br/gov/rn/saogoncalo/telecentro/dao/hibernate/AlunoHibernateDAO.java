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
		
		Query<Aluno> query = session.createQuery("select a from Aluno a join Pessoa p on p.id = a.pessoa.id where a.turma.codigo = :codigo order by p.dataCadastro desc", Aluno.class);
		query.setParameter("codigo", codigoDaTurma);
		Aluno resultado = query.setMaxResults(1).uniqueResult();
		return Optional.ofNullable(resultado);
	}

	@Override
	public boolean atualizar(Aluno aluno) {
		Session session = super.sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Query<?> query = session.createQuery("update Aluno a SET a.matricula = :matricula, a.turma = :turma where a.id = :id");
		query.setParameter("matricula", aluno.getMatricula());
		query.setParameter("turma", aluno.getTurma());
		query.setParameter("id", aluno.getUsuarioId());
		int linhasAlteradas = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return linhasAlteradas == 1;
	}
	
}
