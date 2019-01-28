package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import br.com.daobeans.DaoFilial;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleConsultaFilial implements Initializable {
	@FXML
    private TextField buscaField;

    @FXML
    private Button buscarButton;

    @FXML
    private Button editarButton;

    @FXML
    private TableView<FilialEdit> tabela;

    @FXML
    private TableColumn<FilialEdit, String> nomeColumn;

    @FXML
    private TableColumn<FilialEdit, String> cidadeColumn;

    @FXML
    private TableColumn<FilialEdit, String> ufColumn;
   
    private DaoFilial daoFilial;
    
    private List<Filial> filiais = new ArrayList<>();
    private List<FilialEdit> filiaisEdit = new ArrayList<>();
	
    @FXML
    void actionPeformed(ActionEvent e) throws DaoException, IOException {
    	if(buscarButton==e.getSource()) {
    		if(filiais.size()>0) {
    			filiais.removeAll(filiais);
    		}
    		if(tabela.getItems().size()>0) {
    			tabela.getItems().removeAll(tabela.getItems());
    		}
    		
    		filiais=daoFilial.BuscaFilial(buscaField.getText());
    		if(filiaisEdit.size()>0) {
    			filiaisEdit.removeAll(filiaisEdit);
    		}
    		for(Filial f:filiais) {
    			FilialEdit fe = new FilialEdit();
    			fe.setNome(f.getNome());
    			fe.setCidade(f.getEndereco().getCidade());
    			fe.setUf(f.getEndereco().getUf());
    			filiaisEdit.add(fe);
    		}
    		tabela.getItems().addAll(filiaisEdit);
    	}else if(editarButton==e.getSource()) {
    		ControleCadastroFilialPanel.setFilial(filiais.get(tabela.getSelectionModel().getSelectedIndex()));
    		ControleHomeFuncionario.cadastroFilial = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroFilialPanel.fxml"));
    		ControleHomeFuncionario.filialPanel.setCenter(ControleHomeFuncionario.cadastroFilial);
    	}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	daoFilial = new DaoFilial();
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		ufColumn.setCellValueFactory(new PropertyValueFactory<>("uf"));
	}
    
    public class FilialEdit{
		private String nome;
		private String cidade;
		private String uf;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		
		
		
	}

}
