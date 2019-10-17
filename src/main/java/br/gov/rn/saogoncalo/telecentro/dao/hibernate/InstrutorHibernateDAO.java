package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.InstrutorDAO;
import br.gov.rn.saogoncalo.telecentro.model.Contato;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Pessoa;

public class InstrutorHibernateDAO extends UsuarioHibernateDAO<Instrutor> implements InstrutorDAO {

	public InstrutorHibernateDAO() {
		super(Instrutor.class);
	}

	@Override
	public boolean salvar(Instrutor obj) {
		Session session = super.sessionFactory.openSession();
		session.getTransaction().begin();
		
		Pessoa pessoa = obj.getPessoa();
		session.save(pessoa.getEndereco());
		session.save(pessoa);
		Contato contato = pessoa.getContato();
		contato.setId(pessoa.getId());
		session.save(contato);
		session.save(obj);
		
		session.getTransaction().commit();
		return true;
	}
}
