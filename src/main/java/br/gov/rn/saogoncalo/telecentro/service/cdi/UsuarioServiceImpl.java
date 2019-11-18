package br.gov.rn.saogoncalo.telecentro.service.cdi;

import java.util.Optional;

import javax.inject.Inject;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDAO<Usuario> dao;
	
	@Override
	public boolean salvar(Usuario usuario) {
		gerarMatricula(usuario);
		return dao.salvar(usuario);
	}

	public Optional<Usuario> buscarPorMatricula(String matricula) {
		return dao.buscarPorMatricula(matricula);
	}
	
	 public Optional<Usuario> buscarPorId(Long id) {
		 return dao.buscarPorPK(id);
	 }
	
}
