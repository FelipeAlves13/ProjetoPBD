package br.com.model.relatoriosbeans;

import java.util.Date;

public class RelatorioFinanceiro {
	private String cliente;
	private Date data_realizada;
	private Date data_devolucao;
	private String valorTotal;
	
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
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
