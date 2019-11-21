package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.model.Contato;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.model.Pessoa;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public class UsuarioHibernateDAO<T extends Usuario> extends AbstractHibernateDAO<T, Long> implements UsuarioDAO<T> {

	public UsuarioHibernateDAO(Class<T> type) {
		super(type);
	}
	
	@Override
	public boolean atualizar(T obj) {
		Pessoa pessoa = obj.getPessoa();
		Contato contato = pessoa.getContato();
		Session session = getSession();
		session.getTransaction().begin();
		session.update(pessoa);
		session.update(contato);
		session.getTransaction().commit();
		return true;
	}
	
	@Override
	public Optional<T> buscarPorMatricula(String matricula) {
		return super.buscarPorCampoUnico("matricula", matricula);
	}

	@Override
	public Optional<T> buscarPorMatriculaSenha(String matricula, String senha) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("matricula", matricula);
		parametros.put("senha", senha);
		return super.buscarPorCamposUnicos(parametros);
	}
	
	@Override
	protected void salva(Session session, T obj) {
		Pessoa pessoa = obj.getPessoa();
		Endereco endereco = pessoa.getEndereco();
		Contato contato = pessoa.getContato();
		
		try {			
			if(enderecoNotSaved(endereco)) {
				findEnderecoOrSave(session, pessoa, endereco);
			}
			session.save(pessoa);
			contato.setId(pessoa.getId());
			session.save(contato);
			session.save(obj);
		} catch (Exception e) {
			endereco.setId(0l);
			contato.setId(0l);
			throw e;
		}
	}

	private void findEnderecoOrSave(Session session, Pessoa pessoa, Endereco endereco) {
		EnderecoHibernateDAO dao = new EnderecoHibernateDAO();
		Optional<Endereco> optional = dao.buscarPorBairroLogradouroNumero(endereco.getBairro(), endereco.getLogradouro(), endereco.getNumero());
		if(optional.isPresent())
			pessoa.setEndereco(optional.get());
		else
			session.save(endereco);
	}

	private boolean enderecoNotSaved(Endereco endereco) {
		return endereco.getId() == null || endereco.getId() == 0;
	}

	@Override
	public Long buscarUltimoId() {
		Session session = getSession();
		session.getTransaction().begin();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<? extends Usuario> criteriaQuery = builder.createQuery(type);
		Root<? extends Usuario> root = criteriaQuery.from(type);
		criteriaQuery.orderBy(builder.desc(root.get("id")));
		Query<? extends Usuario> query = session.createQuery(criteriaQuery);
		Usuario usuario = query.setMaxResults(1).uniqueResult();
		
		session.getTransaction().commit();
		return usuario.getId();
	}
	
}
