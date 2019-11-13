package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Turno;
import br.gov.rn.saogoncalo.telecentro.util.DataUtil;

public class GeradorDeCodigoDeTurma {

	public static String gerar(Turma turma) {
		String anoAtual = DataUtil.getAnoAtual();
		Integer trimestre = DataUtil.getTrimestre();
		Long idDaUnidade = turma.getUnidade().getId();
		String turno = "M";
		if(turma.getTurno() == Turno.VESPERTINO)
			turno = "V";
		else if(turma.getTurno() == Turno.NOTURNO)
			turno = "N";
		
		StringBuilder matricula = new StringBuilder();
		matricula.append(anoAtual);
		matricula.append(String.format("%02d", trimestre));
		matricula.append(String.format("%02d", idDaUnidade));
		matricula.append(turno);
		return matricula.toString();
	}
}
