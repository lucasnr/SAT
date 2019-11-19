package br.gov.rn.saogoncalo.telecentro.service;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorUnidade;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public interface Visitor {

	public String visit(Aluno aluno);
	public String visit(Instrutor instrutor);
	public String visit(CoordenadorUnidade coordenadorUnidade);
	public String visit(CoordenadorGeral coordenadorGeral);
	public String visit(Usuario usuario);
}
