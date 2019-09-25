package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public class UsuarioHibernateDAO<T extends Usuario> extends AbstractHibernateDAO<T, Long> implements UsuarioDAO<T> {

	public UsuarioHibernateDAO(Class<T> type) {
		super(type);
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
}
