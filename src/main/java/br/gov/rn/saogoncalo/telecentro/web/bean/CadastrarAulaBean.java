package br.gov.rn.saogoncalo.telecentro.web.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rn.saogoncalo.telecentro.model.Aula;
import br.gov.rn.saogoncalo.telecentro.model.Turma;
import br.gov.rn.saogoncalo.telecentro.service.AulaService;
import br.gov.rn.saogoncalo.telecentro.service.TurmaService;
import br.gov.rn.saogoncalo.telecentro.util.FacesMessageUtil;
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

		@Inject
		private AulaService aulaService;
		
		@Getter
		@Setter
		private Date data;
		
		public void carregarTurma() {
			Optional<Turma> turma = turmaService.buscarPorId(turmaId);
			if(turma.isPresent()) {
				this.aula.setTurma(turma.get());
			} else {
				//o que fazer quando nao existe turma para o id mandado
			}
		}
		
		public String registrarAula(){
			LocalDateTime dataAula = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			aula.setData(dataAula);
			boolean salvou = aulaService.salvar(aula);
			if (salvou) {
				return "atribuirFrequencia.xhtml?faces-redirect=true&id="+aula.getId();
			} else {
				FacesMessageUtil.addErrorMessage("Erro ao cadastrar aula");
				return null;
			}
		}
}
