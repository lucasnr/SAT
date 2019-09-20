package br.gov.rn.saogoncalo.telecentro.model.builder;

import java.time.LocalDate;

import br.gov.rn.saogoncalo.telecentro.model.Sexo;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public abstract class UsuarioBuilder<T extends Usuario> {

	protected String senha;
	protected String nome;
	protected String cpf;
	protected String rg;
	protected LocalDate dataNascimento;
	protected Sexo sexo;

	protected String email;
	protected String telefone;

	protected String cep;
	protected String bairro;
	protected String logradouro;
	protected String numero;
	
	public abstract T build();

	public UsuarioBuilder<T> senha(String senha) {
		this.senha = senha;
		return this;
	}

	public UsuarioBuilder<T> nome(String nome) {
		this.nome = nome;
		return this;
	}

	public UsuarioBuilder<T> cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public UsuarioBuilder<T> rg(String rg) {
		this.rg = rg;
		return this;
	}

	public UsuarioBuilder<T> dataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public UsuarioBuilder<T> sexo(Sexo sexo) {
		this.sexo = sexo;
		return this;
	}

	public UsuarioBuilder<T> email(String email) {
		this.email = email;
		return this;
	}

	public UsuarioBuilder<T> telefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public UsuarioBuilder<T> cep(String cep) {
		this.cep = cep;
		return this;
	}

	public UsuarioBuilder<T> bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public UsuarioBuilder<T> logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public UsuarioBuilder<T> numero(String numero) {
		this.numero = numero;
		return this;
	}

}
