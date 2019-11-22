package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
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

	public Boletim(Aluno aluno, Modulo modulo, Integer nota) {
		super();
		this.aluno = aluno;
		this.modulo = modulo;
		this.nota = nota;
		this.id = new BoletimId(aluno.getUsuarioId(), modulo.getId());
	}

}
