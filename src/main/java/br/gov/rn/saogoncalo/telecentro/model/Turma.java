package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turma {

	private Long id;
	private String codigo;
	private Turno turno;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Unidade unidade;
	private Instrutor instrutor;
}
