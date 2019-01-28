package br.com.model.entidadesbeans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
@Entity
@Immutable
@Subselect("select * from reservasview")
public class Reservasview implements Serializable{
	@Id
	private int id;
	@Column(nullable=false)
	private String cliente;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_realizada;
	@Column(nullable=false)
	private String categoria;
	@Column(nullable=false)
	private String status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Date getData_realizada() {
		return data_realizada;
	}
	public void setData_realizada(Date data_realizada) {
		this.data_realizada = data_realizada;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
