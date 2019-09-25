package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Pessoa;

public interface PessoaDAO extends AbstractDAO<Pessoa, Long> {
	public Optional<Pessoa> buscarPorCpf(String cpf);
	public Optional<Pessoa> buscarPorRg(String rg);
}
