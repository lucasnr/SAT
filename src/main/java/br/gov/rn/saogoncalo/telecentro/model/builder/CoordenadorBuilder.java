package br.gov.rn.saogoncalo.telecentro.model.builder;

import br.gov.rn.saogoncalo.telecentro.model.Contato;
import br.gov.rn.saogoncalo.telecentro.model.Coordenador;
import br.gov.rn.saogoncalo.telecentro.model.Endereco;

public class CoordenadorBuilder extends UsuarioBuilder<Coordenador>{

	@Override
	public Coordenador build() {
		Endereco endereco = new Endereco(cep, bairro, logradouro, numero);
		Contato contato = new Contato(email, telefone);
		return new Coordenador(senha, nome, cpf, rg, dataNascimento, sexo, contato, endereco);
	}

}
