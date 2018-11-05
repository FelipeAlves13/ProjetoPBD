package br.com.modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria_carga")
@SequenceGenerator(name="catc_seq",sequenceName="categoriaCarga_seq",initialValue=1,allocationSize=1)
public class Categoria_carga {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catc_seq")
	private int id;
	@Column(nullable=false)
	private int capacidade_carga;
	@Column(length=30,nullable=false)
	private String embreagem;
	@Column(length=30,nullable=false)
	private String desempenho;
	@Column(length=30,nullable=false)
	private String potencia_do_motor;
	@Column(nullable=false)
	private double distância_eixos;
	@Column(nullable=false)
	private double volume_combustivel;
	
	public int getId() {
		return id;
	}
	
	public int getCapacidade_carga() {
		return capacidade_carga;
	}
	
	public void setCapacidade_carga(int capacidade_carga) {
		this.capacidade_carga = capacidade_carga;
	} 
	
	public String getEmbreagem() {
		return embreagem;
	}
	
	public void setEmbreagem(String embreagem) {
		this.embreagem = embreagem;
	}
	
	public String getDesempenho() {
		return desempenho;
	}
	
	public void setDesempenho(String desempenho) {
		this.desempenho = desempenho;
	}
	
	public String getPotencia_do_motor() {
		return potencia_do_motor;
	}
	
	public void setPotencia_do_motor(String potencia_do_motor) {
		this.potencia_do_motor = potencia_do_motor;
	}
	
	public double getDistância_eixos() {
		return distância_eixos;
	}
	
	public void setDistância_eixos(double distância_eixos) {
		this.distância_eixos = distância_eixos;
	}
	
	public double getVolume_combustivel() {
		return volume_combustivel;
	}
	
	public void setVolume_combustivel(double volume_combustivel) {
		this.volume_combustivel = volume_combustivel;
	}
	
		
}
