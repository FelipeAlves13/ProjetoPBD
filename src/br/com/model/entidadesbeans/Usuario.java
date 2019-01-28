package br.com.model.entidadesbeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@SequenceGenerator(name ="usu_seq",sequenceName="usuario_seq",initialValue=1,allocationSize=1)
public class Usuario {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="usu_seq")
	private int id;
	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	private String senha;
	@OneToOne
	@JoinColumn(name ="id_pessoa")
	private Pessoa pessoa;
	@OneToOne
	@JoinColumn(name ="id_funcionario")
	private Funcionario funcionario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
