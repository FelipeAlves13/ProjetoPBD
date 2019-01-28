package br.com.model.entidadesbeans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Subselect("select * from clientes_fisicosview")
public class Clientes_fisicosview implements Serializable{
	@Id
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(unique = true,nullable=false)
	private String cpf;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_nasc;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
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
