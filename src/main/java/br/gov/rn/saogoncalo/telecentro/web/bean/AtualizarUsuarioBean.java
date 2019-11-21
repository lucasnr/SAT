package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AtualizarUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService service;

	@Getter
	@Setter
	private Long idconsultado;

	@Getter
	@Setter
	private Usuario usuario;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private Date dataNascimento;

	public String buscarPorId() {

		Optional<Usuario> optional = service.buscarPorId(idconsultado);
		if (optional.isPresent()) {
			usuario = optional.get();
		} else {
			FacesMessageUtil.addErrorMessage("Nao encontrei");
		}
		System.out.println(usuario.getNome());

		return "atualizarCadastroUsuario.xhtml?faces-redirect=true&id=" + usuario.getId();
	}

	public void carregarUsuario() {
		Optional<Usuario> optional = service.buscarPorId(id);
		if (optional.isPresent()) {
			this.usuario = optional.get();
			this.dataNascimento = Date
					.from(usuario.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
	}

	public void atualizar() {
		boolean atualizou = service.atualizar(usuario);
		if (atualizou)
			FacesMessageUtil.addSuccessMessage("Usuário atualizado com sucesso");
		else
			FacesMessageUtil.addErrorMessage("Falha ao atualizar usuário");
	}

}
