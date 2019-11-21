package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Instrutor;

public interface InstrutorService {

	public Optional<Instrutor> buscarPorMatricula(String matricula);
}
