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
import br.com.daobeans.DaoPessoa;
import br.com.view.TelaPerfilCliente;

public class ControlePerfilCliente implements ActionListener{
	private DaoPessoa daoPessoa;
	private TelaPerfilCliente telaPerfilCliente;
	
	public ControlePerfilCliente(TelaPerfilCliente telaPerfilCliente) {
		this.telaPerfilCliente =telaPerfilCliente;
		daoPessoa = new DaoPessoa();
		
		this.telaPerfilCliente.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ControlerTelaLogin.getP().setSenha(Criptografia.encrypt(this.telaPerfilCliente.getPasswordField().getText()));
			daoPessoa.updatePessoa(ControlerTelaLogin.getP());
			JOptionPane.showMessageDialog(null,"Senha Alterada!!");
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
