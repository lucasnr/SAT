package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;

public class Turma {

	private final String nome;
	private final Turno turno;
	private final LocalDate dataInicio;
	private final LocalDate dataFim;
	private final Unidade unidade;
	
	public Turma(String nome, Turno turno, LocalDate dataInicio, LocalDate dataFim, Unidade unidade) {
		this.nome = nome;
		this.turno = turno;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public Turno getTurno() {
		return turno;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public Unidade getUnidade() {
		return unidade;
	}
	
}
