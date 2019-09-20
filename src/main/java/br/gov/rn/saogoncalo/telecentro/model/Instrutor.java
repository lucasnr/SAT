package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;

public class Instrutor extends Usuario {

	private final Turma turma;

	public Instrutor(String matricula, String senha, String nome, String cpf, String rg, LocalDate dataNascimento,
			Sexo sexo, Contato contato, Endereco endereco, Turma turma) {
		super(matricula, senha, nome, cpf, rg, dataNascimento, sexo, contato, endereco);
		this.turma = turma;
	}

	public Instrutor(String senha, String nome, String cpf, String rg, LocalDate dataNascimento, Sexo sexo,
			Contato contato, Endereco endereco, Turma turma) {
		super(senha, nome, cpf, rg, dataNascimento, sexo, contato, endereco);
		this.turma = turma;
	}

	public Turma getTurma() {
		return turma;
	}
	
}
