package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.EnderecoDAO;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;

public class EnderecoHibernateDAO extends AbstractHibernateDAO<Endereco, Long> implements EnderecoDAO {

	public EnderecoHibernateDAO() {
		super(Endereco.class);
	}

	@Override
	public Optional<Endereco> buscarPorCep(String cep) {
		return super.buscarPorCampoUnico("cep", cep);
	}

	@Override
	public Optional<Endereco> buscarPorBairroLogradouroNumero(String bairro, String logradouro, String numero) {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("bairro", bairro);
		parametros.put("logradouro", logradouro);
		parametros.put("numero", numero);
		
		return super.buscarPorCamposUnicos(parametros);
	}
	
}
