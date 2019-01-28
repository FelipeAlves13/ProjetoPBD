package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoVeiculo;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Veiculo;
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

public class ControleVeiculoPanel implements Initializable{
	@FXML
    private Button consultarButton;

    @FXML
    private Button cadastrarButton;

    
    @FXML
    public void actionPeformed(ActionEvent e) throws DaoException, IOException {
    	if(consultarButton == e.getSource()) {
    		ControleHomeFuncionario.consultaVeiculoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/ConsultaVeiculoPanel.fxml"));
    		ControleHomeFuncionario.veiculoPanel.setCenter(ControleHomeFuncionario.consultaVeiculoPanel);
    	}else if(cadastrarButton == e.getSource()) {
    		ControleHomeFuncionario.veiculoCadastroPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroVeiculoPanel.fxml"));
    		ControleHomeFuncionario.veiculoPanel.setCenter(ControleHomeFuncionario.veiculoCadastroPanel);
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
	}
	
	
	
}
