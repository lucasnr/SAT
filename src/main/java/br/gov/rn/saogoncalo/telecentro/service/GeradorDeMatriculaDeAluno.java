package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GeradorDeMatriculaDeAluno implements GeradorDeMatricula {

	private GeradorDeMatricula proximo;

	@Override
	public String gera(Usuario usuario) {
		if(usuario instanceof Aluno) {			
			Aluno aluno = (Aluno) usuario;
			return gerarMatricula(aluno);
		}
		else if(proximo != null)
			return proximo.gera(usuario);
		
		throw new IllegalArgumentException("O usuario não é do tipo Aluno e nenhum outro gerador foi fornecido");
	}

	private String gerarMatricula(Aluno aluno) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "AL";
		Integer trimestre = DataUtil.getTrimestre();
		Turma turmaDoAluno = aluno.getTurma();
		Long idDaUnidade = turmaDoAluno.getUnidade().getId();
		String codigoDaTurma = turmaDoAluno.getCodigo();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", trimestre));
		matricula.append(String.format("%02d", idDaUnidade));
		matricula.append(codigoDaTurma);
		return matricula.toString();
	}

}
