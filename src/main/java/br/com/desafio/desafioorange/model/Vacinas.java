package br.com.desafio.desafioorange.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "email_uk"))
public class Vacinas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message="Nome da vacina não pode ser nulo!")
	@NotNull(message="nome da vacina não pode ser vazio!")
	@NotBlank
	@Column(name="nomeVacina")
	private String nomeVacina;
	@NotEmpty(message="E-mail não pode ser nulo!")
	@NotNull(message="E-mail não pode ser vazio!")
	@Column(name="email")
	private String email;
	@NotNull(message="Data da realização não pode ser vazio!")
	@Column(name="dataRealizacao")
	private Date dataRealizacao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	
	

}
