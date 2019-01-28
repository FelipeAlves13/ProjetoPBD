package br.com.model.entidadesbeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria_passageiro")
@SequenceGenerator(name="catp_seq",sequenceName="categoriaPassageiro_seq",initialValue=1,allocationSize=1)
public class Categoria_passageiro {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catp_seq")
	private int id;
	@Column(nullable=false)
	private boolean rodas_de_liga_leve;
	@Column(nullable=false)
	private boolean air_bag;
	@Column(nullable=false)
	private boolean direção_assistida;
	@Column(nullable=false)
	private boolean cinto_de_seguranca_trazeiro;
	@Column(nullable=false)
	private boolean controle_poluicao;
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}


	public boolean isRodas_de_liga_leve() {
		return rodas_de_liga_leve;
	}
	
	public void setRodas_de_liga_leve(boolean rodas_de_liga_leve) {
		this.rodas_de_liga_leve = rodas_de_liga_leve;
	}
	
	public boolean isAir_bag() {
		return air_bag;
	}
	
	public void setAir_bag(boolean air_bag) {
		this.air_bag = air_bag;
	}
	
	public boolean isDireção_assistida() {
		return direção_assistida;
	}
	
	public void setDireção_assistida(boolean direção_assistida) {
		this.direção_assistida = direção_assistida;
	}
	
	public boolean isCinto_de_seguranca_trazeiro() {
		return cinto_de_seguranca_trazeiro;
	}
	
	public void setCinto_de_seguranca_trazeiro(boolean cinto_de_seguranca_trazeiro) {
		this.cinto_de_seguranca_trazeiro = cinto_de_seguranca_trazeiro;
	}
	
	public boolean isControle_poluicao() {
		return controle_poluicao;
	}
	
	public void setControle_poluicao(boolean controle_poluicao) {
		this.controle_poluicao = controle_poluicao;
	}
	
	
	
	
}
