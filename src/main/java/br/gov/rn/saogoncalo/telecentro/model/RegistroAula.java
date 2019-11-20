package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "aluno", "aula" })
@EqualsAndHashCode(exclude = { "aluno", "aula" })
@Entity
@Table(name = "REGISTRO_AULA")
public class RegistroAula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegistroAulaId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALUNO_ID", insertable = false, updatable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AULA_ID", insertable = false, updatable = false)
	private Aula aula;
	
	private Boolean presente;
	
	public boolean isPresente() {
		return this.presente.booleanValue();
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class RegistroAulaId implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ALUNO_ID", columnDefinition = "INT")
	private Long alunoId;
	@Column(name = "AULA_ID", columnDefinition = "INT")
	private Long aulaId;
}
