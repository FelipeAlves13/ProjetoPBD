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
@Table(name="locacao")
@SequenceGenerator(name="loc_seq",sequenceName="locacao_seq")
public class Locacao {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="loc_seq")
	private int id;
	@Column(nullable=false)
	private double taxa;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	@Column(nullable=true)
	@Temporal(TemporalType.TIME)
	private Date hora_entrega;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_origem;
	@Temporal(TemporalType.DATE)
	private Date data_entrega;
	@Column(nullable=false)
	private double valor_Pago;
	@Column(nullable=true)
	private double valo_total;
	@Column(nullable=false,length=12)
	private String status;
	@ManyToOne
	@JoinColumn(name="id_pessoa",nullable=false)
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name="id_motorista",nullable=false)
	private Pessoa motorista;
	@ManyToOne
	@JoinColumn(name="id_veiculo",nullable=false)
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name="id_filial_entrega")
	private Filial filial_entrega;
	@ManyToOne
	@JoinColumn(name="id_filial_origem",nullable=false)
	private Filial filial_origem;
	@ManyToOne
	@JoinColumn(name="id_modalidade")
	private Modalidade modalidade;
	
	
	public int getId() {
		return id;
	}
	
	
	
	public void setValor_Pago(double valor_Pago) {
		this.valor_Pago = valor_Pago;
	}



	public void setValo_total(double valo_total) {
		this.valo_total = valo_total;
	}



	public double getValor_Pago() {
		return valor_Pago;
	}



	public double getValo_total() {
		return valo_total;
	}

	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Modalidade getModalidade() {
		return modalidade;
	}



	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
		
	
	public Filial getFilial_entrega() {
		return filial_entrega;
	}

	public void setFilial_entrega(Filial filial_entrega) {
		this.filial_entrega = filial_entrega;
	}

	public Filial getFilial_origem() {
		return filial_origem;
	}

	public void setFilial_origem(Filial filial_origem) {
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

	
	public Pessoa getMotorista() {
		return motorista;
	}

	public void setMotorista(Pessoa motorista) {
		this.motorista = motorista;
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
