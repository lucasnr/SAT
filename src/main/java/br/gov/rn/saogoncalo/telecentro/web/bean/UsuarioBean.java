package br.gov.rn.saogoncalo.telecentro.web.bean;


import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class UsuarioBean {

	@Inject
	private UsuarioService service;

	@Getter @Setter
	private Long idconsultado;
	
	@Getter @Setter
	private Usuario usuario;

	public String buscarPorId() {
		
		Optional<Usuario> optional = service.buscarPorId(idconsultado);
		if (optional.isPresent()) {
			usuario = optional.get();
		} else {
			FacesMessageUtil.addErrorMessage("Nao encontrei");
		}
		
		return "atualizardadosusuario.xhtml?faces-redirect=true&includeViewParams=true";
	}

}
