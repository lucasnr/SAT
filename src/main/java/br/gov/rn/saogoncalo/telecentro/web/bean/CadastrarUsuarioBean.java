package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aluno;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorGeral;
import br.gov.rn.saogoncalo.telecentro.model.CoordenadorUnidade;
import br.gov.rn.saogoncalo.telecentro.model.Instrutor;
import br.gov.rn.saogoncalo.telecentro.model.Perfil;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastrarUsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Usuario usuario;

	@Getter
	@Setter
	private Date dataNascimento;

	@Getter
	@Setter
	private Long unidadeId;

	public CadastrarUsuarioBean() {
		usuario = new Usuario();
	}

	@Inject
	private UsuarioService service;

	public void salvar() {
		LocalDate localDate = parseDataNascimentoToLocalDate();
		usuario.setDataNascimento(localDate);

		if (usuario.getPerfil() == Perfil.INSTRUTOR) {
			Instrutor instrutor = (Instrutor) usuario;
			Optional<Unidade> unidade = unidadeService.buscarPorId(unidadeId);
			if (unidade.isPresent())
				instrutor.setUnidade(unidade.get());
		} else if (usuario.getPerfil() == Perfil.COORDENADOR_UNIDADE) {
			CoordenadorUnidade coordenadorUnidade = (CoordenadorUnidade) usuario;
			Optional<Unidade> unidade = unidadeService.buscarPorId(unidadeId);
			if (unidade.isPresent())
				coordenadorUnidade.setUnidade(unidade.get());
		}

		boolean salvou = service.salvar(usuario);
		if (salvou) {
			System.out.println("Deu certo");
		} else {
			System.out.println("Deu ruim");
		}
	}

	private LocalDate parseDataNascimentoToLocalDate() {
		return dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@Inject
	private UnidadeService unidadeService;

	public List<Unidade> unidades() {
		return unidadeService.listar();
	}

	public void instanciarAluno() {
		this.usuario = new Aluno();
	}

	public void instanciarInstrutor() {
		this.usuario = new Instrutor();
	}

	public void instanciarCoordenadorUnidade() {
		this.usuario = new CoordenadorUnidade();
	}

	public void instanciarCoordenadorGeral() {
		this.usuario = new CoordenadorGeral();
	}

}
