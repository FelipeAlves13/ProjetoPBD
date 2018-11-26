package br.com.modelBeans;

import java.util.Calendar;
import java.util.Date;

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
	@Temporal(TemporalType.TIME)
	private Date hora;
	@Temporal(TemporalType.DATE)
	private Date data;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	public int getId() {
		return id;
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
	
	
	
}
