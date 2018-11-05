package br.com.modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
@SequenceGenerator(name="end_seq",sequenceName="endereco_seq",initialValue=1,allocationSize=1)
public class Endereco {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="end_seq")
	private int id;
	@Column(nullable=true)
	private String telefone;
	@Column(length=2,nullable=true)
	private String uf;
	@Column(length=40,nullable=true)
	private String cidade;
	@Column(length=12,nullable=true)
	private String cep;
	
	public Endereco() {
		
	}
	
	public Endereco(String tel,String uf,String cidade,String cep) {
		this.telefone=tel;
		this.uf=uf;
		this.cidade=cidade;
		this.cep=cep;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	
	
}
