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
	
	
	public static String gerarNovaMatricula(String matricula, String cod_turma_destino, String matriculaDoUltimoAluno) {

		String numeroEmString = matriculaDoUltimoAluno.substring(matriculaDoUltimoAluno.length() - 4);
		int ordemDoUltimoAluno = Integer.parseInt(numeroEmString);

		int ordemDoNovoAluno = ordemDoUltimoAluno + 1;

		String ordemDoNovoAlunoString = String.format("%04d", ordemDoNovoAluno);
		String ordem = ordemDoNovoAlunoString;
		char[] ord = ordem.toCharArray();

		// yyyy u t pp ss aa
		// 2016 1 1 01 001 0001
		// ano tipoUsuario trimestre unidadeTelecentro ordemCadastroTurma
		// ordemCadastroAluno

		char[] mat = null;
		String palavra = matricula;
		mat = palavra.toCharArray();
		System.out.println(mat.length);

		// yyyy uu t ss
		// 2016 02 2 002
		// ano unidadeTelecentro trimestre ordemCadastroTurma

		char[] tur = null;
		String trasnferir = cod_turma_destino;
		tur = trasnferir.toCharArray();

		// Alteração na unidade do Telecentro do aluno
		mat[6] = tur[4];
		mat[7] = tur[5];

		// Alteração no trimestre do aluno
		mat[5] = tur[6];

		// Alteração na ordem de cadastro da turma do aluno
		mat[8] = tur[7];
		mat[9] = tur[8];
		mat[10] = tur[9];

		// Alteração na ordem de cadastro do aluno
		mat[11] = ord[0];
		mat[12] = ord[1];
		mat[13] = ord[2];
		mat[14] = ord[3];

		String novaMatricula = "";
		for (int i = 0; i < mat.length; i++) {
			novaMatricula += mat[i];
		}
		return novaMatricula;
	}
}
