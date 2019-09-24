package br.gov.rn.saogoncalo.telecentro.dao.hibernate;

import java.util.Optional;

import br.gov.rn.saogoncalo.telecentro.dao.ModuloDAO;
import br.gov.rn.saogoncalo.telecentro.model.Modulo;

public class ModuloHibernateDAO extends EntidadeHibernateDAO<Modulo> implements ModuloDAO {

	public ModuloHibernateDAO() {
		super(Modulo.class);
	}

	@Override
	public Optional<Modulo> buscarPorTitulo(String titulo) {
		return super.buscarPorCampoUnico("titulo", titulo);
	}

}
