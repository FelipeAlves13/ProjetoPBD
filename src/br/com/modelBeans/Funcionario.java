package br.com.modelbeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
@SequenceGenerator(name="func_seq",sequenceName="funcionario_seq",initialValue=1,allocationSize=1)
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="func_seq")
	private int id;
	@Column(length=255,nullable=false)
	private String nome;
	@Column(length=30,nullable=false)
	private String login;
	@Column(length=255,nullable=false)
	private String senha;
	@Column(length=40,nullable=false)
	private String cargo;
	
	public Funcionario() {
	
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	
}
