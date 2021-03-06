package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Endereco;

public interface EnderecoDAO extends AbstractDAO<Endereco, Long> {
	public Optional<Endereco> buscarPorCep(String cep);
	public Optional<Endereco> buscarPorBairroLogradouroNumero(String bairro, String logradouro, String numero);
}
