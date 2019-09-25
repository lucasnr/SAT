package br.gov.rn.saogoncalo.telecentro.service;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.model.dto.CredenciaisDTO;

public interface LoginService {
	public Optional<Usuario> login(CredenciaisDTO credenciais);
}
