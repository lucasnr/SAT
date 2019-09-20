package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
	
	protected String matricula;
	protected String senha;
	protected String nome;
	protected final String cpf;
	protected final String rg;
	protected final LocalDate dataNascimento;
	protected final Sexo sexo;
	protected final LocalDateTime dataCadastro;
	protected Contato contato;
	protected final Endereco endereco;
	
	protected Usuario(String senha, String nome, String cpf, String rg, LocalDate dataNascimento, Sexo sexo,
			Contato contato, Endereco endereco) {
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.contato = contato;
		this.endereco = endereco;
		
		this.dataCadastro = LocalDateTime.now();
	}

	protected Usuario(String matricula, String senha, String nome, String cpf, String rg, LocalDate dataNascimento,
			Sexo sexo, Contato contato, Endereco endereco) {
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.contato = contato;
		this.endereco = endereco;
		
		this.dataCadastro = LocalDateTime.now();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
}
