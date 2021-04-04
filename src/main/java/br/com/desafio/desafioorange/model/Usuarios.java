package br.com.desafio.desafioorange.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(uniqueConstraints ={
	    @UniqueConstraint(columnNames = "email", name = "email_uk"),
	    @UniqueConstraint(columnNames = "cpf", name = "cpf_uk")}
	)
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message="Nome não pode ser nulo!")
	@NotNull(message="Nome não pode ser vazio!")
	@Column(name="nome")
	private String nome;
    @Email @NotBlank
    private String email;
    @CPF @NotBlank
    private String cpf;
	@NotNull(message="Data de nascimento não pode ser vazio!")
	@Column(name="nascimento")
	private Date nascimento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	
} 
