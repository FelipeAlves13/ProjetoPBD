package br.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoFuncionario;
import br.com.modelbeans.Funcionario;
import br.com.view.TelaCadastroFuncionario;

public class ControleCadastroFuncionario implements ActionListener{
	private ControlerTelaLogin login;//usado para saber se a tela de cadastro foi chamada pela tela de login
	private TelaCadastroFuncionario cadastroFuncionario;
	private DaoFuncionario daoFuncionario;
	private ControleFuncionario controleFuncionario;
	
	public ControleCadastroFuncionario(ControlerTelaLogin controleLogin,TelaCadastroFuncionario telaCadastroFuncionario,ControleFuncionario controleFuncionario) {
		this.cadastroFuncionario=telaCadastroFuncionario;
		this.login=controleLogin;
		this.daoFuncionario=new DaoFuncionario();
		this.controleFuncionario = controleFuncionario;
		
		this.cadastroFuncionario.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()>=0){
				this.controleFuncionario.getFuncionarios().get(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()).setNome(this.cadastroFuncionario.getNomeField().getText());
				this.controleFuncionario.getFuncionarios().get(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()).setCargo(this.cadastroFuncionario.getCargoField().getText());
				this.controleFuncionario.getFuncionarios().get(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()).setLogin(this.cadastroFuncionario.getLoginField().getText());
				this.controleFuncionario.getFuncionarios().get(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()).setSenha(Criptografia.encrypt(this.cadastroFuncionario.getSenhaField().getText()));
				daoFuncionario.updateFuncionario(this.controleFuncionario.getFuncionarios().get(this.controleFuncionario.getTelaFuncionario().getTable().getSelectedRow()));
				this.controleFuncionario.getTelaFuncionario().getTable().getSelectionModel().clearSelection();
				JOptionPane.showMessageDialog(null,"Funcionario Editado com sucesso!!");
			}else{
				Funcionario f = new Funcionario();
				f.setNome(this.cadastroFuncionario.getNomeField().getText());
				f.setCargo(this.cadastroFuncionario.getCargoField().getText());
				f.setLogin(this.cadastroFuncionario.getLoginField().getText());
			
				f.setSenha(Criptografia.encrypt(this.cadastroFuncionario.getSenhaField().getText()));//criptografa senha
			
				daoFuncionario.persistFuncionario(f);
				JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso!!");
				
			}
			
			
			if(login.isCadastro()) {
				login.setCadastro(false);
				login.getHome().setVisible(true);
			}
			this.cadastroFuncionario.setVisible(false);
			
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BadPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalBlockSizeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidAlgorithmParameterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}
}
