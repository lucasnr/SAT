package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@ToString(exclude = { "aluno", "modulo" })
@EqualsAndHashCode(exclude = { "aluno", "modulo" })
@Entity
@Table(name = "BOLETIM")
public class Boletim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private BoletimId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALUNO_ID", insertable = false, updatable = false)
	private Aluno aluno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULO_ID", insertable = false, updatable = false)
	private Modulo modulo;
	private Integer nota;
}

@Embeddable
@Data
class BoletimId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ALUNO_ID", columnDefinition = "INT")
	private Long alunoId;
	@Column(name = "MODULO_ID", columnDefinition = "INT")
	private Long moduloId;
}
