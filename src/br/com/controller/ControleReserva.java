package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import br.com.daoBeans.DaoCategoria;
import br.com.daoBeans.DaoPessoa;
import br.com.modelBeans.Categoria;
import br.com.modelBeans.Pessoa;
import br.com.view.TelaCadastroReserva;
import br.com.view.TelaReservas;

public class ControleReserva implements ActionListener{
	private TelaReservas reserva;
	private TelaCadastroReserva telaCadastroReserva;
	private List<Pessoa> pessoas;
	private List<Categoria> categorias;
	private DaoPessoa daoPessoa;
	private DaoCategoria daoCategoria;
	
	public ControleReserva(TelaReservas telaReservas,TelaCadastroReserva telaCadastroReserva) {
		this.reserva = telaReservas;
		this.telaCadastroReserva=telaCadastroReserva;
		this.daoPessoa = new DaoPessoa();
		this.daoCategoria = new DaoCategoria();
		
		this.reserva.getBtnAtualizar().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.reserva.getBtnAtualizar()==e.getSource()) {
			this.pessoas = null;
			this.pessoas = this.daoPessoa.BuscaPessoa("");
			//pega o nome de todos os clientes cadastrados
			this.telaCadastroReserva.getClienteBox().removeAllItems();
			this.telaCadastroReserva.getClienteBox().addItem("");
			
			for(Pessoa p:pessoas) {
				this.telaCadastroReserva.getClienteBox().addItem(p.getNome());
			}
			
			this.categorias = null;
			this.categorias = daoCategoria.BuscaCategoria("");
			
			this.telaCadastroReserva.setVisible(true);
			
		}
		
	}

	public TelaCadastroReserva getTelaCadastroReserva() {
		return telaCadastroReserva;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	

}
