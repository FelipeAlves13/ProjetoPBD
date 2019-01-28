package br.com.controller;

import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.app.App;
import br.com.complemento.Criptografia;
import br.com.daobeans.DaoUsuario;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Usuario;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleResetSenha implements Initializable{
	 @FXML
	 private TextField loginField;

	 @FXML
	 private PasswordField senhaField;

	 @FXML
	 private Button resetarButton;
	  
	 
	 
	 private static String nome;

	  DaoUsuario daoUsuario;
	  @FXML
	 public void actionPeformed(ActionEvent e) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, DaoException {
			if(resetarButton==e.getSource()) {
				Usuario u=daoUsuario.buscarLogin(loginField.getText(), Criptografia.encrypt(senhaField.getText()));
				  
				  if(u.getFuncionario()!=null){
					  if(u.getFuncionario().getCargo().equalsIgnoreCase("Gerente")){
						  Usuario u1=daoUsuario.buscarusuarioP(nome);
				   			u1.setSenha(Criptografia.encrypt("epilef123"));
				   			daoUsuario.updateUsuario(u1);
				   			ExibirMensagem.exibir("Senha resetada!!nova senha: epilef123");
				   			App.getDialogPermissao().close();
					  }else{
						  ExibirMensagem.exibir("Senha o login errado!!"); 
					  }
				  }else{
					  ExibirMensagem.exibir("Senha o login errado!!");
				  }
			}
		  
	  }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoUsuario=new DaoUsuario();
		
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		ControleResetSenha.nome = nome;
	}
	
	

}
