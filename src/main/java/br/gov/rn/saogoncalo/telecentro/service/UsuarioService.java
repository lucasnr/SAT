package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public interface UsuarioService {

	public boolean salvar(Usuario usuario);
	
	public default void gerarMatricula(Usuario usuario) {
		String matriculaGerada = GeradorDeMatricula.gerar(usuario);
		usuario.setMatricula(matriculaGerada);
	}
}
