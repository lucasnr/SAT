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
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.AlunoService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
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

	@Getter
	@Setter
	private Long turmaId;

	public CadastrarUsuarioBean() {
		usuario = new Usuario();
	}

	@Inject
	private UsuarioService service;

	public void salvar() {
		LocalDate localDate = parseDataNascimentoToLocalDate();
		usuario.setDataNascimento(localDate);

		Perfil perfil = usuario.getPerfil();
		if (perfil == Perfil.INSTRUTOR) {
			prepararInstrutor();
		} else if (perfil == Perfil.COORDENADOR_UNIDADE) {
			prepararCoordenadorDeUnidade();
		} else if (perfil == Perfil.ALUNO) {
			prepararAluno();
		}

		boolean salvou = false;
		
		if (perfil == Perfil.ALUNO) {
			Aluno aluno = (Aluno) usuario;
			salvou = alunoService.salvar(aluno);
		} else {			
			salvou = service.salvar(usuario);
		}
		if (salvou) {
			FacesMessageUtil.addSuccessMessage("Usuário cadastrado com sucesso");
			limparCampos();
		} else {
			FacesMessageUtil.addErrorMessage("Erro ao tentar cadastrar o usuário");
		}
	}

	private void limparCampos() {
		usuario = new Usuario();
		dataNascimento = null;
		turmaId = null;
		unidadeId = null;
	}
	
	private void prepararAluno() {
		Aluno aluno = (Aluno) usuario;
		Optional<Turma> turma = turmaService.buscarPorId(turmaId);
		if (turma.isPresent())
			aluno.setTurma(turma.get());
	}

	private void prepararCoordenadorDeUnidade() {
		CoordenadorUnidade coordenadorUnidade = (CoordenadorUnidade) usuario;
		Optional<Unidade> unidade = unidadeService.buscarPorId(unidadeId);
		if (unidade.isPresent())
			coordenadorUnidade.setUnidade(unidade.get());
	}

	private void prepararInstrutor() {
		Instrutor instrutor = (Instrutor) usuario;
		Optional<Unidade> unidade = unidadeService.buscarPorId(unidadeId);
		if (unidade.isPresent())
			instrutor.setUnidade(unidade.get());
	}

	private LocalDate parseDataNascimentoToLocalDate() {
		return dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@Inject
	private UnidadeService unidadeService;

	@Inject
	private TurmaService turmaService;

	@Inject
	private AlunoService alunoService;

	public List<Unidade> unidades() {
		return unidadeService.listar();
	}

	public List<Turma> turmas() {
		return turmaService.listar();
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
