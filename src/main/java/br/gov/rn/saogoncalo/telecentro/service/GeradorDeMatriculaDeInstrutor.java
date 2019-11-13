package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GeradorDeMatriculaDeInstrutor implements GeradorDeMatricula {

	private GeradorDeMatricula proximo;

	@Override
	public String gera(Usuario usuario) {
		if (usuario instanceof Instrutor) {			
			Instrutor instrutor = (Instrutor) usuario;
			return gerarMatricula(instrutor);
		}
		else if (proximo != null)
			return proximo.gera(usuario);

		throw new IllegalArgumentException("O usuario não é do tipo Instrutor e nenhum outro gerador foi fornecido");
	}

	private String gerarMatricula(Instrutor instrutor) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "IN";
		Integer trimestre = DataUtil.getTrimestre();
		Long idDaUnidade = instrutor.getUnidade().getId();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", trimestre));
		matricula.append(String.format("%02d", idDaUnidade));
		return matricula.toString();
	}

}
