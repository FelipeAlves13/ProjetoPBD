package br.com.model.entidadesbeans;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="reserva")
@SequenceGenerator(name="res_seq",sequenceName="reserva_seq",initialValue=1,allocationSize=1)
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="res_seq")
	private int id;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date horaLocacao;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataLocacao;
	@Column(nullable=false)
	private String status;
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false)
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name="id_pessoa",nullable = false)
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name="id_filial")
	private Filial filial;
	
	public int getId() {
		return id;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setHoraLocacao(Date horaLocacao) {
		this.horaLocacao = horaLocacao;
	}


	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}


	public Date getHora() {
		return hora;
	}


	public void setHora(Date hora) {
		this.hora = hora;
	}


	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public String isStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getHoraLocacao() {
		return horaLocacao;
	}


	public Date getDataLocacao() {
		return dataLocacao;
	}


	public Filial getFilial() {
		return filial;
	}


	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	
	
}
