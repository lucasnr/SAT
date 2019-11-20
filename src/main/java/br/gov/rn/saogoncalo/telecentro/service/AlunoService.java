package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;

public interface AlunoService {

	public Optional<Aluno> buscarUltimoAlunoDaTurma(String codigoDaTurma);

	public Optional<Aluno> buscarPorMatricula(String matricula);
}
