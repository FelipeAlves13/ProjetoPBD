package br.com.controller;

import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.complemento.Criptografia;
import br.com.daobeans.DaoUsuario;
import br.com.view.ExibirMensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleAlterarSenha implements Initializable{
	 @FXML
	    private TextField senhaAtualField;

	    @FXML
	    private TextField senhaNovaField;

	    @FXML
	    private Button alterarSenhaButton;

	    @FXML
	    private TextField confirmaSenhaField;

	    @FXML
	    private Button cancelarButton;
	    
	    private DaoUsuario daoUsuario;

	    @FXML
	    void actionPeformed(ActionEvent e) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	    	if(alterarSenhaButton==e.getSource()) {
	    		if(senhaNovaField.getText().length()>=6 && senhaNovaField.getText().length()<=11) {
	    			if(senhaNovaField.getText().equals(confirmaSenhaField.getText())) {
	    				ControleLoginFrame.u.setSenha(Criptografia.encrypt(senhaNovaField.getText()));
			    		daoUsuario.updateUsuario(ControleLoginFrame.u);

			    		if(ControleLoginFrame.u.getFuncionario()!=null) {
			    			ControleHomeFuncionario.paneCenter.setCenter(ControleHomeFuncionario.telaTemp);
			    		}else if(ControleLoginFrame.u.getPessoa()!=null){
			    			ControleHomeClienteFrame.paneCenter.setCenter(ControleHomeClienteFrame.imgTemp);
			    		}
			    		limpar();
			    		ExibirMensagem.exibir("A senha foi atualizada!!");
	    			}else {
	    				ExibirMensagem.exibir("A senhas diferentes!!");
	    			}
	    			
	    		}else {
	    			ExibirMensagem.exibir("Senha deve conter de 6 a 11 caracteres alfanumericos");
	    		}
	    		
	    	}else if(cancelarButton==e.getSource()) {
	    		if(ControleLoginFrame.u.getFuncionario()!=null) {
	    			ControleHomeFuncionario.paneCenter.setCenter(ControleHomeFuncionario.telaTemp);
	    		}else if(ControleLoginFrame.u.getPessoa()!=null){
	    			ControleHomeClienteFrame.paneCenter.setCenter(ControleHomeClienteFrame.imgTemp);
	    		}
	    		limpar();
	    		
	    	}
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoUsuario = new DaoUsuario();
		
	}
	
	public void limpar() {
		senhaAtualField.setText("");
		confirmaSenhaField.setText("");
		senhaNovaField.setText("");
	}
}
