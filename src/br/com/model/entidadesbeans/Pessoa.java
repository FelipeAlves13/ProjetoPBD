package br.com.model.entidadesbeans;

import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="pessoa")
@SequenceGenerator(name ="pes_seq",sequenceName="pessoa_seq",initialValue=1,allocationSize=1)
public class Pessoa {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="pes_seq")
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(unique= true,nullable=false)
	private int codigo;
	@OneToOne
	@JoinColumn(name="id_endereco",nullable=false)
	private Endereco endereco;
	@OneToOne
	@JoinColumn(name ="id_pessoa_f")
	private Pessoa_fisica pessoaFisica;
	@OneToOne
	@JoinColumn(name ="id_pessoa_j")
	private Pessoa_juridica pessoaJuridica;
	
	public Pessoa() {
		
	}
	
	
	
	public Pessoa(String nome, String login, String senha,  int codigo, Endereco endereco,
			Pessoa_fisica pessoaFisica, Pessoa_juridica pessoaJuridica) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.endereco = endereco;
		this.pessoaFisica = pessoaFisica;
		this.pessoaJuridica = pessoaJuridica;
	}



	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
