package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.app.App;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoVeiculo;
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

public class ControleConsultaVeiculo implements Initializable {
	@FXML
    private Button buscarbutton;

    @FXML
    private Button editarButton;
    
    @FXML
    private Button pegarButton;

    @FXML
    private TableView<VeiculoEdit> tabelaVeiculo;
    
    @FXML
    private BorderPane consultaVaiculoPanel;

    @FXML
    private TextField buscaField;

    @FXML
    private TableColumn<VeiculoEdit, String> modeloColumn;

    @FXML
    private TableColumn<VeiculoEdit, String> fabricanteColumn;

    @FXML
    private TableColumn<VeiculoEdit, String> categoriaColumn;

    @FXML
    private TableColumn<VeiculoEdit, String> filialColumn;

    
    
    public static List<Veiculo> veiculos;
    private static List<VeiculoEdit> veiculosEdit;
    private static List<Categoria> categorias;
    private static List<Filial> filiais;
    
    
    private DaoVeiculo daoVeiculo;
    private DaoCategoria daoCategoria;
    private DaoFilial daoFilial;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(ControleCadastroLocacaoPanel.isBuscVeiculo()) {
			editarButton.setVisible(false);
			pegarButton.setVisible(true);
		}
		veiculos=new ArrayList<>();
		veiculosEdit = new ArrayList<>();
		daoVeiculo = new DaoVeiculo();
		daoCategoria = new DaoCategoria();
		daoFilial = new DaoFilial();
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		fabricanteColumn.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		filialColumn.setCellValueFactory(new PropertyValueFactory<>("filial"));
	}
	
	public void actionPeformed(ActionEvent e) throws IOException {
		if(buscarbutton == e.getSource()) {
    		if(ControleCadastroLocacaoPanel.isBuscVeiculo()){
    			tabelaVeiculo.getItems().clear();
        		
        		if(veiculos.size()>0) {
        			 veiculos.removeAll(veiculos);
        		 }
        		 
        		 if(veiculosEdit.size()>0) {
        			 veiculosEdit.removeAll(veiculosEdit);
        		 }
        		 //ExibirMensagem.exibir(ControleCadastroLocacaoPanel.getCategoria().getNome());
        		 veiculos=daoVeiculo.buscarVeiculosDisponiveis(buscaField.getText(),ControleCadastroLocacaoPanel.getCategoria(),ControleCadastroLocacaoPanel.getFilial());
        		 System.out.println(veiculos.size());
        		 for(Veiculo v:veiculos) {
         			VeiculoEdit veiculoEdit = new VeiculoEdit();
         			veiculoEdit.setModelo(v.getModelo());
         			veiculoEdit.setFabricante(v.getFabricante());
         			veiculoEdit.setCategoria(v.getCat().getNome());
         			veiculoEdit.setFilial(v.getFilial().getNome());
         			veiculosEdit.add(veiculoEdit);
         		}
         		
         		tabelaVeiculo.getItems().addAll(veiculosEdit);
         		System.out.println(tabelaVeiculo.getItems().size());
    		}else{
    			tabelaVeiculo.getItems().clear();
        		
        		if(veiculos.size()>0) {
        			 veiculos.removeAll(veiculos);
        		 }
        		 
        		 if(veiculosEdit.size()>0) {
        			 veiculosEdit.removeAll(veiculosEdit);
        		 }
        		
        		veiculos = daoVeiculo.BuscaVeiculo(buscaField.getText());
        		System.out.println();
        		System.out.println(veiculos.size());
        		for(Veiculo v:veiculos) {
        			VeiculoEdit veiculoEdit = new VeiculoEdit();
        			veiculoEdit.setModelo(v.getModelo());
        			veiculoEdit.setFabricante(v.getFabricante());
        			veiculoEdit.setCategoria(v.getCat().getNome());
        			veiculoEdit.setFilial(v.getFilial().getNome());
        			veiculosEdit.add(veiculoEdit);
        		}
        		System.out.println(veiculosEdit.size());
        		tabelaVeiculo.getItems().addAll(veiculosEdit);
        		System.out.println(tabelaVeiculo.getItems().size());
    		}
			
			
    	}else if(editarButton == e.getSource()) {
    		ControleCadastroVeiculoPanel.setVeiculo(veiculos.get(tabelaVeiculo.getSelectionModel().getSelectedIndex()));
    		ControleHomeFuncionario.veiculoCadastroPanel = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroVeiculoPanel.fxml"));
    		ControleHomeFuncionario.veiculoPanel.setCenter(ControleHomeFuncionario.veiculoCadastroPanel);
    	}else if(pegarButton == e.getSource()) {
    		if(ControleCadastroLocacaoPanel.isBuscVeiculo()) {
    			ControleCadastroLocacaoPanel.setVeiculo(veiculos.get(tabelaVeiculo.getSelectionModel().getSelectedIndex()));
    			ControleHomeFuncionario.cadastroLocacaoPanel=FXMLLoader.load(getClass().getClassLoader().getResource("br/com/view/CadastroLocacaoPanel.fxml"));
    			ControleHomeFuncionario.locacao.setCenter(ControleHomeFuncionario.cadastroLocacaoPanel);
    			App.getDialogVeiculo().close();
    			editarButton.setVisible(true);
    			pegarButton.setVisible(false);
    			ControleCadastroLocacaoPanel.setBuscVeiculo(false);
    		}
    	}
	}
	public class VeiculoEdit{
		private String modelo;
		private String fabricante;
		private String categoria;
		private String filial;
		
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}

		public void setFilial(String filial) {
			this.filial = filial;
		}

		public String getModelo() {
			return modelo;
		}

		public String getFabricante() {
			return fabricante;
		}

		public String getCategoria() {
			return categoria;
		}

		public String getFilial() {
			return filial;
		}
		
		
		
	}
}
