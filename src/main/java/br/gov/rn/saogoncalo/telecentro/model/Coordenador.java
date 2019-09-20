package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;

public class Coordenador extends Usuario {

	public Coordenador(String senha, String nome, String cpf, String rg, LocalDate dataNascimento,
			Sexo sexo, Contato contato, Endereco endereco) {
		super(senha, nome, cpf, rg, dataNascimento, sexo, contato, endereco);
	}

}
