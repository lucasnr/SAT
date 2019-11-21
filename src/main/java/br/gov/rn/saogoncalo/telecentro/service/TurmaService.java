package br.gov.rn.saogoncalo.telecentro.service;

import java.util.List;
import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Turma;

public interface TurmaService {

	public Optional<Turma> buscarPorId(Long id);
	public Optional<Turma> buscarPorCodigo(String codigo);
	public List<Turma> listar();
}
