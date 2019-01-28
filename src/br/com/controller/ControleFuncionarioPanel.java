package br.com.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControleFuncionarioPanel implements Initializable{
	@FXML
    private Button cadastrarButton;

    @FXML
    private Button consultarButton;

    @FXML
    void actionPeformed(ActionEvent e) {
    	if(cadastrarButton==e.getSource()) {
    		ControleHomeFuncionario.funcionarioPanel.setCenter(ControleHomeFuncionario.cadastroFuncionario);
    	}else if(consultarButton==e.getSource()) {
    		ControleHomeFuncionario.funcionarioPanel.setCenter(ControleHomeFuncionario.consultarFuncionario);
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
