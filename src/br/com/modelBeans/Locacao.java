package br.com.modelBeans;

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
@Table(name="locacao")
@SequenceGenerator(name="loc_seq",sequenceName="locacao_seq")
public class Locacao {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="loc_seq")
	private int id;
	@Column(nullable=false)
	private boolean km_livre;
	@Column(nullable=false)
	private boolean km_controle;
	@Column(nullable=false)
	private double taxa;
	@Column(length=100,nullable=false)
	private String filial_entrega;
	@Column(length=100,nullable=false)
	private String filial_origem;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hora_entrega;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_origem;
	@Temporal(TemporalType.DATE)
	private Date data_entrega;
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name="id_pessoa_f")
	private Pessoa pessoaFisica;
	@ManyToOne
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	
	public int getId() {
		return id;
	}
	
	public boolean isKm_livre() {
		return km_livre;
	}
	
	public void setKm_livre(boolean km_livre) {
		this.km_livre = km_livre;
	}
	
	public boolean isKm_controle() {
		return km_controle;
	}
	
	public void setKm_controle(boolean km_controle) {
		this.km_controle = km_controle;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public String getFilial_entrega() {
		return filial_entrega;
	}
	
	public void setFilial_entrega(String filial_entrega) {
		this.filial_entrega = filial_entrega;
	}
	
	public String getFilial_origem() {
		return filial_origem;
	}
	
	public void setFilial_origem(String filial_origem) {
		this.filial_origem = filial_origem;
	}
	
	
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Date getHora_entrega() {
		return hora_entrega;
	}

	public void setHora_entrega(Date hora_entrega) {
		this.hora_entrega = hora_entrega;
	}

	public Date getData_origem() {
		return data_origem;
	}
	
	public void setData_origem(Date data_origem) {
		this.data_origem = data_origem;
	}
	
	public Date getData_entrega() {
		return data_entrega;
	}
	
	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(Pessoa pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
