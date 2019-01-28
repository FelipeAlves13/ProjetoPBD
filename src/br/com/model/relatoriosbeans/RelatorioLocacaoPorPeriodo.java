package br.com.model.relatoriosbeans;

import java.util.Date;

public class RelatorioLocacaoPorPeriodo {
	private String cliente;
	private String veiculo;
	private String categoria;
	private Date data_realizada;
	private String modalidade;
	
		
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getData_realizada() {
		return data_realizada;
	}
	public void setData_realizada(Date data_realizada) {
		this.data_realizada = data_realizada;
	}
	
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
}
