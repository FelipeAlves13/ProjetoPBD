package br.com.modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="filial")
@SequenceGenerator(name="fil_seq",sequenceName="filial_seq",initialValue=1,allocationSize=1)
public class Filial {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="fil_seq")
	private int id;
	@Column(length=100,nullable=false)
	private String nome;
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
