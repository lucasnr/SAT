package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.AlunoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Boletim;
import br.gov.rn.saogoncalo.telecentro.model.Contato;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.model.Pessoa;

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
	
	@Override
	public void salva(Session session, Aluno aluno) {
		Pessoa pessoa = aluno.getPessoa();
		Endereco endereco = pessoa.getEndereco();
		Contato contato = pessoa.getContato();
		
		try {			
			if(enderecoNotSaved(endereco)) {
				findEnderecoOrSave(session, pessoa, endereco);
			}
			session.save(pessoa);
			contato.setId(pessoa.getId());
			session.save(contato);
			session.save(aluno);
			List<Boletim> boletins = aluno.getBoletins();
			for (Boletim boletim : boletins) {
				Boletim boletimComId = new Boletim(aluno, boletim.getModulo(), 0);
				session.save(boletimComId);
			}
		} catch (Exception e) {
			endereco.setId(0l);
			contato.setId(0l);
			throw e;
		}
	}
}
