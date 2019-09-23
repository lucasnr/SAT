package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"turma"}, callSuper=false)
@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn(name = "USUARIO_ID")
public class Aluno extends Usuario {

//	TODO: Ajeitar esse transient
	private transient Turma turma;

	@Builder
	public Aluno(Long idUsuario, String matricula, String senha, Pessoa pessoa, Turma turma) {
		super(idUsuario, matricula, senha, pessoa);
		this.turma = turma;
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
//		session.find
	}
	
}
