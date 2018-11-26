package br.com.modelBeans;

import java.util.Date;

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

@Entity
@Table(name="categoria")
@SequenceGenerator(name="cat_seq",sequenceName="categoria_seq",initialValue=1,allocationSize=1)
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cat_seq")
	private int id;
	@Column(nullable=false)
	private String nome;
//	@Column(length=7,nullable= false)
//	private String tamanho;
	@Column(nullable=false)
	private boolean camera_re;
	@Column(nullable=false)
	private boolean direcao_hidraulica;
	@Column(nullable=false)
	private boolean mp3;
	@Column(nullable=false)
	private String tipo_cambio;
	@Column(nullable=false)
	private boolean dvd;
	@Column(nullable=false)
	private boolean ar_condicionado;
	@Column(nullable=false)
	private boolean rádio;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date tempoRevisao;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date tempoLimpeza;
	
	@OneToOne
	@JoinColumn(name="id_categoria_p")
	private Categoria_passageiro categoria_passageiro;

	@OneToOne
	@JoinColumn(name="id_categoria_c")
	private Categoria_carga categoria_carga;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	
//	public String getTamanho() {
//		return tamanho;
//	}
//	
//	public void setTamanho(String tamanho) {
//		this.tamanho = tamanho;
//	}
	
	public boolean isCamera_re() {
		return camera_re;
	}
	
	public void setCamera_re(boolean camera_re) {
		this.camera_re = camera_re;
	}
	
	public boolean isDirecao_hidraulica() {
		return direcao_hidraulica;
	}
	
	public void setDirecao_hidraulica(boolean direcao_hidraulica) {
		this.direcao_hidraulica = direcao_hidraulica;
	}
	
	public boolean isMp3() {
		return mp3;
	}
	
	public void setMp3(boolean mp3) {
		this.mp3 = mp3;
	}
	
	public String getTipo_cambio() {
		return tipo_cambio;
	}
	
	public void setTipo_cambio(String tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}
	
	public boolean isDvd() {
		return dvd;
	}
	
	public void setDvd(boolean dvd) {
		this.dvd = dvd;
	}
	
	public boolean isAr_condicionado() {
		return ar_condicionado;
	}
	
	public void setAr_condicionado(boolean ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}
	
	public boolean isRádio() {
		return rádio;
	}
	
	public void setRádio(boolean rádio) {
		this.rádio = rádio;
	}
	
	public Categoria_passageiro getCategoria_passageiro() {
		return categoria_passageiro;
	}
	
	public void setCategoria_passageiro(Categoria_passageiro categoria_passageiro) {
		this.categoria_passageiro = categoria_passageiro;
	}
	
	public Categoria_carga getCategoria_carga() {
		return categoria_carga;
	}
	
	public void setCategoria_carga(Categoria_carga categoria_carga) {
		this.categoria_carga = categoria_carga;
	}


	public Date getTempoRevisao() {
		return tempoRevisao;
	}


	public void setTempoRevisao(Date tempoRevisao) {
		this.tempoRevisao = tempoRevisao;
	}


	public Date getTempoLimpeza() {
		return tempoLimpeza;
	}


	public void setTempoLimpeza(Date tempoLimpeza) {
		this.tempoLimpeza = tempoLimpeza;
	}


	public String getNome() {
		return nome;
	}
		

}
