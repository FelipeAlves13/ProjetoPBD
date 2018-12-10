package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		this.home.getBtnLocacao().addActionListener(this);
		this.home.getBtnVeiculos().addActionListener(this);
		this.home.getBtnFuncionario().addActionListener(this);
		this.home.getBtnFiliais().addActionListener(this);
		this.home.getBtnVoltar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.home.getBtnCadastrarCategoria()==e.getSource()) {
			this.home.getTelaVeiculo().setVisible(false);
			this.reserva.setVisible(false);
			this.cliente.setVisible(false);
			this.home.getTelaFilial().setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.categoria.setVisible(true);
			this.home.getContent().add(this.categoria);
		}else if(this.home.getBtnCadastrarCliente()==e.getSource()) {
			this.home.getTelaVeiculo().setVisible(false);
			this.reserva.setVisible(false);
			this.categoria.setVisible(false);
			this.home.getTelaFilial().setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.cliente.setVisible(true);
			this.home.getContent().add(this.cliente);
		}else if(this.home.getBtnCadastrarReservas()==e.getSource()) {
			this.home.getTelaVeiculo().setVisible(false);
			this.cliente.setVisible(false);
			this.categoria.setVisible(false);
			this.reserva.setVisible(true);
			this.home.getTelaFilial().setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.home.getContent().add(this.reserva);
		}else if(this.home.getBtnFuncionario()==e.getSource()){
			this.home.getTelaVeiculo().setVisible(false);
			this.cliente.setVisible(false);
			this.categoria.setVisible(false);
			this.reserva.setVisible(false);
			this.home.getTelaFilial().setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaFuncionario().setVisible(true);
			this.home.getContent().add(this.home.getTelaFuncionario());
		}else if(this.home.getBtnLocacao()==e.getSource()){
			this.home.getTelaVeiculo().setVisible(false);
			this.cliente.setVisible(false);
			this.categoria.setVisible(false);
			this.reserva.setVisible(false);
			this.home.getTelaFilial().setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.home.getTelaLocacao().setVisible(true);
			this.home.getContent().add(this.home.getTelaLocacao());
		}else if(this.home.getBtnVeiculos()==e.getSource()){
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaVeiculo().setVisible(true);
			this.cliente.setVisible(false);
			this.categoria.setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.reserva.setVisible(false);
			this.home.getTelaFilial().setVisible(false);
			this.home.getContent().add(this.home.getTelaVeiculo());
			
		}else if(this.home.getBtnFiliais()==e.getSource()){
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaVeiculo().setVisible(false);
			this.cliente.setVisible(false);
			this.categoria.setVisible(false);
			this.reserva.setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
			this.home.getTelaFilial().setVisible(true);
			this.home.getContent().add(this.home.getTelaFilial());
			
		}
		else if(this.home.getBtnVoltar()==e.getSource()) {
			this.login.getComboBox().setSelectedIndex(0);
			this.login.getLoginField().setText("");
			this.login.getSenhaField().setText("");
			this.home.getTelaVeiculo().setVisible(false);
			this.home.setVisible(false);
			this.login.setVisible(true);
			this.cliente.setVisible(false);
			//this.categoria.setVisible(false);
			this.reserva.setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaVeiculo().setVisible(false);
			this.home.getTelaLocacao().setVisible(false);
			this.home.getTelaFuncionario().setVisible(false);
		}
		
	}
	
}
