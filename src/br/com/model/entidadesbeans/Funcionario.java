package br.com.model.entidadesbeans;

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
	@Column(length=40,nullable=false)
	private String cargo;
	
	public Funcionario() {
	
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	
}
