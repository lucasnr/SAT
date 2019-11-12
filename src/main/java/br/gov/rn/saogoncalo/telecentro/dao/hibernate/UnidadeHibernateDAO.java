package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import org.hibernate.Session;

import br.gov.rn.saogoncalo.telecentro.dao.UnidadeDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public class UnidadeHibernateDAO extends AbstractHibernateDAO<Unidade, Long> implements UnidadeDAO {

	public UnidadeHibernateDAO() {
		super(Unidade.class);
	}

	@Override
	protected void salva(Session session, Unidade unidade) {
		if (enderecoNotSaved(unidade.getEndereco())) {
			findEnderecoOrSave(session, unidade);
		}
		session.save(unidade);
	}

	private void findEnderecoOrSave(Session session, Unidade unidade) {
		Endereco endereco = unidade.getEndereco();
		EnderecoHibernateDAO dao = new EnderecoHibernateDAO();
		Optional<Endereco> optional = dao.buscarPorBairroLogradouroNumero(endereco.getBairro(), endereco.getLogradouro(), endereco.getNumero());
		if (optional.isPresent()) 
			unidade.setEndereco(optional.get());
		else
			session.save(endereco);
	}

	private boolean enderecoNotSaved(Endereco endereco) {
		return endereco.getId() == null || endereco.getId() == 0;
	}

}
