package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public interface UsuarioDAO<T extends Usuario> {
	public Optional<T> buscarPorMatricula(String matricula);
	public Optional<T> buscarPorMatriculaSenha(String matricula, String senha);
}
