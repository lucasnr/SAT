package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TURMA_ID")
	private Turma turma;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	private List<Boletim> boletins;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	private List<RegistroAula> registros;
	
	@Builder
	public Aluno(Long idUsuario, String matricula, String senha, Pessoa pessoa, Turma turma) {
		super(idUsuario, matricula, senha, pessoa);
		this.turma = turma;
	}
	
	public boolean isAtivo() {
		return hojeEstaEntreInicioEFim();
	}
	
	public Double frequencia() {
		double presencas = this.registros.stream().filter(RegistroAula::isPresente).count() * 1.0; // 1.0 is for double transform
		return  presencas * 1.0 / this.registros.size();
	}
	
	public String frequenciaEmPorcentagem() {
		return String.format("%,.2f%%", frequencia()*100);
	}
	
	public Double media() {
		return boletins.stream().mapToDouble(Boletim::getNota).average().getAsDouble();
	}

	private boolean hojeEstaEntreInicioEFim() {
		LocalDate hoje = LocalDate.now();
		return hoje.isAfter(this.turma.getDataInicio()) && hoje.isBefore(this.turma.getDataFim());
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Aluno> alunos = session.createQuery("from Aluno", Aluno.class).list();
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
			System.out.println(aluno.media());
			System.out.println(aluno.frequenciaEmPorcentagem());
		}
	}
	
}
