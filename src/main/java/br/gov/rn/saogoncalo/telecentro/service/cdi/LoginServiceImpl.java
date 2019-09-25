package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;
import br.gov.rn.saogoncalo.telecentro.service.LoginService;

public class LoginServiceImpl implements LoginService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO<Usuario> usuarioDAO;
	
	@Override
	public Optional<Usuario> login(CredenciaisDTO credenciais) {
		return buscarUsuarioPorCredenciais(credenciais);
	}

	private Optional<Usuario> buscarUsuarioPorCredenciais(CredenciaisDTO credenciais) {
		String matricula = credenciais.getMatricula();
		String senha = credenciais.getSenha();
		return usuarioDAO.buscarPorMatriculaSenha(matricula, senha);
	}
	
}
