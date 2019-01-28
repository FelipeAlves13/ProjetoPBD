package br.com.model.entidadesbeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.view.ExibirMensagem;

@Entity
@SequenceGenerator(name ="back_seq",sequenceName="backup_seq",initialValue=1,allocationSize=1)
public class Backup {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="back_seq")
	private int id;
	@Column(length=50,nullable=true)
	private String nome;
	@Column(nullable=true)
	private String diretorio;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	private boolean status;
	
	public Backup() {
		
	}
	
	

	public int getId() {
		return id;
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public Date getData() {
		return data;
	}

	



	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
