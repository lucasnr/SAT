package br.gov.rn.saogoncalo.telecentro.util;

import java.time.LocalDate;
import java.time.Year;

public class DataUtil {

	public static Integer getTrimestre() {
		return getTrimestre(LocalDate.now());
	}
	
	public static Integer getTrimestre(LocalDate data) {
		Integer mesAtual = data.getMonthValue();
		Integer trimestre = null;
		if (mesAtual <= 3)
			trimestre = 1;
		else if (mesAtual > 3 && mesAtual <= 6)
			trimestre = 2;
		else if (mesAtual > 6 && mesAtual <= 9)
			trimestre = 3;
		else if (mesAtual > 9)
			trimestre = 4;
		return trimestre;
	}

	public static String getAnoAtual() {
		return Year.now().toString();
	}

}
