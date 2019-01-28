package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.daobeans.DaoFuncionario;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsultaFuncionario implements Initializable{
	@FXML
    private TextField filtroField;

    @FXML
    private Button buscarbutton;

    @FXML
    private Button editarButton;

    @FXML
    private TableView<Funcionario> tabela;

    @FXML
    private TableColumn<Funcionario, String> nomeColumn;

    @FXML
    private TableColumn<Funcionario, String> cargoColumn;
    
    private DaoFuncionario daoFuncionario;
    
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException, IOException {
    	if(buscarbutton==e.getSource()) {
    		if(funcionarios.size()>0) {
    			funcionarios.removeAll(funcionarios);
    		}
    		
    		if(tabela.getItems().size()>0) {
    			tabela.getItems().removeAll(tabela.getItems());
    		}
    		
    		funcionarios = daoFuncionario.BuscaFuncionario(filtroField.getText());
    		tabela.getItems().addAll(funcionarios);
    	}else if(editarButton==e.getSource()) {
    		ControleCadastroFuncionarioPanel.setFuncionario(funcionarios.get(tabela.getSelectionModel().getSelectedIndex()));
    		ControleHomeFuncionario.cadastroFuncionario = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroFuncionarioPanel.fxml"));
    		ControleHomeFuncionario.funcionarioPanel.setCenter(ControleHomeFuncionario.cadastroFuncionario);
    	}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	daoFuncionario = new DaoFuncionario();
    	
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cargoColumn.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		
	}
    
   

}
