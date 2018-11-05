package br.com.modelBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
@SequenceGenerator(name="veic_seq",sequenceName="veiculo_seq",initialValue=1,allocationSize=1)
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="veic_seq")
	private int id;
	@Column(nullable=false)
	private int ano_modelo;
	@Column(nullable=false)
	private String cor;
	@Column(nullable=false)
	private double quilometragem_atual;
	@Column(nullable=false)
	private double quilometragem_antiga;
	@Column(nullable=false)
	private String tipo_combustivel;
	@Column(nullable=false,length=100)
	private String torque_motor;
	@Column(nullable=false)
	private String fabricante;
	@Column(nullable=false)
	private int numero_de_portas;
	@Column(nullable=false)
	private String categoria;
	@Column(nullable=false)
	private int ano_fabricacao;
	@Column(nullable=false)
	private int numero_motor;
	@Column(nullable=false)
	private String nome_placa;
	@Column(nullable=false)
	private int numero_chassi;
	@Column(nullable=false)
	private String modelo;
	@Column(nullable=false)
	private int numero_passageiro;
	@Column(nullable=false)
	private int tamanho;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria cat;
	@ManyToOne
	@JoinColumn(name="id_filial")
	private Filial filial;
	
	public int getId() {
		return id;
	}
	
	
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getQuilometragem_atual() {
		return quilometragem_atual;
	}
	public void setQuilometragem_atual(double quilometragem_atual) {
		this.quilometragem_atual = quilometragem_atual;
	}
	public double getQuilometragem_antiga() {
		return quilometragem_antiga;
	}
	public void setQuilometragem_antiga(double quilometragem_antiga) {
		this.quilometragem_antiga = quilometragem_antiga;
	}
	public String getTipo_combustivel() {
		return tipo_combustivel;
	}
	public void setTipo_combustivel(String tipo_combustivel) {
		this.tipo_combustivel = tipo_combustivel;
	}
	public String getTorque_motor() {
		return torque_motor;
	}
	public void setTorque_motor(String torque_motor) {
		this.torque_motor = torque_motor;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getNumero_de_portas() {
		return numero_de_portas;
	}
	public void setNumero_de_portas(int numero_de_portas) {
		this.numero_de_portas = numero_de_portas;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public int getNumero_motor() {
		return numero_motor;
	}
	public void setNumero_motor(int numero_motor) {
		this.numero_motor = numero_motor;
	}
	public String getNome_placa() {
		return nome_placa;
	}
	public void setNome_placa(String nome_placa) {
		this.nome_placa = nome_placa;
	}
	public int getNumero_chassi() {
		return numero_chassi;
	}
	public void setNumero_chassi(int numero_chassi) {
		this.numero_chassi = numero_chassi;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumero_passageiro() {
		return numero_passageiro;
	}
	public void setNumero_passageiro(int numero_passageiro) {
		this.numero_passageiro = numero_passageiro;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	
	
	
}
