package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorUnidade;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;

public final class GeradorDeMatricula implements Visitor {
	
	private GeradorDeMatricula() {
	}

	@Override
	public String visit(Aluno aluno) {
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

	@Override
	public String visit(Instrutor instrutor) {
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

	@Override
	public String visit(CoordenadorUnidade coordenadorUnidade) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "CU";
		Integer trimestre = DataUtil.getTrimestre();
		Long idDaUnidade = coordenadorUnidade.getUnidade().getId();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", trimestre));
		matricula.append(String.format("%02d", idDaUnidade));
		return matricula.toString();
	}

	@Override
	public String visit(CoordenadorGeral coordenadorGeral) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "CG";
		Integer trimestre = DataUtil.getTrimestre();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", trimestre));
		return matricula.toString();
	}

	@Override
	public String visit(Usuario usuario) {
		throw new RuntimeException("Matriculas não podem ser geradas para usuários sem perfil");
	}

	public static String gerar(Usuario usuario) {
		return usuario.accept(new GeradorDeMatricula());
	}
	
}
