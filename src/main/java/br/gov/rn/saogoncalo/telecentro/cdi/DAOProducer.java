package br.gov.rn.saogoncalo.telecentro.cdi;

import javax.enterprise.inject.Produces;

import br.gov.rn.saogoncalo.telecentro.dao.UsuarioDAO;
import br.gov.rn.saogoncalo.telecentro.dao.hibernate.UsuarioHibernateDAO;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;

public class DAOProducer {

	@Produces
	public UsuarioDAO<Usuario> usuarioDAO(){
		return new UsuarioHibernateDAO<>(Usuario.class);
	}
}
