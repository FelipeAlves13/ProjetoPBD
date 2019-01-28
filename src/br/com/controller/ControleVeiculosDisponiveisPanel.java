package br.com.controller;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoFilial;
import br.com.daobeans.DaoLocacao;
import br.com.exception.DaoException;
import br.com.model.entidadesbeans.Filial;
import br.com.model.entidadesbeans.Locacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleVeiculosDisponiveisPanel implements Initializable {
	@FXML
    private TableView<VeiculoDisponivel> tabela;
	
	@FXML
    private TableColumn<VeiculoDisponivel, String> modeloColumn;

    @FXML
    private TableColumn<VeiculoDisponivel, String> categoriaColumn;

    @FXML
    private TableColumn<VeiculoDisponivel, String> filialColumn;

    @FXML
    private TableColumn<VeiculoDisponivel, String> fabricanteColumn;

    @FXML
    private Button buscarButton;

    @FXML
    private ComboBox<String> filialBox;

    @FXML
    private DatePicker dataDisponivel;
    private List<Filial> filiais = new ArrayList<>();
    private List<Locacao> veiculosDisponiveis = new ArrayList<>(); 
    private DaoLocacao daoLocacao;
    private DaoFilial daoFilial;
    
    @FXML
    void actionPeformed(ActionEvent event) throws DaoException, ParseException {
    	if(veiculosDisponiveis.size()>0) {
    		veiculosDisponiveis.removeAll(veiculosDisponiveis);
    	}
    	if(tabela.getItems().size()>0) {
    		tabela.getItems().removeAll(tabela.getItems());
    	}
    	veiculosDisponiveis = daoLocacao.VeiculosDisponiveisDataCorrente(filiais.get(filialBox.getSelectionModel().getSelectedIndex()), Formatos.getDataFormat().parse(dataDisponivel.getEditor().getText()));
    	for(Locacao l: veiculosDisponiveis) {
    		int cont = 0;
    		for(VeiculoDisponivel v: tabela.getItems()) {
    			if(l.getVeiculo().getModelo().equals(v.getModelo())) {
    				cont++;
    			}
    		}
    		if(cont==0) {
    			VeiculoDisponivel veiculoDisponivel = new VeiculoDisponivel();
        		veiculoDisponivel.setModelo(l.getVeiculo().getModelo());
        		veiculoDisponivel.setCategoria(l.getVeiculo().getCat().getNome());
        		veiculoDisponivel.setFilial(l.getVeiculo().getFilial().getNome());
        		veiculoDisponivel.setFab(l.getVeiculo().getFabricante());
        		tabela.getItems().add(veiculoDisponivel);
    		}
    		
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoLocacao = new DaoLocacao();
		daoFilial = new DaoFilial();
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		filialColumn.setCellValueFactory(new PropertyValueFactory<>("filial"));
		fabricanteColumn.setCellValueFactory(new PropertyValueFactory<>("fab"));
		
		if(filiais.size()>0) {
			filiais.removeAll(filiais);
		}
		
		if(filialBox.getItems().size()>0) {
			filialBox.getItems().removeAll(filialBox.getItems());
		}
		
		try {
			filiais = daoFilial.BuscaFilial("");
			for(Filial f: filiais) {
				filialBox.getItems().add(f.getNome());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public class VeiculoDisponivel{
		private String modelo;
		private String categoria;
		private String filial;
		private String fab;
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getFilial() {
			return filial;
		}
		public void setFilial(String filial) {
			this.filial = filial;
		}
		public String getFab() {
			return fab;
		}
		public void setFab(String fab) {
			this.fab = fab;
		}
		
		
	}

}
