package br.gov.rn.saogoncalo.telecentro.model;

public class Endereco {

	private final String cep;
	private final String bairro;
	private final String logradouro;
	private final String numero;

	public Endereco(String cep, String bairro, String logradouro, String numero) {
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

}
