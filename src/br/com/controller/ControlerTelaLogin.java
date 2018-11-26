package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.daoBeans.DaoFuncionario;
import br.com.modelBeans.Funcionario;
import br.com.view.TelaCadastroCliente;
import br.com.view.TelaCadastroFuncionario;
import br.com.view.TelaHome;
import br.com.view.TelaLogin1;

public class ControlerTelaLogin implements ActionListener{
	private TelaLogin1 login;
	private TelaHome home;
	private TelaCadastroCliente cadastroCliente;
	private TelaCadastroFuncionario cadastroFuncionario;
	private DaoFuncionario daoFuncionario;
	private Funcionario f;
	private boolean cadastro;
	
	public ControlerTelaLogin(TelaLogin1 telaLogin,TelaHome telaHome,TelaCadastroCliente telaCadastroCliente,TelaCadastroFuncionario telaCadastroFuncionario) {
		this.login=telaLogin; 
		this.home=telaHome;
		this.cadastroCliente = telaCadastroCliente;
		this.cadastroFuncionario = telaCadastroFuncionario;
		
		login.getLogarButton().addActionListener(this);
		login.getRegistrarButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(login.getLogarButton()==e.getSource()) {
			if(login.getComboBox().getSelectedIndex()==1) {
				if(daoFuncionario.buscarLogin(login.getLoginField().getText(),login.getSenhaField().getText())) {
					this.setCadastro(false);
					this.home.setVisible(true);
				}else {
					//tela home do cliente falta fazer
				}
				
			}else {
				
			}
		}else if(login.getRegistrarButton()==e.getSource()){
			if(login.getComboBox().getSelectedIndex()==1) {
				this.setCadastro(true);
				cadastroFuncionario.setVisible(true);
			}else {
				this.setCadastro(true);
				cadastroCliente.setVisible(true);
			}
		}
	}

	public boolean isCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}

	public TelaHome getHome() {
		return home;
	}
	
	
	
}
