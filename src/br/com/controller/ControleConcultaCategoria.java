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

public class ControleConcultaCategoria implements Initializable {
	 	@FXML
	    private TableView<CategoriaEdit> tabela;
	    
	    @FXML
	    private TableColumn<CategoriaEdit, String> nomeColumn;

	    @FXML
	    private TableColumn<CategoriaEdit, String> tempoRColumn;

	    @FXML
	    private TableColumn<CategoriaEdit, String> tempLimpezaColumn;

	    @FXML
	    private TableColumn<CategoriaEdit, String> transportaColumn;

	    @FXML
	    private TextField filtroField;

	    @FXML
	    private Button buscarButton;

	    @FXML
	    private Button editarButton;
	    
	    private DaoCategoria daoCategoria;
	    
	    private List<Categoria> categorias  =new ArrayList<>();
	    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoCategoria = new DaoCategoria();
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tempLimpezaColumn.setCellValueFactory(new PropertyValueFactory<>("tempoLimpeza"));
		tempoRColumn.setCellValueFactory(new PropertyValueFactory<>("tempoRevisao"));
		transportaColumn.setCellValueFactory(new PropertyValueFactory<>("transporta"));
		
	}
	
	public void actionPeformed(ActionEvent e) throws IOException, DaoException {
		if(buscarButton==e.getSource()) {
    		if(categorias.size()>0) {
    			categorias.removeAll(categorias);
    		}
    		
    		if(tabela.getItems().size()>0) {
    			tabela.getItems().removeAll(tabela.getItems());
    		}
    		
    		categorias=daoCategoria.BuscaCategoria(filtroField.getText());
    		
    		for(Categoria c:categorias) {
    			CategoriaEdit categoriaEdit = new CategoriaEdit();
    			categoriaEdit.setNome(c.getNome());
    			categoriaEdit.setTempoLimpeza(Formatos.getHoraFormat().format(c.getTempoLimpeza()));
    			categoriaEdit.setTempoRevisao(Formatos.getHoraFormat().format(c.getTempoRevisao()));
    			if(c.getCategoria_carga()!=null) {
    				categoriaEdit.setTransporta("Cargas");
    			}else if(c.getCategoria_passageiro()!=null) {
    				categoriaEdit.setTransporta("Passageiros");
    			}
    			tabela.getItems().add(categoriaEdit);
    		}
    		
    	}else if(editarButton==e.getSource()) {
    		ControleCadastroCategoriaPanel.setCategoria(categorias.get(tabela.getSelectionModel().getSelectedIndex()));
    		ControleHomeFuncionario.cadastroCategoriaPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroCategoriaPanel.fxml"));
    		ControleHomeFuncionario.categoriaPanel.setCenter(ControleHomeFuncionario.cadastroCategoriaPanel);
    	}
	}
	
	public class CategoriaEdit{
		private String nome;
		private String tempoRevisao;
		private String tempoLimpeza;
		private String transporta;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getTempoRevisao() {
			return tempoRevisao;
		}
		public void setTempoRevisao(String tempoRevisao) {
			this.tempoRevisao = tempoRevisao;
		}
		public String getTempoLimpeza() {
			return tempoLimpeza;
		}
		public void setTempoLimpeza(String tempoLimpeza) {
			this.tempoLimpeza = tempoLimpeza;
		}
		public String getTransporta() {
			return transporta;
		}
		public void setTransporta(String transporta) {
			this.transporta = transporta;
		}
		
		
	}
}
