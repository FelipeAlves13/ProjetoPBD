package br.com.model.entidadesbeans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="pessoa_fisica")
@SequenceGenerator(name ="pesf_seq",sequenceName ="pessoaFisica_seq" ,initialValue=1,allocationSize=1)
public class Pessoa_fisica {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="pesf_seq")
	private int id;
	@Column(nullable=false,length=9)
	private String sexo;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_nasc;
	@Column(unique = true,nullable=false)
	private String cpf;
	@Column(nullable=true)
	private Date data_venc_habilita;
	@Column(nullable=true)
	private Integer num_habilitacao;
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}


	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData_venc_habilita() {
		return data_venc_habilita;
	}
	public void setData_venc_habilita(Date data_venc_habilita) {
		this.data_venc_habilita = data_venc_habilita;
	}
	public int getNum_habilitacao() {
		return num_habilitacao;
	}
	public void setNum_habilitacao(int num_habilitacao) {
		this.num_habilitacao = num_habilitacao;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	
}
