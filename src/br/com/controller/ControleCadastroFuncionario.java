package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.daoBeans.DaoFuncionario;
import br.com.modelBeans.Funcionario;
import br.com.view.TelaCadastroFuncionario;

public class ControleCadastroFuncionario implements ActionListener{
	private ControlerTelaLogin login;//usado para saber se a tela de cadastro foi chamada pela tela de login
	private TelaCadastroFuncionario cadastroFuncionario;
	private DaoFuncionario daoFuncionario;
	
	public ControleCadastroFuncionario(ControlerTelaLogin controleLogin,TelaCadastroFuncionario telaCadastroFuncionario) {
		this.cadastroFuncionario=telaCadastroFuncionario;
		this.login=controleLogin;
		this.daoFuncionario=new DaoFuncionario();
		this.cadastroFuncionario.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Funcionario f = new Funcionario();
		f.setNome(this.cadastroFuncionario.getNomeField().getText());
		f.setCargo(this.cadastroFuncionario.getCargoField().getText());
		f.setLogin(this.cadastroFuncionario.getLoginField().getText());
		f.setSenha(this.cadastroFuncionario.getSenhaField().getText());
		
		daoFuncionario.persist(f);
		//coloca o JOPtion pane 
		if(login.isCadastro()) {
			login.setCadastro(false);
			login.getHome().setVisible(true);
		}
		this.cadastroFuncionario.setVisible(false);
		
		
	}
}
