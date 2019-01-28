package br.com.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.daobeans.DaoFuncionario;
import br.com.daobeans.DaoUsuario;
import br.com.view.ExibirMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControlePerfilFuncionarioPanel implements Initializable{

	 @FXML
	 private ComboBox<String> cargoBox;

	 @FXML
	 private TextField nomeField;

	 @FXML
	 private Button AtualizarButton;

	 @FXML
	 private TextField loginField;

	 private DaoFuncionario daoFuncionario;
	 private DaoUsuario daoUsuario;
	 
	 @FXML
	 void actionPeformed(ActionEvent event) {
		 ControleLoginFrame.u.getFuncionario().setCargo(cargoBox.getSelectionModel().getSelectedItem());
		 ControleLoginFrame.u.getFuncionario().setNome(nomeField.getText());
		 daoFuncionario.updateFuncionario(ControleLoginFrame.u.getFuncionario());
		 ControleLoginFrame.u.setLogin(loginField.getText());
		 daoUsuario.updateUsuario(ControleLoginFrame.u);
		 ExibirMensagem.exibir("Dados Atualizados!!");
	 }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		daoFuncionario = new DaoFuncionario();
		daoUsuario  =new DaoUsuario();
		ObservableList<String> cargos = FXCollections.observableArrayList("Nenhum","Gerente","Adiministrador","Atendente");
		cargoBox.getItems().addAll(cargos);
		cargoBox.getSelectionModel().select(ControleLoginFrame.u.getFuncionario().getCargo());
		nomeField.setText(ControleLoginFrame.u.getFuncionario().getNome());
		loginField.setText(ControleLoginFrame.u.getLogin());
	}

}
