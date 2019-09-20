package br.gov.rn.saogoncalo.telecentro.model;

public class Unidade {

	private final String nome;
	private final Integer quantidadeEquipamentos;
	private final Endereco endereco;

	public Unidade(String nome, Integer quantidadeEquipamentos, Endereco endereco) {
		this.nome = nome;
		this.quantidadeEquipamentos = quantidadeEquipamentos;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadeEquipamentos() {
		return quantidadeEquipamentos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

}
