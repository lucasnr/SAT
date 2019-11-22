package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aula;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastrarAulaBean implements Serializable {
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Getter
		@Setter
		private Aula aula = new Aula();
		
		@Getter
		@Setter
		private Long turmaId;
		@Inject
		private TurmaService turmaService;

//		@Inject
//		private AulaService aulaService;
		
		public void carregarTurma() {
			Optional<Turma> turma = turmaService.buscarPorId(turmaId);
			if(turma.isPresent()) {
				this.aula.setTurma(turma.get());
			} else {
				//o que fazer quando nao existe turma para o id mandado
			}
		}
		
		public void registrarAula(){
			
		}
}
