package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorUnidade;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;

public final class GeradorDeMatricula implements Visitor {
	
	private Long ordem;


	private GeradorDeMatricula(Long lastId) {
		this.ordem = lastId + 1;
	}
	
	@Override
	public String visit(Aluno aluno) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "4";
		Integer trimestre = DataUtil.getTrimestre();
		Turma turmaDoAluno = aluno.getTurma();
		Long idDaUnidade = turmaDoAluno.getUnidade().getId();
		Long idDaTurma = turmaDoAluno.getId();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(trimestre);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", idDaUnidade));
		matricula.append(String.format("%03d", idDaTurma));
		matricula.append(String.format("%04d", ordem));
		return matricula.toString();
	}

	@Override
	public String visit(Instrutor instrutor) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "3";
		Integer trimestre = DataUtil.getTrimestre();
		Long idDaUnidade = instrutor.getUnidade().getId();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(trimestre);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", idDaUnidade));
		matricula.append(String.format("%04d", ordem));
		return matricula.toString();
	}

	@Override
	public String visit(CoordenadorUnidade coordenadorUnidade) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "2";
		Integer trimestre = DataUtil.getTrimestre();
		Long idDaUnidade = coordenadorUnidade.getUnidade().getId();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(trimestre);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%02d", idDaUnidade));
		matricula.append(String.format("%04d", ordem));
		return matricula.toString();
	}

	@Override
	public String visit(CoordenadorGeral coordenadorGeral) {
		String anoAtual = DataUtil.getAnoAtual();
		String tipoDeUsuario = "1";
		Integer trimestre = DataUtil.getTrimestre();
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(trimestre);
		matricula.append(tipoDeUsuario);
		matricula.append(String.format("%04d", ordem));
		return matricula.toString();
	}

	@Override
	public String visit(Usuario usuario) {
		throw new RuntimeException("Matriculas não podem ser geradas para usuários sem perfil");
	}

	public static String gerar(Usuario usuario, Long lastId) {
		return usuario.accept(new GeradorDeMatricula(lastId));
	}
	
	
	public static String gerarNovaMatricula(String antigaMatricula, Turma turma, String matriculaDoUltimoAluno) {
		Long idDaUnidade = turma.getUnidade().getId();
		Long idDaTurma = turma.getId();
		
		String ordemDoUltimoAlunoEmString = matriculaDoUltimoAluno.substring(matriculaDoUltimoAluno.length() - 4);
		int ordemDoUltimoAluno = Integer.parseInt(ordemDoUltimoAlunoEmString);
		
		int ordemDoNovoAluno = ordemDoUltimoAluno + 1;
		
		String ordemDoNovoAlunoString = String.format("%04d", ordemDoNovoAluno);
		String ordem = ordemDoNovoAlunoString;
		char[] ordemArray = ordem.toCharArray();
		
		
		// ano trimestre tipoDeUsuario unidade turma ordemDoAluno
		// 2016 1 1 01 001 0001

		char[] antigaMatriculaArray = antigaMatricula.toCharArray();

		// ano trimestre unidade turno
		// 2016 1 02 M

		String ordemDaTurmaEmString = String.format("%03d", idDaTurma); // 3 posicoes
		char[] ordemDaTurma = ordemDaTurmaEmString.toCharArray();
		
		String ordemDaUnidadeEmString = String.format("%02d", idDaUnidade);
		char[] ordemDaUnidade = ordemDaUnidadeEmString.toCharArray();

		// Alteração na ordem da unidade
		antigaMatriculaArray[6] = ordemDaUnidade[0];
		antigaMatriculaArray[7] = ordemDaUnidade[1];

		// Alteração na ordem de cadastro da turma do aluno
		antigaMatriculaArray[8] = ordemDaTurma[0];
		antigaMatriculaArray[9] = ordemDaTurma[1];
		antigaMatriculaArray[10] = ordemDaTurma[2];
		
		// Alteração na ordem de cadastro do aluno
		antigaMatriculaArray[11] = ordemArray[0];
		antigaMatriculaArray[12] = ordemArray[1];
		antigaMatriculaArray[13] = ordemArray[2];
		antigaMatriculaArray[14] = ordemArray[3];

		String novaMatricula = "";
		for (int i = 0; i < antigaMatriculaArray.length; i++) {
			novaMatricula += antigaMatriculaArray[i];
		} 
		return novaMatricula;
	}
	
}
