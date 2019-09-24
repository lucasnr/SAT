package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.PessoaDAO;
import br.gov.rn.saogoncalo.telecentro.model.Pessoa;

public class PessoaHibernateDAO extends EntidadeHibernateDAO<Pessoa> implements PessoaDAO {

	public PessoaHibernateDAO() {
		super(Pessoa.class);
	}
	
	@Override
	public Optional<Pessoa> buscarPorCpf(String cpf) {
		return super.buscarPorCampoUnico("cpf", cpf);
	}

	@Override
	public Optional<Pessoa> buscarPorRg(String rg) {
		return super.buscarPorCampoUnico("rg", rg);
	}

}
