package br.com.model.entidadesbeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="modalidade")
@SequenceGenerator(name="mod_seq",sequenceName="modalidade_seq",initialValue=1,allocationSize=1)
public class Modalidade {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mod_seq")
	private int id;
	@Column(nullable=false,length=11)
	private String nome;
	@Column(nullable=false)
	private double valor;
	
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
