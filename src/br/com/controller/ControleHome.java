package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.view.TelaCategoria;
import br.com.view.TelaCliente;
import br.com.view.TelaHome;
import br.com.view.TelaLogin1;
import br.com.view.TelaReservas;

public class ControleHome implements ActionListener{
	private TelaHome home;
	private TelaLogin1 login;
	private TelaCliente cliente;
	private TelaCategoria categoria;
	private TelaReservas reserva;
	
	public ControleHome(TelaHome telaHome,TelaLogin1 telaLogin1,TelaCliente telaCliente,TelaCategoria telaCategoria,TelaReservas telaReserva) {
		this.home=telaHome;
		this.login = telaLogin1;
		this.cliente = telaCliente;
		this.categoria=telaCategoria;
		this.reserva=telaReserva;
		
		this.home.getBtnCadastrarCategoria().addActionListener(this);
		this.home.getBtnCadastrarCliente().addActionListener(this);
		this.home.getBtnCadastrarReservas().addActionListener(this);
		this.home.getBtnVoltar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.home.getBtnCadastrarCategoria()==e.getSource()) {
			this.categoria.setVisible(true);
		}else if(this.home.getBtnCadastrarCliente()==e.getSource()) {
			this.cliente.setVisible(true);
		}else if(this.home.getBtnCadastrarReservas()==e.getSource()) {
			this.reserva.setVisible(true);
		}else if(this.home.getBtnVoltar()==e.getSource()) {
			this.home.setVisible(false);
			this.login.setVisible(true);
		}
		
	}
}
