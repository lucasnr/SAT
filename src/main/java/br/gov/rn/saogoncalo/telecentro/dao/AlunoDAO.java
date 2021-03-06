package br.gov.rn.saogoncalo.telecentro.dao;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;

public interface AlunoDAO extends UsuarioDAO<Aluno> {

	public Optional<Aluno> buscarUltimoAlunoDaTurma(String codigoDaTurma);

}
