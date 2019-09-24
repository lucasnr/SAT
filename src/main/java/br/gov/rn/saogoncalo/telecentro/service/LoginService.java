package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.dao.hibernate.AlunoHibernateDAO;
import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;

public class LoginService {

	public Optional<Usuario> login(CredenciaisDTO credenciais) {
		String matricula = credenciais.getMatricula();
		String senha = credenciais.getSenha();
		UsuarioDAO<Aluno> dao = new AlunoHibernateDAO();
		return dao.buscarPorMatriculaSenha(matricula, senha).map(a -> a);
	}
	
}
