package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.view.TelaHomeCliente;
import br.com.view.TelaLogin1;


public class ControleHomeCliente implements ActionListener {
	private TelaLogin1 telaLogin1;
	private TelaHomeCliente telaHomeCliente;
	
	public ControleHomeCliente(TelaHomeCliente telaHomeCliente,TelaLogin1 telaLogin1) {
		this.telaHomeCliente = telaHomeCliente;
		this.telaLogin1 = telaLogin1;
		
		telaHomeCliente.getBtnPerfil().addActionListener(this);
		telaHomeCliente.getBtnSair().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(telaHomeCliente.getBtnPerfil()==e.getSource()) {
			telaHomeCliente.getTelaPerfilCliente().setVisible(true);
		}else if(telaHomeCliente.getBtnSair()==e.getSource()){
			telaLogin1.getLoginField().setText("");
			telaLogin1.getSenhaField().setText("");
			telaHomeCliente.setVisible(false);
			telaLogin1.setVisible(true);
		}
		
	}
}
