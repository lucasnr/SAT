package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GeradorDeMatriculaDeCoordenadorGeral implements GeradorDeMatricula {

	private GeradorDeMatricula proximo;

	@Override
	public String gera(Usuario usuario) {
		if (usuario instanceof CoordenadorGeral)
			return gerarMatricula();
		else if (proximo != null)
			return proximo.gera(usuario);

		throw new IllegalArgumentException(
				"O usuario não é do tipo Coordenador Geral e nenhum outro gerador foi fornecido");
	}

	private String gerarMatricula() {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "CG";
		Integer trimestre = DataUtil.getTrimestre();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", trimestre));
		return matricula.toString();
	}

}
