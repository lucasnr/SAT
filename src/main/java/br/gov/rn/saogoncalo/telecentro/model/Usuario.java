package br.gov.rn.saogoncalo.telecentro.model;

import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition="INT")
	private Long id;
	
	private String matricula;
	private String senha;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PESSOA_ID")
	private Pessoa pessoa;

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Usuario usuario = session.find(Usuario.class, 2L);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.printf("Bem-vindo usuário %s, você está conosco desde %s\n", usuario.getPessoa().getNome(), usuario.getPessoa().getDataCadastro().format(formatador));
		System.out.println("Seu contato é: " + usuario.getPessoa().getContato());
	}
}
