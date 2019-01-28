package br.com.controller;


import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.exception.DaoException;
import br.com.exception.ValidacaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControleClientePanel implements Initializable {
		//public static ConsultarClienteTempFrame  atualizarCliente;
	  	
	  	
	    @FXML
	    private Button cadastrarButton;

	    @FXML
	    private Button consultarButton;
	    
	    
	    
//	    private  BorderPane cadastroClientePane;
//	    private Pane atualizarClientePane;
	
	    
	    
	    
	    
	    @FXML
	    public void actionPeformed(ActionEvent e) throws DaoException, ValidacaoException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	    	if(cadastrarButton==e.getSource()) {
	    		ControleHomeFuncionario.clientePanel.setCenter(ControleHomeFuncionario.cadastroClientePane);
	    	}else if(consultarButton==e.getSource()) {
	    		ControleHomeFuncionario.clientePanel.setCenter(ControleHomeFuncionario.consultaClientePanel);
	    	}
	   }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
		}

		
}
