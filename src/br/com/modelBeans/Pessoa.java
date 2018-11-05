package br.com.modelBeans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa")
@SequenceGenerator(name ="pes_seq",sequenceName="pessoa_seq",initialValue=1,allocationSize=1)
public class Pessoa {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="pes_seq")
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String login;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private char sexo;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_nasc;
	@Column(unique= true,nullable=false)
	private int codigo;
	@OneToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	@OneToOne
	@JoinColumn(name ="id_pessoa_f")
	private Pessoa_fisica pessoaFisica;
	@OneToOne
	@JoinColumn(name ="id_pessoa_j")
	private Pessoa_juridica pessoaJuridica;
	
	public Pessoa() {
		
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
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pessoa_fisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(Pessoa_fisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Pessoa_juridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(Pessoa_juridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}