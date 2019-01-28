package br.com.model.entidadesbeans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Subselect("select * from clientes_juridicosview")
public class Clientes_juridicosview implements Serializable {
	@Id
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(unique=true,nullable=false)
	private String cnpj;
	@Column(nullable = false)
	private String inscricao_estadual;
	@Column(length=40,nullable=false)
	private String cidade;
	@Column(length=2,nullable=false)
	private String uf;
	
	
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricao_estadual() {
		return inscricao_estadual;
	}
	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
}
