package br.com.modelbeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_juridica")
@SequenceGenerator(name="pesj_seq",sequenceName="pessoaJuridica_seq",initialValue=1,allocationSize=1)
public class Pessoa_juridica {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pesj_seq")
	private int id;
	@Column(unique=true,nullable=false)
	private String cnpj;
	@Column(nullable = false)
	private String inscricao_estadual;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	
	
}
