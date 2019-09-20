package br.gov.rn.saogoncalo.telecentro.model.builder;

import br.gov.rn.saogoncalo.telecentro.model.Contato;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Turma;

public class InstrutorBuilder extends UsuarioBuilder<Instrutor> {

	private Turma turma;

	@Override
	public Instrutor build() {
		Contato contato = new Contato(email, telefone);
		Endereco endereco = new Endereco(cep, bairro, logradouro, numero);
		return new Instrutor(senha, nome, cpf, rg, dataNascimento, sexo, contato, endereco, turma);
	}
	
	public InstrutorBuilder turma(Turma turma) {
		this.turma = turma;
		return this;
	}

}
