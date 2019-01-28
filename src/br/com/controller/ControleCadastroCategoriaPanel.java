package br.com.controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import br.com.complemento.Formatos;
import br.com.daobeans.DaoCategoria;
import br.com.daobeans.DaoCategoria_carga;
import br.com.daobeans.DaoCategoria_passageiro;
import br.com.model.entidadesbeans.Categoria;
import br.com.model.entidadesbeans.Categoria_carga;
import br.com.model.entidadesbeans.Categoria_passageiro;
import br.com.view.ExibirMensagem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class ControleCadastroCategoriaPanel implements Initializable {
	@FXML
    private TextField nomeField;

    @FXML
    private JFXTimePicker tempoR;

    @FXML
    private JFXTimePicker tempoL;

    @FXML
    private ComboBox<String> cambioBox;

    @FXML
    private CheckBox cameraBox;

    @FXML
    private CheckBox direcaoBox;

    @FXML
    private CheckBox mp3Box;

    @FXML
    private CheckBox dvdBox;

    @FXML
    private CheckBox arcondBox;

    @FXML
    private CheckBox radioBox;

    @FXML
    private RadioButton passageiroBox;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton cargaBox;

    @FXML
    private Pane cargaPanel;

    @FXML
    private TextField capacidadeField;

    @FXML
    private TextField desempenhoField;

    @FXML
    private TextField distEixosField;

    @FXML
    private TextField potenciaMotField;

    @FXML
    private TextField volumeField;

    @FXML
    private ComboBox<String> embreagemBox;

    @FXML
    private Pane panePassageiro;

    @FXML
    private CheckBox airBagBox;

    @FXML
    private CheckBox cintoBox;

    @FXML
    private CheckBox controlePolBox;

    @FXML
    private CheckBox direcaoAbox;

    @FXML
    private CheckBox rodaBox;

    @FXML
    private Button salvarButton;

//    @FXML
//    private Pane pane;

    @FXML
    private TextField valorCategoriaField;
    
    private DaoCategoria daoCategoria;
    private DaoCategoria_carga daoCategoriaCarga;
    private DaoCategoria_passageiro daoCategoriaPassageiro;
    
    private static  Categoria categoria;
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(categoria!=null) {
			preencherDados();
		}
		ObservableList<String> opcoes = FXCollections.observableArrayList("Manual","Automatico");
		
		cambioBox.getItems().addAll(opcoes);
		
		ObservableList<String> tipos = FXCollections.observableArrayList("Manual","Hidraulica");
		embreagemBox.getItems().addAll(tipos);
		
		if(passageiroBox.isSelected()) {
			//pane.setVisible(false);
			panePassageiro.setVisible(true);
		}
		
		group.selectedToggleProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				RadioButton rb =(RadioButton)group.getSelectedToggle();
				if(rb.getText().equals("Passageiro")) {
					//pane.setVisible(false);
					cargaPanel.setVisible(false);
					panePassageiro.setVisible(true);
				}else {
					//pane.setVisible(false);
					panePassageiro.setVisible(false);
					cargaPanel.setVisible(true);
				}
			}
		});
		
		daoCategoria = new DaoCategoria();
		daoCategoriaCarga = new DaoCategoria_carga();
		daoCategoriaPassageiro = new DaoCategoria_passageiro();
		
	}

	public void actionPeformed(ActionEvent e) throws ParseException, IOException {
		
		Categoria c = new Categoria();
		Categoria_passageiro categoria_passageiro= new Categoria_passageiro();
		Categoria_carga categoria_carga = new Categoria_carga();

		c.setAr_condicionado(arcondBox.isSelected());
		c.setCamera_re(cameraBox.isSelected());
		c.setDirecao_hidraulica(direcaoBox.isSelected());
		c.setDvd(dvdBox.isSelected());
		c.setMp3(mp3Box.isSelected());
		c.setRádio(radioBox.isSelected());
		c.setTipo_cambio(cambioBox.getSelectionModel().getSelectedItem());
		c.setTempoLimpeza(Formatos.getHoraFormat().parse(tempoL.getEditor().getText()));
		c.setTempoRevisao(Formatos.getHoraFormat().parse(tempoR.getEditor().getText()));
		c.setNome(nomeField.getText());
		c.setValor(Double.parseDouble(valorCategoriaField.getText()));
		if(categoria!=null) {
			if(passageiroBox.isSelected()) {
				System.out.println("passeii");
				categoria_passageiro.setId(categoria.getCategoria_passageiro().getId());
				categoria_passageiro.setAir_bag(airBagBox.isSelected());
				categoria_passageiro.setCinto_de_seguranca_trazeiro(cintoBox.isSelected());
				categoria_passageiro.setControle_poluicao(controlePolBox.isSelected());
				categoria_passageiro.setDireção_assistida(direcaoAbox.isSelected());
				categoria_passageiro.setRodas_de_liga_leve(rodaBox.isSelected());
				daoCategoriaPassageiro.updateCategoriaPassageiro(categoria_passageiro);
				
				c.setCategoria_carga(null);
				c.setCategoria_passageiro(categoria_passageiro);
				if(categoria.getCategoria_carga()!=null) {
					daoCategoriaCarga.remover(categoria.getCategoria_carga());
				}
			}else if(cargaBox.isSelected()){
				categoria_carga.setId(categoria.getCategoria_carga().getId());
				categoria_carga.setCapacidade_carga(Double.parseDouble(capacidadeField.getText()));
				categoria_carga.setDesempenho(Double.parseDouble(desempenhoField.getText()));
				categoria_carga.setDistância_eixos(Double.parseDouble(distEixosField.getText()));
				categoria_carga.setEmbreagem(embreagemBox.getSelectionModel().getSelectedItem());
				categoria_carga.setPotencia_do_motor(Double.parseDouble(potenciaMotField.getText()));
				categoria_carga.setVolume_combustivel(Double.parseDouble(volumeField.getText()));
				c.setCategoria_passageiro(null);
				c.setCategoria_carga(categoria_carga);
				daoCategoriaCarga.updateCategoriaCarga(categoria_carga);
				if(categoria.getCategoria_passageiro()!=null) {
					daoCategoriaPassageiro.remover(categoria.getCategoria_passageiro());
				}
		
			}
			c.setId(categoria.getId());
			daoCategoria.updateCategoria(c);
			ExibirMensagem.exibir("categoria atualizada com sucesso!!");
			categoria=null;
			
		}else {
			if(passageiroBox.isSelected()) {
				categoria_passageiro.setAir_bag(airBagBox.isSelected());
				categoria_passageiro.setCinto_de_seguranca_trazeiro(cintoBox.isSelected());
				categoria_passageiro.setControle_poluicao(controlePolBox.isSelected());
				categoria_passageiro.setDireção_assistida(direcaoAbox.isSelected());
				categoria_passageiro.setRodas_de_liga_leve(rodaBox.isSelected());
				daoCategoriaPassageiro.persist(categoria_passageiro);
				c.setCategoria_carga(null);
				c.setCategoria_passageiro(daoCategoriaPassageiro.buscarIdDoUltimoDado());
			}else if(cargaBox.isSelected()){
				categoria_carga.setCapacidade_carga(Double.parseDouble(capacidadeField.getText()));
				categoria_carga.setDesempenho(Double.parseDouble(desempenhoField.getText()));
				categoria_carga.setDistância_eixos(Double.parseDouble(distEixosField.getText()));
				categoria_carga.setEmbreagem(embreagemBox.getSelectionModel().getSelectedItem());
				categoria_carga.setPotencia_do_motor(Double.parseDouble(potenciaMotField.getText()));
				categoria_carga.setVolume_combustivel(Double.parseDouble(volumeField.getText()));
				c.setCategoria_passageiro(null);
				daoCategoriaCarga.persistCategoriaCarga(categoria_carga);
				c.setCategoria_carga(daoCategoriaCarga.buscarIdDoUltimoDado());
			}
			daoCategoria.persistCategoria(c);
			ExibirMensagem.exibir("categoria cadastrada com sucesso!!");
		}
		
		limparDados();
	}
	
	public void limparDados() {
		nomeField.setText("");
		tempoL.getEditor().setText("");
		tempoR.getEditor().setText("");
		valorCategoriaField.setText("");
		arcondBox.setSelected(false);
		airBagBox.setSelected(false);
		radioBox.setSelected(false);
		dvdBox.setSelected(false);
		mp3Box.setSelected(false);
		cameraBox.setSelected(false);
		volumeField.setText("");
		desempenhoField.setText("");
		potenciaMotField.setText("");
		embreagemBox.getSelectionModel().select(0);
		distEixosField.setText("");
		capacidadeField.setText("");
		cintoBox.setSelected(false);
		controlePolBox.setSelected(false);
		direcaoAbox.setSelected(false);
		group.selectToggle(passageiroBox);
		rodaBox.setSelected(false);
		direcaoBox.setSelected(false);
		cambioBox.getSelectionModel().select(0);
		panePassageiro.setVisible(true);
		cargaPanel.setVisible(false);
		//pane.setVisible(true);
	}
	
	public void preencherDados() {
		nomeField.setText(categoria.getNome());
		tempoL.setValue(Formatos.converterLocalTime(categoria.getTempoLimpeza().getTime()));
		tempoR.setValue(Formatos.converterLocalTime(categoria.getTempoRevisao().getTime()));
		valorCategoriaField.setText(""+categoria.getValor());
		arcondBox.setSelected(categoria.isAr_condicionado());
		radioBox.setSelected(categoria.isRádio());
		dvdBox.setSelected(categoria.isDvd());
		mp3Box.setSelected(categoria.isMp3());
		cameraBox.setSelected(categoria.isCamera_re());
		direcaoBox.setSelected(categoria.isDirecao_hidraulica());
		cambioBox.getSelectionModel().select(categoria.getTipo_cambio());
		
		if(categoria.getCategoria_passageiro()!=null) {
			airBagBox.setSelected(categoria.getCategoria_passageiro().isAir_bag());
			cintoBox.setSelected(categoria.getCategoria_passageiro().isCinto_de_seguranca_trazeiro());
			controlePolBox.setSelected(categoria.getCategoria_passageiro().isControle_poluicao());
			direcaoAbox.setSelected(categoria.getCategoria_passageiro().isDireção_assistida());
			panePassageiro.setVisible(true);
			group.selectToggle(passageiroBox);
			cargaPanel.setVisible(false);
			rodaBox.setSelected(categoria.getCategoria_passageiro().isRodas_de_liga_leve());
		}else {
			volumeField.setText(""+categoria.getCategoria_carga().getVolume_combustivel());
			desempenhoField.setText(""+categoria.getCategoria_carga().getDesempenho());
			potenciaMotField.setText(""+categoria.getCategoria_carga().getPotencia_do_motor());
			embreagemBox.getSelectionModel().select(categoria.getCategoria_carga().getEmbreagem());
			distEixosField.setText(""+categoria.getCategoria_carga().getDistância_eixos());
			capacidadeField.setText(""+categoria.getCategoria_carga().getCapacidade_carga());
			panePassageiro.setVisible(false);
			cargaPanel.setVisible(true);
			group.selectToggle(cargaBox);
		}
		//pane.setVisible(false);
	}

	public static Categoria getCategoria() {
		return categoria;
	}

	public static void setCategoria(Categoria categoria) {
		ControleCadastroCategoriaPanel.categoria = categoria;
	}
	
	
}
