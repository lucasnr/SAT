package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Unidade;
import br.gov.rn.saogoncalo.telecentro.model.Usuario;
import br.gov.rn.saogoncalo.telecentro.service.UnidadeService;
import br.gov.rn.saogoncalo.telecentro.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class CadastrarUsuarioBean {
	
	@Getter @Setter
	private Usuario usuario;
	
	@Getter @Setter
	private Date dataNascimento;
	
	public CadastrarUsuarioBean() {
		usuario = new Usuario();
	}
	
	@Inject
	private UsuarioService service;
	
	public void salvar() {
		LocalDate localDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		usuario.setDataNascimento(localDate);
		System.out.println(usuario);
		
		boolean salvou = service.salvar(usuario);
		
		if(salvou) {
			System.out.println("Deu certo");
		} else {
		System.out.println("Deu ruim");
	}
	}
	

	@Inject
	private UnidadeService unidadeService;

	public List<Unidade> unidades() {
		return unidadeService.listar();
	}
	
	
	
	

}
