package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoCategoria;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControleCategoriaFrame implements Initializable {
	 	@FXML
	    private BorderPane categoriaFrame;  	
	 	
	 	@FXML
	    private  BorderPane consultaCategoria;
	 	
	 	@FXML
	    private Button consultarButton;

	    @FXML
	    private Button cadastrarButton;

	    

	    @FXML
	    void actionPeformed(ActionEvent e) throws DaoException, IOException {
	    	if(consultarButton==e.getSource()) {
	    		
	    		ControleHomeFuncionario.categoriaPanel.setCenter(ControleHomeFuncionario.consultaCategoriaPanel);
	    		
	    	}else if(cadastrarButton==e.getSource()) {
	    		ControleHomeFuncionario.cadastroCategoriaPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroCategoriaPanel.fxml"));
	    		ControleHomeFuncionario.categoriaPanel.setCenter(ControleHomeFuncionario.cadastroCategoriaPanel);
	    	}
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
