package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public interface UsuarioService {

	public boolean salvar(Usuario usuario);
	public boolean atualizar(Usuario usuario);
	
	public Optional<Usuario> buscarPorMatricula(String matricula);
	public Optional<Usuario> buscarPorId(Long id);
	
	public void gerarMatricula(Usuario usuario);
}
