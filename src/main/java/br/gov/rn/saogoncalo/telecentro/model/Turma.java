package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "alunos", "instrutor", "modulos", "unidade" })
@EqualsAndHashCode(exclude = { "alunos", "instrutor", "modulos", "unidade" })
@Builder
@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT")
	private Long id;

	private String codigo;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('MATUTINO', 'VESPERTINO', 'NOTURNO')")
	private Turno turno;

	@Column(name = "DATA_INICIO")
	private LocalDate dataInicio;

	@Column(name = "DATA_FIM")
	private LocalDate dataFim;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIDADE_ID", columnDefinition = "INT")
	private Unidade unidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSTRUTOR_ID")
	private Instrutor instrutor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "turma")
	private List<Aluno> alunos;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TURMA_MODULO", 
		joinColumns = { @JoinColumn(name = "TURMA_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "MODULO_ID") }
	)
	private List<Modulo> modulos;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TURMA_ID")
	private List<Aula> aulas;

	public boolean isAtiva() {
		return hojeEstaEntreInicioEFim();
	}
	
	private boolean hojeEstaEntreInicioEFim() {
		LocalDate hoje = LocalDate.now();
		return hoje.isAfter(this.getDataInicio()) && hoje.isBefore(this.getDataFim());
	}
}
