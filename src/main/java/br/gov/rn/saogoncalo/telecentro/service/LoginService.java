package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.dao.hibernate.UsuarioHibernateDAO;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;

public class LoginService {

	public Optional<Usuario> login(CredenciaisDTO credenciais) {
		return buscarUsuarioPorCredenciais(credenciais);
	}

	private Optional<Usuario> buscarUsuarioPorCredenciais(CredenciaisDTO credenciais) {
		String matricula = credenciais.getMatricula();
		String senha = credenciais.getSenha();
		UsuarioDAO<Usuario> dao = new UsuarioHibernateDAO<>(Usuario.class);
		return dao.buscarPorMatriculaSenha(matricula, senha);
	}
	
}
