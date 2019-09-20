package br.gov.rn.saogoncalo.telecentro.model.builder;

import java.time.LocalDate;

import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Turno;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;

public class TurmaBuilder {

	private String nome;
	private Turno turno;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Unidade unidade;

	public Turma build() {
		return new Turma(nome, turno, dataInicio, dataFim, unidade);
	}
	
	public TurmaBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public TurmaBuilder turno(Turno turno) {
		this.turno = turno;
		return this;
	}
	
	public TurmaBuilder inicio(LocalDate inicio) {
		dataInicio = inicio;
		return this;
	}
	
	public TurmaBuilder fim(LocalDate fim) {
		dataFim = fim;
		return this;
	}
	
	public TurmaBuilder unidade(Unidade unidade) {
		this.unidade = unidade;
		return this;
	}
	
}
