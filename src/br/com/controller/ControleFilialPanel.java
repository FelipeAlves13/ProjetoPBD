package br.com.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControleFilialPanel implements Initializable{
	 	@FXML
	    private BorderPane filialPanel; 	
	 	
	 	
	 	@FXML
	 	private BorderPane consultaFilialPanel;
	 	
	 	@FXML
	    private Button consultarButton;

	    @FXML
	    private Button cadastrarButton;

	    
	    private Pane cadastroFilialPanel;
	    
	   
	    
	    @FXML
	    void actionPeformed(ActionEvent e) throws Exception {
	    	if(cadastrarButton==e.getSource()) {
//	    		if(tabela.getItems().size()>0) {
//	    			tabela.getItems().removeAll(tabela.getItems());
//	    		}
	    		ControleHomeFuncionario.filialPanel.setCenter(ControleHomeFuncionario.cadastroFilial);
	    		
	    	}else if(consultarButton==e.getSource()) {
	    		ControleHomeFuncionario.filialPanel.setCenter(ControleHomeFuncionario.consultarFilial);
	    	}
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	
}
