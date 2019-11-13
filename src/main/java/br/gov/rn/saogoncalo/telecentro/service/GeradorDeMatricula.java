package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public interface GeradorDeMatricula {

	public static String gerar(Usuario usuario) {
		GeradorDeMatricula gerador = 
				new GeradorDeMatriculaDeAluno(
						new GeradorDeMatriculaDeInstrutor(
								new GeradorDeMatriculaDeCoordenadorDeUnidade(
										new GeradorDeMatriculaDeCoordenadorGeral())));
		return gerador.gera(usuario);
	}

	public String gera(Usuario usuario);
}
